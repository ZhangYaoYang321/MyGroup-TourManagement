<template>
  <div class="app-container">

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="ordersList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="ID" align="center" prop="id" />
      <el-table-column label="订单号" align="center" prop="orderId" />
      <el-table-column label="身份证号" align="center" prop="cnId" />
      <el-table-column label="房间号" align="center" prop="roomNum" />
      <el-table-column label="房间类型" align="center" prop="type" />
      <el-table-column label="开始日期" align="center" prop="startDate" />
      <el-table-column label="结束日期" align="center" prop="endDate" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加酒店订单对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="姓名" prop="orderId">
          <el-input
            v-model="form.name"
            placeholder="请输入姓名"
            clearable
            @keyup.enter.native="handleQuery"
          />
        </el-form-item>
        <el-form-item label="身份证号" prop="cnId">
          <el-input
            v-model="form.cnId"
            placeholder="请输入身份证号"
            v-decorator="['aaa',{ rules: [{validator:handleConfirmMoney,message:'请输入正确身份证号码',}] }]"
            clearable
            @keyup.enter.native="handleQuery"
          />
        </el-form-item>
        <el-form-item label="电话号码" prop="phoneNum">
          <el-input
            v-model="form.phoneNum"
            placeholder="请输入电话号码"
            clearable
            @keyup.enter.native="handleQuery"
          />
        </el-form-item>
        <el-form-item label="开始日期" prop="field104">
          <el-date-picker v-model="form.startDate" format="yyyy-MM-dd" value-format="yyyy-MM-dd":picker-options="pickerOptions"
                          :style="{width: '100%'}" placeholder="请选择日期选择" clearable></el-date-picker>
        </el-form-item>
        <el-form-item label="结束日期" prop="field105">
          <el-date-picker v-model="form.endDate" format="yyyy-MM-dd" value-format="yyyy-MM-dd":picker-options="pickerOptions"
                          :style="{width: '100%'}" placeholder="请选择日期选择" clearable></el-date-picker>
        </el-form-item>
        <el-form-item label="房间选择" prop="field102">
          <el-cascader v-model="form.field102" :options="field102Options" :props="field102Props"
                       :style="{width: '100%'}" placeholder="请选择房间" clearable></el-cascader>
        </el-form-item>

      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>

    <!-- 修改酒店订单对话框 -->
    <el-dialog :title="title" :visible.sync="open2" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="开始日期" prop="field104">
          <el-date-picker v-model="form.startDate" format="yyyy-MM-dd" value-format="yyyy-MM-dd":picker-options="pickerOptions"
                          :style="{width: '100%'}" placeholder="请选择日期选择" clearable></el-date-picker>
        </el-form-item>
        <el-form-item label="结束日期" prop="field105">
          <el-date-picker v-model="form.endDate" format="yyyy-MM-dd" value-format="yyyy-MM-dd":picker-options="pickerOptions"
                          :style="{width: '100%'}" placeholder="请选择日期选择" clearable></el-date-picker>
        </el-form-item>
        <el-form-item label="房间选择" prop="field102">
          <el-cascader v-model="form.field102" :options="field102Options" :props="field102Props"
                       :style="{width: '100%'}" placeholder="请选择房间" clearable></el-cascader>
        </el-form-item>

      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>

  </div>
</template>

<script>
import { listOrders, getOrders, delOrders, addOrders, updateOrders } from "@/api/hotel/orders";

