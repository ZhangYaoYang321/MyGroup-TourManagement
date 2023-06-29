import request from '@/utils/request'

// 查询投诉列表
export function listComplaint_complete(query) {
  return request({
    url: '/system/complaint_complete/list',
    method: 'get',
    params: query
  })
}

// 查询投诉详细
export function getComplaint_complete(id) {
  return request({
    url: '/system/complaint_complete/' + id,
    method: 'get'
  })
}

// 新增投诉
export function addComplaint_complete(data) {
  return request({
    url: '/system/complaint_complete',
    method: 'post',
    data: data
  })
}

// 修改投诉
export function updateComplaint_complete(data) {
  return request({
    url: '/system/complaint_complete',
    method: 'put',
    data: data
  })
}

// 删除投诉
export function delComplaint_complete(id) {
  return request({
    url: '/system/complaint_complete/' + id,
    method: 'delete'
  })
}
