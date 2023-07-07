<template>
  <div class="app-container home">
    <el-row :gutter="20">
      <el-col :span="9">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span>酒店住房</span><!--标间价格，数量，单人间价格数量，家庭套房价格数量，总剩余空房数-->
          </div>
          <div class="body">
            <div id="myChart" style="width:100%;height:400px;float:left;"></div>
          </div>
        </el-card>
      </el-col>

      <el-col :span="3">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span>住房价格</span>
          </div>
          <div class="body" style="width:100%;height:400px;float:left;">
            <p v-for="room in hotel_pricesList" :key="room.typeRoom">
              {{ room.typeRoom }}：<br>{{ room.priceRoom }}元<br>
            </p>
          </div>
        </el-card>
      </el-col>

      <el-col :span="9">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span>景区门票</span>
          </div>
          <div class="body">
            <div id="myChart2" style="width:100%;height:400px;float:left;"></div>
          </div>
        </el-card>
      </el-col>

      <el-col :span="3">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span>门票价格</span>
          </div>
          <div class="body" style="width:100%;height:400px;float:left;">
            <p v-for="ticket in ticket_pricesList" :key="ticket.typeTicket">
              {{ ticket.typeTicket }}：<br>{{ ticket.priceTicket }}元<br>
            </p>
          </div>
        </el-card>
      </el-col>
    </el-row>

    <el-row :gutter="20" style="margin-top: 10px">
      <el-col :span="9" style="height: 400px">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span class="card-title">当日事件</span>
          </div>
          <div style="width: 100%; height: 360px; overflow-x: auto;">
            <div class="body">
              <div class="event-wrapper">
                <div v-for="(event, index) in epagedEvents" :key="index" class="event">
                  <span class="label">发生时间：</span><br>
                  <span class="content">{{ parseTime(event.emergenciesTime, '{y}-{m}-{d} {h}:{i}:{s}') }}</span><br><br>
                  <span class="label">发生地点：</span><br>
                  <span class="content">{{ event.location }}</span><br><br>
                  <span class="label">详细信息：</span><br>
                  <span class="content">{{ event.emergenciesMessage }}</span><br><br>
                  <span class="label">紧急程度：</span><br>
                  <div class="urgency-bar">
                    <div
                      v-for="level in 3"
                      :key="level"
                      :class="['urgency-bar-item', { 'ur-active': level <= event.emergenciesLevel }, { 'ur-inactive': level > event.emergenciesLevel }]"
                    ></div>
                  </div><br><br>
                  <span class="label" >处理部门：</span><br>
                  <span class="content">{{ event.department || '暂未下放，等待处理中……'}}</span><br><br>
                  <span class="label">处理状态：</span><br>
                  <div v-if="event.stateEmergencies == 0" class="status-box pink">
                    未处理
                  </div>
                  <div v-else-if="event.stateEmergencies == 1" class="status-box light-green">
                    已处理
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="page-dots">
            <span
              v-for="(event, index) in emergenciesList"
              :key="index"
              class="dot"
              :class="{ 'active': index === ecurrentPage }"
              @click="goToEmergenciesPage(index)"
            ></span>
          </div>
        </el-card>
      </el-col>

      <el-col :span="3" style="height: 400px">
        <el-card :class="isFull ? 'card-full' : 'card-not-full'">
          <div slot="header" class="clearfix">
            <span>景区流量</span>
          </div>
          <div class="capacity">
            <div class="peopleInfo">
              <div class="count">
                {{ this.peopleCount }} / {{ this.totalCount }}
              </div>
              <div class="status">
                {{ isFull ? '已满' : '未满' }}
              </div>
            </div>
          </div>
        </el-card>

      </el-col>

      <el-col :span="9" style="height: 400px">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span class="card-title">当日投诉</span>
          </div>
          <div style="width: 100%; height: 360px; overflow-x: auto;">
            <div class="body">
              <div class="event-wrapper">
                <div v-for="(complaint, index) in cpagedComplaints" :key="index" class="event">
                  <span class="label">投诉ID：</span><br>
                  <span class="content">{{ complaint.complaintsId }}</span><br><br>
                  <span class="label">投诉内容：</span><br>
                  <span class="content">{{ complaint.complaintsMessage }}</span><br><br>
                  <span class="label">处理状态：</span><br>
                  <div v-if="complaint.stateComplaints == 0" class="status-box pink">
                    未处理
                  </div>
                  <div v-else-if="complaint.stateComplaints == 1" class="status-box light-green">
                    已处理
                  </div><br><br>
                  <span class="label">回复内容：</span><br>
                  <span class="content">{{ complaint.complaintsReplyMessage || '暂未回复，等待处理中……' }}</span><br><br>
                </div>
              </div>
            </div>
          </div>
          <div class="page-dots">
            <span
              v-for="(complaint, index) in complaintsList"
              :key="index"
              class="dot"
              :class="{ 'active': index === ccurrentPage }"
              @click="goToComplaintsPage(index)"
            ></span>
          </div>
        </el-card>
      </el-col>

      <el-col :span="3" style="height: 400px">
        <el-card :class="isFull ? 'card-full' : 'card-not-full'">
          <div slot="header" class="clearfix">
            <span>停车场流量</span>
          </div>
          <div class="capacity">
            <div class="parking-info">
              <div class="count">
                {{ this.occupiedCountCar }} / {{ this.totalCountCar }}
              </div>
              <div class="status">
                {{ isFullCar ? '已满' : '未满' }}
              </div>
            </div>
          </div>
        </el-card>
      </el-col>
    </el-row>


  </div>
