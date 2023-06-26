import request from '@/utils/request'

// 查询游客列表
export function listVisitors(query) {
  return request({
    url: '/system/visitors/list',
    method: 'get',
    params: query
  })
}

// 查询游客详细
export function getVisitors(id) {
  return request({
    url: '/system/visitors/' + id,
    method: 'get'
  })
}

// 新增游客
export function addVisitors(data) {
  return request({
    url: '/system/visitors',
    method: 'post',
    data: data
  })
}

// 修改游客
export function updateVisitors(data) {
  return request({
    url: '/system/visitors',
    method: 'put',
    data: data
  })
}

// 删除游客
export function delVisitors(id) {
  return request({
    url: '/system/visitors/' + id,
    method: 'delete'
  })
}
