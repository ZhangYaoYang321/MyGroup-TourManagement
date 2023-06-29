import request from '@/utils/request'

// 查询票务列表
export function listTicket_services(query) {
  return request({
    url: '/system/ticket_services/list',
    method: 'get',
    params: query
  })
}

// 查询票务详细
export function getTicket_services(id) {
  return request({
    url: '/system/ticket_services/' + id,
    method: 'get'
  })
}

// 新增票务
export function addTicket_services(data) {
  return request({
    url: '/system/ticket_services',
    method: 'post',
    data: data
  })
}

// 修改票务
export function updateTicket_services(data) {
  return request({
    url: '/system/ticket_services',
    method: 'put',
    data: data
  })
}

// 删除票务
export function delTicket_services(id) {
  return request({
    url: '/system/ticket_services/' + id,
    method: 'delete'
  })
}