</template>

<script>
import { listHotel_prices } from '@/api/system/hotel_prices'
import { listHotel_prices2, getTodayTickets, getTodayEmergencies, getTodayComplaints, getParkingCount2, getPeopleCounts2 } from '@/api/notificationbar'
import { getPeopleCounts, listTicket_services } from '@/api/system/ticket_services'
import { listTicket_prices } from '@/api/system/ticket_prices'
import {listEmergencies} from "@/api/system/emergencies";
import {getDept, listDept} from "@/api/system/dept";
import {getParkingCount} from "@/api/system/cars";

export default {
  name: "Index",
  data() {
    return {
      // 版本号
      version: "3.8.5",
      myChart: '',
      myChart2: '',
      hotel_prices_single:0,
      hotel_prices_double:0,
      hotel_prices_family:0,
      ticket_prices_kids:0,
      ticket_prices_stu:0,
      ticket_prices_ad:0,
      ticket_prices_older:0,
      ticket_prices_vip:0,
      free_rooms:0,
      reserved_rooms:0,
      check_in_rooms:0,
      ticket_servicesList:[],
      roomsList:[],
      ticket_pricesList:[],
      hotel_pricesList:[],
      emergenciesList: [], // 事件列表数据
      ecurrentPage: 0, // 当前页码
      eitemsPerPage: 1, // 每页显示的事件数量
      complaintsList: [], // 投诉列表数据
      ccurrentPage: 0, // 当前页码
      citemsPerPage: 1, // 每页显示的投诉数量
      peopleCountsList:[],
      parkingCountList:[],
      peopleCount: 0,
      totalCount: 0,
      occupiedCountCar: 0,
      totalCountCar: 0,
      opinionData2: [
        { value: null, name: '已入住', itemStyle: 'red' },
        { value: null, name: '空房', itemStyle: '#1FC48D' },
        { value: null, name: '已预定', itemStyle: '#3F8FFF' }
      ],
      opinionData3: [
        { value: 1, name: '儿童票', itemStyle: '#229692' },
        { value: 3, name: '学生票', itemStyle: '#1FC48D' },
        { value: 45, name: '成人票', itemStyle: '#3F8FFF' },
        { value: 3, name: '长者票', itemStyle: '#5ab1f6' },
        { value: 3, name: 'VIP票', itemStyle: '#006cc2' }
      ],queryParams: {
        pageNum: 1,
        pageSize: 10,
        typeRoom: null,
        priceRoom: null,
        totalRooms: null,
        freeRooms: null
      },
      // 表单参数
      form: {}
    };
  },
  mounted: function () {
    this.getList(),
    this.drawLine(),
    this.drawLine2(),
    // 定时器，每隔一段时间调用getList()方法，实现实时更新
    setInterval(() => {
      this.getList();
      this.drawLine();
      this.drawLine2();
      this.ecurrentPage = (this.ecurrentPage + 1) % this.emergenciesList.length;
      this.ccurrentPage = (this.ccurrentPage + 1) % this.complaintsList.length;
    }, 5000); // 设置更新间隔，单位为毫秒，这里设置为5秒
  },
  computed: {
    etotalPages() {
      return Math.ceil(this.emergenciesList.length / this.eitemsPerPage);
    },
    epagedEvents() {
      const startIndex = this.ecurrentPage * this.eitemsPerPage;
      const endIndex = startIndex + this.eitemsPerPage;
      return this.emergenciesList.slice(startIndex, endIndex);
    },
    ctotalPages() {
      return Math.ceil(this.complaintsList.length / this.citemsPerPage);
    },
    cpagedComplaints() {
      const startIndex = this.ccurrentPage * this.citemsPerPage;
      const endIndex = startIndex + this.citemsPerPage;
      return this.complaintsList.slice(startIndex, endIndex);
    },
    isFull() {
      return this.peopleCount >= this.totalCount;
    },
    isFullCar() {
      return this.occupiedCountCar >= this.totalCountCar;
    }
  },
  methods: {
    goTarget(href) {
      window.open(href, "_blank");
    },
    goToEmergenciesPage(page) {
      this.ecurrentPage = page;
    },
    goToComplaintsPage(page) {
      this.ccurrentPage = page;
    },
    drawLine () {
      listHotel_prices2().then(response => {
        this.roomsList=response.rows;
        this.reserved_rooms=0;
        this.check_in_rooms=0;
        for(let i in this.roomsList){
          if(this.roomsList[i]=='已预约')
            this.reserved_rooms=this.reserved_rooms+1;
          else
            this.check_in_rooms=this.check_in_rooms+1;
        }
        this.free_rooms=160-this.reserved_rooms-this.check_in_rooms;
        this.myChart = this.$echarts.init(document.getElementById('myChart'));
        this.opinionData2.at(0).value=this.check_in_rooms;
        this.opinionData2.at(1).value=this.free_rooms;
        this.opinionData2.at(2).value=this.reserved_rooms;
        this.myChart.setOption({
          title: {
            text: '今日住房情况', // 主标题
            subtext: '', // 副标题
            x: 'left' // x轴方向对齐方式
          },
          grid: { containLabel: true },
          tooltip: {
            trigger: 'item',
            formatter: '{a} <br/>{b} : {d}%'
          },
          color: ['red', '#1FC48D', '#3F8FFF'],
          // backgroundColor: '#ffffff',
          legend: {
            orient: 'vertical',
            icon: 'circle',
            align: 'left',
            x: 'right',
            y: 'bottom',
            data: ['已入住', '空房', '已预定']
          },
          series: [
            {
              name: '住房情况',
              type: 'pie',
              radius: ['50%', '70%'],
              avoidLabelOverlap: false,
              center: ['50%', '50%'],
              itemStyle: {
                emphasis: {
                  shadowBlur: 10,
                  shadowOffsetX: 0,
                  shadowColor: 'rgba(0, 0, 0, 0.5)'
                },
                color: function (params) {
                  // 自定义颜色
                  var colorList = ['red', '#1FC48D','#3F8FFF']
                  return colorList[params.dataIndex]
                }
              },
              label:{
                formatter: '{b}\n{c}间',
              },
              data: this.opinionData2
            }
          ]
        })
      });
    },

    drawLine2() {
      listTicket_prices(this.queryParams).then(response => {
        // 创建 countList 数组并初始化为 0
        const countList = this.ticket_pricesList.map(ticket => ({
          id: ticket.id,
          type: ticket.typeTicket,
          count: 0
        }));
        // 更新票务数据统计
        for (let i in this.ticket_servicesList) {
          const ticketService = this.ticket_servicesList[i];
          const countItem = countList.find(item => item.id == ticketService.typeTicket);
          if (countItem) {
            countItem.count++;
          }
        }
        this.myChart2 = this.$echarts.init(document.getElementById('myChart2'));
        this.myChart2.setOption({
          title: {
            text: '门票售出情况',
            subtext: '',
            x: 'left'
          },
          grid: { containLabel: true },
          tooltip: {
            trigger: 'item',
            formatter: '{a} <br/>{b} : {d}%'
          },
          legend: {
            orient: 'vertical',
            icon: 'circle',
            align: 'left',
            x: 'right',
            y: 'bottom',
            data: countList.map(item => item.type)
          },
          series: [
            {
              name: '售票情况',
              type: 'pie',
              radius: ['50%', '70%'],
              avoidLabelOverlap: false,
              center: ['50%', '50%'],
              label: {
                formatter: '{b}\n{c}张'
              },
              data: countList.map(item => {
                return {
                  value: item.count,
                  name: item.type
                };
              })
            }
          ]
        });
      });
    },

    getList() {
      listHotel_prices(this.queryParams).then(response => {
        this.hotel_pricesList = response.rows;
      });
      listTicket_prices(this.queryParams).then(response => {
        this.ticket_pricesList = response.rows;
        getTodayTickets().then(response => {
          this.ticket_servicesList = response.rows;
          this.drawLine2();
        });
      });
      getTodayEmergencies(this.queryParams).then(response => {
        this.emergenciesList = response.rows;
      });
      getTodayComplaints(this.queryParams).then((response) => {
        this.complaintsList = response.rows;
      });
      getPeopleCounts2().then(response => {
        this.totalCount = response.rows[0].value;
        this.peopleCount = response.rows[1].value;
      });
      getParkingCount2().then(response => {
        this.totalCountCar = response.rows[0].value;
        this.occupiedCountCar = response.rows[1].value;
      });
    },

  }
};
</script>

