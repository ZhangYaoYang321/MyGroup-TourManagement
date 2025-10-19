<template>
  <div class="app-container">
    <!-- 搜索和筛选区域 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" label-width="80px" class="mb8">
      <el-form-item label="推荐类型" prop="type">
        <el-select
          v-model="queryParams.type"
          placeholder="请选择推荐类型"
          clearable
          @change="handleQuery"
        >
          <el-option label="景点" value="scenery"></el-option>
          <el-option label="酒店" value="hotel"></el-option>
          <el-option label="路线" value="route"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="目的地" prop="destination">
        <el-input
          v-model="queryParams.destination"
          placeholder="请输入目的地"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="价格范围">
        <el-range-picker
          v-model="priceRange"
          range-separator="至"
          start-placeholder="最低价格"
          end-placeholder="最高价格"
          @change="handlePriceChange"
        ></el-range-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <!-- 推荐列表 -->
    <el-row :gutter="20" class="mb8">
      <el-col :span="6" v-for="(item, index) in recommendationList" :key="index">
        <el-card :body-style="{ padding: '10px' }">
          <div slot="header" class="clearfix">
            <span>{{ item.name }}</span>
            <el-rate
              v-model="item.rate"
              disabled
              size="mini"
              class="float-right"
            ></el-rate>
          </div>
          <div class="recommend-img">
            <img :src="item.imageUrl" class="image">
          </div>
          <div class="recommend-info">
            <p class="desc">{{ item.description }}</p>
            <div class="price">
              <span class="money">¥{{ item.price }}</span>
              <span class="unit">{{ item.unit }}</span>
            </div>
            <el-button
              type="text"
              class="detail-btn"
              @click="handleDetail(item)"
            >查看详情</el-button>
          </div>
        </el-card>
      </el-col>
    </el-row>

    <!-- 分页 -->
    <pagination
      v-show="total > 0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 详情弹窗 -->
    <el-dialog :title="detailTitle" :visible.sync="openDetail" width="700px" append-to-body>
      <el-row :gutter="20">
        <el-col :span="10">
          <img :src="detailData.imageUrl" class="detail-img">
        </el-col>
        <el-col :span="14">
          <el-descriptions column="1" border>
            <el-descriptions-item label="名称">{{ detailData.name }}</el-descriptions-item>
            <el-descriptions-item label="类型">{{ getTypeName(detailData.type) }}</el-descriptions-item>
            <el-descriptions-item label="地址">{{ detailData.address }}</el-descriptions-item>
            <el-descriptions-item label="价格">{{ detailData.price }} {{ detailData.unit }}</el-descriptions-item>
            <el-descriptions-item label="评分">{{ detailData.rate }} 分</el-descriptions-item>
            <el-descriptions-item label="推荐理由">{{ detailData.reason }}</el-descriptions-item>
          </el-descriptions>
        </el-col>
      </el-row>
      <div slot="footer" class="dialog-footer">
        <el-button @click="openDetail = false">关闭</el-button>
        <el-button type="primary" @click="handleReserve(detailData)">立即预订</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listRecommendation } from "@/api/system/recommendation";

export default {
  name: "Recommendation",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 推荐列表
      recommendationList: [],
      // 总条数
      total: 0,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 8,
        type: "",
        destination: "",
        minPrice: null,
        maxPrice: null
      },
      // 价格范围
      priceRange: [],
      // 详情弹窗显示控制
      openDetail: false,
      // 详情标题
      detailTitle: "",
      // 详情数据
      detailData: {}
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询推荐列表 */
    getList() {
      this.loading = true;
      listRecommendation(this.queryParams).then(response => {
        this.recommendationList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.priceRange = [];
      this.$refs.queryForm.resetFields();
      this.queryParams.minPrice = null;
      this.queryParams.maxPrice = null;
      this.handleQuery();
    },
    /** 价格范围变化 */
    handlePriceChange(val) {
      if (val) {
        this.queryParams.minPrice = val[0];
        this.queryParams.maxPrice = val[1];
      } else {
        this.queryParams.minPrice = null;
        this.queryParams.maxPrice = null;
      }
    },
    /** 查看详情 */
    handleDetail(item) {
      this.detailData = item;
      this.detailTitle = `${this.getTypeName(item.type)}详情`;
      this.openDetail = true;
    },
    /** 获取类型名称 */
    getTypeName(type) {
      const typeMap = {
        scenery: "景点",
        hotel: "酒店",
        route: "路线"
      };
      return typeMap[type] || type;
    },
    /** 立即预订 */
    handleReserve(item) {
      // 根据类型跳转到不同的预订页面
      if (item.type === 'hotel') {
        this.$router.push({ path: '/hotel/reservation', query: { id: item.id } });
      } else if (item.type === 'scenery') {
        this.$router.push({ path: '/system/ticket_services/scenery', query: { id: item.id } });
      } else {
        this.$modal.msgSuccess("即将为您跳转到预订页面");
      }
      this.openDetail = false;
    }
  }
};
</script>

<style scoped>
.recommend-img {
  position: relative;
  height: 180px;
  overflow: hidden;
}

.image {
  width: 100%;
  height: 100%;
  object-fit: cover;
  transition: all 0.3s ease;
}

.image:hover {
  transform: scale(1.05);
}

.recommend-info {
  padding: 10px;
}

.desc {
  display: -webkit-box;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 2;
  overflow: hidden;
  margin-bottom: 10px;
  height: 40px;
  font-size: 13px;
  color: #666;
}

.price {
  display: flex;
  align-items: center;
  margin-bottom: 10px;
}

.money {
  font-size: 16px;
  color: #f56c6c;
  font-weight: bold;
}

.unit {
  font-size: 12px;
  color: #999;
  margin-left: 5px;
}

.detail-btn {
  width: 100%;
  color: #409eff;
  padding: 5px 0;
}

.detail-img {
  width: 100%;
  height: 300px;
  object-fit: cover;
  border-radius: 4px;
}
</style>