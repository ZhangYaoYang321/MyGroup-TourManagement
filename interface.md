---
title: TourManagementSystem v1.0.0
language_tabs:
  - shell: Shell
  - http: HTTP
  - javascript: JavaScript
  - ruby: Ruby
  - python: Python
  - php: PHP
  - java: Java
  - go: Go
toc_footers: []
includes: []
search: true
code_clipboard: true
highlight_theme: darkula
headingLevel: 2
generator: "@tarslib/widdershins v4.0.17"

---

# TourManagementSystem

> v1.0.0

Base URLs:

# 车辆Controller

## GET 查询车辆列表

GET /system/cars/list

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|query|string| 否 |ID|
|carId|query|string| 否 |车牌号|
|carInTime|query|string| 否 |入场时间|
|carOutTime|query|string| 否 |出场时间|
|parkingCost|query|string| 否 |停车费|
|stateParking|query|string| 否 |停车状态|
|createBy|query|string| 否 |创建者|
|createTime|query|string| 否 |创建时间|
|updateBy|query|string| 否 |更新者|
|updateTime|query|string| 否 |更新时间|
|remark|query|string| 否 |备注|
|params.key.key|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "total": 0,
  "rows": [],
  "code": 0,
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[TableDataInfo](#schematabledatainfo)|

## POST 导出车辆列表

POST /system/cars/export

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|query|string| 否 |ID|
|carId|query|string| 否 |车牌号|
|carInTime|query|string| 否 |入场时间|
|carOutTime|query|string| 否 |出场时间|
|parkingCost|query|string| 否 |停车费|
|stateParking|query|string| 否 |停车状态|
|createBy|query|string| 否 |创建者|
|createTime|query|string| 否 |创建时间|
|updateBy|query|string| 否 |更新者|
|updateTime|query|string| 否 |更新时间|
|remark|query|string| 否 |备注|
|params.key.key|query|string| 否 |none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 获取车辆详细信息

GET /system/cars/{id}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## POST 新增车辆

POST /system/cars

> Body 请求参数

```json
{
  "id": 0,
  "carId": "string",
  "carInTime": "string",
  "carOutTime": "string",
  "parkingCost": "string",
  "stateParking": "string",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[SelfParkingCars](#schemaselfparkingcars)| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## PUT 修改车辆

PUT /system/cars

> Body 请求参数

```json
{
  "id": 0,
  "carId": "string",
  "carInTime": "string",
  "carOutTime": "string",
  "parkingCost": "string",
  "stateParking": "string",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[SelfParkingCars](#schemaselfparkingcars)| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## DELETE 删除车辆

DELETE /system/cars/{ids}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|ids|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## GET 车辆入场

GET /system/cars/parkingCars/{carIdKey}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|carIdKey|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## GET 车辆出场

GET /system/cars/leavingCars/{carIdKey}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|carIdKey|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## GET 获取车辆信息

GET /system/cars/searchCars/{carIdKey}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|carIdKey|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "total": 0,
  "rows": [],
  "code": 0,
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[TableDataInfo](#schematabledatainfo)|

## GET 出入场时计算并更新停车场车辆数据

GET /system/cars/getParkingCount

> 返回示例

> 成功

```json
{
  "total": 0,
  "rows": [],
  "code": 0,
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[TableDataInfo](#schematabledatainfo)|

## GET 排序

GET /system/cars/sort/{sortsId}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|sortsId|path|string| 是 |none|
|id|query|string| 否 |ID|
|carId|query|string| 否 |车牌号|
|carInTime|query|string| 否 |入场时间|
|carOutTime|query|string| 否 |出场时间|
|parkingCost|query|string| 否 |停车费|
|stateParking|query|string| 否 |停车状态|
|createBy|query|string| 否 |创建者|
|createTime|query|string| 否 |创建时间|
|updateBy|query|string| 否 |更新者|
|updateTime|query|string| 否 |更新时间|
|remark|query|string| 否 |备注|
|params.key.key|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "total": 0,
  "rows": [],
  "code": 0,
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[TableDataInfo](#schematabledatainfo)|

# 酒店退房Controller

## GET 查询酒店订单列表

GET /hotel/checkout/list

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|query|string| 否 |none|
|orderId|query|string| 否 |订单号|
|cnId|query|string| 否 |身份证号|
|phoneNum|query|string| 否 |电话号码|
|name|query|string| 否 |姓名|
|startDate|query|string| 否 |开始日期|
|endDate|query|string| 否 |截至日期|
|type|query|string| 否 |房价类型|
|roomNum|query|string| 否 |房间号|
|state|query|string| 否 |房间状态|
|createBy|query|string| 否 |创建者|
|createTime|query|string| 否 |创建时间|
|updateBy|query|string| 否 |更新者|
|updateTime|query|string| 否 |更新时间|
|remark|query|string| 否 |备注|
|params.key.key|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "total": 0,
  "rows": [],
  "code": 0,
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[TableDataInfo](#schematabledatainfo)|

## DELETE 删除酒店订单

DELETE /hotel/checkout/{id}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## GET 查询酒店订单列表

GET /hotel/checkin/list

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|query|string| 否 |none|
|orderId|query|string| 否 |订单号|
|cnId|query|string| 否 |身份证号|
|phoneNum|query|string| 否 |电话号码|
|name|query|string| 否 |姓名|
|startDate|query|string| 否 |开始日期|
|endDate|query|string| 否 |截至日期|
|type|query|string| 否 |房价类型|
|roomNum|query|string| 否 |房间号|
|state|query|string| 否 |房间状态|
|createBy|query|string| 否 |创建者|
|createTime|query|string| 否 |创建时间|
|updateBy|query|string| 否 |更新者|
|updateTime|query|string| 否 |更新时间|
|remark|query|string| 否 |备注|
|params.key.key|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "total": 0,
  "rows": [],
  "code": 0,
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[TableDataInfo](#schematabledatainfo)|

## GET 查询酒店房间数

GET /hotel/checkin/rooms

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|query|string| 否 |none|
|orderId|query|string| 否 |订单号|
|cnId|query|string| 否 |身份证号|
|phoneNum|query|string| 否 |电话号码|
|name|query|string| 否 |姓名|
|startDate|query|string| 否 |开始日期|
|endDate|query|string| 否 |截至日期|
|type|query|string| 否 |房价类型|
|roomNum|query|string| 否 |房间号|
|state|query|string| 否 |房间状态|
|createBy|query|string| 否 |创建者|
|createTime|query|string| 否 |创建时间|
|updateBy|query|string| 否 |更新者|
|updateTime|query|string| 否 |更新时间|
|remark|query|string| 否 |备注|
|params.key.key|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "total": 0,
  "rows": [],
  "code": 0,
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[TableDataInfo](#schematabledatainfo)|

## DELETE 删除酒店订单

DELETE /hotel/checkin/{id}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

# 酒店订单Controller

## GET 查询酒店订单列表

GET /hotel/orders/list

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|query|string| 否 |none|
|orderId|query|string| 否 |订单号|
|cnId|query|string| 否 |身份证号|
|phoneNum|query|string| 否 |电话号码|
|name|query|string| 否 |姓名|
|startDate|query|string| 否 |开始日期|
|endDate|query|string| 否 |截至日期|
|type|query|string| 否 |房价类型|
|roomNum|query|string| 否 |房间号|
|state|query|string| 否 |房间状态|
|createBy|query|string| 否 |创建者|
|createTime|query|string| 否 |创建时间|
|updateBy|query|string| 否 |更新者|
|updateTime|query|string| 否 |更新时间|
|remark|query|string| 否 |备注|
|params.key.key|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "total": 0,
  "rows": [],
  "code": 0,
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[TableDataInfo](#schematabledatainfo)|

## POST 导出酒店订单列表

POST /hotel/orders/export

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|query|string| 否 |none|
|orderId|query|string| 否 |订单号|
|cnId|query|string| 否 |身份证号|
|phoneNum|query|string| 否 |电话号码|
|name|query|string| 否 |姓名|
|startDate|query|string| 否 |开始日期|
|endDate|query|string| 否 |截至日期|
|type|query|string| 否 |房价类型|
|roomNum|query|string| 否 |房间号|
|state|query|string| 否 |房间状态|
|createBy|query|string| 否 |创建者|
|createTime|query|string| 否 |创建时间|
|updateBy|query|string| 否 |更新者|
|updateTime|query|string| 否 |更新时间|
|remark|query|string| 否 |备注|
|params.key.key|query|string| 否 |none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 获取酒店订单详细信息

GET /hotel/orders/{id}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## POST 新增酒店订单

POST /hotel/orders

> Body 请求参数

```json
{
  "id": 0,
  "orderId": 0,
  "cnId": "string",
  "phoneNum": "string",
  "name": "string",
  "startDate": "string",
  "endDate": "string",
  "type": "string",
  "roomNum": 0,
  "state": "string",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[SelfHotelOrders](#schemaselfhotelorders)| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## PUT 修改酒店订单

PUT /hotel/orders

> Body 请求参数

```json
{
  "id": 0,
  "orderId": 0,
  "cnId": "string",
  "phoneNum": "string",
  "name": "string",
  "startDate": "string",
  "endDate": "string",
  "type": "string",
  "roomNum": 0,
  "state": "string",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[SelfHotelOrders](#schemaselfhotelorders)| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## DELETE 删除酒店订单

DELETE /hotel/orders/{ids}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|ids|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

# 酒店预约Controller

## GET 查询酒店订单列表

GET /hotel/reservation/list

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|query|string| 否 |none|
|orderId|query|string| 否 |订单号|
|cnId|query|string| 否 |身份证号|
|phoneNum|query|string| 否 |电话号码|
|name|query|string| 否 |姓名|
|startDate|query|string| 否 |开始日期|
|endDate|query|string| 否 |截至日期|
|type|query|string| 否 |房价类型|
|roomNum|query|string| 否 |房间号|
|state|query|string| 否 |房间状态|
|createBy|query|string| 否 |创建者|
|createTime|query|string| 否 |创建时间|
|updateBy|query|string| 否 |更新者|
|updateTime|query|string| 否 |更新时间|
|remark|query|string| 否 |备注|
|params.key.key|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "total": 0,
  "rows": [],
  "code": 0,
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[TableDataInfo](#schematabledatainfo)|

## POST 新增酒店订单

POST /hotel/reservation

> Body 请求参数

```json
{
  "id": 0,
  "orderId": 0,
  "cnId": "string",
  "phoneNum": "string",
  "name": "string",
  "startDate": "string",
  "endDate": "string",
  "type": "string",
  "roomNum": 0,
  "state": "string",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[SelfHotelReservation](#schemaselfhotelreservation)| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## PUT 修改酒店订单

PUT /hotel/reservation

> Body 请求参数

```json
{
  "id": 0,
  "orderId": 0,
  "cnId": "string",
  "phoneNum": "string",
  "name": "string",
  "startDate": "string",
  "endDate": "string",
  "type": "string",
  "roomNum": 0,
  "state": "string",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[SelfHotelReservation](#schemaselfhotelreservation)| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## GET 获取酒店订单详细信息

GET /hotel/reservation/{id}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## DELETE 删除酒店订单

DELETE /hotel/reservation/{id}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## GET 获取酒店房间详细信息

GET /hotel/reservation/1/{date}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|date|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "total": 0,
  "rows": [],
  "code": 0,
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[TableDataInfo](#schematabledatainfo)|

# 考勤信息Controller

## GET 查询考勤信息列表

GET /system/attendances/list

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|query|string| 否 |ID|
|employeeId|query|string| 否 |员工ID|
|employeeName|query|string| 否 |员工姓名|
|stateWorking|query|string| 否 |考勤状态|
|createBy|query|string| 否 |创建者|
|createTime|query|string| 否 |创建时间|
|updateBy|query|string| 否 |更新者|
|updateTime|query|string| 否 |更新时间|
|remark|query|string| 否 |备注|
|params.key.key|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "total": 0,
  "rows": [],
  "code": 0,
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[TableDataInfo](#schematabledatainfo)|

## GET listcur

GET /system/attendances/listcur

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|query|string| 否 |ID|
|employeeId|query|string| 否 |员工ID|
|employeeName|query|string| 否 |员工姓名|
|stateWorking|query|string| 否 |考勤状态|
|createBy|query|string| 否 |创建者|
|createTime|query|string| 否 |创建时间|
|updateBy|query|string| 否 |更新者|
|updateTime|query|string| 否 |更新时间|
|remark|query|string| 否 |备注|
|params.key.key|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "total": 0,
  "rows": [],
  "code": 0,
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[TableDataInfo](#schematabledatainfo)|

## POST 导出考勤信息列表

POST /system/attendances/export

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|query|string| 否 |ID|
|employeeId|query|string| 否 |员工ID|
|employeeName|query|string| 否 |员工姓名|
|stateWorking|query|string| 否 |考勤状态|
|createBy|query|string| 否 |创建者|
|createTime|query|string| 否 |创建时间|
|updateBy|query|string| 否 |更新者|
|updateTime|query|string| 否 |更新时间|
|remark|query|string| 否 |备注|
|params.key.key|query|string| 否 |none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 获取考勤信息详细信息

GET /system/attendances/{id}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## POST 新增考勤信息

POST /system/attendances

> Body 请求参数

```json
{
  "id": 0,
  "employeeId": "string",
  "employeeName": "string",
  "stateWorking": "string",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[SelfAttendances](#schemaselfattendances)| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## PUT 修改考勤信息

PUT /system/attendances

> Body 请求参数

```json
{
  "id": 0,
  "employeeId": "string",
  "employeeName": "string",
  "stateWorking": "string",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[SelfAttendances](#schemaselfattendances)| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## DELETE 删除考勤信息

DELETE /system/attendances/{ids}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|ids|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## DELETE resetKQAttendances

DELETE /system/attendances/resetKQAttendances/{ids}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|ids|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

# 投诉Controller

## GET 查询投诉列表

GET /system/complaint_add/list

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|query|string| 否 |ID|
|complaintsId|query|string| 否 |投诉ID|
|complaintsMessage|query|string| 否 |投诉信息|
|complaintsDate|query|string| 否 |投诉日期|
|stateComplaints|query|string| 否 |处理状态|
|complaintsReplyDate|query|string| 否 |回复日期|
|complaintsReplyMessage|query|string| 否 |回复信息|
|createBy|query|string| 否 |创建者|
|createTime|query|string| 否 |创建时间|
|updateBy|query|string| 否 |更新者|
|updateTime|query|string| 否 |更新时间|
|remark|query|string| 否 |备注|
|params.key.key|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "total": 0,
  "rows": [],
  "code": 0,
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[TableDataInfo](#schematabledatainfo)|

## POST 导出投诉列表

POST /system/complaint_add/export

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|query|string| 否 |ID|
|complaintsId|query|string| 否 |投诉ID|
|complaintsMessage|query|string| 否 |投诉信息|
|complaintsDate|query|string| 否 |投诉日期|
|stateComplaints|query|string| 否 |处理状态|
|complaintsReplyDate|query|string| 否 |回复日期|
|complaintsReplyMessage|query|string| 否 |回复信息|
|createBy|query|string| 否 |创建者|
|createTime|query|string| 否 |创建时间|
|updateBy|query|string| 否 |更新者|
|updateTime|query|string| 否 |更新时间|
|remark|query|string| 否 |备注|
|params.key.key|query|string| 否 |none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 获取投诉详细信息

GET /system/complaint_add/{id}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## POST 新增投诉

POST /system/complaint_add

> Body 请求参数

```json
{
  "id": 0,
  "complaintsId": 0,
  "complaintsMessage": "string",
  "complaintsDate": "string",
  "stateComplaints": "string",
  "complaintsReplyDate": "string",
  "complaintsReplyMessage": "string",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[SelfComplaintAdd](#schemaselfcomplaintadd)| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## PUT 修改投诉

PUT /system/complaint_add

> Body 请求参数

```json
{
  "id": 0,
  "complaintsId": 0,
  "complaintsMessage": "string",
  "complaintsDate": "string",
  "stateComplaints": "string",
  "complaintsReplyDate": "string",
  "complaintsReplyMessage": "string",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[SelfComplaintAdd](#schemaselfcomplaintadd)| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## DELETE 删除投诉

DELETE /system/complaint_add/{ids}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|ids|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## GET 查询投诉列表

GET /system/complaint_complete/list

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|query|string| 否 |ID|
|complaintsId|query|string| 否 |投诉ID|
|complaintsMessage|query|string| 否 |投诉信息|
|complaintsDate|query|string| 否 |投诉日期|
|stateComplaints|query|string| 否 |处理状态|
|complaintsReplyDate|query|string| 否 |回复日期|
|complaintsReplyMessage|query|string| 否 |回复信息|
|createBy|query|string| 否 |创建者|
|createTime|query|string| 否 |创建时间|
|updateBy|query|string| 否 |更新者|
|updateTime|query|string| 否 |更新时间|
|remark|query|string| 否 |备注|
|params.key.key|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "total": 0,
  "rows": [],
  "code": 0,
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[TableDataInfo](#schematabledatainfo)|

## POST 导出投诉列表

POST /system/complaint_complete/export

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|query|string| 否 |ID|
|complaintsId|query|string| 否 |投诉ID|
|complaintsMessage|query|string| 否 |投诉信息|
|complaintsDate|query|string| 否 |投诉日期|
|stateComplaints|query|string| 否 |处理状态|
|complaintsReplyDate|query|string| 否 |回复日期|
|complaintsReplyMessage|query|string| 否 |回复信息|
|createBy|query|string| 否 |创建者|
|createTime|query|string| 否 |创建时间|
|updateBy|query|string| 否 |更新者|
|updateTime|query|string| 否 |更新时间|
|remark|query|string| 否 |备注|
|params.key.key|query|string| 否 |none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 获取投诉详细信息

GET /system/complaint_complete/{id}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## POST 新增投诉

POST /system/complaint_complete

> Body 请求参数

```json
{
  "id": 0,
  "complaintsId": 0,
  "complaintsMessage": "string",
  "complaintsDate": "string",
  "stateComplaints": "string",
  "complaintsReplyDate": "string",
  "complaintsReplyMessage": "string",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[SelfComplaintComplete](#schemaselfcomplaintcomplete)| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## PUT 修改投诉

PUT /system/complaint_complete

> Body 请求参数

```json
{
  "id": 0,
  "complaintsId": 0,
  "complaintsMessage": "string",
  "complaintsDate": "string",
  "stateComplaints": "string",
  "complaintsReplyDate": "string",
  "complaintsReplyMessage": "string",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[SelfComplaintComplete](#schemaselfcomplaintcomplete)| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## DELETE 删除投诉

DELETE /system/complaint_complete/{ids}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|ids|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## GET 查询投诉列表

GET /system/complaints/list

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|query|string| 否 |ID|
|complaintsId|query|string| 否 |投诉ID|
|complaintsMessage|query|string| 否 |投诉信息|
|complaintsDate|query|string| 否 |投诉日期|
|stateComplaints|query|string| 否 |处理状态|
|complaintsReplyDate|query|string| 否 |回复日期|
|complaintsReplyMessage|query|string| 否 |回复信息|
|createBy|query|string| 否 |创建者|
|createTime|query|string| 否 |创建时间|
|updateBy|query|string| 否 |更新者|
|updateTime|query|string| 否 |更新时间|
|remark|query|string| 否 |备注|
|params.key.key|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "total": 0,
  "rows": [],
  "code": 0,
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[TableDataInfo](#schematabledatainfo)|

## POST 导出投诉列表

POST /system/complaints/export

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|query|string| 否 |ID|
|complaintsId|query|string| 否 |投诉ID|
|complaintsMessage|query|string| 否 |投诉信息|
|complaintsDate|query|string| 否 |投诉日期|
|stateComplaints|query|string| 否 |处理状态|
|complaintsReplyDate|query|string| 否 |回复日期|
|complaintsReplyMessage|query|string| 否 |回复信息|
|createBy|query|string| 否 |创建者|
|createTime|query|string| 否 |创建时间|
|updateBy|query|string| 否 |更新者|
|updateTime|query|string| 否 |更新时间|
|remark|query|string| 否 |备注|
|params.key.key|query|string| 否 |none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 获取投诉详细信息

GET /system/complaints/{id}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## POST 新增投诉

POST /system/complaints

> Body 请求参数

```json
{
  "id": 0,
  "complaintsId": 0,
  "complaintsMessage": "string",
  "complaintsDate": "string",
  "stateComplaints": "string",
  "complaintsReplyDate": "string",
  "complaintsReplyMessage": "string",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[SelfComplaints](#schemaselfcomplaints)| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## PUT 修改投诉

PUT /system/complaints

> Body 请求参数

```json
{
  "id": 0,
  "complaintsId": 0,
  "complaintsMessage": "string",
  "complaintsDate": "string",
  "stateComplaints": "string",
  "complaintsReplyDate": "string",
  "complaintsReplyMessage": "string",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[SelfComplaints](#schemaselfcomplaints)| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## DELETE 删除投诉

DELETE /system/complaints/{ids}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|ids|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

# 事件Controller

## GET 查询事件列表

GET /system/emergencies/list

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|query|string| 否 |ID|
|location|query|string| 否 |事件地点|
|emergenciesMessage|query|string| 否 |事件信息|
|department|query|string| 否 |处理部门|
|stateEmergencies|query|string| 否 |处理状态|
|emergenciesLevel|query|string| 否 |紧急程度|
|emergenciesTime|query|string| 否 |发生日期|
|createBy|query|string| 否 |创建者|
|createTime|query|string| 否 |创建时间|
|updateBy|query|string| 否 |更新者|
|updateTime|query|string| 否 |更新时间|
|remark|query|string| 否 |备注|
|params.key.key|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "total": 0,
  "rows": [],
  "code": 0,
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[TableDataInfo](#schematabledatainfo)|

## POST 导出事件列表

POST /system/emergencies/export

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|query|string| 否 |ID|
|location|query|string| 否 |事件地点|
|emergenciesMessage|query|string| 否 |事件信息|
|department|query|string| 否 |处理部门|
|stateEmergencies|query|string| 否 |处理状态|
|emergenciesLevel|query|string| 否 |紧急程度|
|emergenciesTime|query|string| 否 |发生日期|
|createBy|query|string| 否 |创建者|
|createTime|query|string| 否 |创建时间|
|updateBy|query|string| 否 |更新者|
|updateTime|query|string| 否 |更新时间|
|remark|query|string| 否 |备注|
|params.key.key|query|string| 否 |none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 获取事件详细信息

GET /system/emergencies/{id}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## POST 新增事件

POST /system/emergencies

> Body 请求参数

```json
{
  "id": 0,
  "location": "string",
  "emergenciesMessage": "string",
  "department": "string",
  "stateEmergencies": "string",
  "emergenciesLevel": "string",
  "emergenciesTime": "string",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[SelfEmergencies](#schemaselfemergencies)| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## PUT 修改事件

PUT /system/emergencies

> Body 请求参数

```json
{
  "id": 0,
  "location": "string",
  "emergenciesMessage": "string",
  "department": "string",
  "stateEmergencies": "string",
  "emergenciesLevel": "string",
  "emergenciesTime": "string",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[SelfEmergencies](#schemaselfemergencies)| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## DELETE 删除事件

DELETE /system/emergencies/{ids}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|ids|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## GET 查询事件列表

GET /system/emergency_add/list

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|query|string| 否 |ID|
|location|query|string| 否 |事件地点|
|emergenciesMessage|query|string| 否 |事件信息|
|department|query|string| 否 |处理部门|
|stateEmergencies|query|string| 否 |处理状态|
|emergenciesLevel|query|string| 否 |紧急程度|
|emergenciesTime|query|string| 否 |发生日期|
|createBy|query|string| 否 |创建者|
|createTime|query|string| 否 |创建时间|
|updateBy|query|string| 否 |更新者|
|updateTime|query|string| 否 |更新时间|
|remark|query|string| 否 |备注|
|params.key.key|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "total": 0,
  "rows": [],
  "code": 0,
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[TableDataInfo](#schematabledatainfo)|

## POST 导出事件列表

POST /system/emergency_add/export

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|query|string| 否 |ID|
|location|query|string| 否 |事件地点|
|emergenciesMessage|query|string| 否 |事件信息|
|department|query|string| 否 |处理部门|
|stateEmergencies|query|string| 否 |处理状态|
|emergenciesLevel|query|string| 否 |紧急程度|
|emergenciesTime|query|string| 否 |发生日期|
|createBy|query|string| 否 |创建者|
|createTime|query|string| 否 |创建时间|
|updateBy|query|string| 否 |更新者|
|updateTime|query|string| 否 |更新时间|
|remark|query|string| 否 |备注|
|params.key.key|query|string| 否 |none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 获取事件详细信息

GET /system/emergency_add/{id}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## POST 新增事件

POST /system/emergency_add

> Body 请求参数

```json
{
  "id": 0,
  "location": "string",
  "emergenciesMessage": "string",
  "department": "string",
  "stateEmergencies": "string",
  "emergenciesLevel": "string",
  "emergenciesTime": "string",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[SelfEmergencyAdd](#schemaselfemergencyadd)| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## PUT 修改事件

PUT /system/emergency_add

> Body 请求参数

```json
{
  "id": 0,
  "location": "string",
  "emergenciesMessage": "string",
  "department": "string",
  "stateEmergencies": "string",
  "emergenciesLevel": "string",
  "emergenciesTime": "string",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[SelfEmergencyAdd](#schemaselfemergencyadd)| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## DELETE 删除事件

DELETE /system/emergency_add/{ids}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|ids|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

# 事件处理Controller

## GET 查询事件处理列表

GET /system/emergency_complete/list

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|query|string| 否 |ID|
|location|query|string| 否 |事件地点|
|emergenciesMessage|query|string| 否 |事件信息|
|department|query|string| 否 |处理部门|
|stateEmergencies|query|string| 否 |处理状态|
|emergenciesLevel|query|string| 否 |紧急程度|
|emergenciesTime|query|string| 否 |发生日期|
|createBy|query|string| 否 |创建者|
|createTime|query|string| 否 |创建时间|
|updateBy|query|string| 否 |更新者|
|updateTime|query|string| 否 |更新时间|
|remark|query|string| 否 |备注|
|params.key.key|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "total": 0,
  "rows": [],
  "code": 0,
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[TableDataInfo](#schematabledatainfo)|

## POST 导出事件处理列表

POST /system/emergency_complete/export

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|query|string| 否 |ID|
|location|query|string| 否 |事件地点|
|emergenciesMessage|query|string| 否 |事件信息|
|department|query|string| 否 |处理部门|
|stateEmergencies|query|string| 否 |处理状态|
|emergenciesLevel|query|string| 否 |紧急程度|
|emergenciesTime|query|string| 否 |发生日期|
|createBy|query|string| 否 |创建者|
|createTime|query|string| 否 |创建时间|
|updateBy|query|string| 否 |更新者|
|updateTime|query|string| 否 |更新时间|
|remark|query|string| 否 |备注|
|params.key.key|query|string| 否 |none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 获取事件处理详细信息

GET /system/emergency_complete/{id}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## POST 新增事件处理

POST /system/emergency_complete

> Body 请求参数

```json
{
  "id": 0,
  "location": "string",
  "emergenciesMessage": "string",
  "department": "string",
  "stateEmergencies": "string",
  "emergenciesLevel": "string",
  "emergenciesTime": "string",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[SelfEmergencyComplete](#schemaselfemergencycomplete)| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## PUT 修改事件处理

PUT /system/emergency_complete

> Body 请求参数

```json
{
  "id": 0,
  "location": "string",
  "emergenciesMessage": "string",
  "department": "string",
  "stateEmergencies": "string",
  "emergenciesLevel": "string",
  "emergenciesTime": "string",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[SelfEmergencyComplete](#schemaselfemergencycomplete)| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## DELETE 删除事件处理

DELETE /system/emergency_complete/{ids}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|ids|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

# 酒店价格Controller

## GET 查询酒店价格列表

GET /system/hotel_prices/list

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|query|string| 否 |ID|
|typeRoom|query|string| 否 |房间类型|
|priceRoom|query|string| 否 |房间价格|
|totalRooms|query|string| 否 |房间总数|
|freeRooms|query|string| 否 |空余房数|
|createBy|query|string| 否 |创建者|
|createTime|query|string| 否 |创建时间|
|updateBy|query|string| 否 |更新者|
|updateTime|query|string| 否 |更新时间|
|remark|query|string| 否 |备注|
|params.key.key|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "total": 0,
  "rows": [],
  "code": 0,
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[TableDataInfo](#schematabledatainfo)|

## POST 导出酒店价格列表

POST /system/hotel_prices/export

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|query|string| 否 |ID|
|typeRoom|query|string| 否 |房间类型|
|priceRoom|query|string| 否 |房间价格|
|totalRooms|query|string| 否 |房间总数|
|freeRooms|query|string| 否 |空余房数|
|createBy|query|string| 否 |创建者|
|createTime|query|string| 否 |创建时间|
|updateBy|query|string| 否 |更新者|
|updateTime|query|string| 否 |更新时间|
|remark|query|string| 否 |备注|
|params.key.key|query|string| 否 |none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 获取酒店价格详细信息

GET /system/hotel_prices/{id}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## POST 新增酒店价格

POST /system/hotel_prices

> Body 请求参数

```json
{
  "id": 0,
  "typeRoom": "string",
  "priceRoom": "string",
  "totalRooms": 0,
  "freeRooms": 0,
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[SelfHotelPrices](#schemaselfhotelprices)| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## PUT 修改酒店价格

PUT /system/hotel_prices

> Body 请求参数

```json
{
  "id": 0,
  "typeRoom": "string",
  "priceRoom": "string",
  "totalRooms": 0,
  "freeRooms": 0,
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[SelfHotelPrices](#schemaselfhotelprices)| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## DELETE 删除酒店价格

DELETE /system/hotel_prices/{ids}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|ids|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

# 房间Controller

## GET 查询房间列表

GET /system/rooms/list

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|query|string| 否 |ID|
|roomId|query|string| 否 |房间号|
|typeRoom|query|string| 否 |房间类型|
|orderId|query|string| 否 |订单号|
|stateRoom|query|string| 否 |入住情况|
|createBy|query|string| 否 |创建者|
|createTime|query|string| 否 |创建时间|
|updateBy|query|string| 否 |更新者|
|updateTime|query|string| 否 |更新时间|
|remark|query|string| 否 |备注|
|params.key.key|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "total": 0,
  "rows": [],
  "code": 0,
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[TableDataInfo](#schematabledatainfo)|

## POST 导出房间列表

POST /system/rooms/export

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|query|string| 否 |ID|
|roomId|query|string| 否 |房间号|
|typeRoom|query|string| 否 |房间类型|
|orderId|query|string| 否 |订单号|
|stateRoom|query|string| 否 |入住情况|
|createBy|query|string| 否 |创建者|
|createTime|query|string| 否 |创建时间|
|updateBy|query|string| 否 |更新者|
|updateTime|query|string| 否 |更新时间|
|remark|query|string| 否 |备注|
|params.key.key|query|string| 否 |none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 获取房间详细信息

GET /system/rooms/{id}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## POST 新增房间

POST /system/rooms

> Body 请求参数

```json
{
  "id": 0,
  "roomId": 0,
  "typeRoom": "string",
  "orderId": 0,
  "stateRoom": "string",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[SelfHotelRooms](#schemaselfhotelrooms)| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## PUT 修改房间

PUT /system/rooms

> Body 请求参数

```json
{
  "id": 0,
  "roomId": 0,
  "typeRoom": "string",
  "orderId": 0,
  "stateRoom": "string",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[SelfHotelRooms](#schemaselfhotelrooms)| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## DELETE 删除房间

DELETE /system/rooms/{ids}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|ids|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

# 票价Controller

## GET 查询票价列表

GET /system/ticket_prices/list

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|query|string| 否 |ID|
|typeTicket|query|string| 否 |门票类型|
|priceTicket|query|string| 否 |门票价格|
|createBy|query|string| 否 |创建者|
|createTime|query|string| 否 |创建时间|
|updateBy|query|string| 否 |更新者|
|updateTime|query|string| 否 |更新时间|
|remark|query|string| 否 |备注|
|params.key.key|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "total": 0,
  "rows": [],
  "code": 0,
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[TableDataInfo](#schematabledatainfo)|

## POST 导出票价列表

POST /system/ticket_prices/export

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|query|string| 否 |ID|
|typeTicket|query|string| 否 |门票类型|
|priceTicket|query|string| 否 |门票价格|
|createBy|query|string| 否 |创建者|
|createTime|query|string| 否 |创建时间|
|updateBy|query|string| 否 |更新者|
|updateTime|query|string| 否 |更新时间|
|remark|query|string| 否 |备注|
|params.key.key|query|string| 否 |none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 获取票价详细信息

GET /system/ticket_prices/{id}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## POST 新增票价

POST /system/ticket_prices

> Body 请求参数

```json
{
  "id": 0,
  "typeTicket": "string",
  "priceTicket": "string",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[SelfTicketPrices](#schemaselfticketprices)| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## PUT 修改票价

PUT /system/ticket_prices

> Body 请求参数

```json
{
  "id": 0,
  "typeTicket": "string",
  "priceTicket": "string",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[SelfTicketPrices](#schemaselfticketprices)| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## DELETE 删除票价

DELETE /system/ticket_prices/{ids}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|ids|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

# 票务Controller

## GET 查询票务列表

GET /system/ticket_services/list

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|query|string| 否 |ID|
|ticketId|query|string| 否 |门票号|
|cnId|query|string| 否 |身份证号|
|scheduledDate|query|string| 否 |预约日期|
|visitorInTime|query|string| 否 |入园时间|
|visitorOutTime|query|string| 否 |出园时间|
|stateVisit|query|string| 否 |参观状态|
|typeTicket|query|string| 否 |门票类型|
|visitorsName|query|string| 否 |none|
|phoneNumber|query|string| 否 |none|
|createBy|query|string| 否 |创建者|
|createTime|query|string| 否 |创建时间|
|updateBy|query|string| 否 |更新者|
|updateTime|query|string| 否 |更新时间|
|remark|query|string| 否 |备注|
|params.key.key|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "total": 0,
  "rows": [],
  "code": 0,
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[TableDataInfo](#schematabledatainfo)|

## POST 导出票务列表

POST /system/ticket_services/export

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|query|string| 否 |ID|
|ticketId|query|string| 否 |门票号|
|cnId|query|string| 否 |身份证号|
|scheduledDate|query|string| 否 |预约日期|
|visitorInTime|query|string| 否 |入园时间|
|visitorOutTime|query|string| 否 |出园时间|
|stateVisit|query|string| 否 |参观状态|
|typeTicket|query|string| 否 |门票类型|
|visitorsName|query|string| 否 |none|
|phoneNumber|query|string| 否 |none|
|createBy|query|string| 否 |创建者|
|createTime|query|string| 否 |创建时间|
|updateBy|query|string| 否 |更新者|
|updateTime|query|string| 否 |更新时间|
|remark|query|string| 否 |备注|
|params.key.key|query|string| 否 |none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 获取票务详细信息

GET /system/ticket_services/{id}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## POST 新增票务

POST /system/ticket_services

> Body 请求参数

```json
{
  "id": 0,
  "ticketId": 0,
  "cnId": "string",
  "scheduledDate": "string",
  "visitorInTime": "string",
  "visitorOutTime": "string",
  "stateVisit": "string",
  "typeTicket": "string",
  "visitorsName": "string",
  "phoneNumber": "string",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[SelfTicketServices](#schemaselfticketservices)| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## PUT 修改票务

PUT /system/ticket_services

> Body 请求参数

```json
{
  "id": 0,
  "ticketId": 0,
  "cnId": "string",
  "scheduledDate": "string",
  "visitorInTime": "string",
  "visitorOutTime": "string",
  "stateVisit": "string",
  "typeTicket": "string",
  "visitorsName": "string",
  "phoneNumber": "string",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[SelfTicketServices](#schemaselfticketservices)| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## DELETE 删除票务

DELETE /system/ticket_services/{ids}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|ids|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## POST 游客预约

POST /system/ticket_services/appoint

> Body 请求参数

```json
{
  "id": 0,
  "ticketId": 0,
  "cnId": "string",
  "scheduledDate": "string",
  "visitorInTime": "string",
  "visitorOutTime": "string",
  "stateVisit": "string",
  "typeTicket": "string",
  "visitorsName": "string",
  "phoneNumber": "string",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[SelfTicketServices](#schemaselfticketservices)| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## GET 游客查询信息

GET /system/ticket_services/checkInfo/{cnId}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|cnId|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "total": 0,
  "rows": [],
  "code": 0,
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[TableDataInfo](#schematabledatainfo)|

## GET inPark

GET /system/ticket_services/inPark/{cnId}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|cnId|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## GET outPark

GET /system/ticket_services/outPark/{cnId}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|cnId|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## GET getPeopleCounts

GET /system/ticket_services/getPeopleCounts

> 返回示例

> 成功

```json
{
  "total": 0,
  "rows": [],
  "code": 0,
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[TableDataInfo](#schematabledatainfo)|

# 游客Controller

## GET 查询游客列表

GET /system/visitors/list

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|query|string| 否 |ID|
|cnId|query|string| 否 |身份证号|
|visitorsName|query|string| 否 |游客姓名|
|phoneNumber|query|string| 否 |手机号|
|orderId|query|string| 否 |订单号|
|ticketId|query|string| 否 |门票号|
|createBy|query|string| 否 |创建者|
|createTime|query|string| 否 |创建时间|
|updateBy|query|string| 否 |更新者|
|updateTime|query|string| 否 |更新时间|
|remark|query|string| 否 |备注|
|params.key.key|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "total": 0,
  "rows": [],
  "code": 0,
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[TableDataInfo](#schematabledatainfo)|

## POST 导出游客列表

POST /system/visitors/export

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|query|string| 否 |ID|
|cnId|query|string| 否 |身份证号|
|visitorsName|query|string| 否 |游客姓名|
|phoneNumber|query|string| 否 |手机号|
|orderId|query|string| 否 |订单号|
|ticketId|query|string| 否 |门票号|
|createBy|query|string| 否 |创建者|
|createTime|query|string| 否 |创建时间|
|updateBy|query|string| 否 |更新者|
|updateTime|query|string| 否 |更新时间|
|remark|query|string| 否 |备注|
|params.key.key|query|string| 否 |none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 获取游客详细信息

GET /system/visitors/{id}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## POST 新增游客

POST /system/visitors

> Body 请求参数

```json
{
  "id": 0,
  "cnId": "string",
  "visitorsName": "string",
  "phoneNumber": "string",
  "orderId": 0,
  "ticketId": 0,
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[SelfVisitors](#schemaselfvisitors)| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## PUT 修改游客

PUT /system/visitors

> Body 请求参数

```json
{
  "id": 0,
  "cnId": "string",
  "visitorsName": "string",
  "phoneNumber": "string",
  "orderId": 0,
  "ticketId": 0,
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[SelfVisitors](#schemaselfvisitors)| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## DELETE 删除游客

DELETE /system/visitors/{ids}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|ids|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

# 参数配置 信息操作处理

## GET 获取参数配置列表

GET /system/config/list

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|configId|query|string| 否 |参数主键|
|configName|query|string| 否 |参数名称|
|configKey|query|string| 否 |参数键名|
|configValue|query|string| 否 |参数键值|
|configType|query|string| 否 |系统内置（Y是 N否）|
|createBy|query|string| 否 |创建者|
|createTime|query|string| 否 |创建时间|
|updateBy|query|string| 否 |更新者|
|updateTime|query|string| 否 |更新时间|
|remark|query|string| 否 |备注|
|params.key.key|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "total": 0,
  "rows": [],
  "code": 0,
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[TableDataInfo](#schematabledatainfo)|

## POST export

POST /system/config/export

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|configId|query|string| 否 |参数主键|
|configName|query|string| 否 |参数名称|
|configKey|query|string| 否 |参数键名|
|configValue|query|string| 否 |参数键值|
|configType|query|string| 否 |系统内置（Y是 N否）|
|createBy|query|string| 否 |创建者|
|createTime|query|string| 否 |创建时间|
|updateBy|query|string| 否 |更新者|
|updateTime|query|string| 否 |更新时间|
|remark|query|string| 否 |备注|
|params.key.key|query|string| 否 |none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 根据参数编号获取详细信息

GET /system/config/{configId}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|configId|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## GET 根据参数键名查询参数值

GET /system/config/configKey/{configKey}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|configKey|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## POST 新增参数配置

POST /system/config

> Body 请求参数

```json
{
  "configId": 0,
  "configName": "string",
  "configKey": "string",
  "configValue": "string",
  "configType": "string",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[SysConfig](#schemasysconfig)| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## PUT 修改参数配置

PUT /system/config

> Body 请求参数

```json
{
  "configId": 0,
  "configName": "string",
  "configKey": "string",
  "configValue": "string",
  "configType": "string",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[SysConfig](#schemasysconfig)| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## DELETE 删除参数配置

DELETE /system/config/{configIds}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|configIds|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## DELETE 刷新参数缓存

DELETE /system/config/refreshCache

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

# 部门信息

## GET 获取部门列表

GET /system/dept/list

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|deptId|query|string| 否 |部门ID|
|parentId|query|string| 否 |父部门ID|
|ancestors|query|string| 否 |祖级列表|
|deptName|query|string| 否 |部门名称|
|orderNum|query|string| 否 |显示顺序|
|leader|query|string| 否 |负责人|
|phone|query|string| 否 |联系电话|
|email|query|string| 否 |邮箱|
|status|query|string| 否 |部门状态:0正常,1停用|
|delFlag|query|string| 否 |删除标志（0代表存在 2代表删除）|
|parentName|query|string| 否 |父部门名称|
|children[0].deptId|query|string| 否 |部门ID|
|children[0].parentId|query|string| 否 |父部门ID|
|children[0].ancestors|query|string| 否 |祖级列表|
|children[0].deptName|query|string| 否 |部门名称|
|children[0].orderNum|query|string| 否 |显示顺序|
|children[0].leader|query|string| 否 |负责人|
|children[0].phone|query|string| 否 |联系电话|
|children[0].email|query|string| 否 |邮箱|
|children[0].status|query|string| 否 |部门状态:0正常,1停用|
|children[0].delFlag|query|string| 否 |删除标志（0代表存在 2代表删除）|
|children[0].parentName|query|string| 否 |父部门名称|
|children[0].children[0].key|query|string| 否 |none|
|children[0].createBy|query|string| 否 |创建者|
|children[0].createTime|query|string| 否 |创建时间|
|children[0].updateBy|query|string| 否 |更新者|
|children[0].updateTime|query|string| 否 |更新时间|
|children[0].remark|query|string| 否 |备注|
|children[0].params.key.key|query|string| 否 |none|
|createBy|query|string| 否 |创建者|
|createTime|query|string| 否 |创建时间|
|updateBy|query|string| 否 |更新者|
|updateTime|query|string| 否 |更新时间|
|remark|query|string| 否 |备注|
|params.key.key|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## GET 查询部门列表（排除节点）

GET /system/dept/list/exclude/{deptId}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|deptId|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## GET 根据部门编号获取详细信息

GET /system/dept/{deptId}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|deptId|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## DELETE 删除部门

DELETE /system/dept/{deptId}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|deptId|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## POST 新增部门

POST /system/dept

> Body 请求参数

```json
{}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|object| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## PUT 修改部门

PUT /system/dept

> Body 请求参数

```json
{}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|object| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

# 数据字典信息

## GET list

GET /system/dict/data/list

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|dictCode|query|string| 否 |字典编码|
|dictSort|query|string| 否 |字典排序|
|dictLabel|query|string| 否 |字典标签|
|dictValue|query|string| 否 |字典键值|
|dictType|query|string| 否 |字典类型|
|cssClass|query|string| 否 |样式属性（其他样式扩展）|
|listClass|query|string| 否 |表格字典样式|
|isDefault|query|string| 否 |是否默认（Y是 N否）|
|status|query|string| 否 |状态（0正常 1停用）|
|createBy|query|string| 否 |创建者|
|createTime|query|string| 否 |创建时间|
|updateBy|query|string| 否 |更新者|
|updateTime|query|string| 否 |更新时间|
|remark|query|string| 否 |备注|
|params.key.key|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "total": 0,
  "rows": [],
  "code": 0,
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[TableDataInfo](#schematabledatainfo)|

## POST export

POST /system/dict/data/export

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|dictCode|query|string| 否 |字典编码|
|dictSort|query|string| 否 |字典排序|
|dictLabel|query|string| 否 |字典标签|
|dictValue|query|string| 否 |字典键值|
|dictType|query|string| 否 |字典类型|
|cssClass|query|string| 否 |样式属性（其他样式扩展）|
|listClass|query|string| 否 |表格字典样式|
|isDefault|query|string| 否 |是否默认（Y是 N否）|
|status|query|string| 否 |状态（0正常 1停用）|
|createBy|query|string| 否 |创建者|
|createTime|query|string| 否 |创建时间|
|updateBy|query|string| 否 |更新者|
|updateTime|query|string| 否 |更新时间|
|remark|query|string| 否 |备注|
|params.key.key|query|string| 否 |none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 查询字典数据详细

GET /system/dict/data/{dictCode}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|dictCode|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## GET 根据字典类型查询字典数据信息

GET /system/dict/data/type/{dictType}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|dictType|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## POST 新增字典类型

POST /system/dict/data

> Body 请求参数

```json
{
  "dictCode": 0,
  "dictSort": 0,
  "dictLabel": "string",
  "dictValue": "string",
  "dictType": "string",
  "cssClass": "string",
  "listClass": "string",
  "isDefault": "string",
  "status": "string",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[SysDictData](#schemasysdictdata)| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## PUT 修改保存字典类型

PUT /system/dict/data

> Body 请求参数

```json
{
  "dictCode": 0,
  "dictSort": 0,
  "dictLabel": "string",
  "dictValue": "string",
  "dictType": "string",
  "cssClass": "string",
  "listClass": "string",
  "isDefault": "string",
  "status": "string",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[SysDictData](#schemasysdictdata)| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## DELETE 删除字典类型

DELETE /system/dict/data/{dictCodes}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|dictCodes|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## GET list

GET /system/dict/type/list

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|dictId|query|string| 否 |字典主键|
|dictName|query|string| 否 |字典名称|
|dictType|query|string| 否 |字典类型|
|status|query|string| 否 |状态（0正常 1停用）|
|createBy|query|string| 否 |创建者|
|createTime|query|string| 否 |创建时间|
|updateBy|query|string| 否 |更新者|
|updateTime|query|string| 否 |更新时间|
|remark|query|string| 否 |备注|
|params.key.key|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "total": 0,
  "rows": [],
  "code": 0,
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[TableDataInfo](#schematabledatainfo)|

## POST export

POST /system/dict/type/export

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|dictId|query|string| 否 |字典主键|
|dictName|query|string| 否 |字典名称|
|dictType|query|string| 否 |字典类型|
|status|query|string| 否 |状态（0正常 1停用）|
|createBy|query|string| 否 |创建者|
|createTime|query|string| 否 |创建时间|
|updateBy|query|string| 否 |更新者|
|updateTime|query|string| 否 |更新时间|
|remark|query|string| 否 |备注|
|params.key.key|query|string| 否 |none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 查询字典类型详细

GET /system/dict/type/{dictId}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|dictId|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## POST 新增字典类型

POST /system/dict/type

> Body 请求参数

```json
{
  "dictId": 0,
  "dictName": "string",
  "dictType": "string",
  "status": "string",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[SysDictType](#schemasysdicttype)| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## PUT 修改字典类型

PUT /system/dict/type

> Body 请求参数

```json
{
  "dictId": 0,
  "dictName": "string",
  "dictType": "string",
  "status": "string",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[SysDictType](#schemasysdicttype)| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## DELETE 删除字典类型

DELETE /system/dict/type/{dictIds}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|dictIds|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## DELETE 刷新字典缓存

DELETE /system/dict/type/refreshCache

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## GET 获取字典选择框列表

GET /system/dict/type/optionselect

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

# 用户信息

## GET 获取用户列表

GET /system/user/list

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|userId|query|string| 否 |用户ID|
|deptId|query|string| 否 |部门ID|
|userName|query|string| 否 |用户账号|
|nickName|query|string| 否 |用户昵称|
|email|query|string| 否 |用户邮箱|
|phonenumber|query|string| 否 |手机号码|
|sex|query|string| 否 |用户性别|
|avatar|query|string| 否 |用户头像|
|password|query|string| 否 |密码|
|status|query|string| 否 |帐号状态（0正常 1停用）|
|delFlag|query|string| 否 |删除标志（0代表存在 2代表删除）|
|loginIp|query|string| 否 |最后登录IP|
|loginDate|query|string| 否 |最后登录时间|
|dept.deptId|query|string| 否 |部门ID|
|dept.parentId|query|string| 否 |父部门ID|
|dept.ancestors|query|string| 否 |祖级列表|
|dept.deptName|query|string| 否 |部门名称|
|dept.orderNum|query|string| 否 |显示顺序|
|dept.leader|query|string| 否 |负责人|
|dept.phone|query|string| 否 |联系电话|
|dept.email|query|string| 否 |邮箱|
|dept.status|query|string| 否 |部门状态:0正常,1停用|
|dept.delFlag|query|string| 否 |删除标志（0代表存在 2代表删除）|
|dept.parentName|query|string| 否 |父部门名称|
|dept.children[0].deptId|query|string| 否 |部门ID|
|dept.children[0].parentId|query|string| 否 |父部门ID|
|dept.children[0].ancestors|query|string| 否 |祖级列表|
|dept.children[0].deptName|query|string| 否 |部门名称|
|dept.children[0].orderNum|query|string| 否 |显示顺序|
|dept.children[0].leader|query|string| 否 |负责人|
|dept.children[0].phone|query|string| 否 |联系电话|
|dept.children[0].email|query|string| 否 |邮箱|
|dept.children[0].status|query|string| 否 |部门状态:0正常,1停用|
|dept.children[0].delFlag|query|string| 否 |删除标志（0代表存在 2代表删除）|
|dept.children[0].parentName|query|string| 否 |父部门名称|
|dept.children[0].children[0].key|query|string| 否 |none|
|dept.children[0].createBy|query|string| 否 |创建者|
|dept.children[0].createTime|query|string| 否 |创建时间|
|dept.children[0].updateBy|query|string| 否 |更新者|
|dept.children[0].updateTime|query|string| 否 |更新时间|
|dept.children[0].remark|query|string| 否 |备注|
|dept.children[0].params.key.key|query|string| 否 |none|
|dept.createBy|query|string| 否 |创建者|
|dept.createTime|query|string| 否 |创建时间|
|dept.updateBy|query|string| 否 |更新者|
|dept.updateTime|query|string| 否 |更新时间|
|dept.remark|query|string| 否 |备注|
|dept.params.key.key|query|string| 否 |none|
|roles[0].roleId|query|string| 否 |角色ID|
|roles[0].roleName|query|string| 否 |角色名称|
|roles[0].roleKey|query|string| 否 |角色权限|
|roles[0].roleSort|query|string| 否 |角色排序|
|roles[0].dataScope|query|string| 否 |数据范围（1：所有数据权限；2：自定义数据权限；3：本部门数据权限；4：本部门及以下数据权限；5：仅本人数据权限）|
|roles[0].menuCheckStrictly|query|string| 否 |菜单树选择项是否关联显示（ 0：父子不互相关联显示 1：父子互相关联显示）|
|roles[0].deptCheckStrictly|query|string| 否 |部门树选择项是否关联显示（0：父子不互相关联显示 1：父子互相关联显示 ）|
|roles[0].status|query|string| 否 |角色状态（0正常 1停用）|
|roles[0].delFlag|query|string| 否 |删除标志（0代表存在 2代表删除）|
|roles[0].flag|query|string| 否 |用户是否存在此角色标识 默认不存在|
|roles[0].menuIds[0]|query|string| 否 |菜单组|
|roles[0].deptIds[0]|query|string| 否 |部门组（数据权限）|
|roles[0].permissions[0]|query|string| 否 |角色菜单权限|
|roles[0].createBy|query|string| 否 |创建者|
|roles[0].createTime|query|string| 否 |创建时间|
|roles[0].updateBy|query|string| 否 |更新者|
|roles[0].updateTime|query|string| 否 |更新时间|
|roles[0].remark|query|string| 否 |备注|
|roles[0].params.key.key|query|string| 否 |none|
|roleIds[0]|query|string| 否 |角色组|
|postIds[0]|query|string| 否 |岗位组|
|roleId|query|string| 否 |角色ID|
|createBy|query|string| 否 |创建者|
|createTime|query|string| 否 |创建时间|
|updateBy|query|string| 否 |更新者|
|updateTime|query|string| 否 |更新时间|
|remark|query|string| 否 |备注|
|params.key.key|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "total": 0,
  "rows": [],
  "code": 0,
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[TableDataInfo](#schematabledatainfo)|

## POST export

POST /system/user/export

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|userId|query|string| 否 |用户ID|
|deptId|query|string| 否 |部门ID|
|userName|query|string| 否 |用户账号|
|nickName|query|string| 否 |用户昵称|
|email|query|string| 否 |用户邮箱|
|phonenumber|query|string| 否 |手机号码|
|sex|query|string| 否 |用户性别|
|avatar|query|string| 否 |用户头像|
|password|query|string| 否 |密码|
|status|query|string| 否 |帐号状态（0正常 1停用）|
|delFlag|query|string| 否 |删除标志（0代表存在 2代表删除）|
|loginIp|query|string| 否 |最后登录IP|
|loginDate|query|string| 否 |最后登录时间|
|dept.deptId|query|string| 否 |部门ID|
|dept.parentId|query|string| 否 |父部门ID|
|dept.ancestors|query|string| 否 |祖级列表|
|dept.deptName|query|string| 否 |部门名称|
|dept.orderNum|query|string| 否 |显示顺序|
|dept.leader|query|string| 否 |负责人|
|dept.phone|query|string| 否 |联系电话|
|dept.email|query|string| 否 |邮箱|
|dept.status|query|string| 否 |部门状态:0正常,1停用|
|dept.delFlag|query|string| 否 |删除标志（0代表存在 2代表删除）|
|dept.parentName|query|string| 否 |父部门名称|
|dept.children[0].deptId|query|string| 否 |部门ID|
|dept.children[0].parentId|query|string| 否 |父部门ID|
|dept.children[0].ancestors|query|string| 否 |祖级列表|
|dept.children[0].deptName|query|string| 否 |部门名称|
|dept.children[0].orderNum|query|string| 否 |显示顺序|
|dept.children[0].leader|query|string| 否 |负责人|
|dept.children[0].phone|query|string| 否 |联系电话|
|dept.children[0].email|query|string| 否 |邮箱|
|dept.children[0].status|query|string| 否 |部门状态:0正常,1停用|
|dept.children[0].delFlag|query|string| 否 |删除标志（0代表存在 2代表删除）|
|dept.children[0].parentName|query|string| 否 |父部门名称|
|dept.children[0].children[0].key|query|string| 否 |none|
|dept.children[0].createBy|query|string| 否 |创建者|
|dept.children[0].createTime|query|string| 否 |创建时间|
|dept.children[0].updateBy|query|string| 否 |更新者|
|dept.children[0].updateTime|query|string| 否 |更新时间|
|dept.children[0].remark|query|string| 否 |备注|
|dept.children[0].params.key.key|query|string| 否 |none|
|dept.createBy|query|string| 否 |创建者|
|dept.createTime|query|string| 否 |创建时间|
|dept.updateBy|query|string| 否 |更新者|
|dept.updateTime|query|string| 否 |更新时间|
|dept.remark|query|string| 否 |备注|
|dept.params.key.key|query|string| 否 |none|
|roles[0].roleId|query|string| 否 |角色ID|
|roles[0].roleName|query|string| 否 |角色名称|
|roles[0].roleKey|query|string| 否 |角色权限|
|roles[0].roleSort|query|string| 否 |角色排序|
|roles[0].dataScope|query|string| 否 |数据范围（1：所有数据权限；2：自定义数据权限；3：本部门数据权限；4：本部门及以下数据权限；5：仅本人数据权限）|
|roles[0].menuCheckStrictly|query|string| 否 |菜单树选择项是否关联显示（ 0：父子不互相关联显示 1：父子互相关联显示）|
|roles[0].deptCheckStrictly|query|string| 否 |部门树选择项是否关联显示（0：父子不互相关联显示 1：父子互相关联显示 ）|
|roles[0].status|query|string| 否 |角色状态（0正常 1停用）|
|roles[0].delFlag|query|string| 否 |删除标志（0代表存在 2代表删除）|
|roles[0].flag|query|string| 否 |用户是否存在此角色标识 默认不存在|
|roles[0].menuIds[0]|query|string| 否 |菜单组|
|roles[0].deptIds[0]|query|string| 否 |部门组（数据权限）|
|roles[0].permissions[0]|query|string| 否 |角色菜单权限|
|roles[0].createBy|query|string| 否 |创建者|
|roles[0].createTime|query|string| 否 |创建时间|
|roles[0].updateBy|query|string| 否 |更新者|
|roles[0].updateTime|query|string| 否 |更新时间|
|roles[0].remark|query|string| 否 |备注|
|roles[0].params.key.key|query|string| 否 |none|
|roleIds[0]|query|string| 否 |角色组|
|postIds[0]|query|string| 否 |岗位组|
|roleId|query|string| 否 |角色ID|
|createBy|query|string| 否 |创建者|
|createTime|query|string| 否 |创建时间|
|updateBy|query|string| 否 |更新者|
|updateTime|query|string| 否 |更新时间|
|remark|query|string| 否 |备注|
|params.key.key|query|string| 否 |none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## POST importData

POST /system/user/importData

> Body 请求参数

```yaml
file: string

```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|updateSupport|query|string| 否 |none|
|body|body|object| 否 |none|
|» file|body|string(binary)| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## POST importTemplate

POST /system/user/importTemplate

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 根据用户编号获取详细信息

GET /system/user/%2C/system/user/{userId}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|userId|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## POST 新增用户

POST /system/user

> Body 请求参数

```json
{
  "userId": 0,
  "deptId": 0,
  "userName": "string",
  "nickName": "string",
  "email": "string",
  "phonenumber": "string",
  "sex": "string",
  "avatar": "string",
  "password": "string",
  "status": "string",
  "delFlag": "string",
  "loginIp": "string",
  "loginDate": "string",
  "dept": {},
  "roles": [
    {
      "roleId": 0,
      "roleName": "string",
      "roleKey": "string",
      "roleSort": 0,
      "dataScope": "string",
      "menuCheckStrictly": true,
      "deptCheckStrictly": true,
      "status": "string",
      "delFlag": "string",
      "flag": "false",
      "menuIds": [
        0
      ],
      "deptIds": [
        0
      ],
      "permissions": [
        "string"
      ],
      "createBy": "string",
      "createTime": "string",
      "updateBy": "string",
      "updateTime": "string",
      "remark": "string",
      "params": {
        "key": {}
      }
    }
  ],
  "roleIds": [
    0
  ],
  "postIds": [
    0
  ],
  "roleId": 0,
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[SysUser](#schemasysuser)| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## PUT 修改用户

PUT /system/user

> Body 请求参数

```json
{
  "userId": 0,
  "deptId": 0,
  "userName": "string",
  "nickName": "string",
  "email": "string",
  "phonenumber": "string",
  "sex": "string",
  "avatar": "string",
  "password": "string",
  "status": "string",
  "delFlag": "string",
  "loginIp": "string",
  "loginDate": "string",
  "dept": {},
  "roles": [
    {
      "roleId": 0,
      "roleName": "string",
      "roleKey": "string",
      "roleSort": 0,
      "dataScope": "string",
      "menuCheckStrictly": true,
      "deptCheckStrictly": true,
      "status": "string",
      "delFlag": "string",
      "flag": "false",
      "menuIds": [
        0
      ],
      "deptIds": [
        0
      ],
      "permissions": [
        "string"
      ],
      "createBy": "string",
      "createTime": "string",
      "updateBy": "string",
      "updateTime": "string",
      "remark": "string",
      "params": {
        "key": {}
      }
    }
  ],
  "roleIds": [
    0
  ],
  "postIds": [
    0
  ],
  "roleId": 0,
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[SysUser](#schemasysuser)| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## DELETE 删除用户

DELETE /system/user/{userIds}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|userIds|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## PUT 重置密码

PUT /system/user/resetPwd

> Body 请求参数

```json
{
  "userId": 0,
  "deptId": 0,
  "userName": "string",
  "nickName": "string",
  "email": "string",
  "phonenumber": "string",
  "sex": "string",
  "avatar": "string",
  "password": "string",
  "status": "string",
  "delFlag": "string",
  "loginIp": "string",
  "loginDate": "string",
  "dept": {},
  "roles": [
    {
      "roleId": 0,
      "roleName": "string",
      "roleKey": "string",
      "roleSort": 0,
      "dataScope": "string",
      "menuCheckStrictly": true,
      "deptCheckStrictly": true,
      "status": "string",
      "delFlag": "string",
      "flag": "false",
      "menuIds": [
        0
      ],
      "deptIds": [
        0
      ],
      "permissions": [
        "string"
      ],
      "createBy": "string",
      "createTime": "string",
      "updateBy": "string",
      "updateTime": "string",
      "remark": "string",
      "params": {
        "key": {}
      }
    }
  ],
  "roleIds": [
    0
  ],
  "postIds": [
    0
  ],
  "roleId": 0,
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[SysUser](#schemasysuser)| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## PUT 状态修改

PUT /system/user/changeStatus

> Body 请求参数

```json
{
  "userId": 0,
  "deptId": 0,
  "userName": "string",
  "nickName": "string",
  "email": "string",
  "phonenumber": "string",
  "sex": "string",
  "avatar": "string",
  "password": "string",
  "status": "string",
  "delFlag": "string",
  "loginIp": "string",
  "loginDate": "string",
  "dept": {},
  "roles": [
    {
      "roleId": 0,
      "roleName": "string",
      "roleKey": "string",
      "roleSort": 0,
      "dataScope": "string",
      "menuCheckStrictly": true,
      "deptCheckStrictly": true,
      "status": "string",
      "delFlag": "string",
      "flag": "false",
      "menuIds": [
        0
      ],
      "deptIds": [
        0
      ],
      "permissions": [
        "string"
      ],
      "createBy": "string",
      "createTime": "string",
      "updateBy": "string",
      "updateTime": "string",
      "remark": "string",
      "params": {
        "key": {}
      }
    }
  ],
  "roleIds": [
    0
  ],
  "postIds": [
    0
  ],
  "roleId": 0,
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[SysUser](#schemasysuser)| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## GET 根据用户编号获取授权角色

GET /system/user/authRole/{userId}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|userId|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## PUT 用户授权角色

PUT /system/user/authRole

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|userId|query|integer| 否 |none|
|roleIds|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## GET 获取部门树列表

GET /system/user/deptTree

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|deptId|query|string| 否 |部门ID|
|parentId|query|string| 否 |父部门ID|
|ancestors|query|string| 否 |祖级列表|
|deptName|query|string| 否 |部门名称|
|orderNum|query|string| 否 |显示顺序|
|leader|query|string| 否 |负责人|
|phone|query|string| 否 |联系电话|
|email|query|string| 否 |邮箱|
|status|query|string| 否 |部门状态:0正常,1停用|
|delFlag|query|string| 否 |删除标志（0代表存在 2代表删除）|
|parentName|query|string| 否 |父部门名称|
|children[0].deptId|query|string| 否 |部门ID|
|children[0].parentId|query|string| 否 |父部门ID|
|children[0].ancestors|query|string| 否 |祖级列表|
|children[0].deptName|query|string| 否 |部门名称|
|children[0].orderNum|query|string| 否 |显示顺序|
|children[0].leader|query|string| 否 |负责人|
|children[0].phone|query|string| 否 |联系电话|
|children[0].email|query|string| 否 |邮箱|
|children[0].status|query|string| 否 |部门状态:0正常,1停用|
|children[0].delFlag|query|string| 否 |删除标志（0代表存在 2代表删除）|
|children[0].parentName|query|string| 否 |父部门名称|
|children[0].children[0].key|query|string| 否 |none|
|children[0].createBy|query|string| 否 |创建者|
|children[0].createTime|query|string| 否 |创建时间|
|children[0].updateBy|query|string| 否 |更新者|
|children[0].updateTime|query|string| 否 |更新时间|
|children[0].remark|query|string| 否 |备注|
|children[0].params.key.key|query|string| 否 |none|
|createBy|query|string| 否 |创建者|
|createTime|query|string| 否 |创建时间|
|updateBy|query|string| 否 |更新者|
|updateTime|query|string| 否 |更新时间|
|remark|query|string| 否 |备注|
|params.key.key|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

# 角色信息

## GET list

GET /system/role/list

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|roleId|query|string| 否 |角色ID|
|roleName|query|string| 否 |角色名称|
|roleKey|query|string| 否 |角色权限|
|roleSort|query|string| 否 |角色排序|
|dataScope|query|string| 否 |数据范围（1：所有数据权限；2：自定义数据权限；3：本部门数据权限；4：本部门及以下数据权限；5：仅本人数据权限）|
|menuCheckStrictly|query|string| 否 |菜单树选择项是否关联显示（ 0：父子不互相关联显示 1：父子互相关联显示）|
|deptCheckStrictly|query|string| 否 |部门树选择项是否关联显示（0：父子不互相关联显示 1：父子互相关联显示 ）|
|status|query|string| 否 |角色状态（0正常 1停用）|
|delFlag|query|string| 否 |删除标志（0代表存在 2代表删除）|
|flag|query|string| 否 |用户是否存在此角色标识 默认不存在|
|menuIds[0]|query|string| 否 |菜单组|
|deptIds[0]|query|string| 否 |部门组（数据权限）|
|permissions[0]|query|string| 否 |角色菜单权限|
|createBy|query|string| 否 |创建者|
|createTime|query|string| 否 |创建时间|
|updateBy|query|string| 否 |更新者|
|updateTime|query|string| 否 |更新时间|
|remark|query|string| 否 |备注|
|params.key.key|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "total": 0,
  "rows": [],
  "code": 0,
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[TableDataInfo](#schematabledatainfo)|

## POST export

POST /system/role/export

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|roleId|query|string| 否 |角色ID|
|roleName|query|string| 否 |角色名称|
|roleKey|query|string| 否 |角色权限|
|roleSort|query|string| 否 |角色排序|
|dataScope|query|string| 否 |数据范围（1：所有数据权限；2：自定义数据权限；3：本部门数据权限；4：本部门及以下数据权限；5：仅本人数据权限）|
|menuCheckStrictly|query|string| 否 |菜单树选择项是否关联显示（ 0：父子不互相关联显示 1：父子互相关联显示）|
|deptCheckStrictly|query|string| 否 |部门树选择项是否关联显示（0：父子不互相关联显示 1：父子互相关联显示 ）|
|status|query|string| 否 |角色状态（0正常 1停用）|
|delFlag|query|string| 否 |删除标志（0代表存在 2代表删除）|
|flag|query|string| 否 |用户是否存在此角色标识 默认不存在|
|menuIds[0]|query|string| 否 |菜单组|
|deptIds[0]|query|string| 否 |部门组（数据权限）|
|permissions[0]|query|string| 否 |角色菜单权限|
|createBy|query|string| 否 |创建者|
|createTime|query|string| 否 |创建时间|
|updateBy|query|string| 否 |更新者|
|updateTime|query|string| 否 |更新时间|
|remark|query|string| 否 |备注|
|params.key.key|query|string| 否 |none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 根据角色编号获取详细信息

GET /system/role/{roleId}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|roleId|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## POST 新增角色

POST /system/role

> Body 请求参数

```json
{
  "roleId": 0,
  "roleName": "string",
  "roleKey": "string",
  "roleSort": 0,
  "dataScope": "string",
  "menuCheckStrictly": true,
  "deptCheckStrictly": true,
  "status": "string",
  "delFlag": "string",
  "flag": "false",
  "menuIds": [
    0
  ],
  "deptIds": [
    0
  ],
  "permissions": [
    "string"
  ],
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[SysRole](#schemasysrole)| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## PUT 修改保存角色

PUT /system/role

> Body 请求参数

```json
{
  "roleId": 0,
  "roleName": "string",
  "roleKey": "string",
  "roleSort": 0,
  "dataScope": "string",
  "menuCheckStrictly": true,
  "deptCheckStrictly": true,
  "status": "string",
  "delFlag": "string",
  "flag": "false",
  "menuIds": [
    0
  ],
  "deptIds": [
    0
  ],
  "permissions": [
    "string"
  ],
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[SysRole](#schemasysrole)| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## PUT 修改保存数据权限

PUT /system/role/dataScope

> Body 请求参数

```json
{
  "roleId": 0,
  "roleName": "string",
  "roleKey": "string",
  "roleSort": 0,
  "dataScope": "string",
  "menuCheckStrictly": true,
  "deptCheckStrictly": true,
  "status": "string",
  "delFlag": "string",
  "flag": "false",
  "menuIds": [
    0
  ],
  "deptIds": [
    0
  ],
  "permissions": [
    "string"
  ],
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[SysRole](#schemasysrole)| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## PUT 状态修改

PUT /system/role/changeStatus

> Body 请求参数

```json
{
  "roleId": 0,
  "roleName": "string",
  "roleKey": "string",
  "roleSort": 0,
  "dataScope": "string",
  "menuCheckStrictly": true,
  "deptCheckStrictly": true,
  "status": "string",
  "delFlag": "string",
  "flag": "false",
  "menuIds": [
    0
  ],
  "deptIds": [
    0
  ],
  "permissions": [
    "string"
  ],
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[SysRole](#schemasysrole)| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## DELETE 删除角色

DELETE /system/role/{roleIds}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|roleIds|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## GET 获取角色选择框列表

GET /system/role/optionselect

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## GET 查询已分配用户角色列表

GET /system/role/authUser/allocatedList

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|userId|query|string| 否 |用户ID|
|deptId|query|string| 否 |部门ID|
|userName|query|string| 否 |用户账号|
|nickName|query|string| 否 |用户昵称|
|email|query|string| 否 |用户邮箱|
|phonenumber|query|string| 否 |手机号码|
|sex|query|string| 否 |用户性别|
|avatar|query|string| 否 |用户头像|
|password|query|string| 否 |密码|
|status|query|string| 否 |帐号状态（0正常 1停用）|
|delFlag|query|string| 否 |删除标志（0代表存在 2代表删除）|
|loginIp|query|string| 否 |最后登录IP|
|loginDate|query|string| 否 |最后登录时间|
|dept.deptId|query|string| 否 |部门ID|
|dept.parentId|query|string| 否 |父部门ID|
|dept.ancestors|query|string| 否 |祖级列表|
|dept.deptName|query|string| 否 |部门名称|
|dept.orderNum|query|string| 否 |显示顺序|
|dept.leader|query|string| 否 |负责人|
|dept.phone|query|string| 否 |联系电话|
|dept.email|query|string| 否 |邮箱|
|dept.status|query|string| 否 |部门状态:0正常,1停用|
|dept.delFlag|query|string| 否 |删除标志（0代表存在 2代表删除）|
|dept.parentName|query|string| 否 |父部门名称|
|dept.children[0].deptId|query|string| 否 |部门ID|
|dept.children[0].parentId|query|string| 否 |父部门ID|
|dept.children[0].ancestors|query|string| 否 |祖级列表|
|dept.children[0].deptName|query|string| 否 |部门名称|
|dept.children[0].orderNum|query|string| 否 |显示顺序|
|dept.children[0].leader|query|string| 否 |负责人|
|dept.children[0].phone|query|string| 否 |联系电话|
|dept.children[0].email|query|string| 否 |邮箱|
|dept.children[0].status|query|string| 否 |部门状态:0正常,1停用|
|dept.children[0].delFlag|query|string| 否 |删除标志（0代表存在 2代表删除）|
|dept.children[0].parentName|query|string| 否 |父部门名称|
|dept.children[0].children[0].key|query|string| 否 |none|
|dept.children[0].createBy|query|string| 否 |创建者|
|dept.children[0].createTime|query|string| 否 |创建时间|
|dept.children[0].updateBy|query|string| 否 |更新者|
|dept.children[0].updateTime|query|string| 否 |更新时间|
|dept.children[0].remark|query|string| 否 |备注|
|dept.children[0].params.key.key|query|string| 否 |none|
|dept.createBy|query|string| 否 |创建者|
|dept.createTime|query|string| 否 |创建时间|
|dept.updateBy|query|string| 否 |更新者|
|dept.updateTime|query|string| 否 |更新时间|
|dept.remark|query|string| 否 |备注|
|dept.params.key.key|query|string| 否 |none|
|roles[0].roleId|query|string| 否 |角色ID|
|roles[0].roleName|query|string| 否 |角色名称|
|roles[0].roleKey|query|string| 否 |角色权限|
|roles[0].roleSort|query|string| 否 |角色排序|
|roles[0].dataScope|query|string| 否 |数据范围（1：所有数据权限；2：自定义数据权限；3：本部门数据权限；4：本部门及以下数据权限；5：仅本人数据权限）|
|roles[0].menuCheckStrictly|query|string| 否 |菜单树选择项是否关联显示（ 0：父子不互相关联显示 1：父子互相关联显示）|
|roles[0].deptCheckStrictly|query|string| 否 |部门树选择项是否关联显示（0：父子不互相关联显示 1：父子互相关联显示 ）|
|roles[0].status|query|string| 否 |角色状态（0正常 1停用）|
|roles[0].delFlag|query|string| 否 |删除标志（0代表存在 2代表删除）|
|roles[0].flag|query|string| 否 |用户是否存在此角色标识 默认不存在|
|roles[0].menuIds[0]|query|string| 否 |菜单组|
|roles[0].deptIds[0]|query|string| 否 |部门组（数据权限）|
|roles[0].permissions[0]|query|string| 否 |角色菜单权限|
|roles[0].createBy|query|string| 否 |创建者|
|roles[0].createTime|query|string| 否 |创建时间|
|roles[0].updateBy|query|string| 否 |更新者|
|roles[0].updateTime|query|string| 否 |更新时间|
|roles[0].remark|query|string| 否 |备注|
|roles[0].params.key.key|query|string| 否 |none|
|roleIds[0]|query|string| 否 |角色组|
|postIds[0]|query|string| 否 |岗位组|
|roleId|query|string| 否 |角色ID|
|createBy|query|string| 否 |创建者|
|createTime|query|string| 否 |创建时间|
|updateBy|query|string| 否 |更新者|
|updateTime|query|string| 否 |更新时间|
|remark|query|string| 否 |备注|
|params.key.key|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "total": 0,
  "rows": [],
  "code": 0,
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[TableDataInfo](#schematabledatainfo)|

## GET 查询未分配用户角色列表

GET /system/role/authUser/unallocatedList

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|userId|query|string| 否 |用户ID|
|deptId|query|string| 否 |部门ID|
|userName|query|string| 否 |用户账号|
|nickName|query|string| 否 |用户昵称|
|email|query|string| 否 |用户邮箱|
|phonenumber|query|string| 否 |手机号码|
|sex|query|string| 否 |用户性别|
|avatar|query|string| 否 |用户头像|
|password|query|string| 否 |密码|
|status|query|string| 否 |帐号状态（0正常 1停用）|
|delFlag|query|string| 否 |删除标志（0代表存在 2代表删除）|
|loginIp|query|string| 否 |最后登录IP|
|loginDate|query|string| 否 |最后登录时间|
|dept.deptId|query|string| 否 |部门ID|
|dept.parentId|query|string| 否 |父部门ID|
|dept.ancestors|query|string| 否 |祖级列表|
|dept.deptName|query|string| 否 |部门名称|
|dept.orderNum|query|string| 否 |显示顺序|
|dept.leader|query|string| 否 |负责人|
|dept.phone|query|string| 否 |联系电话|
|dept.email|query|string| 否 |邮箱|
|dept.status|query|string| 否 |部门状态:0正常,1停用|
|dept.delFlag|query|string| 否 |删除标志（0代表存在 2代表删除）|
|dept.parentName|query|string| 否 |父部门名称|
|dept.children[0].deptId|query|string| 否 |部门ID|
|dept.children[0].parentId|query|string| 否 |父部门ID|
|dept.children[0].ancestors|query|string| 否 |祖级列表|
|dept.children[0].deptName|query|string| 否 |部门名称|
|dept.children[0].orderNum|query|string| 否 |显示顺序|
|dept.children[0].leader|query|string| 否 |负责人|
|dept.children[0].phone|query|string| 否 |联系电话|
|dept.children[0].email|query|string| 否 |邮箱|
|dept.children[0].status|query|string| 否 |部门状态:0正常,1停用|
|dept.children[0].delFlag|query|string| 否 |删除标志（0代表存在 2代表删除）|
|dept.children[0].parentName|query|string| 否 |父部门名称|
|dept.children[0].children[0].key|query|string| 否 |none|
|dept.children[0].createBy|query|string| 否 |创建者|
|dept.children[0].createTime|query|string| 否 |创建时间|
|dept.children[0].updateBy|query|string| 否 |更新者|
|dept.children[0].updateTime|query|string| 否 |更新时间|
|dept.children[0].remark|query|string| 否 |备注|
|dept.children[0].params.key.key|query|string| 否 |none|
|dept.createBy|query|string| 否 |创建者|
|dept.createTime|query|string| 否 |创建时间|
|dept.updateBy|query|string| 否 |更新者|
|dept.updateTime|query|string| 否 |更新时间|
|dept.remark|query|string| 否 |备注|
|dept.params.key.key|query|string| 否 |none|
|roles[0].roleId|query|string| 否 |角色ID|
|roles[0].roleName|query|string| 否 |角色名称|
|roles[0].roleKey|query|string| 否 |角色权限|
|roles[0].roleSort|query|string| 否 |角色排序|
|roles[0].dataScope|query|string| 否 |数据范围（1：所有数据权限；2：自定义数据权限；3：本部门数据权限；4：本部门及以下数据权限；5：仅本人数据权限）|
|roles[0].menuCheckStrictly|query|string| 否 |菜单树选择项是否关联显示（ 0：父子不互相关联显示 1：父子互相关联显示）|
|roles[0].deptCheckStrictly|query|string| 否 |部门树选择项是否关联显示（0：父子不互相关联显示 1：父子互相关联显示 ）|
|roles[0].status|query|string| 否 |角色状态（0正常 1停用）|
|roles[0].delFlag|query|string| 否 |删除标志（0代表存在 2代表删除）|
|roles[0].flag|query|string| 否 |用户是否存在此角色标识 默认不存在|
|roles[0].menuIds[0]|query|string| 否 |菜单组|
|roles[0].deptIds[0]|query|string| 否 |部门组（数据权限）|
|roles[0].permissions[0]|query|string| 否 |角色菜单权限|
|roles[0].createBy|query|string| 否 |创建者|
|roles[0].createTime|query|string| 否 |创建时间|
|roles[0].updateBy|query|string| 否 |更新者|
|roles[0].updateTime|query|string| 否 |更新时间|
|roles[0].remark|query|string| 否 |备注|
|roles[0].params.key.key|query|string| 否 |none|
|roleIds[0]|query|string| 否 |角色组|
|postIds[0]|query|string| 否 |岗位组|
|roleId|query|string| 否 |角色ID|
|createBy|query|string| 否 |创建者|
|createTime|query|string| 否 |创建时间|
|updateBy|query|string| 否 |更新者|
|updateTime|query|string| 否 |更新时间|
|remark|query|string| 否 |备注|
|params.key.key|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "total": 0,
  "rows": [],
  "code": 0,
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[TableDataInfo](#schematabledatainfo)|

## PUT 取消授权用户

PUT /system/role/authUser/cancel

> Body 请求参数

```json
{
  "userId": 0,
  "roleId": 0
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[SysUserRole](#schemasysuserrole)| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## PUT 批量取消授权用户

PUT /system/role/authUser/cancelAll

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|roleId|query|integer| 否 |none|
|userIds|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## PUT 批量选择用户授权

PUT /system/role/authUser/selectAll

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|roleId|query|integer| 否 |none|
|userIds|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## GET 获取对应角色部门树列表

GET /system/role/deptTree/{roleId}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|roleId|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

# 注册验证

## POST register

POST /register

> Body 请求参数

```json
{
  "username": "string",
  "password": "string",
  "code": "string",
  "uuid": "string"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[RegisterBody](#schemaregisterbody)| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

# 个人信息 业务处理

## GET 个人信息

GET /system/user/profile

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## PUT 修改用户

PUT /system/user/profile

> Body 请求参数

```json
{
  "userId": 0,
  "deptId": 0,
  "userName": "string",
  "nickName": "string",
  "email": "string",
  "phonenumber": "string",
  "sex": "string",
  "avatar": "string",
  "password": "string",
  "status": "string",
  "delFlag": "string",
  "loginIp": "string",
  "loginDate": "string",
  "dept": {},
  "roles": [
    {
      "roleId": 0,
      "roleName": "string",
      "roleKey": "string",
      "roleSort": 0,
      "dataScope": "string",
      "menuCheckStrictly": true,
      "deptCheckStrictly": true,
      "status": "string",
      "delFlag": "string",
      "flag": "false",
      "menuIds": [
        0
      ],
      "deptIds": [
        0
      ],
      "permissions": [
        "string"
      ],
      "createBy": "string",
      "createTime": "string",
      "updateBy": "string",
      "updateTime": "string",
      "remark": "string",
      "params": {
        "key": {}
      }
    }
  ],
  "roleIds": [
    0
  ],
  "postIds": [
    0
  ],
  "roleId": 0,
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[SysUser](#schemasysuser)| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## PUT 重置密码

PUT /system/user/profile/updatePwd

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|oldPassword|query|string| 否 |none|
|newPassword|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## POST 头像上传

POST /system/user/profile/avatar

> Body 请求参数

```yaml
avatarfile: string

```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|object| 否 |none|
|» avatarfile|body|string(binary)| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

# 岗位信息操作处理

## GET 获取岗位列表

GET /system/post/list

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|postId|query|string| 否 |岗位序号|
|postCode|query|string| 否 |岗位编码|
|postName|query|string| 否 |岗位名称|
|postSort|query|string| 否 |岗位排序|
|status|query|string| 否 |状态（0正常 1停用）|
|flag|query|string| 否 |用户是否存在此岗位标识 默认不存在|
|createBy|query|string| 否 |创建者|
|createTime|query|string| 否 |创建时间|
|updateBy|query|string| 否 |更新者|
|updateTime|query|string| 否 |更新时间|
|remark|query|string| 否 |备注|
|params.key.key|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "total": 0,
  "rows": [],
  "code": 0,
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[TableDataInfo](#schematabledatainfo)|

## POST export

POST /system/post/export

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|postId|query|string| 否 |岗位序号|
|postCode|query|string| 否 |岗位编码|
|postName|query|string| 否 |岗位名称|
|postSort|query|string| 否 |岗位排序|
|status|query|string| 否 |状态（0正常 1停用）|
|flag|query|string| 否 |用户是否存在此岗位标识 默认不存在|
|createBy|query|string| 否 |创建者|
|createTime|query|string| 否 |创建时间|
|updateBy|query|string| 否 |更新者|
|updateTime|query|string| 否 |更新时间|
|remark|query|string| 否 |备注|
|params.key.key|query|string| 否 |none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 根据岗位编号获取详细信息

GET /system/post/{postId}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|postId|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## POST 新增岗位

POST /system/post

> Body 请求参数

```json
{
  "postId": 0,
  "postCode": "string",
  "postName": "string",
  "postSort": 0,
  "status": "string",
  "flag": "false",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[SysPost](#schemasyspost)| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## PUT 修改岗位

PUT /system/post

> Body 请求参数

```json
{
  "postId": 0,
  "postCode": "string",
  "postName": "string",
  "postSort": 0,
  "status": "string",
  "flag": "false",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[SysPost](#schemasyspost)| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## DELETE 删除岗位

DELETE /system/post/{postIds}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|postIds|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## GET 获取岗位选择框列表

GET /system/post/optionselect

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

# 公告 信息操作处理

## GET 获取通知公告列表

GET /system/notice/list

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|noticeId|query|string| 否 |公告ID|
|noticeTitle|query|string| 否 |公告标题|
|noticeType|query|string| 否 |公告类型（1通知 2公告）|
|noticeContent|query|string| 否 |公告内容|
|status|query|string| 否 |公告状态（0正常 1关闭）|
|createBy|query|string| 否 |创建者|
|createTime|query|string| 否 |创建时间|
|updateBy|query|string| 否 |更新者|
|updateTime|query|string| 否 |更新时间|
|remark|query|string| 否 |备注|
|params.key.key|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "total": 0,
  "rows": [],
  "code": 0,
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[TableDataInfo](#schematabledatainfo)|

## GET 根据通知公告编号获取详细信息

GET /system/notice/{noticeId}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|noticeId|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## POST 新增通知公告

POST /system/notice

> Body 请求参数

```json
{
  "noticeId": 0,
  "noticeTitle": "string",
  "noticeType": "string",
  "noticeContent": "string",
  "status": "string",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[SysNotice](#schemasysnotice)| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## PUT 修改通知公告

PUT /system/notice

> Body 请求参数

```json
{
  "noticeId": 0,
  "noticeTitle": "string",
  "noticeType": "string",
  "noticeContent": "string",
  "status": "string",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[SysNotice](#schemasysnotice)| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## DELETE 删除通知公告

DELETE /system/notice/{noticeIds}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|noticeIds|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

# 菜单信息

## GET 获取菜单列表

GET /system/menu/list

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|menuId|query|string| 否 |菜单ID|
|menuName|query|string| 否 |菜单名称|
|parentName|query|string| 否 |父菜单名称|
|parentId|query|string| 否 |父菜单ID|
|orderNum|query|string| 否 |显示顺序|
|path|query|string| 否 |路由地址|
|component|query|string| 否 |组件路径|
|query|query|string| 否 |路由参数|
|isFrame|query|string| 否 |是否为外链（0是 1否）|
|isCache|query|string| 否 |是否缓存（0缓存 1不缓存）|
|menuType|query|string| 否 |类型（M目录 C菜单 F按钮）|
|visible|query|string| 否 |显示状态（0显示 1隐藏）|
|status|query|string| 否 |菜单状态（0正常 1停用）|
|perms|query|string| 否 |权限字符串|
|icon|query|string| 否 |菜单图标|
|children[0].menuId|query|string| 否 |菜单ID|
|children[0].menuName|query|string| 否 |菜单名称|
|children[0].parentName|query|string| 否 |父菜单名称|
|children[0].parentId|query|string| 否 |父菜单ID|
|children[0].orderNum|query|string| 否 |显示顺序|
|children[0].path|query|string| 否 |路由地址|
|children[0].component|query|string| 否 |组件路径|
|children[0].query|query|string| 否 |路由参数|
|children[0].isFrame|query|string| 否 |是否为外链（0是 1否）|
|children[0].isCache|query|string| 否 |是否缓存（0缓存 1不缓存）|
|children[0].menuType|query|string| 否 |类型（M目录 C菜单 F按钮）|
|children[0].visible|query|string| 否 |显示状态（0显示 1隐藏）|
|children[0].status|query|string| 否 |菜单状态（0正常 1停用）|
|children[0].perms|query|string| 否 |权限字符串|
|children[0].icon|query|string| 否 |菜单图标|
|children[0].children[0].key|query|string| 否 |none|
|children[0].createBy|query|string| 否 |创建者|
|children[0].createTime|query|string| 否 |创建时间|
|children[0].updateBy|query|string| 否 |更新者|
|children[0].updateTime|query|string| 否 |更新时间|
|children[0].remark|query|string| 否 |备注|
|children[0].params.key.key|query|string| 否 |none|
|createBy|query|string| 否 |创建者|
|createTime|query|string| 否 |创建时间|
|updateBy|query|string| 否 |更新者|
|updateTime|query|string| 否 |更新时间|
|remark|query|string| 否 |备注|
|params.key.key|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## GET 根据菜单编号获取详细信息

GET /system/menu/{menuId}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|menuId|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## DELETE 删除菜单

DELETE /system/menu/{menuId}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|menuId|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## GET 获取菜单下拉树列表

GET /system/menu/treeselect

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|menuId|query|string| 否 |菜单ID|
|menuName|query|string| 否 |菜单名称|
|parentName|query|string| 否 |父菜单名称|
|parentId|query|string| 否 |父菜单ID|
|orderNum|query|string| 否 |显示顺序|
|path|query|string| 否 |路由地址|
|component|query|string| 否 |组件路径|
|query|query|string| 否 |路由参数|
|isFrame|query|string| 否 |是否为外链（0是 1否）|
|isCache|query|string| 否 |是否缓存（0缓存 1不缓存）|
|menuType|query|string| 否 |类型（M目录 C菜单 F按钮）|
|visible|query|string| 否 |显示状态（0显示 1隐藏）|
|status|query|string| 否 |菜单状态（0正常 1停用）|
|perms|query|string| 否 |权限字符串|
|icon|query|string| 否 |菜单图标|
|children[0].menuId|query|string| 否 |菜单ID|
|children[0].menuName|query|string| 否 |菜单名称|
|children[0].parentName|query|string| 否 |父菜单名称|
|children[0].parentId|query|string| 否 |父菜单ID|
|children[0].orderNum|query|string| 否 |显示顺序|
|children[0].path|query|string| 否 |路由地址|
|children[0].component|query|string| 否 |组件路径|
|children[0].query|query|string| 否 |路由参数|
|children[0].isFrame|query|string| 否 |是否为外链（0是 1否）|
|children[0].isCache|query|string| 否 |是否缓存（0缓存 1不缓存）|
|children[0].menuType|query|string| 否 |类型（M目录 C菜单 F按钮）|
|children[0].visible|query|string| 否 |显示状态（0显示 1隐藏）|
|children[0].status|query|string| 否 |菜单状态（0正常 1停用）|
|children[0].perms|query|string| 否 |权限字符串|
|children[0].icon|query|string| 否 |菜单图标|
|children[0].children[0].key|query|string| 否 |none|
|children[0].createBy|query|string| 否 |创建者|
|children[0].createTime|query|string| 否 |创建时间|
|children[0].updateBy|query|string| 否 |更新者|
|children[0].updateTime|query|string| 否 |更新时间|
|children[0].remark|query|string| 否 |备注|
|children[0].params.key.key|query|string| 否 |none|
|createBy|query|string| 否 |创建者|
|createTime|query|string| 否 |创建时间|
|updateBy|query|string| 否 |更新者|
|updateTime|query|string| 否 |更新时间|
|remark|query|string| 否 |备注|
|params.key.key|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## GET 加载对应角色菜单列表树

GET /system/menu/roleMenuTreeselect/{roleId}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|roleId|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## POST 新增菜单

POST /system/menu

> Body 请求参数

```json
{
  "menuId": 0,
  "menuName": "string",
  "parentName": "string",
  "parentId": 0,
  "orderNum": 0,
  "path": "string",
  "component": "string",
  "query": "string",
  "isFrame": "string",
  "isCache": "string",
  "menuType": "string",
  "visible": "string",
  "status": "string",
  "perms": "string",
  "icon": "string",
  "children": "new ArrayList<SysMenu>()",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[SysMenu](#schemasysmenu)| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## PUT 修改菜单

PUT /system/menu

> Body 请求参数

```json
{
  "menuId": 0,
  "menuName": "string",
  "parentName": "string",
  "parentId": 0,
  "orderNum": 0,
  "path": "string",
  "component": "string",
  "query": "string",
  "isFrame": "string",
  "isCache": "string",
  "menuType": "string",
  "visible": "string",
  "status": "string",
  "perms": "string",
  "icon": "string",
  "children": "new ArrayList<SysMenu>()",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[SysMenu](#schemasysmenu)| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

# 登录验证

## POST 登录方法

POST /login

> Body 请求参数

```json
{
  "username": "string",
  "password": "string",
  "code": "string",
  "uuid": "string"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[LoginBody](#schemaloginbody)| 否 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## GET 获取用户信息

GET /getInfo

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

## GET 获取路由信息

GET /getRouters

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[AjaxResult](#schemaajaxresult)|

# 首页

## GET 访问首页，提示语

GET /

> 返回示例

> 成功

```json
null
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|string|

# 数据模型

<h2 id="tocS_LoginBody">LoginBody</h2>

<a id="schemaloginbody"></a>
<a id="schema_LoginBody"></a>
<a id="tocSloginbody"></a>
<a id="tocsloginbody"></a>

```json
{
  "username": "string",
  "password": "string",
  "code": "string",
  "uuid": "string"
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|username|string|false|none||用户名|
|password|string|false|none||用户密码|
|code|string|false|none||验证码|
|uuid|string|false|none||唯一标识|

<h2 id="tocS_SysMenu">SysMenu</h2>

<a id="schemasysmenu"></a>
<a id="schema_SysMenu"></a>
<a id="tocSsysmenu"></a>
<a id="tocssysmenu"></a>

```json
{
  "menuId": 0,
  "menuName": "string",
  "parentName": "string",
  "parentId": 0,
  "orderNum": 0,
  "path": "string",
  "component": "string",
  "query": "string",
  "isFrame": "string",
  "isCache": "string",
  "menuType": "string",
  "visible": "string",
  "status": "string",
  "perms": "string",
  "icon": "string",
  "children": "new ArrayList<SysMenu>()",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|menuId|integer|false|none||菜单ID|
|menuName|string|false|none||菜单名称|
|parentName|string|false|none||父菜单名称|
|parentId|integer|false|none||父菜单ID|
|orderNum|integer|false|none||显示顺序|
|path|string|false|none||路由地址|
|component|string|false|none||组件路径|
|query|string|false|none||路由参数|
|isFrame|string|false|none||是否为外链（0是 1否）|
|isCache|string|false|none||是否缓存（0缓存 1不缓存）|
|menuType|string|false|none||类型（M目录 C菜单 F按钮）|
|visible|string|false|none||显示状态（0显示 1隐藏）|
|status|string|false|none||菜单状态（0正常 1停用）|
|perms|string|false|none||权限字符串|
|icon|string|false|none||菜单图标|
|children|[[SysMenu](#schemasysmenu)]|false|none||子菜单|
|createBy|string|false|none||创建者|
|createTime|string|false|none||创建时间|
|updateBy|string|false|none||更新者|
|updateTime|string|false|none||更新时间|
|remark|string|false|none||备注|
|params|[Map«Object»](#schemamap%c2%abobject%c2%bb)|false|none||请求参数|

<h2 id="tocS_Map«Object»">Map«Object»</h2>

<a id="schemamap«object»"></a>
<a id="schema_Map«Object»"></a>
<a id="tocSmap«object»"></a>
<a id="tocsmap«object»"></a>

```json
{
  "key": {}
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|key|[key](#schemakey)|false|none||params.key|

<h2 id="tocS_key">key</h2>

<a id="schemakey"></a>
<a id="schema_key"></a>
<a id="tocSkey"></a>
<a id="tocskey"></a>

```json
{}

```

### 属性

*None*

<h2 id="tocS_TableDataInfo">TableDataInfo</h2>

<a id="schematabledatainfo"></a>
<a id="schema_TableDataInfo"></a>
<a id="tocStabledatainfo"></a>
<a id="tocstabledatainfo"></a>

```json
{
  "total": 0,
  "rows": [
    {}
  ],
  "code": 0,
  "msg": "string"
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|total|integer|false|none||总记录数|
|rows|[object]|false|none||列表数据|
|code|integer|false|none||消息状态码|
|msg|string|false|none||消息内容|

<h2 id="tocS_SysNotice">SysNotice</h2>

<a id="schemasysnotice"></a>
<a id="schema_SysNotice"></a>
<a id="tocSsysnotice"></a>
<a id="tocssysnotice"></a>

```json
{
  "noticeId": 0,
  "noticeTitle": "string",
  "noticeType": "string",
  "noticeContent": "string",
  "status": "string",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|noticeId|integer|false|none||公告ID|
|noticeTitle|string|false|none||公告标题|
|noticeType|string|false|none||公告类型（1通知 2公告）|
|noticeContent|string|false|none||公告内容|
|status|string|false|none||公告状态（0正常 1关闭）|
|createBy|string|false|none||创建者|
|createTime|string|false|none||创建时间|
|updateBy|string|false|none||更新者|
|updateTime|string|false|none||更新时间|
|remark|string|false|none||备注|
|params|[Map«Object»](#schemamap%c2%abobject%c2%bb)|false|none||请求参数|

<h2 id="tocS_SysPost">SysPost</h2>

<a id="schemasyspost"></a>
<a id="schema_SysPost"></a>
<a id="tocSsyspost"></a>
<a id="tocssyspost"></a>

```json
{
  "postId": 0,
  "postCode": "string",
  "postName": "string",
  "postSort": 0,
  "status": "string",
  "flag": "false",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|postId|integer|false|none||岗位序号|
|postCode|string|false|none||岗位编码|
|postName|string|false|none||岗位名称|
|postSort|integer|false|none||岗位排序|
|status|string|false|none||状态（0正常 1停用）|
|flag|boolean|false|none||用户是否存在此岗位标识 默认不存在|
|createBy|string|false|none||创建者|
|createTime|string|false|none||创建时间|
|updateBy|string|false|none||更新者|
|updateTime|string|false|none||更新时间|
|remark|string|false|none||备注|
|params|[Map«Object»](#schemamap%c2%abobject%c2%bb)|false|none||请求参数|

<h2 id="tocS_RegisterBody">RegisterBody</h2>

<a id="schemaregisterbody"></a>
<a id="schema_RegisterBody"></a>
<a id="tocSregisterbody"></a>
<a id="tocsregisterbody"></a>

```json
{
  "username": "string",
  "password": "string",
  "code": "string",
  "uuid": "string"
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|username|string|false|none||用户名|
|password|string|false|none||用户密码|
|code|string|false|none||验证码|
|uuid|string|false|none||唯一标识|

<h2 id="tocS_SysUserRole">SysUserRole</h2>

<a id="schemasysuserrole"></a>
<a id="schema_SysUserRole"></a>
<a id="tocSsysuserrole"></a>
<a id="tocssysuserrole"></a>

```json
{
  "userId": 0,
  "roleId": 0
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|userId|integer|false|none||用户ID|
|roleId|integer|false|none||角色ID|

<h2 id="tocS_SysRole">SysRole</h2>

<a id="schemasysrole"></a>
<a id="schema_SysRole"></a>
<a id="tocSsysrole"></a>
<a id="tocssysrole"></a>

```json
{
  "roleId": 0,
  "roleName": "string",
  "roleKey": "string",
  "roleSort": 0,
  "dataScope": "string",
  "menuCheckStrictly": true,
  "deptCheckStrictly": true,
  "status": "string",
  "delFlag": "string",
  "flag": "false",
  "menuIds": [
    0
  ],
  "deptIds": [
    0
  ],
  "permissions": [
    "string"
  ],
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|roleId|integer|false|none||角色ID|
|roleName|string|false|none||角色名称|
|roleKey|string|false|none||角色权限|
|roleSort|integer|false|none||角色排序|
|dataScope|string|false|none||数据范围（1：所有数据权限；2：自定义数据权限；3：本部门数据权限；4：本部门及以下数据权限；5：仅本人数据权限）|
|menuCheckStrictly|boolean|false|none||菜单树选择项是否关联显示（ 0：父子不互相关联显示 1：父子互相关联显示）|
|deptCheckStrictly|boolean|false|none||部门树选择项是否关联显示（0：父子不互相关联显示 1：父子互相关联显示 ）|
|status|string|false|none||角色状态（0正常 1停用）|
|delFlag|string|false|none||删除标志（0代表存在 2代表删除）|
|flag|boolean|false|none||用户是否存在此角色标识 默认不存在|
|menuIds|[integer]|false|none||菜单组|
|deptIds|[integer]|false|none||部门组（数据权限）|
|permissions|[string]|false|none||角色菜单权限|
|createBy|string|false|none||创建者|
|createTime|string|false|none||创建时间|
|updateBy|string|false|none||更新者|
|updateTime|string|false|none||更新时间|
|remark|string|false|none||备注|
|params|[Map«Object»](#schemamap%c2%abobject%c2%bb)|false|none||请求参数|

<h2 id="tocS_SysUser">SysUser</h2>

<a id="schemasysuser"></a>
<a id="schema_SysUser"></a>
<a id="tocSsysuser"></a>
<a id="tocssysuser"></a>

```json
{
  "userId": 0,
  "deptId": 0,
  "userName": "string",
  "nickName": "string",
  "email": "string",
  "phonenumber": "string",
  "sex": "string",
  "avatar": "string",
  "password": "string",
  "status": "string",
  "delFlag": "string",
  "loginIp": "string",
  "loginDate": "string",
  "dept": {},
  "roles": [
    {
      "roleId": 0,
      "roleName": "string",
      "roleKey": "string",
      "roleSort": 0,
      "dataScope": "string",
      "menuCheckStrictly": true,
      "deptCheckStrictly": true,
      "status": "string",
      "delFlag": "string",
      "flag": "false",
      "menuIds": [
        0
      ],
      "deptIds": [
        0
      ],
      "permissions": [
        "string"
      ],
      "createBy": "string",
      "createTime": "string",
      "updateBy": "string",
      "updateTime": "string",
      "remark": "string",
      "params": {
        "key": {}
      }
    }
  ],
  "roleIds": [
    0
  ],
  "postIds": [
    0
  ],
  "roleId": 0,
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|userId|integer|false|none||用户ID|
|deptId|integer|false|none||部门ID|
|userName|string|false|none||用户账号|
|nickName|string|false|none||用户昵称|
|email|string|false|none||用户邮箱|
|phonenumber|string|false|none||手机号码|
|sex|string|false|none||用户性别|
|avatar|string|false|none||用户头像|
|password|string|false|none||密码|
|status|string|false|none||帐号状态（0正常 1停用）|
|delFlag|string|false|none||删除标志（0代表存在 2代表删除）|
|loginIp|string|false|none||最后登录IP|
|loginDate|string|false|none||最后登录时间|
|dept|object|false|none||部门对象|
|roles|[[SysRole](#schemasysrole)]|false|none||角色对象|
|roleIds|[integer]|false|none||角色组|
|postIds|[integer]|false|none||岗位组|
|roleId|integer|false|none||角色ID|
|createBy|string|false|none||创建者|
|createTime|string|false|none||创建时间|
|updateBy|string|false|none||更新者|
|updateTime|string|false|none||更新时间|
|remark|string|false|none||备注|
|params|[Map«Object»](#schemamap%c2%abobject%c2%bb)|false|none||请求参数|

<h2 id="tocS_SysDept">SysDept</h2>

<a id="schemasysdept"></a>
<a id="schema_SysDept"></a>
<a id="tocSsysdept"></a>
<a id="tocssysdept"></a>

```json
{
  "deptId": 0,
  "parentId": 0,
  "ancestors": "string",
  "deptName": "string",
  "orderNum": 0,
  "leader": "string",
  "phone": "string",
  "email": "string",
  "status": "string",
  "delFlag": "string",
  "parentName": "string",
  "children": "new ArrayList<SysDept>()",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|deptId|integer|false|none||部门ID|
|parentId|integer|false|none||父部门ID|
|ancestors|string|false|none||祖级列表|
|deptName|string|false|none||部门名称|
|orderNum|integer|false|none||显示顺序|
|leader|string|false|none||负责人|
|phone|string|false|none||联系电话|
|email|string|false|none||邮箱|
|status|string|false|none||部门状态:0正常,1停用|
|delFlag|string|false|none||删除标志（0代表存在 2代表删除）|
|parentName|string|false|none||父部门名称|
|children|[object]|false|none||子部门|
|createBy|string|false|none||创建者|
|createTime|string|false|none||创建时间|
|updateBy|string|false|none||更新者|
|updateTime|string|false|none||更新时间|
|remark|string|false|none||备注|
|params|[Map«Object»](#schemamap%c2%abobject%c2%bb)|false|none||请求参数|

<h2 id="tocS_SysDictType">SysDictType</h2>

<a id="schemasysdicttype"></a>
<a id="schema_SysDictType"></a>
<a id="tocSsysdicttype"></a>
<a id="tocssysdicttype"></a>

```json
{
  "dictId": 0,
  "dictName": "string",
  "dictType": "string",
  "status": "string",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|dictId|integer|false|none||字典主键|
|dictName|string|false|none||字典名称|
|dictType|string|false|none||字典类型|
|status|string|false|none||状态（0正常 1停用）|
|createBy|string|false|none||创建者|
|createTime|string|false|none||创建时间|
|updateBy|string|false|none||更新者|
|updateTime|string|false|none||更新时间|
|remark|string|false|none||备注|
|params|[Map«Object»](#schemamap%c2%abobject%c2%bb)|false|none||请求参数|

<h2 id="tocS_SysDictData">SysDictData</h2>

<a id="schemasysdictdata"></a>
<a id="schema_SysDictData"></a>
<a id="tocSsysdictdata"></a>
<a id="tocssysdictdata"></a>

```json
{
  "dictCode": 0,
  "dictSort": 0,
  "dictLabel": "string",
  "dictValue": "string",
  "dictType": "string",
  "cssClass": "string",
  "listClass": "string",
  "isDefault": "string",
  "status": "string",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|dictCode|integer|false|none||字典编码|
|dictSort|integer|false|none||字典排序|
|dictLabel|string|false|none||字典标签|
|dictValue|string|false|none||字典键值|
|dictType|string|false|none||字典类型|
|cssClass|string|false|none||样式属性（其他样式扩展）|
|listClass|string|false|none||表格字典样式|
|isDefault|string|false|none||是否默认（Y是 N否）|
|status|string|false|none||状态（0正常 1停用）|
|createBy|string|false|none||创建者|
|createTime|string|false|none||创建时间|
|updateBy|string|false|none||更新者|
|updateTime|string|false|none||更新时间|
|remark|string|false|none||备注|
|params|[Map«Object»](#schemamap%c2%abobject%c2%bb)|false|none||请求参数|

<h2 id="tocS_AjaxResult">AjaxResult</h2>

<a id="schemaajaxresult"></a>
<a id="schema_AjaxResult"></a>
<a id="tocSajaxresult"></a>
<a id="tocsajaxresult"></a>

```json
{
  "key": {}
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|key|object|false|none||none|

<h2 id="tocS_SysConfig">SysConfig</h2>

<a id="schemasysconfig"></a>
<a id="schema_SysConfig"></a>
<a id="tocSsysconfig"></a>
<a id="tocssysconfig"></a>

```json
{
  "configId": 0,
  "configName": "string",
  "configKey": "string",
  "configValue": "string",
  "configType": "string",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|configId|integer|false|none||参数主键|
|configName|string|false|none||参数名称|
|configKey|string|false|none||参数键名|
|configValue|string|false|none||参数键值|
|configType|string|false|none||系统内置（Y是 N否）|
|createBy|string|false|none||创建者|
|createTime|string|false|none||创建时间|
|updateBy|string|false|none||更新者|
|updateTime|string|false|none||更新时间|
|remark|string|false|none||备注|
|params|[Map«Object»](#schemamap%c2%abobject%c2%bb)|false|none||请求参数|

<h2 id="tocS_SelfVisitors">SelfVisitors</h2>

<a id="schemaselfvisitors"></a>
<a id="schema_SelfVisitors"></a>
<a id="tocSselfvisitors"></a>
<a id="tocsselfvisitors"></a>

```json
{
  "id": 0,
  "cnId": "string",
  "visitorsName": "string",
  "phoneNumber": "string",
  "orderId": 0,
  "ticketId": 0,
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|id|integer|false|none||ID|
|cnId|string|false|none||身份证号|
|visitorsName|string|false|none||游客姓名|
|phoneNumber|string|false|none||手机号|
|orderId|integer|false|none||订单号|
|ticketId|integer|false|none||门票号|
|createBy|string|false|none||创建者|
|createTime|string|false|none||创建时间|
|updateBy|string|false|none||更新者|
|updateTime|string|false|none||更新时间|
|remark|string|false|none||备注|
|params|[Map«Object»](#schemamap%c2%abobject%c2%bb)|false|none||请求参数|

<h2 id="tocS_SelfTicketServices">SelfTicketServices</h2>

<a id="schemaselfticketservices"></a>
<a id="schema_SelfTicketServices"></a>
<a id="tocSselfticketservices"></a>
<a id="tocsselfticketservices"></a>

```json
{
  "id": 0,
  "ticketId": 0,
  "cnId": "string",
  "scheduledDate": "string",
  "visitorInTime": "string",
  "visitorOutTime": "string",
  "stateVisit": "string",
  "typeTicket": "string",
  "visitorsName": "string",
  "phoneNumber": "string",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|id|integer|false|none||ID|
|ticketId|integer|false|none||门票号|
|cnId|string|false|none||身份证号|
|scheduledDate|string|false|none||预约日期|
|visitorInTime|string|false|none||入园时间|
|visitorOutTime|string|false|none||出园时间|
|stateVisit|string|false|none||参观状态|
|typeTicket|string|false|none||门票类型|
|visitorsName|string|false|none||none|
|phoneNumber|string|false|none||none|
|createBy|string|false|none||创建者|
|createTime|string|false|none||创建时间|
|updateBy|string|false|none||更新者|
|updateTime|string|false|none||更新时间|
|remark|string|false|none||备注|
|params|[Map«Object»](#schemamap%c2%abobject%c2%bb)|false|none||请求参数|

<h2 id="tocS_SelfTicketPrices">SelfTicketPrices</h2>

<a id="schemaselfticketprices"></a>
<a id="schema_SelfTicketPrices"></a>
<a id="tocSselfticketprices"></a>
<a id="tocsselfticketprices"></a>

```json
{
  "id": 0,
  "typeTicket": "string",
  "priceTicket": "string",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|id|integer|false|none||ID|
|typeTicket|string|false|none||门票类型|
|priceTicket|string|false|none||门票价格|
|createBy|string|false|none||创建者|
|createTime|string|false|none||创建时间|
|updateBy|string|false|none||更新者|
|updateTime|string|false|none||更新时间|
|remark|string|false|none||备注|
|params|[Map«Object»](#schemamap%c2%abobject%c2%bb)|false|none||请求参数|

<h2 id="tocS_SelfHotelRooms">SelfHotelRooms</h2>

<a id="schemaselfhotelrooms"></a>
<a id="schema_SelfHotelRooms"></a>
<a id="tocSselfhotelrooms"></a>
<a id="tocsselfhotelrooms"></a>

```json
{
  "id": 0,
  "roomId": 0,
  "typeRoom": "string",
  "orderId": 0,
  "stateRoom": "string",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|id|integer|false|none||ID|
|roomId|integer|false|none||房间号|
|typeRoom|string|false|none||房间类型|
|orderId|integer|false|none||订单号|
|stateRoom|string|false|none||入住情况|
|createBy|string|false|none||创建者|
|createTime|string|false|none||创建时间|
|updateBy|string|false|none||更新者|
|updateTime|string|false|none||更新时间|
|remark|string|false|none||备注|
|params|[Map«Object»](#schemamap%c2%abobject%c2%bb)|false|none||请求参数|

<h2 id="tocS_SelfHotelPrices">SelfHotelPrices</h2>

<a id="schemaselfhotelprices"></a>
<a id="schema_SelfHotelPrices"></a>
<a id="tocSselfhotelprices"></a>
<a id="tocsselfhotelprices"></a>

```json
{
  "id": 0,
  "typeRoom": "string",
  "priceRoom": "string",
  "totalRooms": 0,
  "freeRooms": 0,
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|id|integer|false|none||ID|
|typeRoom|string|false|none||房间类型|
|priceRoom|string|false|none||房间价格|
|totalRooms|integer|false|none||房间总数|
|freeRooms|integer|false|none||空余房数|
|createBy|string|false|none||创建者|
|createTime|string|false|none||创建时间|
|updateBy|string|false|none||更新者|
|updateTime|string|false|none||更新时间|
|remark|string|false|none||备注|
|params|[Map«Object»](#schemamap%c2%abobject%c2%bb)|false|none||请求参数|

<h2 id="tocS_SelfEmergencyComplete">SelfEmergencyComplete</h2>

<a id="schemaselfemergencycomplete"></a>
<a id="schema_SelfEmergencyComplete"></a>
<a id="tocSselfemergencycomplete"></a>
<a id="tocsselfemergencycomplete"></a>

```json
{
  "id": 0,
  "location": "string",
  "emergenciesMessage": "string",
  "department": "string",
  "stateEmergencies": "string",
  "emergenciesLevel": "string",
  "emergenciesTime": "string",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|id|integer|false|none||ID|
|location|string|false|none||事件地点|
|emergenciesMessage|string|false|none||事件信息|
|department|string|false|none||处理部门|
|stateEmergencies|string|false|none||处理状态|
|emergenciesLevel|string|false|none||紧急程度|
|emergenciesTime|string|false|none||发生日期|
|createBy|string|false|none||创建者|
|createTime|string|false|none||创建时间|
|updateBy|string|false|none||更新者|
|updateTime|string|false|none||更新时间|
|remark|string|false|none||备注|
|params|[Map«Object»](#schemamap%c2%abobject%c2%bb)|false|none||请求参数|

<h2 id="tocS_SelfEmergencyAdd">SelfEmergencyAdd</h2>

<a id="schemaselfemergencyadd"></a>
<a id="schema_SelfEmergencyAdd"></a>
<a id="tocSselfemergencyadd"></a>
<a id="tocsselfemergencyadd"></a>

```json
{
  "id": 0,
  "location": "string",
  "emergenciesMessage": "string",
  "department": "string",
  "stateEmergencies": "string",
  "emergenciesLevel": "string",
  "emergenciesTime": "string",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|id|integer|false|none||ID|
|location|string|false|none||事件地点|
|emergenciesMessage|string|false|none||事件信息|
|department|string|false|none||处理部门|
|stateEmergencies|string|false|none||处理状态|
|emergenciesLevel|string|false|none||紧急程度|
|emergenciesTime|string|false|none||发生日期|
|createBy|string|false|none||创建者|
|createTime|string|false|none||创建时间|
|updateBy|string|false|none||更新者|
|updateTime|string|false|none||更新时间|
|remark|string|false|none||备注|
|params|[Map«Object»](#schemamap%c2%abobject%c2%bb)|false|none||请求参数|

<h2 id="tocS_SelfEmergencies">SelfEmergencies</h2>

<a id="schemaselfemergencies"></a>
<a id="schema_SelfEmergencies"></a>
<a id="tocSselfemergencies"></a>
<a id="tocsselfemergencies"></a>

```json
{
  "id": 0,
  "location": "string",
  "emergenciesMessage": "string",
  "department": "string",
  "stateEmergencies": "string",
  "emergenciesLevel": "string",
  "emergenciesTime": "string",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|id|integer|false|none||ID|
|location|string|false|none||事件地点|
|emergenciesMessage|string|false|none||事件信息|
|department|string|false|none||处理部门|
|stateEmergencies|string|false|none||处理状态|
|emergenciesLevel|string|false|none||紧急程度|
|emergenciesTime|string|false|none||发生日期|
|createBy|string|false|none||创建者|
|createTime|string|false|none||创建时间|
|updateBy|string|false|none||更新者|
|updateTime|string|false|none||更新时间|
|remark|string|false|none||备注|
|params|[Map«Object»](#schemamap%c2%abobject%c2%bb)|false|none||请求参数|

<h2 id="tocS_SelfComplaints">SelfComplaints</h2>

<a id="schemaselfcomplaints"></a>
<a id="schema_SelfComplaints"></a>
<a id="tocSselfcomplaints"></a>
<a id="tocsselfcomplaints"></a>

```json
{
  "id": 0,
  "complaintsId": 0,
  "complaintsMessage": "string",
  "complaintsDate": "string",
  "stateComplaints": "string",
  "complaintsReplyDate": "string",
  "complaintsReplyMessage": "string",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|id|integer|false|none||ID|
|complaintsId|integer|false|none||投诉ID|
|complaintsMessage|string|false|none||投诉信息|
|complaintsDate|string|false|none||投诉日期|
|stateComplaints|string|false|none||处理状态|
|complaintsReplyDate|string|false|none||回复日期|
|complaintsReplyMessage|string|false|none||回复信息|
|createBy|string|false|none||创建者|
|createTime|string|false|none||创建时间|
|updateBy|string|false|none||更新者|
|updateTime|string|false|none||更新时间|
|remark|string|false|none||备注|
|params|[Map«Object»](#schemamap%c2%abobject%c2%bb)|false|none||请求参数|

<h2 id="tocS_SelfComplaintComplete">SelfComplaintComplete</h2>

<a id="schemaselfcomplaintcomplete"></a>
<a id="schema_SelfComplaintComplete"></a>
<a id="tocSselfcomplaintcomplete"></a>
<a id="tocsselfcomplaintcomplete"></a>

```json
{
  "id": 0,
  "complaintsId": 0,
  "complaintsMessage": "string",
  "complaintsDate": "string",
  "stateComplaints": "string",
  "complaintsReplyDate": "string",
  "complaintsReplyMessage": "string",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|id|integer|false|none||ID|
|complaintsId|integer|false|none||投诉ID|
|complaintsMessage|string|false|none||投诉信息|
|complaintsDate|string|false|none||投诉日期|
|stateComplaints|string|false|none||处理状态|
|complaintsReplyDate|string|false|none||回复日期|
|complaintsReplyMessage|string|false|none||回复信息|
|createBy|string|false|none||创建者|
|createTime|string|false|none||创建时间|
|updateBy|string|false|none||更新者|
|updateTime|string|false|none||更新时间|
|remark|string|false|none||备注|
|params|[Map«Object»](#schemamap%c2%abobject%c2%bb)|false|none||请求参数|

<h2 id="tocS_SelfComplaintAdd">SelfComplaintAdd</h2>

<a id="schemaselfcomplaintadd"></a>
<a id="schema_SelfComplaintAdd"></a>
<a id="tocSselfcomplaintadd"></a>
<a id="tocsselfcomplaintadd"></a>

```json
{
  "id": 0,
  "complaintsId": 0,
  "complaintsMessage": "string",
  "complaintsDate": "string",
  "stateComplaints": "string",
  "complaintsReplyDate": "string",
  "complaintsReplyMessage": "string",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|id|integer|false|none||ID|
|complaintsId|integer|false|none||投诉ID|
|complaintsMessage|string|false|none||投诉信息|
|complaintsDate|string|false|none||投诉日期|
|stateComplaints|string|false|none||处理状态|
|complaintsReplyDate|string|false|none||回复日期|
|complaintsReplyMessage|string|false|none||回复信息|
|createBy|string|false|none||创建者|
|createTime|string|false|none||创建时间|
|updateBy|string|false|none||更新者|
|updateTime|string|false|none||更新时间|
|remark|string|false|none||备注|
|params|[Map«Object»](#schemamap%c2%abobject%c2%bb)|false|none||请求参数|

<h2 id="tocS_SelfAttendances">SelfAttendances</h2>

<a id="schemaselfattendances"></a>
<a id="schema_SelfAttendances"></a>
<a id="tocSselfattendances"></a>
<a id="tocsselfattendances"></a>

```json
{
  "id": 0,
  "employeeId": "string",
  "employeeName": "string",
  "stateWorking": "string",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|id|integer|false|none||ID|
|employeeId|string|false|none||员工ID|
|employeeName|string|false|none||员工姓名|
|stateWorking|string|false|none||考勤状态|
|createBy|string|false|none||创建者|
|createTime|string|false|none||创建时间|
|updateBy|string|false|none||更新者|
|updateTime|string|false|none||更新时间|
|remark|string|false|none||备注|
|params|[Map«Object»](#schemamap%c2%abobject%c2%bb)|false|none||请求参数|

<h2 id="tocS_SelfHotelReservation">SelfHotelReservation</h2>

<a id="schemaselfhotelreservation"></a>
<a id="schema_SelfHotelReservation"></a>
<a id="tocSselfhotelreservation"></a>
<a id="tocsselfhotelreservation"></a>

```json
{
  "id": 0,
  "orderId": 0,
  "cnId": "string",
  "phoneNum": "string",
  "name": "string",
  "startDate": "string",
  "endDate": "string",
  "type": "string",
  "roomNum": 0,
  "state": "string",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|id|integer|false|none||none|
|orderId|integer|false|none||订单号|
|cnId|string|false|none||身份证号|
|phoneNum|string|false|none||电话号码|
|name|string|false|none||姓名|
|startDate|string|false|none||开始日期|
|endDate|string|false|none||截至日期|
|type|string|false|none||房价类型|
|roomNum|integer|false|none||房间号|
|state|string|false|none||房间状态|
|createBy|string|false|none||创建者|
|createTime|string|false|none||创建时间|
|updateBy|string|false|none||更新者|
|updateTime|string|false|none||更新时间|
|remark|string|false|none||备注|
|params|[Map«Object»](#schemamap%c2%abobject%c2%bb)|false|none||请求参数|

<h2 id="tocS_SelfHotelOrders">SelfHotelOrders</h2>

<a id="schemaselfhotelorders"></a>
<a id="schema_SelfHotelOrders"></a>
<a id="tocSselfhotelorders"></a>
<a id="tocsselfhotelorders"></a>

```json
{
  "id": 0,
  "orderId": 0,
  "cnId": "string",
  "phoneNum": "string",
  "name": "string",
  "startDate": "string",
  "endDate": "string",
  "type": "string",
  "roomNum": 0,
  "state": "string",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|id|integer|false|none||none|
|orderId|integer|false|none||订单号|
|cnId|string|false|none||身份证号|
|phoneNum|string|false|none||电话号码|
|name|string|false|none||姓名|
|startDate|string|false|none||开始日期|
|endDate|string|false|none||截至日期|
|type|string|false|none||房价类型|
|roomNum|integer|false|none||房间号|
|state|string|false|none||房间状态|
|createBy|string|false|none||创建者|
|createTime|string|false|none||创建时间|
|updateBy|string|false|none||更新者|
|updateTime|string|false|none||更新时间|
|remark|string|false|none||备注|
|params|[Map«Object»](#schemamap%c2%abobject%c2%bb)|false|none||请求参数|

<h2 id="tocS_SelfParkingCars">SelfParkingCars</h2>

<a id="schemaselfparkingcars"></a>
<a id="schema_SelfParkingCars"></a>
<a id="tocSselfparkingcars"></a>
<a id="tocsselfparkingcars"></a>

```json
{
  "id": 0,
  "carId": "string",
  "carInTime": "string",
  "carOutTime": "string",
  "parkingCost": "string",
  "stateParking": "string",
  "createBy": "string",
  "createTime": "string",
  "updateBy": "string",
  "updateTime": "string",
  "remark": "string",
  "params": {
    "key": {}
  }
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|id|integer|false|none||ID|
|carId|string|false|none||车牌号|
|carInTime|string|false|none||入场时间|
|carOutTime|string|false|none||出场时间|
|parkingCost|string|false|none||停车费|
|stateParking|string|false|none||停车状态|
|createBy|string|false|none||创建者|
|createTime|string|false|none||创建时间|
|updateBy|string|false|none||更新者|
|updateTime|string|false|none||更新时间|
|remark|string|false|none||备注|
|params|[Map«Object»](#schemamap%c2%abobject%c2%bb)|false|none||请求参数|

