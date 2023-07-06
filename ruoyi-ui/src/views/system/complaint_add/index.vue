<template>
  <div class="app-container">
    <el-form ref="form" :model="form" :rules="rules" label-width="80px">
      <el-form-item label="投诉信息" prop="complaintsMessage">
        <el-input v-model="form.complaintsMessage" type="textarea" placeholder="请输入内容" />
      </el-form-item>
      <el-form-item label="投诉时间" prop="complaintsDate">
        <el-date-picker clearable
                        v-model="form.complaintsDate"
                        type="datetime"
                        value-format="yyyy-MM-dd hh:mm:ss"
                        readonly="true">
        </el-date-picker>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button type="primary" @click="submitForm">提 交</el-button>
      <el-button @click="cancel">清 空</el-button>
    </div>
  </div>
</template>

<script>
import { listComplaint_add, getComplaint_add, delComplaint_add, addComplaint_add, updateComplaint_add } from "@/api/system/complaint_add";

export default {
  name: "Complaint_add",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 投诉表格数据
      complaint_addList: [],
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        complaintsMessage: [
          { required: true, message: "投诉信息不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.reset();
  },
  methods: {
    // 取消按钮
    cancel() {
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        complaintsId: this.getProjectNum() + Math.floor(Math.random() * 100),
        complaintsMessage: null,
        stateComplaints: 0,
        complaintsReplyDate: null,
        complaintsReplyMessage: null,
        complaintsDate: new Date()
      };
      this.resetForm("form");
    },
    // 获取当前日期的方法
    getProjectNum () {
      const projectTime = new Date() // 当前中国标准时间
      const Year = projectTime.getFullYear() // 获取当前年份 支持IE和火狐浏览器.
      const Month = projectTime.getMonth() + 1 // 获取中国区月份
      const Day = projectTime.getDate() // 获取几号
      var CurrentDate = String(Year)
      if (Month >= 10) { // 判断月份和几号是否大于10或者小于10
        CurrentDate += Month
      } else {
        CurrentDate += '0' + Month
      }
      if (Day >= 10) {
        CurrentDate += Day
      } else {
        CurrentDate += '0' + Day
      }
      return CurrentDate
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          addComplaint_add(this.form).then(response => {
            this.$modal.msgSuccess("新增成功");
          });
        }
      });
      this.reset();
    }
  }
};
</script>
