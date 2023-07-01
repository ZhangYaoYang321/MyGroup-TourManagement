<template>
  <div class="app-container">

    <div class="container" :class="isFull ? 'full-container' : 'not-full-container'">
      <div class="buttons-container">
        <div class="buttons-group">
          <el-button
            type="success"
            plain
            icon="el-icon-s-flag"
            size="large"
            @click="handleParking"
            v-hasPermi="['system:cars:parking']"
            class="vertical-button"
          >车辆入场
          </el-button>
          <el-button
            type="primary"
            plain
            icon="el-icon-s-release"
            size="large"
            @click="handleLeaving"
            v-hasPermi="['system:cars:leaving']"
            class="vertical-button"
          >车辆出场
          </el-button>
          <el-button
            type="warning"
            plain
            icon="el-icon-s-comment"
            size="large"
            @click="handleSearch"
            v-hasPermi="['system:cars:search']"
            class="vertical-button"
          >车辆查询
          </el-button>
        </div>
      </div>

      <div class="content">
        <div class="parking-info" :class="isFull ? 'full' : 'not-full'">
          <div class="count">
            {{ this.occupiedCount }} / {{ this.totalCount }}
          </div>
          <div class="status">
            {{ isFull ? '已满' : '未满' }}
          </div>
        </div>
      </div>
    </div>

    <!-- 输入车牌号弹窗 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="车牌号" prop="carId">
          <el-input v-model="form.carId" placeholder="请输入车牌号"/>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>

    <!-- 车辆查询 -->
    <el-dialog ref="carInfoDialog"
               title="车辆信息"
               v-if="carInfoDialog"
               :visible.sync="carInfoDialog"
               width="500px"
               append-to-body
               class="car-info-dialog">
      <div v-if="carInfo.rows.length == 0">
        无该车辆信息
      </div>
      <div v-else>
        <div v-for="(result, index) in carInfo.rows" :key="index">
          <el-row>
            <el-col :span="6">车牌号：</el-col>
            <el-col :span="18">{{ result.carId }}</el-col>
          </el-row>
          <el-row>
            <el-col :span="6">入场时间：</el-col>
            <el-col :span="18">{{ parseTime(result.carInTime, '{y}-{m}-{d} {h}:{i}:{s}') }}</el-col>
          </el-row>
          <el-row>
            <el-col :span="6">出场时间：</el-col>
            <el-col :span="18">{{ parseTime(result.carOutTime, '{y}-{m}-{d} {h}:{i}:{s}') }}</el-col>
          </el-row>
          <el-row>
            <el-col :span="6">停车状态：</el-col>
            <el-col :span="18">{{ result.stateParking == 1 ? "已入场" : result.stateParking == 2 ? "已出场" : "警告" }}</el-col>
          </el-row>
          <el-row>
            <el-col :span="6">停车费：</el-col>
            <el-col :span="18">{{ result.parkingCost }}元</el-col>
          </el-row>
          <hr v-if="index !== carInfo.length - 1" />
        </div>
      </div>
      <div slot="footer" class="dialog-footer">
        <el-button @click="carInfoDialog = false">确 定</el-button>
      </div>
    </el-dialog>

    <!--    <el-table v-loading="loading" :data="carsList" @selection-change="handleSelectionChange">-->
    <!--      <el-table-column type="selection" width="55" align="center"/>-->
    <!--      <el-table-column label="ID" align="center" prop="id"/>-->
    <!--      <el-table-column label="车牌号" align="center" prop="carId"/>-->
    <!--      <el-table-column label="入场时间" align="center" prop="carInTime" width="180">-->
    <!--        <template slot-scope="scope">-->
    <!--          <span>{{ parseTime(scope.row.carInTime, '{y}-{m}-{d} {h}:{i}:{s}') }}</span>-->
    <!--        </template>-->
    <!--      </el-table-column>-->
    <!--      <el-table-column label="出场时间" align="center" prop="carOutTime" width="180">-->
    <!--        <template slot-scope="scope">-->
    <!--          <span>{{ parseTime(scope.row.carOutTime, '{y}-{m}-{d} {h}:{i}:{s}') }}</span>-->
    <!--        </template>-->
    <!--      </el-table-column>-->
    <!--      <el-table-column label="停车费" align="center">-->
    <!--        <template slot-scope="scope">-->
    <!--          <span>{{ scope.row.parkingCost }}</span>-->
    <!--          <span>元</span>-->
    <!--        </template>-->
    <!--      </el-table-column>-->
    <!--      <el-table-column label="停车状态" align="center" prop="stateParking">-->
    <!--        <template slot-scope="scope">-->
    <!--          <span :style="{-->
    <!--            'background-color': scope.row.stateParking == 1 ? '#00afff' : scope.row.stateParking == 2 ? '#808080' : '#ff0000',-->
    <!--            'border-radius': '30px',-->
    <!--            'color': 'white',-->
    <!--            'padding': '5px 9px',-->
    <!--            'display': 'inline-block',-->
    <!--            'box-shadow': '0 2px 5px rgba(0, 0, 0, 0.3)'-->
    <!--          }">-->
    <!--            {{ scope.row.stateParking == 1 ? "已入场" : scope.row.stateParking == 2 ? "已出场" : "警告" }}-->
    <!--          </span>-->
    <!--        </template>-->
    <!--      </el-table-column>-->
    <!--      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">-->
    <!--        <template slot-scope="scope">-->
    <!--          <el-button-->
    <!--            size="mini"-->
    <!--            type="text"-->
    <!--            icon="el-icon-edit"-->
    <!--            @click="handleUpdate(scope.row)"-->
    <!--            v-hasPermi="['system:cars:edit']"-->
    <!--          >修改-->
    <!--          </el-button>-->
    <!--          <el-button-->
    <!--            size="mini"-->
    <!--            type="text"-->
    <!--            icon="el-icon-delete"-->
    <!--            @click="handleDelete(scope.row)"-->
    <!--            v-hasPermi="['system:cars:remove']"-->
    <!--          >删除-->
    <!--          </el-button>-->
    <!--        </template>-->
    <!--      </el-table-column>-->
    <!--    </el-table>-->

    <!--    <pagination-->
    <!--      v-show="total>0"-->
    <!--      :total="total"-->
    <!--      :page.sync="queryParams.pageNum"-->
    <!--      :limit.sync="queryParams.pageSize"-->
    <!--      @pagination="getList"-->
    <!--    />-->
  </div>
