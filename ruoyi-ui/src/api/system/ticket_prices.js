import request from '@/utils/request'

// 查询票价列表
export function listTicket_prices(query) {
  return request({
    url: '/system/ticket_prices/list',
    method: 'get',
    params: query
  })
}

// 查询票价详细
export function getTicket_prices(id) {
  return request({
    url: '/system/ticket_prices/' + id,
    method: 'get'
  })
}

// 新增票价
export function addTicket_prices(data) {
  return request({
    url: '/system/ticket_prices',
    method: 'post',
    data: data
  })
}

// 修改票价
export function updateTicket_prices(data) {
  return request({
    url: '/system/ticket_prices',
    method: 'put',
    data: data
  })
}

// 删除票价
export function delTicket_prices(id) {
  return request({
    url: '/system/ticket_prices/' + id,
    method: 'delete'
  })
}