export default {
  name: "Orders",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 酒店订单表格数据
      ordersList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      open2:false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        orderId: null,
        cnId: null
      },
      // 表单参数
      form: {},
      // 表单校验
      pickerOptions: {
        disabledDate: (time) => {
          return time.getTime() < Date.now() - 86400000; // 当前日期之前的日期都禁止选择
        },
      },
      rules: {
        phoneNum: [
          { required: true, message: '请输入手机号', trigger: 'blur' },
          {
            validator: this.validatePhoneNumber,
            trigger: 'blur',
          },
        ],
        cnId:[{ required: true, message: '请输身份证号', trigger: 'blur' },
          {
            validator: this.validateCnId,
            trigger: 'blur',
          }],
        startDate: [{
          required: true,
          message: '请选择日期选择',
          trigger: 'change'
        }],
        endDate: [{
          required: true,
          message: '请选择日期选择',
          trigger: 'change'
        }],
        field102: [{
          required: true,
          type: 'array',
          message: '请至少选择一个field102',
          trigger: 'change'
        }],
      },
      field102Options: [{
        "label": "单人间",
        "value": "单人间",
        "id": 101,
        "children": [{
          "label": "101",
          "value": 101,
          "id": 104
        }, {
          "label": "102",
          "value": 102,
          "id": 105,
        }, {
          "label": "103",
          "value": 103,
          "id": 106,
        },{
          "label": "201",
          "value": 201,
          "id": 104
        }, {
          "label": "202",
          "value": 202,
          "id": 105,
        }, {
          "label": "203",
          "value": 203,
          "id": 106,
        },{
          "label": "301",
          "value": 301,
          "id": 104
        }, {
          "label": "302",
          "value": 302,
          "id": 105,
        }, {
          "label": "303",
          "value": 303,
          "id": 106,
        },{
          "label": "401",
          "value": 401,
          "id": 104
        }, {
          "label": "402",
          "value": 402,
          "id": 105,
        }, {
          "label": "403",
          "value": 403,
          "id": 106,
        },{
          "label": "501",
          "value": 501,
          "id": 104
        }, {
          "label": "502",
          "value": 502,
          "id": 105,
        }, {
          "label": "503",
          "value": 503,
          "id": 106,
        },{
          "label": "601",
          "value": 601,
          "id": 104
        }, {
          "label": "602",
          "value": 602,
          "id": 105,
        }, {
          "label": "603",
          "value": 603,
          "id": 106,
        },{
          "label": "701",
          "value": 701,
          "id": 104
        }, {
          "label": "702",
          "value": 702,
          "id": 105,
        }, {
          "label": "703",
          "value": 703,
          "id": 106,
        },{
          "label": "801",
          "value": 801,
          "id": 104
        }, {
          "label": "802",
          "value": 802,
          "id": 105,
        }, {
          "label": "803",
          "value": 803,
          "id": 106,
        }]
      }, {
        "label": "标准间",
        "value": "标准间",
        "id": 102,
        "children": [{
          "label": "104",
          "value": 104,
          "id": 108
        },{
          "label": "105",
          "value": 105,
          "id": 108
        },{
          "label": "106",
          "value": 106,
          "id": 108
        },{
          "label": "107",
          "value": 107,
          "id": 108
        },{
          "label": "108",
          "value": 108,
          "id": 108
        },{
          "label": "109",
          "value": 109,
          "id": 108
        },{
          "label": "110",
          "value": 110,
          "id": 108
        },{
          "label": "111",
          "value": 111,
          "id": 108
        },{
          "label": "112",
          "value": 112,
          "id": 108
        },{
          "label": "113",
          "value": 113,
          "id": 108
        },{
          "label": "114",
          "value": 114,
          "id": 108
        },{
          "label": "115",
          "value": 115,
          "id": 108
        },{
          "label": "116",
          "value": 116,
          "id": 108
        },{
          "label": "117",
          "value": 117,
          "id": 108
        },{
          "label": "204",
          "value": 204,
          "id": 108
        },{
          "label": "205",
          "value": 205,
          "id": 108
        },{
          "label": "206",
          "value": 206,
          "id": 108
        },{
          "label": "207",
          "value": 207,
          "id": 108
        },{
          "label": "208",
          "value": 208,
          "id": 108
        },{
          "label": "209",
          "value": 209,
          "id": 108
        },{
          "label": "210",
          "value": 210,
          "id": 108
        },{
          "label": "211",
          "value": 211,
          "id": 108
        },{
          "label": "212",
          "value": 212,
          "id": 108
        },{
          "label": "213",
          "value": 213,
          "id": 108
        },{
          "label": "214",
          "value": 214,
          "id": 108
        },{
          "label": "215",
          "value": 215,
          "id": 108
        },{
          "label": "216",
          "value": 216,
          "id": 108
        },{
          "label": "217",
          "value": 217,
          "id": 108
        },{
          "label": "304",
          "value": 304,
          "id": 108
        },{
          "label": "305",
          "value": 305,
          "id": 108
        },{
          "label": "306",
          "value": 306,
          "id": 108
        },{
          "label": "307",
          "value": 307,
          "id": 108
        },{
          "label": "308",
          "value": 308,
          "id": 108
        },{
          "label": "309",
          "value": 309,
          "id": 108
        },{
          "label": "310",
          "value": 310,
          "id": 108
        },{
          "label": "311",
          "value": 311,
          "id": 108
        },{
          "label": "312",
          "value": 312,
          "id": 108
        },{
          "label": "313",
          "value": 313,
          "id": 108
        },{
          "label": "314",
          "value": 314,
          "id": 108
        },{
          "label": "315",
          "value": 315,
          "id": 108
        },{
          "label": "316",
          "value": 316,
          "id": 108
        },{
          "label": "317",
          "value": 317,
          "id": 108
        },{
          "label": "404",
          "value": 404,
          "id": 108
        },{
          "label": "405",
          "value": 405,
          "id": 108
        },{
          "label": "406",
          "value": 406,
          "id": 108
        },{
          "label": "407",
          "value": 407,
          "id": 108
        },{
          "label": "408",
          "value": 408,
          "id": 108
        },{
          "label": "409",
          "value": 409,
          "id": 108
        },{
          "label": "410",
          "value": 410,
          "id": 108
        },{
          "label": "411",
          "value": 411,
          "id": 108
        },{
          "label": "412",
          "value": 412,
          "id": 108
        },{
          "label": "413",
          "value": 413,
          "id": 108
        },{
          "label": "414",
          "value": 414,
          "id": 108
        },{
          "label": "415",
          "value": 415,
          "id": 108
        },{
          "label": "416",
          "value": 416,
          "id": 108
        },{
          "label": "417",
          "value": 417,
          "id": 108
        },,{
          "label": "504",
          "value": 504,
          "id": 108
        },{
          "label": "505",
          "value": 505,
          "id": 108
        },{
          "label": "506",
          "value": 506,
          "id": 108
        },{
          "label": "507",
          "value": 507,
          "id": 108
        },{
          "label": "508",
          "value": 508,
          "id": 108
        },{
          "label": "509",
          "value": 509,
          "id": 108
        },{
          "label": "510",
          "value": 510,
          "id": 108
        },{
          "label": "511",
          "value": 511,
          "id": 108
        },{
          "label": "512",
          "value": 512,
          "id": 108
        },{
          "label": "513",
          "value": 513,
          "id": 108
        },{
          "label": "514",
          "value": 514,
          "id": 108
        },{
          "label": "515",
          "value": 515,
          "id": 108
        },{
          "label": "516",
          "value": 516,
          "id": 108
        },{
          "label": "517",
          "value": 517,
          "id": 108
        },,{
          "label": "604",
          "value": 604,
          "id": 108
        },{
          "label": "605",
          "value": 605,
          "id": 108
        },{
          "label": "606",
          "value": 606,
          "id": 108
        },{
          "label": "607",
          "value": 607,
          "id": 108
        },{
          "label": "608",
          "value": 608,
          "id": 108
        },{
          "label": "609",
          "value": 609,
          "id": 108
        },{
          "label": "610",
          "value": 610,
          "id": 108
        },{
          "label": "611",
          "value": 611,
          "id": 108
        },{
          "label": "612",
          "value": 612,
          "id": 108
        },{
          "label": "613",
          "value": 613,
          "id": 108
        },{
          "label": "614",
          "value": 614,
          "id": 108
        },{
          "label": "615",
          "value": 615,
          "id": 108
        },{
          "label": "616",
          "value": 616,
          "id": 108
        },{
          "label": "617",
          "value": 617,
          "id": 108
        },,{
          "label": "704",
          "value": 704,
          "id": 108
        },{
          "label": "705",
          "value": 705,
          "id": 108
        },{
          "label": "706",
          "value": 706,
          "id": 108
        },{
          "label": "707",
          "value": 707,
          "id": 108
        },{
          "label": "708",
          "value": 708,
          "id": 108
        },{
          "label": "709",
          "value": 709,
          "id": 108
        },{
          "label": "710",
          "value": 710,
          "id": 108
        },{
          "label": "711",
          "value": 711,
          "id": 108
        },{
          "label": "712",
          "value": 712,
          "id": 108
        },{
          "label": "713",
          "value": 713,
          "id": 108
        },{
          "label": "714",
          "value": 714,
          "id": 108
        },{
          "label": "715",
          "value": 715,
          "id": 108
        },{
          "label": "716",
          "value": 716,
          "id": 108
        },{
          "label": "717",
          "value": 717,
          "id": 108
        },{
          "label": "804",
          "value": 804,
          "id": 108
        },{
          "label": "805",
          "value": 805,
          "id": 108
        },{
          "label": "806",
          "value": 806,
          "id": 108
        },{
          "label": "807",
          "value": 807,
          "id": 108
        },{
          "label": "808",
          "value": 808,
          "id": 108
        },{
          "label": "809",
          "value": 809,
          "id": 108
        },{
          "label": "810",
          "value": 810,
          "id": 108
        },{
          "label": "811",
          "value": 811,
          "id": 108
        },{
          "label": "812",
          "value": 812,
          "id": 108
        },{
          "label": "813",
          "value": 813,
          "id": 108
        },{
          "label": "814",
          "value": 814,
          "id": 108
        },{
          "label": "815",
          "value": 815,
          "id": 108
        },{
          "label": "816",
          "value": 816,
          "id": 108
        },{
          "label": "817",
          "value": 817,
          "id": 108
        }]
      }, {
        "label": "家庭套房",
        "value": "家庭套房",
        "id": 103,
        "children": [{
          "label": "120",
          "value": 120,
          "id": 107
        },{
          "label": "119",
          "value": 119,
          "id": 107
        },{
          "label": "118",
          "value": 118,
          "id": 107
        },{
          "label": "220",
          "value": 220,
          "id": 107
        },{
          "label": "219",
          "value": 219,
          "id": 107
        },{
          "label": "218",
          "value": 218,
          "id": 107
        },{
          "label": "320",
          "value": 320,
          "id": 107
        },{
          "label": "319",
          "value": 319,
          "id": 107
        },{
          "label": "318",
          "value": 318,
          "id": 107
        },{
          "label": "420",
          "value": 420,
          "id": 107
        },{
          "label": "419",
          "value": 419,
          "id": 107
        },{
          "label": "418",
          "value": 418,
          "id": 107
        },{
          "label": "520",
          "value": 520,
          "id": 107
        },{
          "label": "519",
          "value": 519,
          "id": 107
        },{
          "label": "518",
          "value": 518,
          "id": 107
        },{
          "label": "620",
          "value": 620,
          "id": 107
        },{
          "label": "619",
          "value": 619,
          "id": 107
        },{
          "label": "618",
          "value": 618,
          "id": 107
        },{
          "label": "720",
          "value": 720,
          "id": 107
        },{
          "label": "719",
          "value": 719,
          "id": 107
        },{
          "label": "718",
          "value": 718,
          "id": 107
        },{
          "label": "820",
          "value": 820,
          "id": 107
        },{
          "label": "819",
          "value": 819,
          "id": 107
        },{
          "label": "818",
          "value": 818,
          "id": 107
        },
        ]
      }],
      field102Props: {
        "multiple": false
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    validateCnId(rule, value, callback) {
      // 验证身份证号格式
      const pattern = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
      if (!pattern.test(value)) {
        callback(new Error('请输入有效的中华人民共和国身份证号'));
      } else {
        callback();
      }
    },
    validatePhoneNumber(rule, value, callback) {
      // 验证手机号格式
      const pattern = /^1[0-9]{10}$/;
      if (!pattern.test(value)) {
        callback(new Error('请输入有效的手机号'));
      } else {
        callback();
      }
    },
    /** 查询酒店订单列表 */
    getList() {
      this.loading = true;
      listOrders(this.queryParams).then(response => {
        this.ordersList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.open2=false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        field102: [],
        id: null,
        name:null,
        orderId: null,
        cnId: null,
        type:null,
        startDate:null,
        endDate:null,
        roomNum:null,
        state:null,
        phoneNum:null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加酒店订单";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getOrders(id).then(response => {
        this.form = response.data;
        this.open2 = true;
        this.title = "修改酒店订单";
      });
    },
    /** 提交按钮 */

    submitForm() {
      this.$refs["form"].validate(valid => {
        if(this.form.endDate<this.form.startDate)
          this.$modal.msgWarning("请输入正确日期");
        else{
          this.form.type=this.form.field102.at(0)
          this.form.roomNum=this.form.field102.at(1)
          if (valid) {
            if (this.form.id != null) {
              updateOrders(this.form).then(response => {
                this.$modal.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              });
            } else {
              addOrders(this.form).then(response => {
                this.$modal.msgSuccess("新增成功");
                this.open = false;
                this.getList();
              });
            }
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除酒店订单编号为"' + ids + '"的数据项？').then(function() {
        return delOrders(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    handleConfirmMoney(rule, value, callback) {
      if (value) {
        let z_reg = /^[\u4e00-\u9fa5]+$/
        if (z_reg.test(value)) {
          callback()
        } else {
          callback('请输入正确的格式')
        }
      }
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('hotel/orders/export', {
        ...this.queryParams
      }, `orders_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
