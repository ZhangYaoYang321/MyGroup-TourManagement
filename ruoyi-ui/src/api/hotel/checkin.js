import request from '@/utils/request'
// 查询酒店订单列表
export function listOrders(query) {
  return request({
    url: '/hotel/checkin/list',
    method: 'get',
    params: query
  })
}

export function checkIn(id) {
  return request({
    url: '/hotel/checkin/'+ id,
    method: 'delete',
  })
}
