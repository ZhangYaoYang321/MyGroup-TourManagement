
<template>
  <div class="app-container">
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
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>


    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="我的预约">
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

    <el-form :model="queryRooms" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="空房查询">
      </el-form-item>
    </el-form>

    <el-form :model="form" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="日期选择" prop="field102">
        <el-date-picker v-model="form.startDate" format="yyyy-MM-dd" value-format="yyyy-MM-dd"
                        :style="{width: '100%'}":picker-options="pickerOptions" placeholder="请选择日期" clearable></el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery2">搜索</el-button>
      </el-form-item>
    </el-form>



    <el-form ref="elForm" :model="formData" :rules="rules" size="small" label-width="0px" style="text-align: center">
      <el-form-item size="medium">
        <el-button ref="101" type="warning" >101</el-button>
        <el-button ref="102" type="warning" >102</el-button>
        <el-button ref="103" type="warning" >103</el-button>
        <el-button ref="104" type="success" >104</el-button>
        <el-button ref="105" type="success" >105</el-button>
        <el-button ref="106" type="success" >106</el-button>
        <el-button ref="107" type="success" >107</el-button>
        <el-button ref="108" type="success" >108</el-button>
        <el-button ref="109" type="success" >109</el-button>
        <el-button ref="110" type="success" >110</el-button>
        <el-button ref="111" type="success" >111</el-button>
        <el-button ref="112" type="success" >112</el-button>
        <el-button ref="113" type="success" >113</el-button>
        <el-button ref="114" type="success" >114</el-button>
        <el-button ref="115" type="success" >115</el-button>
        <el-button ref="116" type="success" >116</el-button>
        <el-button ref="117" type="success" >117</el-button>
        <el-button ref="118" type="danger">118</el-button>
        <el-button ref="119" type="danger" >119</el-button>
        <el-button ref="120" type="danger" >120</el-button>
      </el-form-item>
      <el-form-item size="medium">
        <el-button ref="201" type="warning" >201</el-button>
        <el-button ref="202" type="warning" >202</el-button>
        <el-button ref="203" type="warning" >203</el-button>
        <el-button ref="204" type="success" >204</el-button>
        <el-button ref="205" type="success" >205</el-button>
        <el-button ref="206" type="success" >206</el-button>
        <el-button ref="207" type="success" >207</el-button>
        <el-button ref="208" type="success" >208</el-button>
        <el-button ref="209" type="success" >209</el-button>
        <el-button ref="210" type="success" >210</el-button>
        <el-button ref="211" type="success" >211</el-button>
        <el-button ref="212" type="success" >212</el-button>
        <el-button ref="213" type="success" >213</el-button>
        <el-button ref="214" type="success" >214</el-button>
        <el-button ref="215" type="success" >215</el-button>
        <el-button ref="216" type="success" >216</el-button>
        <el-button ref="217" type="success" >217</el-button>
        <el-button ref="218" type="danger" >218</el-button>
        <el-button ref="219" type="danger" >219</el-button>
        <el-button ref="220" type="danger" >220</el-button>
      </el-form-item>
      <el-form-item size="medium">
        <el-button ref="301" type="warning" >301</el-button>
        <el-button ref="302" type="warning" >302</el-button>
        <el-button ref="303" type="warning" >303</el-button>
        <el-button ref="304" type="success" >304</el-button>
        <el-button ref="305" type="success" >305</el-button>
        <el-button ref="306" type="success" >306</el-button>
        <el-button ref="307" type="success" >307</el-button>
        <el-button ref="308" type="success" >308</el-button>
        <el-button ref="309" type="success" >309</el-button>
        <el-button ref="310" type="success" >310</el-button>
        <el-button ref="311" type="success" >311</el-button>
        <el-button ref="312" type="success" >312</el-button>
        <el-button ref="313" type="success" >313</el-button>
        <el-button ref="314" type="success" >314</el-button>
        <el-button ref="315" type="success" >315</el-button>
        <el-button ref="316" type="success" >316</el-button>
        <el-button ref="317" type="success" >317</el-button>
        <el-button ref="318" type="danger" >318</el-button>
        <el-button ref="319" type="danger" >319</el-button>
        <el-button ref="320" type="danger" >320</el-button>
      </el-form-item>
      <el-form-item size="medium">
        <el-button ref="401" type="warning" >401</el-button>
        <el-button ref="402" type="warning" >402</el-button>
        <el-button ref="403" type="warning" >403</el-button>
        <el-button ref="404" type="success" >404</el-button>
        <el-button ref="405" type="success" >405</el-button>
        <el-button ref="406" type="success" >406</el-button>
        <el-button ref="407" type="success" >407</el-button>
        <el-button ref="408" type="success" >408</el-button>
        <el-button ref="409" type="success" >409</el-button>
        <el-button ref="410" type="success" >410</el-button>
        <el-button ref="411" type="success" >411</el-button>
        <el-button ref="412" type="success" >412</el-button>
        <el-button ref="413" type="success" >413</el-button>
        <el-button ref="414" type="success" >414</el-button>
        <el-button ref="415" type="success" >415</el-button>
        <el-button ref="416" type="success" >416</el-button>
        <el-button ref="417" type="success" >417</el-button>
        <el-button ref="418" type="danger" >418</el-button>
        <el-button ref="419" type="danger" >419</el-button>
        <el-button ref="420" type="danger" >420</el-button>
      </el-form-item>
      <el-form-item size="medium">
        <el-button ref="501" type="warning" >501</el-button>
        <el-button ref="502" type="warning" >502</el-button>
        <el-button ref="503" type="warning" >503</el-button>
        <el-button ref="504" type="success" >504</el-button>
        <el-button ref="505" type="success" >505</el-button>
        <el-button ref="506" type="success" >506</el-button>
        <el-button ref="507" type="success" >507</el-button>
        <el-button ref="508" type="success" >508</el-button>
        <el-button ref="509" type="success" >509</el-button>
        <el-button ref="510" type="success" >510</el-button>
        <el-button ref="511" type="success" >511</el-button>
        <el-button ref="512" type="success" >512</el-button>
        <el-button ref="513" type="success" >513</el-button>
        <el-button ref="514" type="success" >514</el-button>
        <el-button ref="515" type="success" >515</el-button>
        <el-button ref="516" type="success" >516</el-button>
        <el-button ref="517" type="success" >517</el-button>
        <el-button ref="518" type="danger" >518</el-button>
        <el-button ref="519" type="danger" >519</el-button>
        <el-button ref="520" type="danger" >520</el-button>
      </el-form-item>
      <el-form-item size="medium">
        <el-button ref="601" type="warning" >601</el-button>
        <el-button ref="602" type="warning" >602</el-button>
        <el-button ref="603" type="warning" >603</el-button>
        <el-button ref="604" type="success" >604</el-button>
        <el-button ref="605" type="success" >605</el-button>
        <el-button ref="606" type="success" >606</el-button>
        <el-button ref="607" type="success" >607</el-button>
        <el-button ref="608" type="success" >608</el-button>
        <el-button ref="609" type="success" >609</el-button>
        <el-button ref="610" type="success" >610</el-button>
        <el-button ref="611" type="success" >611</el-button>
        <el-button ref="612" type="success" >612</el-button>
        <el-button ref="613" type="success" >613</el-button>
        <el-button ref="614" type="success" >614</el-button>
        <el-button ref="615" type="success" >615</el-button>
        <el-button ref="616" type="success" >616</el-button>
        <el-button ref="617" type="success" >617</el-button>
        <el-button ref="618" type="danger" >618</el-button>
        <el-button ref="619" type="danger" >619</el-button>
        <el-button ref="620" type="danger" >620</el-button>
      </el-form-item>
      <el-form-item size="medium">
        <el-button ref="701" type="warning" >701</el-button>
        <el-button ref="702" type="warning" >702</el-button>
        <el-button ref="703" type="warning" >703</el-button>
        <el-button ref="704" type="success" >704</el-button>
        <el-button ref="705" type="success" >705</el-button>
        <el-button ref="706" type="success" >706</el-button>
        <el-button ref="707" type="success" >707</el-button>
        <el-button ref="708" type="success" >708</el-button>
        <el-button ref="709" type="success" >709</el-button>
        <el-button ref="710" type="success" >710</el-button>
        <el-button ref="711" type="success" >711</el-button>
        <el-button ref="712" type="success" >712</el-button>
        <el-button ref="713" type="success" >713</el-button>
        <el-button ref="714" type="success" >714</el-button>
        <el-button ref="715" type="success" >715</el-button>
        <el-button ref="716" type="success" >716</el-button>
        <el-button ref="717" type="success" >717</el-button>
        <el-button ref="718" type="danger" >718</el-button>
        <el-button ref="719" type="danger" >719</el-button>
        <el-button ref="720" type="danger" >720</el-button>
      </el-form-item>
      <el-form-item size="medium">
        <el-button ref="801" type="warning" >801</el-button>
        <el-button ref="802" type="warning" >802</el-button>
        <el-button ref="803" type="warning" >803</el-button>
        <el-button ref="804" type="success" >804</el-button>
        <el-button ref="805" type="success" >805</el-button>
        <el-button ref="806" type="success" >806</el-button>
        <el-button ref="807" type="success" >807</el-button>
        <el-button ref="808" type="success" >808</el-button>
        <el-button ref="809" type="success" >809</el-button>
        <el-button ref="810" type="success" >810</el-button>
        <el-button ref="811" type="success" >811</el-button>
        <el-button ref="812" type="success" >812</el-button>
        <el-button ref="813" type="success" >813</el-button>
        <el-button ref="814" type="success" >814</el-button>
        <el-button ref="815" type="success" >815</el-button>
        <el-button ref="816" type="success" >816</el-button>
        <el-button ref="817" type="success" >817</el-button>
        <el-button ref="818" type="danger" >818</el-button>
        <el-button ref="819" type="danger" >819</el-button>
        <el-button ref="820" type="danger" >820</el-button>
      </el-form-item>
    </el-form>

    <!-- 添加酒店订单对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="姓名" prop="orderId">
          <el-input
            v-model="form.name"
            placeholder="请输入姓名"
            clearable
            @keyup.enter.native="handleQuery"
          />
        </el-form-item>
        <el-form-item label="身份证号" prop="cnId">
          <el-input
            v-model="form.cnId"
            placeholder="请输入身份证号"
            clearable
            @keyup.enter.native="handleQuery"
          />
        </el-form-item>
        <el-form-item label="电话号码" prop="phoneNum">
          <el-input
            v-model="form.phoneNum"
            placeholder="请输入电话号码"
            clearable
            @keyup.enter.native="handleQuery"
          />
        </el-form-item>
        <el-form-item label="开始日期" prop="field104">
          <el-date-picker v-model="form.startDate" format="yyyy-MM-dd" value-format="yyyy-MM-dd":picker-options="pickerOptions"
                          :style="{width: '100%'}" placeholder="请选择日期选择" clearable></el-date-picker>
        </el-form-item>
        <el-form-item label="结束日期" prop="field105">
          <el-date-picker v-model="form.endDate" format="yyyy-MM-dd" value-format="yyyy-MM-dd":picker-options="pickerOptions"
                          :style="{width: '100%'}" placeholder="请选择日期选择" clearable></el-date-picker>
        </el-form-item>
        <el-form-item label="房间选择" prop="field102">
          <el-cascader v-model="form.field102" :options="field102Options" :props="field102Props"
                       :style="{width: '100%'}" placeholder="请选择房间" clearable></el-cascader>
        </el-form-item>

      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>


    <!-- 修改酒店订单对话框 -->
    <el-dialog :title="title" :visible.sync="open1" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="开始日期" prop="field104">
          <el-date-picker v-model="form.startDate" format="yyyy-MM-dd" value-format="yyyy-MM-dd":picker-options="pickerOptions"
                          :style="{width: '100%'}" placeholder="请选择日期选择" clearable></el-date-picker>
        </el-form-item>
        <el-form-item label="结束日期" prop="field105">
          <el-date-picker v-model="form.endDate" format="yyyy-MM-dd" value-format="yyyy-MM-dd":picker-options="pickerOptions"
                          :style="{width: '100%'}" placeholder="请选择日期选择" clearable></el-date-picker>
        </el-form-item>
        <el-form-item label="房间选择" prop="field102">
          <el-cascader v-model="form.field102" :options="field102Options" :props="field102Props"
                       :style="{width: '100%'}" placeholder="请选择房间" clearable></el-cascader>
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

