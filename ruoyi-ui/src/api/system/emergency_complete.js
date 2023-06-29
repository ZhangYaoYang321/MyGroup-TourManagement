import request from '@/utils/request'

// 查询事件处理列表
export function listEmergency_complete(query) {
  return request({
    url: '/system/emergency_complete/list',
    method: 'get',
    params: query
  })
}

// 查询事件处理详细
export function getEmergency_complete(id) {
  return request({
    url: '/system/emergency_complete/' + id,
    method: 'get'
  })
}

// 新增事件处理
export function addEmergency_complete(data) {
  return request({
    url: '/system/emergency_complete',
    method: 'post',
    data: data
  })
}

// 修改事件处理
export function updateEmergency_complete(data) {
  return request({
    url: '/system/emergency_complete',
    method: 'put',
    data: data
  })
}

// 删除事件处理
export function delEmergency_complete(id) {
  return request({
    url: '/system/emergency_complete/' + id,
    method: 'delete'
  })
}
