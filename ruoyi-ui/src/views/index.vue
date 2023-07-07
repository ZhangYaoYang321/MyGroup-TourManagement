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
  </div>
</template>

<script>
import { listHotel_prices } from '@/api/system/hotel_prices'
import { listHotel_prices2, getTodayTickets } from '@/api/notificationbar'
import { listTicket_services } from '@/api/system/ticket_services'
import { listTicket_prices } from '@/api/system/ticket_prices'

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
    }, 5000); // 设置更新间隔，单位为毫秒，这里设置为5秒
  },
  methods: {
    goTarget(href) {
      window.open(href, "_blank");
    },
    drawLine () {
      listHotel_prices2().then(response => {
        this.roomsList=response.rows;
        this.reserved_rooms=0;
        this.check_in_rooms=0;
        for(let i in this.roomsList){
          console.log(this.reserved_rooms.toString());
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
        console.log(this.ticket_servicesList); // 检查 ticket_servicesList 数据
        for (let i in this.ticket_servicesList) {
          const ticketService = this.ticket_servicesList[i];
          const countItem = countList.find(item => item.id == ticketService.typeTicket);
          if (countItem) {
            countItem.count++;
          }
        }
        console.log(countList); // 检查 countList 数据

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
}
</style>