</template>

<script>
import {
  listCars,
  getCars,
  delCars,
  addCars,
  updateCars,
  parkingCars,
  leavingCars,
  searchCars,
  getParkingCount
} from "@/api/system/cars";

export default {
  name: "Cars",
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
      // 车辆表格数据
      carsList: [],
      // 车辆信息弹窗
      carInfoDialog: false,
      // 用于存储查询到的车辆信息
      carInfo: [],
      // 停车场中停车数
      occupiedCount: 0,
      // 停车场总车位数
      totalCount: 1,
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 停车状态时间范围
      daterangeCarInTime: [],
      // 停车状态时间范围
      daterangeCarOutTime: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        carId: null,
        carInTime: null,
        carOutTime: null,
        parkingCost: null,
        stateParking: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        carId: [{
          required: true,
          message: '请输入车牌号',
          trigger: 'blur'
        }, {
          pattern: /^([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[a-zA-Z](([DF]((?![IO])[a-zA-Z0-9](?![IO]))[0-9]{4})|([0-9]{5}[DF]))|[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1})$/,
          message: '车牌号格式错误',
          trigger: 'blur'
        }]
      }
    };
  },
  created() {
    this.getList();
    // this.startFetchingParkingData();
  },
  methods: {
    /** 查询车辆列表 */
    getList() {
      this.loading = true;
      this.queryParams.params = {};
      this.fetchParkingData();
      if (null != this.daterangeCarInTime && '' != this.daterangeCarInTime) {
        this.queryParams.params["beginCarInTime"] = this.daterangeCarInTime[0];
        this.queryParams.params["endCarInTime"] = this.daterangeCarInTime[1];
      }
      if (null != this.daterangeCarOutTime && '' != this.daterangeCarOutTime) {
        this.queryParams.params["beginCarOutTime"] = this.daterangeCarOutTime[0];
        this.queryParams.params["endCarOutTime"] = this.daterangeCarOutTime[1];
      }
      listCars(this.queryParams).then(response => {
        this.carsList = response.rows;
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
        carId: null,
        carInTime: null,
        carOutTime: null,
        parkingCost: null,
        stateParking: null
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
      this.daterangeCarInTime = [];
      this.daterangeCarOutTime = [];
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加车辆";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getCars(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改车辆";
      });
    },
    /** 车辆入场操作 */
    handleParking() {
      this.fetchParkingData();
      if (this.isFull) {
        this.$message.warning("停车场已满！");
      } else {
        this.reset();
        this.open = true;
        this.title = "车辆入场";
      }
    },
    /** 车辆出场操作 */
    handleLeaving() {
      this.fetchParkingData();
      this.reset();
      this.open = true;
      this.title = "车辆出场";
    },
    /** 车辆查询操作 */
    handleSearch() {
      this.fetchParkingData();
      this.reset();
      this.open = true;
      this.title = "车辆查询";
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateCars(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            if (this.title === "车辆入场") {
              parkingCars(this.form.carId).then(response => {
                this.$modal.msgSuccess("车辆入场成功！" + this.form.carId);
                this.open = false;
                this.getList();
              });
            } else if (this.title === "车辆出场") {
              leavingCars(this.form.carId).then(response => {
                this.$modal.msgSuccess("车辆出场成功！" + this.form.carId);
                this.open = false;
                this.getList();
              });
            } else if (this.title === "车辆查询") {
              searchCars(this.form.carId).then(response => {
                this.carInfoDialog = false;
                this.open = false;
                if (this.carInfo = response) {
                  this.carInfoDialog = true;
                } else {
                  this.$message.warning("当日并无该车辆！");
                }
              }).catch(error => {
                  this.$message.error("查询车辆信息失败！");
              });
            }
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除车辆编号为"' + ids + '"的数据项？').then(function () {
        return delCars(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {
      });
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/cars/export', {
        ...this.queryParams
      }, `cars_${new Date().getTime()}.xlsx`)
    },
    // 获取停车数
    fetchParkingData() {
      getParkingCount().then(response => {
        this.totalCount = response.rows[0].value;
        this.occupiedCount = response.rows[1].value;
      });
    },
    // // 获取停车数定时循环
    // startFetchingParkingData() {
    //   setInterval(() => {
    //     this.fetchParkingData();
    //   }, 10000);
    // }
  },
  computed: {
    isFull() {
      return this.occupiedCount >= this.totalCount;
    }
  }
};
</script>

