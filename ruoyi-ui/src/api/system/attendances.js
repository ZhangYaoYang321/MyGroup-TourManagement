import request from '@/utils/request'

// 查询考勤信息列表
export function listAttendances(query) {
  return request({
    url: '/system/attendances/list',
    method: 'get',
    params: query
  })
}

export function listCurAttendances(query) {
  return request({
    url: '/system/attendances/listcur',
    method: 'get',
    params: query
  })
}

// 查询考勤信息详细
export function getAttendances(id) {
  return request({
    url: '/system/attendances/' + id,
    method: 'get'
  })
}

// 新增考勤信息
export function addAttendances(data) {
  return request({
    url: '/system/attendances',
    method: 'post',
    data: data
  })
}

// 修改考勤信息
export function updateAttendances(data) {
  return request({
    url: '/system/attendances',
    method: 'put',
    data: data
  })
}

// 删除考勤信息
export function delAttendances(id) {
  return request({
    url: '/system/attendances/' + id,
    method: 'delete'
  })
}

export function resetKQAttendances(id) {
  return request({
    url: '/system/attendances/resetKQAttendances/' + id,
    method: 'delete'
  })
}
