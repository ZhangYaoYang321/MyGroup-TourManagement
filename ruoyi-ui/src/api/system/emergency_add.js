import request from '@/utils/request'

// 查询事件列表
export function listEmergency_add(query) {
  return request({
    url: '/system/emergency_add/list',
    method: 'get',
    params: query
  })
}

// 查询事件详细
export function getEmergency_add(id) {
  return request({
    url: '/system/emergency_add/' + id,
    method: 'get'
  })
}

// 新增事件
export function addEmergency_add(data) {
  return request({
    url: '/system/emergency_add',
    method: 'post',
    data: data
  })
}

// 修改事件
export function updateEmergency_add(data) {
  return request({
    url: '/system/emergency_add',
    method: 'put',
    data: data
  })
}

// 删除事件
export function delEmergency_add(id) {
  return request({
    url: '/system/emergency_add/' + id,
    method: 'delete'
  })
}