<style>
.car-info-dialog {
  border-radius: 10px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.15);
  /* 可根据需要自行调整其他样式属性 */
}
.car-info-dialog .el-row {
  font-size: 16px; /* 调整行的字体大小 */
}
.car-info-dialog .el-col {
  font-size: 16px; /* 调整列的字体大小 */
}
.car-info-dialog .dialog-footer {
  text-align: right; /* 将按钮右对齐 */
}
.container {
  width: 800px; /* 宽度扩大为 800px */
  height: 600px; /* 高度扩大为 600px */
  border: 1px solid #ccc;
  border-radius: 5px;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: center;
  margin: 0 auto; /* 水平居中对齐 */
  transform: scale(0.9); /* 缩小为原来的 90% */
}
.buttons-container {
  display: flex;
  justify-content: space-around;
  align-items: center;
  margin-top: 80px; /* 上部间距扩大为 40px */
  transform: scale(2);
}
.button {
  padding: 30px 60px; /* 按钮的内边距扩大为 30px 上下，60px 左右 */
  background-color: lightblue;
  border: none;
  border-radius: 5px;
  font-size: 48px; /* 字体大小扩大为 48px */
  cursor: pointer;
}
.content {
  padding: 40px; /* 内容区域的内边距扩大为 40px */
  text-align: center;
}
.full-container {
  background-color: lightcoral;
}
.not-full-container {
  background-color: lightgreen;
}
.full {
  background-color: lightcoral;
  color: white;
}
.not-full {
  background-color: lightgreen;
}
.parking-info {
  width: 400px; /* 车辆信息框宽度为 400px */
  height: 200px; /* 车辆信息框高度为 200px */
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  border: 1px solid #ccc;
  border-radius: 5px;
  font-size: 80px; /* 字体大小扩大为 80px */
  font-weight: bold;
  text-align: center;
  margin-top: 40px; /* 顶部外边距为 40px */
}
</style>
