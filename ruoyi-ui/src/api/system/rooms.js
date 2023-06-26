import request from '@/utils/request'

// 查询房间列表
export function listRooms(query) {
  return request({
    url: '/system/rooms/list',
    method: 'get',
    params: query
  })
}

// 查询房间详细
export function getRooms(id) {
  return request({
    url: '/system/rooms/' + id,
    method: 'get'
  })
}

// 新增房间
export function addRooms(data) {
  return request({
    url: '/system/rooms',
    method: 'post',
    data: data
  })
}

// 修改房间
export function updateRooms(data) {
  return request({
    url: '/system/rooms',
    method: 'put',
    data: data
  })
}

// 删除房间
export function delRooms(id) {
  return request({
    url: '/system/rooms/' + id,
    method: 'delete'
  })
}
