import request from '@/utils/request'


// 查询酒店订单列表
export function listOrders(query) {
  return request({
    url: '/hotel/reservation/list',
    method: 'get',
    params: query
  })
}
// 查询酒店房间列表
export function listRooms(date) {
  console.log("11111111111111111111111")
  return request({
    url: '/hotel/reservation/1/'+date,
    method: 'get',
  })
}
export function addOrders(data) {
  return request({
    url: '/hotel/reservation',
    method: 'post',
    data: data
  })
}
export function updateOrders(data) {
  return request({
    url: '/hotel/reservation',
    method: 'put',
    data: data
  })
}
// 查询酒店订单详细
export function getOrders(id) {
  return request({
    url: '/hotel/reservation/' + id,
    method: 'get'
  })
}
// 删除酒店订单
export function delOrders(id) {
  return request({
    url: '/hotel/reservation/' + id,
    method: 'delete'
  })
}
