import request from '@/utils/request'

// 查询酒店价格列表
export function listHotel_prices(query) {
  return request({
    url: '/system/hotel_prices/list',
    method: 'get',
    params: query
  })
}

// 查询酒店价格详细
export function getHotel_prices(id) {
  return request({
    url: '/system/hotel_prices/' + id,
    method: 'get'
  })
}

// 新增酒店价格
export function addHotel_prices(data) {
  return request({
    url: '/system/hotel_prices',
    method: 'post',
    data: data
  })
}

// 修改酒店价格
export function updateHotel_prices(data) {
  return request({
    url: '/system/hotel_prices',
    method: 'put',
    data: data
  })
}

// 删除酒店价格
export function delHotel_prices(id) {
  return request({
    url: '/system/hotel_prices/' + id,
    method: 'delete'
  })
}
