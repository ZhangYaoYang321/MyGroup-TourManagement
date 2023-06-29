import request from '@/utils/request'

// 新增投诉
export function addComplaint_add(data) {
  return request({
    url: '/system/complaint_add',
    method: 'post',
    data: data
  })
}
