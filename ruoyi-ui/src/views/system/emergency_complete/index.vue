<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="事件地点" prop="location">
        <el-input
          v-model="queryParams.location"
          placeholder="请输入事件地点"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="处理状态" prop="stateEmergencies">
        <el-input
          v-model="queryParams.stateEmergencies"
          placeholder="请输入处理状态"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="紧急程度" prop="emergenciesLevel">
        <el-input
          v-model="queryParams.emergenciesLevel"
          placeholder="请输入紧急程度"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="发生日期">
        <el-date-picker
          v-model="daterangeEmergenciesTime"
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
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:emergency_complete:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="emergency_completeList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="ID" align="center" prop="id" />
      <el-table-column label="事件地点" align="center" prop="location" />
      <el-table-column label="事件信息" align="center" prop="emergenciesMessage" />
      <el-table-column label="处理部门" align="center" prop="department" />
      <el-table-column label="处理状态" align="center" prop="stateEmergencies" />
      <el-table-column label="紧急程度" align="center" prop="emergenciesLevel" />
      <el-table-column label="发生日期" align="center" prop="emergenciesTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.emergenciesTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:emergency_complete:edit']"
          >已处理</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:emergency_complete:edit']"
          >待处理</el-button>
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

    <!-- 添加或修改事件处理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="事件地点" prop="location">
          <el-input v-model="form.location" placeholder="请输入事件地点" />
        </el-form-item>
        <el-form-item label="事件信息" prop="emergenciesMessage">
          <el-input v-model="form.emergenciesMessage" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="处理部门" prop="department">
          <el-input v-model="form.department" placeholder="请输入处理部门" />
        </el-form-item>
        <el-form-item label="处理状态" prop="stateEmergencies">
          <el-input v-model="form.stateEmergencies" placeholder="请输入处理状态" />
        </el-form-item>
        <el-form-item label="紧急程度" prop="emergenciesLevel">
          <el-input v-model="form.emergenciesLevel" placeholder="请输入紧急程度" />
        </el-form-item>
        <el-form-item label="发生日期" prop="emergenciesTime">
          <el-date-picker clearable
            v-model="form.emergenciesTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择发生日期">
          </el-date-picker>
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
import { listEmergency_complete, getEmergency_complete, delEmergency_complete, addEmergency_complete, updateEmergency_complete } from "@/api/system/emergency_complete";
import { getUserProfile } from "@/api/system/user";

export default {
  name: "Emergency_complete",
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
      // 事件处理表格数据
      emergency_completeList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 发生日期时间范围
      daterangeEmergenciesTime: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        location: null,
        emergenciesMessage: null,
        department: null,
        stateEmergencies: null,
        emergenciesLevel: null,
        emergenciesTime: null
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
    /** 查询事件处理列表 */
    getList() {
      this.loading = true;
      this.queryParams.params = {};
      if (null != this.daterangeEmergenciesTime && '' != this.daterangeEmergenciesTime) {
        this.queryParams.params["beginEmergenciesTime"] = this.daterangeEmergenciesTime[0];
        this.queryParams.params["endEmergenciesTime"] = this.daterangeEmergenciesTime[1];
      }
      getUserProfile().then(response => {
        this.queryParams.department = response.data.deptId;
        listEmergency_complete(this.queryParams).then(response => {
          this.emergency_completeList = response.rows;
          this.total = response.total;
          this.loading = false;
        });
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
        location: null,
        emergenciesMessage: null,
        department: null,
        stateEmergencies: null,
        emergenciesLevel: null,
        emergenciesTime: null
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
      this.daterangeEmergenciesTime = [];
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
      this.title = "添加事件处理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getEmergency_complete(id).then(response => {
        this.form = response.data;
        this.form.stateEmergencies = 1;
        if (this.form.id != null) {
          updateEmergency_complete(this.form).then(response => {
            this.$modal.msgSuccess("处理完成");
            this.getList();
          });
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      this.reset();
      const id = row.id || this.ids
      getEmergency_complete(id).then(response => {
        this.form = response.data;
        this.form.stateEmergencies = 0;
        if (this.form.id != null) {
          updateEmergency_complete(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.getList();
          });
        }
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateEmergency_complete(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addEmergency_complete(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/emergency_complete/export', {
        ...this.queryParams
      }, `emergency_complete_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
