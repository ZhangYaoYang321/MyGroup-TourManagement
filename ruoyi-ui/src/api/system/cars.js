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
