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
