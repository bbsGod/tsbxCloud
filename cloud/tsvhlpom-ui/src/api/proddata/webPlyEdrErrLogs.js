// 获取用户详细信息
import request from '@/utils/request'

export function getList(query) {
  return request({
    url: '/proddata/webPlyEdrErrLogs/getWebPlyEdrErrLogsList',
    method: 'get',
    params: query
  })
}
export function getWebPlyEdrErrLogs(pkId){
  return request({
    url: '/proddata/webPlyEdrErrLogs/'+pkId,
    method: 'get'
  })
}
export function deleteWebPlyEdrErrLogs(pkIds){
  return request({
    url: '/proddata/webPlyEdrErrLogs/delete/'+pkIds,
    method:'get'
  })
}
export function updateWebPlyEdrErrLogs(param){
  return request({
    url: '/proddata/webPlyEdrErrLogs/update',
    method: 'post',
    data: param
  })
}
export function saveWebPlyEdrErrLogs(param){
  return request({
    url: '/proddata/webPlyEdrErrLogs/save',
    method: 'post',
    data: param
  })
}
export function downloadWebPlyEdrErrLogs(param){
  return request({
    url: '/proddata/webPlyEdrErrLogs/importTemplate',
    method: 'post',
    data: param
  })
}
/*export function exportVip() {
  return request({
    url: '/proddata/webPlyEdrErrLogs/exportVip',
    method: 'get'
  })
}*/
