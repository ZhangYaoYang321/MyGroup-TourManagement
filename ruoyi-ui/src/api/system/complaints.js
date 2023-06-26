import request from '@/utils/request'

// 查询投诉列表
export function listComplaints(query) {
  return request({
    url: '/system/complaints/list',
    method: 'get',
    params: query
  })
}

// 查询投诉详细
export function getComplaints(id) {
  return request({
    url: '/system/complaints/' + id,
    method: 'get'
  })
}

// 新增投诉
export function addComplaints(data) {
  return request({
    url: '/system/complaints',
    method: 'post',
    data: data
  })
}

// 修改投诉
export function updateComplaints(data) {
  return request({
    url: '/system/complaints',
    method: 'put',
    data: data
  })
}

// 删除投诉
export function delComplaints(id) {
  return request({
    url: '/system/complaints/' + id,
    method: 'delete'
  })
}
