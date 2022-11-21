import request from '@/utils/request'

export function getWebOthManagerEmailList(query) {
  return request({
    url: '/prod26/webOthManagerEmail/getWebOthManagerEmailList',
    method: 'get',
    params: query
  })
}


/** 修改续保清单邮箱接收人part start*/
export function updateWebOthManagerEmail(query) {
  return request({
    url: '/prod26/webOthManagerEmail/updateEmail/',
    method: 'get',
    params: query
  })
}
/** 修改续保清单邮箱接收人part end*/
