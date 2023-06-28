
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
          v-hasPermi="['hotel:orders:add']"
        >新增</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>


    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="我的预约">
      </el-form-item>
    </el-form>

    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="身份证号" prop="cnId">
        <el-input
          v-model="queryParams.cnId"
          placeholder="请输入身份证号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
      </el-form-item>
    </el-form>

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

    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="空房查询">
      </el-form-item>
    </el-form>

    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="日期选择" prop="field102">
        <el-date-picker v-model="form.startDate" format="yyyy-MM-dd" value-format="yyyy-MM-dd"
                        :style="{width: '100%'}" placeholder="请选择日期选择" clearable></el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
      </el-form-item>
    </el-form>



    <el-form ref="elForm" :model="formData" :rules="rules" size="small" label-width="0px" style="text-align: center">
      <el-form-item size="medium">
        <el-button type="warning" >101</el-button>
        <el-button type="warning" >102</el-button>
        <el-button type="warning" >103</el-button>
        <el-button type="success" >104</el-button>
        <el-button type="success" >105</el-button>
        <el-button type="success" >106</el-button>
        <el-button type="success" >107</el-button>
        <el-button type="success" >108</el-button>
        <el-button type="success" >109</el-button>
        <el-button type="success" >110</el-button>
        <el-button type="success" >111</el-button>
        <el-button type="success" >112</el-button>
        <el-button type="success" >113</el-button>
        <el-button type="success" >114</el-button>
        <el-button type="success" >115</el-button>
        <el-button type="success" >116</el-button>
        <el-button type="success" >117</el-button>
        <el-button type="danger">118</el-button>
        <el-button type="danger" >119</el-button>
        <el-button type="danger" >120</el-button>
      </el-form-item>
      <el-form-item size="medium">
        <el-button type="warning" >201</el-button>
        <el-button type="warning" >202</el-button>
        <el-button type="warning" >203</el-button>
        <el-button type="success" >204</el-button>
        <el-button type="success" >205</el-button>
        <el-button type="success" >206</el-button>
        <el-button type="success" >207</el-button>
        <el-button type="success" >208</el-button>
        <el-button type="success" >209</el-button>
        <el-button type="success" >210</el-button>
        <el-button type="success" >211</el-button>
        <el-button type="success" >212</el-button>
        <el-button type="success" >213</el-button>
        <el-button type="success" >214</el-button>
        <el-button type="success" >215</el-button>
        <el-button type="success" >216</el-button>
        <el-button type="success" >217</el-button>
        <el-button type="danger" >218</el-button>
        <el-button type="danger" >219</el-button>
        <el-button type="danger" >220</el-button>
      </el-form-item>
      <el-form-item size="medium">
        <el-button type="warning" >301</el-button>
        <el-button type="warning" >302</el-button>
        <el-button type="warning" >303</el-button>
        <el-button type="success" >304</el-button>
        <el-button type="success" >305</el-button>
        <el-button type="success" >306</el-button>
        <el-button type="success" >307</el-button>
        <el-button type="success" >308</el-button>
        <el-button type="success" >309</el-button>
        <el-button type="success" >310</el-button>
        <el-button type="success" >311</el-button>
        <el-button type="success" >312</el-button>
        <el-button type="success" >313</el-button>
        <el-button type="success" >314</el-button>
        <el-button type="success" >315</el-button>
        <el-button type="success" >316</el-button>
        <el-button type="success" >317</el-button>
        <el-button type="danger" >318</el-button>
        <el-button type="danger" >319</el-button>
        <el-button type="danger" >320</el-button>
      </el-form-item>
      <el-form-item size="medium">
        <el-button type="warning" >401</el-button>
        <el-button type="warning" >402</el-button>
        <el-button type="warning" >403</el-button>
        <el-button type="success" >404</el-button>
        <el-button type="success" >405</el-button>
        <el-button type="success" >406</el-button>
        <el-button type="success" >407</el-button>
        <el-button type="success" >408</el-button>
        <el-button type="success" >409</el-button>
        <el-button type="success" >410</el-button>
        <el-button type="success" >411</el-button>
        <el-button type="success" >412</el-button>
        <el-button type="success" >413</el-button>
        <el-button type="success" >414</el-button>
        <el-button type="success" >415</el-button>
        <el-button type="success" >416</el-button>
        <el-button type="success" >417</el-button>
        <el-button type="danger" >418</el-button>
        <el-button type="danger" >419</el-button>
        <el-button type="danger" >420</el-button>
      </el-form-item>
      <el-form-item size="medium">
        <el-button type="warning" >501</el-button>
        <el-button type="warning" >502</el-button>
        <el-button type="warning" >503</el-button>
        <el-button type="success" >504</el-button>
        <el-button type="success" >505</el-button>
        <el-button type="success" >506</el-button>
        <el-button type="success" >507</el-button>
        <el-button type="success" >508</el-button>
        <el-button type="success" >509</el-button>
        <el-button type="success" >510</el-button>
        <el-button type="success" >511</el-button>
        <el-button type="success" >512</el-button>
        <el-button type="success" >513</el-button>
        <el-button type="success" >514</el-button>
        <el-button type="success" >515</el-button>
        <el-button type="success" >516</el-button>
        <el-button type="success" >517</el-button>
        <el-button type="danger" >518</el-button>
        <el-button type="danger" >519</el-button>
        <el-button type="danger" >520</el-button>
      </el-form-item>
      <el-form-item size="medium">
        <el-button type="warning" >601</el-button>
        <el-button type="warning" >602</el-button>
        <el-button type="warning" >603</el-button>
        <el-button type="success" >604</el-button>
        <el-button type="success" >605</el-button>
        <el-button type="success" >606</el-button>
        <el-button type="success" >607</el-button>
        <el-button type="success" >608</el-button>
        <el-button type="success" >609</el-button>
        <el-button type="success" >610</el-button>
        <el-button type="success" >611</el-button>
        <el-button type="success" >612</el-button>
        <el-button type="success" >613</el-button>
        <el-button type="success" >614</el-button>
        <el-button type="success" >615</el-button>
        <el-button type="success" >616</el-button>
        <el-button type="success" >617</el-button>
        <el-button type="danger" >618</el-button>
        <el-button type="danger" >619</el-button>
        <el-button type="danger" >620</el-button>
      </el-form-item>
      <el-form-item size="medium">
        <el-button type="warning" >701</el-button>
        <el-button type="warning" >702</el-button>
        <el-button type="warning" >703</el-button>
        <el-button type="success" >704</el-button>
        <el-button type="success" >705</el-button>
        <el-button type="success" >706</el-button>
        <el-button type="success" >707</el-button>
        <el-button type="success" >708</el-button>
        <el-button type="success" >709</el-button>
        <el-button type="success" >710</el-button>
        <el-button type="success" >711</el-button>
        <el-button type="success" >712</el-button>
        <el-button type="success" >713</el-button>
        <el-button type="success" >714</el-button>
        <el-button type="success" >715</el-button>
        <el-button type="success" >716</el-button>
        <el-button type="success" >717</el-button>
        <el-button type="danger" >718</el-button>
        <el-button type="danger" >719</el-button>
        <el-button type="danger" >720</el-button>
      </el-form-item>
      <el-form-item size="medium">
        <el-button type="warning" >801</el-button>
        <el-button type="warning" >802</el-button>
        <el-button type="warning" >803</el-button>
        <el-button type="success" >804</el-button>
        <el-button type="success" >805</el-button>
        <el-button type="success" >806</el-button>
        <el-button type="success" >807</el-button>
        <el-button type="success" >808</el-button>
        <el-button type="success" >809</el-button>
        <el-button type="success" >810</el-button>
        <el-button type="success" >811</el-button>
        <el-button type="success" >812</el-button>
        <el-button type="success" >813</el-button>
        <el-button type="success" >814</el-button>
        <el-button type="success" >815</el-button>
        <el-button type="success" >816</el-button>
        <el-button type="success" >817</el-button>
        <el-button type="danger" >818</el-button>
        <el-button type="danger" >819</el-button>
        <el-button type="danger" >820</el-button>
      </el-form-item>
    </el-form>








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

