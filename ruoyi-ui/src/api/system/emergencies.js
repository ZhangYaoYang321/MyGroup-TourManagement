import request from '@/utils/request'

// 查询事件列表
export function listEmergencies(query) {
  return request({
    url: '/system/emergencies/list',
    method: 'get',
    params: query
  })
}

// 查询事件详细
export function getEmergencies(id) {
  return request({
    url: '/system/emergencies/' + id,
    method: 'get'
  })
}

// 新增事件
export function addEmergencies(data) {
  return request({
    url: '/system/emergencies',
    method: 'post',
    data: data
  })
}

// 修改事件
export function updateEmergencies(data) {
  return request({
    url: '/system/emergencies',
    method: 'put',
    data: data
  })
}

// 删除事件
export function delEmergencies(id) {
  return request({
    url: '/system/emergencies/' + id,
    method: 'delete'
  })
}