<style scoped lang="scss">
.home {
  blockquote {
    padding: 10px 20px;
    margin: 0 0 20px;
    font-size: 17.5px;
    border-left: 5px solid #eee;
  }
  hr {
    margin-top: 20px;
    margin-bottom: 20px;
    border: 0;
    border-top: 1px solid #eee;
  }
  .col-item {
    margin-bottom: 20px;
  }

  .card-full {
    background-color: #e18683;
  }

  .card-not-full {
    background-color: #a6ec99;
  }

  ul {
    padding: 0;
    margin: 0;
  }

  font-family: "open sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
  font-size: 13px;
  color: #676a6c;
  overflow-x: hidden;

  ul {
    list-style-type: none;
  }

  h4 {
    margin-top: 0px;
  }

  h2 {
    margin-top: 10px;
    font-size: 26px;
    font-weight: 100;
  }

  p {
    margin-top: 10px;

    b {
      font-weight: 700;
    }
  }

  .update-log {
    ol {
      display: block;
      list-style-type: decimal;
      margin-block-start: 1em;
      margin-block-end: 1em;
      margin-inline-start: 0;
      margin-inline-end: 0;
      padding-inline-start: 40px;
    }
  }

  .page-dots {
    display: flex;
    justify-content: center;
    margin-top: 10px;
  }

  .dot {
    width: 10px;
    height: 10px;
    border-radius: 50%;
    background-color: gray;
    margin: 0 5px;
    cursor: pointer;
  }

  .active {
    background-color: black;
  }

  .label {
    font-size: 14px;
    font-weight: bold;
    color: #333;
    margin-right: 5px;
  }

  .content {
    font-size: 16px;
    color: #666;
  }

  .status-box {
    display: inline-block;
    padding: 4px 8px;
    border-radius: 4px;
    font-size: 14px;
    font-weight: bold;
  }

  .pink {
    background-color: pink;
    color: white;
  }

  .light-green {
    background-color: lightgreen;
    color: black;
  }

  .urgency-bar {
    display: flex;
    align-items: center;
    height: 20px;
    width: 50%;
  }

  .urgency-bar-item {
    flex: 1;
    height: 100%;
    transition: background-color 0.3s;
  }

  .urgency-bar-item:nth-child(1) {
    background-color: lightblue;
    border-top-left-radius: 4px;
    border-bottom-left-radius: 4px;
  }

  .urgency-bar-item:nth-child(2) {
    background-color: orange;
  }

  .urgency-bar-item:nth-child(3) {
    background-color: purple;
    border-top-right-radius: 4px;
    border-bottom-right-radius: 4px;
  }

  .ur-active {
    opacity: 1;
  }

  .ur-inactive {
    background-color: lightgray !important;
  }

  .capacity {
    height: 380px;
  }
}
</style>
