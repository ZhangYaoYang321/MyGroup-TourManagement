
<template>
  <div>
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="我的住房">
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
            @click="handleCheckedOut(scope.row)"
            v-hasPermi="['hotel:checkout:submit']"
          >退房</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import { checkOut, listOrders } from '@/api/hotel/checkout'
import { delOrders } from '@/api/hotel/reservation'

export default {
  name: 'index.vue',
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

      },
    };
  },
  created() {

  },
  methods: {
    reset() {
      this.form = {
        id: null,
        name:null,
        orderId: null,
        cnId: null,
        type:null,
        startDate:null,
        endDate:null,
        room:null,
        state:null,
        phoneNum:null
      };
      this.resetForm("form");
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
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 入住按钮操作 */
    handleCheckedOut(row) {
      const id = row.orderId;
      this.$modal.confirm('是否确认退房？').then(function() {
        return checkOut(id);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("退房成功");
      }).catch(() => {});
    }
  }
};
</script>

<style scoped>

</style>
