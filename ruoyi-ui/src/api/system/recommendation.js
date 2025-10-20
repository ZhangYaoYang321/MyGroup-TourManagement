import request from '@/utils/request'

// 获取景点推荐列表
export function getScenicRecommendations(params) {
  return request({
    url: '/scenic/recommendation',
    method: 'get',
    params: params
  })
}
// 查询推荐列表（支持多类型筛选）
export function listRecommendation(query) {
  return request({
    url: '/scenic/recommendation/list',
    method: 'get',
    params: query
  })
}

// 查询推荐详情
export function getRecommendation(id) {
  return request({
    url: '/scenic/recommendation/' + id,
    method: 'get'
  })
}

// （可选）新增推荐信息（用于后台管理）
export function addRecommendation(data) {
  return request({
    url: '/scenic/recommendation',
    method: 'post',
    data: data
  })
}

// （可选）修改推荐信息（用于后台管理）
export function updateRecommendation(data) {
  return request({
    url: '/scenic/recommendation',
    method: 'put',
    data: data
  })
}

// （可选）删除推荐信息（用于后台管理）
export function delRecommendation(id) {
  return request({
    url: '/scenic/recommendation/' + id,
    method: 'delete'
  })
}