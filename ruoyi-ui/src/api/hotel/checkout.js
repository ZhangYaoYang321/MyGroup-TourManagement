import request from '@/utils/request'
// 查询酒店订单列表
export function listOrders(query) {
  return request({
    url: '/hotel/checkout/list',
    method: 'get',
    params: query
  })
}

export function checkOut(id) {
  return request({
    url: '/hotel/checkout/'+ id,
    method: 'delete',
  })
}
