import request from '@/utils/request'

// 注册方法
export function listHotel_prices2() {
  console.log("aaaaaaaaaaaaaaa")
  return request({
    url: '/hotel/checkin/rooms/',
    method: 'get',
  })
}
