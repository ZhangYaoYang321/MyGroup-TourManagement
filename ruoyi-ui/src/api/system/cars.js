import request from '@/utils/request'

// 查询车辆列表
export function listCars(query) {
  return request({
    url: '/system/cars/list',
    method: 'get',
    params: query
  })
}

// 查询车辆详细
export function getCars(id) {
  return request({
    url: '/system/cars/' + id,
    method: 'get'
  })
}

// 新增车辆
export function addCars(data) {
  return request({
    url: '/system/cars',
    method: 'post',
    data: data
  })
}

// 修改车辆
export function updateCars(data) {
  return request({
    url: '/system/cars',
    method: 'put',
    data: data
  })
}

// 删除车辆
export function delCars(id) {
  return request({
    url: '/system/cars/' + id,
    method: 'delete'
  })
}

// 车辆进场
export function parkingCars(carIdKey) {
  return request({
    url: '/system/cars/parkingCars/' + carIdKey,
    method: 'get'
  })
}

// 车辆出场
export function leavingCars(carIdKey) {
  return request({
    url: '/system/cars/leavingCars/' + carIdKey,
    method: 'get'
  })
}

// 查询车辆信息
export function searchCars(id) {
  return request({
    url: '/system/cars/searchCars/' + id,
    method: 'get'
  })
}

// 获取停车场车辆数
export function getParkingCount() {
  return request({
    url: '/system/cars/getParkingCount',
    method: 'get',
  })
}
