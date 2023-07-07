import request from '@/utils/request'

// 注册方法
export function listHotel_prices2() {
  return request({
    url: '/hotel/checkin/rooms/',
    method: 'get',
  })
}

// 查询当日票务
export function getTodayTickets() {
  return request({
    url: '/system/ticket_services/getTodayTickets',
    method: 'get',
  })
}

// 查询当日事件
export function getTodayEmergencies() {
  return request({
    url: '/system/emergencies/getTodayEmergencies',
    method: 'get',
  })
}

// 查询当日投诉
export function getTodayComplaints() {
  return request({
    url: '/system/complaints/getTodayComplaints',
    method: 'get',
  })
}