import {addOrders,listOrders, updateOrders,getOrders,delOrders} from "@/api/hotel/reservation";
import rooms from '@/views/system/rooms/index.vue'


export default {
  inheritAttrs: false,
  name: 'index.vue',
  components: {},
  props: [],
  data() {
    return {

      // 遮罩层
      loading: false,
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
      open1: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        name: null,
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
  },
  methods: {
    onOpen() {},
    onClose() {
      this.$refs['elForm'].resetFields()
    },
    close() {
      this.$emit('update:visible', false)
    },
    handleConfirm() {
      this.$refs['elForm'].validate(valid => {
        if (!valid) return
        this.close()
      })
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
    cancel() {
      this.open = false;
      this.open1 = false;
      this.reset();
    },
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
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加酒店预订";
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
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getOrders(id).then(response => {
        this.form = response.data;
        this.open1 = true;
        this.title = "修改酒店预约";
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.id;
      this.$modal.confirm('是否确认删除酒店订单编号为"' + id + '"的数据项？').then(function() {
        return delOrders(id);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        this.form.type=this.form.field102.at(0)
        this.form.roomNum=this.form.field102.at(1)
        if (valid) {
          if (this.form.id != null) {
            updateOrders(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.open1 = false;
              this.getList();
            });
          } else {
            addOrders(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.open1 = false;
              this.getList();
            });
          }
        }
      });
    }

  }
};
</script>

<style type='text/css'>

.el-button--warning{
  width: 60px;
  height:36px;
  text-align: center;
  background-color: rgb(11, 20, 28);
  color: #7ca4af;
  border-color: #000623;
}

.el-button--success{
  width: 60px;
  height:36px;
  text-align: center;
  background-color: rgb(148, 197, 238);
  color: #000055;
  border-color: #000623;
}

.el-button--danger{
  width: 60px;
  height:36px;
  text-align: center;
  background-color: rgb(148, 197, 238);
}
</style>
