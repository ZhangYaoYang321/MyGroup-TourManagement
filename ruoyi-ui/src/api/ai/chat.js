import request from '@/utils/request'

// 发送AI问答请求
export function sendAiQuestion(data) {
  return request({
    url: '/ai/chat',
    method: 'post',
    data: data
  })
}