import request from '@/utils/request'

export function getWebOthSalesEmailList(query) {
  return request({
    url: '/prod26/webOthSalesEmail/getWebOthSalesEmailList',
    method: 'get',
    params: query
  })
}


/** 修改续保清单邮箱接收人part start*/
export function updateWebOthSalesEmail(query) {
  return request({
    url: '/prod26/webOthSalesEmail/updateEmail/',
    method: 'get',
    params: query
  })
}
/** 修改续保清单邮箱接收人part end*/
