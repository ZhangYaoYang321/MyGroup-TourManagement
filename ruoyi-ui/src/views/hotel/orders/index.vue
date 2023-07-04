<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="订单号" prop="orderId">
        <el-input
          v-model="form.orderId"
          placeholder="请输入订单号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="身份证号" prop="cnId">
        <el-input
          v-model="form.cnId"
          placeholder="请输入身份证号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="姓名" prop="name">
        <el-input
          v-model="form.name"
          placeholder="请输入姓名"
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
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['hotel:orders:add']"
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
          v-hasPermi="['hotel:orders:edit']"
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
          v-hasPermi="['hotel:orders:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['hotel:orders:export']"
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
            v-hasPermi="['hotel:reservation:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['hotel:orders:remove']"
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
          <el-date-picker v-model="form.startDate" format="yyyy-MM-dd" value-format="yyyy-MM-dd"
                          :style="{width: '100%'}" placeholder="请选择日期选择" clearable></el-date-picker>
        </el-form-item>
        <el-form-item label="结束日期" prop="field105">
          <el-date-picker v-model="form.endDate" format="yyyy-MM-dd" value-format="yyyy-MM-dd"
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
    <el-dialog :title="title" :visible.sync="open1" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="开始日期" prop="field104">
          <el-date-picker v-model="form.startDate" format="yyyy-MM-dd" value-format="yyyy-MM-dd"
                          :style="{width: '100%'}" placeholder="请选择日期选择" clearable></el-date-picker>
        </el-form-item>
        <el-form-item label="结束日期" prop="field105">
          <el-date-picker v-model="form.endDate" format="yyyy-MM-dd" value-format="yyyy-MM-dd"
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
      rules: {
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
        }]
      }, {
        "label": "标准间",
        "value": "标准间",
        "id": 102,
        "children": [{
          "label": "104",
          "value": 104,
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
        }]
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
        this.open = true;
        this.title = "修改酒店订单";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
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
    /** 导出按钮操作 */
    handleExport() {
      this.download('hotel/orders/export', {
        ...this.queryParams
      }, `orders_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
