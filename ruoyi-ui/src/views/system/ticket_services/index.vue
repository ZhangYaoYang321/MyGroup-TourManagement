<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="门票号" prop="ticketId">
        <el-input
          v-model="queryParams.ticketId"
          placeholder="请输入门票号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="身份证号" prop="cnId">
        <el-input
          v-model="queryParams.cnId"
          placeholder="请输入身份证号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="预约日期">
        <el-date-picker
          v-model="daterangeScheduledDate"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item>
      <el-form-item label="入园时间">
        <el-date-picker
          v-model="daterangeVisitorInTime"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item>
      <el-form-item label="出园时间">
        <el-date-picker
          v-model="daterangeVisitorOutTime"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item>
      <el-form-item label="参观状态" prop="stateVisit">
        <el-input
          v-model="queryParams.stateVisit"
          placeholder="请输入参观状态"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="门票类型" prop="typeTicket">
        <el-input
          v-model="queryParams.typeTicket"
          placeholder="请输入门票类型"
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

    <el-table v-loading="loading" :data="ticket_servicesList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="ID" align="center" prop="id" />
      <el-table-column label="门票号" align="center" prop="ticketId" />
      <el-table-column label="身份证号" align="center" prop="cnId" />
      <el-table-column label="预约日期" align="center" prop="scheduledDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.scheduledDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="入园时间" align="center" prop="visitorInTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.visitorInTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="出园时间" align="center" prop="visitorOutTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.visitorOutTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="参观状态" align="center" prop="stateVisit" />
      <el-table-column label="门票类型" align="center" prop="typeTicket" />
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

    <!-- 添加或修改票务对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="门票号" prop="ticketId">
          <el-input v-model="form.ticketId" placeholder="请输入门票号" />
        </el-form-item>
        <el-form-item label="身份证号" prop="cnId">
          <el-input v-model="form.cnId" placeholder="请输入身份证号" />
        </el-form-item>
        <el-form-item label="预约日期" prop="scheduledDate">
          <el-date-picker clearable
            v-model="form.scheduledDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择预约日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="入园时间" prop="visitorInTime">
          <el-date-picker clearable
            v-model="form.visitorInTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择入园时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="出园时间" prop="visitorOutTime">
          <el-date-picker clearable
            v-model="form.visitorOutTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择出园时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="参观状态" prop="stateVisit">
          <el-input v-model="form.stateVisit" placeholder="请输入参观状态" />
        </el-form-item>
        <el-form-item label="门票类型" prop="typeTicket">
          <el-input v-model="form.typeTicket" placeholder="请输入门票类型" />
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
import { listTicket_services, getTicket_services, delTicket_services, addTicket_services, updateTicket_services } from "@/api/system/ticket_services";

export default {
  name: "Ticket_services",
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
      // 票务表格数据
      ticket_servicesList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 门票类型时间范围
      daterangeScheduledDate: [],
      // 门票类型时间范围
      daterangeVisitorInTime: [],
      // 门票类型时间范围
      daterangeVisitorOutTime: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        ticketId: null,
        cnId: null,
        scheduledDate: null,
        visitorInTime: null,
        visitorOutTime: null,
        stateVisit: null,
        typeTicket: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询票务列表 */
    getList() {
      this.loading = true;
      this.queryParams.params = {};
      if (null != this.daterangeScheduledDate && '' != this.daterangeScheduledDate) {
        this.queryParams.params["beginScheduledDate"] = this.daterangeScheduledDate[0];
        this.queryParams.params["endScheduledDate"] = this.daterangeScheduledDate[1];
      }
      if (null != this.daterangeVisitorInTime && '' != this.daterangeVisitorInTime) {
        this.queryParams.params["beginVisitorInTime"] = this.daterangeVisitorInTime[0];
        this.queryParams.params["endVisitorInTime"] = this.daterangeVisitorInTime[1];
      }
      if (null != this.daterangeVisitorOutTime && '' != this.daterangeVisitorOutTime) {
        this.queryParams.params["beginVisitorOutTime"] = this.daterangeVisitorOutTime[0];
        this.queryParams.params["endVisitorOutTime"] = this.daterangeVisitorOutTime[1];
      }
      listTicket_services(this.queryParams).then(response => {
        this.ticket_servicesList = response.rows;
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
        id: null,
        ticketId: null,
        cnId: null,
        scheduledDate: null,
        visitorInTime: null,
        visitorOutTime: null,
        stateVisit: null,
        typeTicket: null
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
      this.daterangeScheduledDate = [];
      this.daterangeVisitorInTime = [];
      this.daterangeVisitorOutTime = [];
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
      this.title = "添加票务";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getTicket_services(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改票务";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateTicket_services(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addTicket_services(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除票务编号为"' + ids + '"的数据项？').then(function() {
        return delTicket_services(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/ticket_services/export', {
        ...this.queryParams
      }, `ticket_services_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