import {addOrders,listOrders, updateOrders,getOrders,delOrders,listRooms} from "@/api/hotel/reservation";
import rooms from '@/views/system/rooms/index.vue'


export default {
  inheritAttrs: false,
  name: 'index.vue',
  components: {},
  props: [],
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
      // 房间总条数
      rtotal: 0,
      // 酒店订单表格数据
      ordersList: [],
      // 酒店房间表格数据
      roomsList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      open1: false,
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
      pickerOptions: {
        disabledDate: (time) => {
          return time.getTime() < Date.now() - 86400000; // 当前日期之前的日期都禁止选择
        },
      },
      rules: {
        name: [
          { required: true, message: '请姓名', trigger: 'blur' }
        ],
        phoneNum: [
          { required: true, message: '请输入手机号', trigger: 'blur' },
          {
            validator: this.validatePhoneNumber,
            trigger: 'blur',
          },
        ],
        cnId:[{ required: true, message: '请输身份证号', trigger: 'blur' },
          {
            validator: this.validateCnId,
            trigger: 'blur',
          }],
        startDate: [{
          required: true,
          message: '请选择日期选择',
          trigger: 'change'
        }],
        endDate: [{
          required: true,
          message: '请选择日期选择',
          trigger: 'change'
        }],
        field102: [{
          required: true,
          type: 'array',
          message: '请至少选择一个field102',
          trigger: 'change'
        }],
      },
      field102Options: [{
        "label": "单人间",
        "value": "单人间",
        "id": 101,
        "children": [{
          "label": "101",
          "value": 101,
          "id": 104
        }, {
          "label": "102",
          "value": 102,
          "id": 105,
        }, {
          "label": "103",
          "value": 103,
          "id": 106,
        },{
          "label": "201",
          "value": 201,
          "id": 104
        }, {
          "label": "202",
          "value": 202,
          "id": 105,
        }, {
          "label": "203",
          "value": 203,
          "id": 106,
        },{
          "label": "301",
          "value": 301,
          "id": 104
        }, {
          "label": "302",
          "value": 302,
          "id": 105,
        }, {
          "label": "303",
          "value": 303,
          "id": 106,
        },{
          "label": "401",
          "value": 401,
          "id": 104
        }, {
          "label": "402",
          "value": 402,
          "id": 105,
        }, {
          "label": "403",
          "value": 403,
          "id": 106,
        },{
          "label": "501",
          "value": 501,
          "id": 104
        }, {
          "label": "502",
          "value": 502,
          "id": 105,
        }, {
          "label": "503",
          "value": 503,
          "id": 106,
        },{
          "label": "601",
          "value": 601,
          "id": 104
        }, {
          "label": "602",
          "value": 602,
          "id": 105,
        }, {
          "label": "603",
          "value": 603,
          "id": 106,
        },{
          "label": "701",
          "value": 701,
          "id": 104
        }, {
          "label": "702",
          "value": 702,
          "id": 105,
        }, {
          "label": "703",
          "value": 703,
          "id": 106,
        },{
          "label": "801",
          "value": 801,
          "id": 104
        }, {
          "label": "802",
          "value": 802,
          "id": 105,
        }, {
          "label": "803",
          "value": 803,
          "id": 106,
        }]
      }, {
        "label": "标准间",
        "value": "标准间",
        "id": 102,
        "children": [{
          "label": "104",
          "value": 104,
          "id": 108
        },{
          "label": "105",
          "value": 105,
          "id": 108
        },{
          "label": "106",
          "value": 106,
          "id": 108
        },{
          "label": "107",
          "value": 107,
          "id": 108
        },{
          "label": "108",
          "value": 108,
          "id": 108
        },{
          "label": "109",
          "value": 109,
          "id": 108
        },{
          "label": "110",
          "value": 110,
          "id": 108
        },{
          "label": "111",
          "value": 111,
          "id": 108
        },{
          "label": "112",
          "value": 112,
          "id": 108
        },{
          "label": "113",
          "value": 113,
          "id": 108
        },{
          "label": "114",
          "value": 114,
          "id": 108
        },{
          "label": "115",
          "value": 115,
          "id": 108
        },{
          "label": "116",
          "value": 116,
          "id": 108
        },{
          "label": "117",
          "value": 117,
          "id": 108
        },{
          "label": "204",
          "value": 204,
          "id": 108
        },{
          "label": "205",
          "value": 205,
          "id": 108
        },{
          "label": "206",
          "value": 206,
          "id": 108
        },{
          "label": "207",
          "value": 207,
          "id": 108
        },{
          "label": "208",
          "value": 208,
          "id": 108
        },{
          "label": "209",
          "value": 209,
          "id": 108
        },{
          "label": "210",
          "value": 210,
          "id": 108
        },{
          "label": "211",
          "value": 211,
          "id": 108
        },{
          "label": "212",
          "value": 212,
          "id": 108
        },{
          "label": "213",
          "value": 213,
          "id": 108
        },{
          "label": "214",
          "value": 214,
          "id": 108
        },{
          "label": "215",
          "value": 215,
          "id": 108
        },{
          "label": "216",
          "value": 216,
          "id": 108
        },{
          "label": "217",
          "value": 217,
          "id": 108
        },{
          "label": "304",
          "value": 304,
          "id": 108
        },{
          "label": "305",
          "value": 305,
          "id": 108
        },{
          "label": "306",
          "value": 306,
          "id": 108
        },{
          "label": "307",
          "value": 307,
          "id": 108
        },{
          "label": "308",
          "value": 308,
          "id": 108
        },{
          "label": "309",
          "value": 309,
          "id": 108
        },{
          "label": "310",
          "value": 310,
          "id": 108
        },{
          "label": "311",
          "value": 311,
          "id": 108
        },{
          "label": "312",
          "value": 312,
          "id": 108
        },{
          "label": "313",
          "value": 313,
          "id": 108
        },{
          "label": "314",
          "value": 314,
          "id": 108
        },{
          "label": "315",
          "value": 315,
          "id": 108
        },{
          "label": "316",
          "value": 316,
          "id": 108
        },{
          "label": "317",
          "value": 317,
          "id": 108
        },{
          "label": "404",
          "value": 404,
          "id": 108
        },{
          "label": "405",
          "value": 405,
          "id": 108
        },{
          "label": "406",
          "value": 406,
          "id": 108
        },{
          "label": "407",
          "value": 407,
          "id": 108
        },{
          "label": "408",
          "value": 408,
          "id": 108
        },{
          "label": "409",
          "value": 409,
          "id": 108
        },{
          "label": "410",
          "value": 410,
          "id": 108
        },{
          "label": "411",
          "value": 411,
          "id": 108
        },{
          "label": "412",
          "value": 412,
          "id": 108
        },{
          "label": "413",
          "value": 413,
          "id": 108
        },{
          "label": "414",
          "value": 414,
          "id": 108
        },{
          "label": "415",
          "value": 415,
          "id": 108
        },{
          "label": "416",
          "value": 416,
          "id": 108
        },{
          "label": "417",
          "value": 417,
          "id": 108
        },,{
          "label": "504",
          "value": 504,
          "id": 108
        },{
          "label": "505",
          "value": 505,
          "id": 108
        },{
          "label": "506",
          "value": 506,
          "id": 108
        },{
          "label": "507",
          "value": 507,
          "id": 108
        },{
          "label": "508",
          "value": 508,
          "id": 108
        },{
          "label": "509",
          "value": 509,
          "id": 108
        },{
          "label": "510",
          "value": 510,
          "id": 108
        },{
          "label": "511",
          "value": 511,
          "id": 108
        },{
          "label": "512",
          "value": 512,
          "id": 108
        },{
          "label": "513",
          "value": 513,
          "id": 108
        },{
          "label": "514",
          "value": 514,
          "id": 108
        },{
          "label": "515",
          "value": 515,
          "id": 108
        },{
          "label": "516",
          "value": 516,
          "id": 108
        },{
          "label": "517",
          "value": 517,
          "id": 108
        },,{
          "label": "604",
          "value": 604,
          "id": 108
        },{
          "label": "605",
          "value": 605,
          "id": 108
        },{
          "label": "606",
          "value": 606,
          "id": 108
        },{
          "label": "607",
          "value": 607,
          "id": 108
        },{
          "label": "608",
          "value": 608,
          "id": 108
        },{
          "label": "609",
          "value": 609,
          "id": 108
        },{
          "label": "610",
          "value": 610,
          "id": 108
        },{
          "label": "611",
          "value": 611,
          "id": 108
        },{
          "label": "612",
          "value": 612,
          "id": 108
        },{
          "label": "613",
          "value": 613,
          "id": 108
        },{
          "label": "614",
          "value": 614,
          "id": 108
        },{
          "label": "615",
          "value": 615,
          "id": 108
        },{
          "label": "616",
          "value": 616,
          "id": 108
        },{
          "label": "617",
          "value": 617,
          "id": 108
        },,{
          "label": "704",
          "value": 704,
          "id": 108
        },{
          "label": "705",
          "value": 705,
          "id": 108
        },{
          "label": "706",
          "value": 706,
          "id": 108
        },{
          "label": "707",
          "value": 707,
          "id": 108
        },{
          "label": "708",
          "value": 708,
          "id": 108
        },{
          "label": "709",
          "value": 709,
          "id": 108
        },{
          "label": "710",
          "value": 710,
          "id": 108
        },{
          "label": "711",
          "value": 711,
          "id": 108
        },{
          "label": "712",
          "value": 712,
          "id": 108
        },{
          "label": "713",
          "value": 713,
          "id": 108
        },{
          "label": "714",
          "value": 714,
          "id": 108
        },{
          "label": "715",
          "value": 715,
          "id": 108
        },{
          "label": "716",
          "value": 716,
          "id": 108
        },{
          "label": "717",
          "value": 717,
          "id": 108
        },{
          "label": "804",
          "value": 804,
          "id": 108
        },{
          "label": "805",
          "value": 805,
          "id": 108
        },{
          "label": "806",
          "value": 806,
          "id": 108
        },{
          "label": "807",
          "value": 807,
          "id": 108
        },{
          "label": "808",
          "value": 808,
          "id": 108
        },{
          "label": "809",
          "value": 809,
          "id": 108
        },{
          "label": "810",
          "value": 810,
          "id": 108
        },{
          "label": "811",
          "value": 811,
          "id": 108
        },{
          "label": "812",
          "value": 812,
          "id": 108
        },{
          "label": "813",
          "value": 813,
          "id": 108
        },{
          "label": "814",
          "value": 814,
          "id": 108
        },{
          "label": "815",
          "value": 815,
          "id": 108
        },{
          "label": "816",
          "value": 816,
          "id": 108
        },{
          "label": "817",
          "value": 817,
          "id": 108
        }]
      }, {
        "label": "家庭套房",
        "value": "家庭套房",
        "id": 103,
        "children": [{
          "label": "120",
          "value": 120,
          "id": 107
        },{
          "label": "119",
          "value": 119,
          "id": 107
        },{
          "label": "118",
          "value": 118,
          "id": 107
        },{
          "label": "220",
          "value": 220,
          "id": 107
        },{
          "label": "219",
          "value": 219,
          "id": 107
        },{
          "label": "218",
          "value": 218,
          "id": 107
        },{
          "label": "320",
          "value": 320,
          "id": 107
        },{
          "label": "319",
          "value": 319,
          "id": 107
        },{
          "label": "318",
          "value": 318,
          "id": 107
        },{
          "label": "420",
          "value": 420,
          "id": 107
        },{
          "label": "419",
          "value": 419,
          "id": 107
        },{
          "label": "418",
          "value": 418,
          "id": 107
        },{
          "label": "520",
          "value": 520,
          "id": 107
        },{
          "label": "519",
          "value": 519,
          "id": 107
        },{
          "label": "518",
          "value": 518,
          "id": 107
        },{
          "label": "620",
          "value": 620,
          "id": 107
        },{
          "label": "619",
          "value": 619,
          "id": 107
        },{
          "label": "618",
          "value": 618,
          "id": 107
        },{
          "label": "720",
          "value": 720,
          "id": 107
        },{
          "label": "719",
          "value": 719,
          "id": 107
        },{
          "label": "718",
          "value": 718,
          "id": 107
        },{
          "label": "820",
          "value": 820,
          "id": 107
        },{
          "label": "819",
          "value": 819,
          "id": 107
        },{
          "label": "818",
          "value": 818,
          "id": 107
        },
        ]
      }],
      field102Props: {
        "multiple": false
      }
    };
  },
  created() {
  },
  methods: {
    onOpen() {},
    onClose() {
      this.$refs['elForm'].resetFields()
    },
    close() {
      this.$emit('update:visible', false)
    },
    handleConfirm() {
      this.$refs['elForm'].validate(valid => {
        if (!valid) return
        this.close()
      })
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
    /** 查询酒店房间列表 */
    getList2() {
      listRooms(this.form.startDate).then(response => {
        this.roomsList = response.rows;
        this.rtotal = response.total;
        for(let i in this.roomsList){
          var aa=this.roomsList[i].toString();
          this.$refs[aa].type="info";
        }
      });
    },
    cancel() {
      this.open = false;
      this.open1 = false;
      this.reset();
    },
    reset() {
      this.form = {
        field102: [],
        id: null,
        name:null,
        orderId: null,
        cnId: "",
        type:null,
        startDate:null,
        endDate:null,
        roomNum:null,
        state:null,
        phoneNum:null
      };
      this.resetForm("form");
    },
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加酒店预订";
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 搜索按钮操作 */
    handleQuery2() {
      this.getList2();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getOrders(id).then(response => {
        this.form = response.data;
        this.open1 = true;
        this.title = "修改酒店预约";
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.id;
      this.$modal.confirm('是否确认删除酒店订单编号为"' + id + '"的数据项？').then(function() {
        return delOrders(id);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    validateCnId(rule, value, callback) {
      // 验证身份证号格式
      const pattern = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
      if (!pattern.test(value)) {
        callback(new Error('请输入有效的中华人民共和国身份证号'));
      } else {
        callback();
      }
    },
    validatePhoneNumber(rule, value, callback) {
      // 验证手机号格式
      const pattern = /^1[0-9]{10}$/;
      if (!pattern.test(value)) {
        callback(new Error('请输入有效的手机号'));
      } else {
        callback();
      }
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if(this.form.endDate<this.form.startDate)
          this.$modal.msgWarning("请输入正确日期");
        else{
          this.form.type=this.form.field102.at(0)
          this.form.roomNum=this.form.field102.at(1)
          if (valid) {
            if (this.form.id != null) {
              updateOrders(this.form).then(response => {
                this.$modal.msgSuccess("修改成功");
                this.open = false;
                this.open1 = false;
                this.getList();
              });
            } else {
              addOrders(this.form).then(response => {
                this.$modal.msgSuccess("新增成功");
                this.open = false;
                this.open1 = false;
                this.getList();
              });
            }
          }
        }
      });
    }

  }
};
</script>

<style scoped type='text/css' >

.el-button--warning{
  width: 50px;
  height:36px;
  text-align: center;
  background-color: rgb(78, 168, 246);
  color: #00040e;
  border-color: #000003;
}

.el-button--info{
  width: 50px;
  height:36px;
  text-align: center;
  background-color: rgb(181, 184, 187);
  color: #7e7e7e;
  border-color: #a9a9a9;
}

.el-button--success{
  width: 50px;
  height:36px;
  text-align: center;
  background-color: rgb(72, 141, 197);
  color: #00040e;
  border-color: #000003;
}

.el-button--danger{
  width: 50px;
  height:36px;
  text-align: center;
  background-color: rgb(53, 146, 224);
  color: #00040e;
  border-color: #000003;
}
</style>
