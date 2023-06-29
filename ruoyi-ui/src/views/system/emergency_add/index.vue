<template>
  <div class="app-container">
    <el-form ref="form" :model="form" :rules="rules" label-width="80px">
      <el-form-item label="事件地点" prop="location">
        <el-input v-model="form.location" placeholder="请输入事件地点" />
      </el-form-item>
      <el-form-item label="事件信息" prop="emergenciesMessage">
        <el-input v-model="form.emergenciesMessage" type="textarea" placeholder="请输入内容" />
      </el-form-item>
      <el-form-item label="紧急程度" prop="emergenciesLevel">
        <el-input v-model="form.emergenciesLevel" placeholder="请输入紧急程度" />
      </el-form-item>
      <el-form-item label="发生时间" prop="emergenciesTime">
        <el-date-picker clearable
                        v-model="form.emergenciesTime"
                        type="datetime"
                        placeholder="请选择发生日期">
        </el-date-picker>

      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button type="primary" @click="submitForm">上 报</el-button>
      <el-button @click="cancel">清 空</el-button>
    </div>
  </div>
</template>

<script>
import { listEmergency_add, getEmergency_add, delEmergency_add, addEmergency_add, updateEmergency_add } from "@/api/system/emergency_add";

export default {
  name: "Emergency_add",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        location: [
          { required: true, message: "事件地点不能为空", trigger: "blur" }
        ],
        emergenciesMessage: [
          { required: true, message: "事件信息不能为空", trigger: "blur" }
        ],
        emergenciesLevel: [
          { required: true, message: "事件等级不能为空", trigger: "blur" }
        ],
        emergenciesTime: [
          { required: true, message: "发生时间不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.reset();
  },
  methods: {
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
        stateEmergencies: 0,
        emergenciesLevel: null,
        emergenciesTime: null
      };
      this.resetForm("form");
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          addEmergency_add(this.form).then(response => {
            this.$modal.msgSuccess("新增成功");
          this.open = false;
          this.getList();
          });
        }
      });
      this.reset();
    }
  }
};
</script>
