<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="投诉ID" prop="complaintsId">
        <el-input
          v-model="queryParams.complaintsId"
          placeholder="请输入投诉ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="投诉日期">
        <el-date-picker
          v-model="daterangeComplaintsDate"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item>
      <el-form-item label="处理状态" prop="stateComplaints">
        <el-input
          v-model="queryParams.stateComplaints"
          placeholder="请输入处理状态"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="回复日期">
        <el-date-picker
          v-model="daterangeComplaintsReplyDate"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
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
          v-hasPermi="['system:complaints:add']"
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
          v-hasPermi="['system:complaints:edit']"
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
          v-hasPermi="['system:complaints:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:complaints:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="complaintsList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="ID" align="center" prop="id" />
      <el-table-column label="投诉ID" align="center" prop="complaintsId" />
      <el-table-column label="投诉信息" align="center" prop="complaintsMessage" />
      <el-table-column label="投诉日期" align="center" prop="complaintsDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.complaintsDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="处理状态" align="center" prop="stateComplaints" />
      <el-table-column label="回复日期" align="center" prop="complaintsReplyDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.complaintsReplyDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="回复信息" align="center" prop="complaintsReplyMessage" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:complaints:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:complaints:remove']"
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

    <!-- 添加或修改投诉对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="投诉ID" prop="complaintsId">
          <el-input v-model="form.complaintsId" placeholder="请输入投诉ID" />
        </el-form-item>
        <el-form-item label="投诉信息" prop="complaintsMessage">
          <el-input v-model="form.complaintsMessage" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="投诉时间" prop="complaintsDate">
          <el-date-picker clearable
            v-model="form.complaintsDate"
            type="datetime"
            value-format="yyyy-MM-dd hh:mm:ss"
            placeholder="请选择投诉日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="处理状态" prop="stateComplaints">
          <el-input v-model="form.stateComplaints" placeholder="请输入处理状态" />
        </el-form-item>
        <el-form-item label="回复日期" prop="complaintsReplyDate">
          <el-date-picker clearable
            v-model="form.complaintsReplyDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择回复日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="回复信息" prop="complaintsReplyMessage">
          <el-input v-model="form.complaintsReplyMessage" type="textarea" placeholder="请输入内容" />
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
import { listComplaints, getComplaints, delComplaints, addComplaints, updateComplaints } from "@/api/system/complaints";

export default {
  name: "Complaints",
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
      // 投诉表格数据
      complaintsList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 回复信息时间范围
      daterangeComplaintsDate: [],
      // 回复信息时间范围
      daterangeComplaintsReplyDate: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        complaintsId: null,
        complaintsMessage: null,
        complaintsDate: null,
        stateComplaints: null,
        complaintsReplyDate: null,
        complaintsReplyMessage: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        complaintsId: [
          { required: true, message: "投诉ID不能为空", trigger: "blur" }
        ],
        complaintsMessage: [
          { required: true, message: "投诉信息不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询投诉列表 */
    getList() {
      this.loading = true;
      this.queryParams.params = {};
      if (null != this.daterangeComplaintsDate && '' != this.daterangeComplaintsDate) {
        this.queryParams.params["beginComplaintsDate"] = this.daterangeComplaintsDate[0];
        this.queryParams.params["endComplaintsDate"] = this.daterangeComplaintsDate[1];
      }
      if (null != this.daterangeComplaintsReplyDate && '' != this.daterangeComplaintsReplyDate) {
        this.queryParams.params["beginComplaintsReplyDate"] = this.daterangeComplaintsReplyDate[0];
        this.queryParams.params["endComplaintsReplyDate"] = this.daterangeComplaintsReplyDate[1];
      }
      listComplaints(this.queryParams).then(response => {
        this.complaintsList = response.rows;
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
        complaintsId: null,
        complaintsMessage: null,
        complaintsDate: null,
        stateComplaints: null,
        complaintsReplyDate: null,
        complaintsReplyMessage: null
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
      this.daterangeComplaintsDate = [];
      this.daterangeComplaintsReplyDate = [];
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
      this.title = "添加投诉";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getComplaints(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改投诉";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateComplaints(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addComplaints(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除投诉编号为"' + ids + '"的数据项？').then(function() {
        return delComplaints(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/complaints/export', {
        ...this.queryParams
      }, `complaints_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
