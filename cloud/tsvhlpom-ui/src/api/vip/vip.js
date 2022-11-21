// 获取用户详细信息
import request from '@/utils/request'

export function getList(query) {
  return request({
    url: '/vip/vip_main/getVIPList',
    method: 'get',
    params: query
  })
}
export function getVIP(pkId){
  return request({
    url: '/vip/vip_main/'+pkId,
    method: 'get'
  })
}
export function deleteVIP(pkIds){
  return request({
    url: '/vip/vip_main/delete/'+pkIds,
    method:'get'
  })
}
export function updateVip(param){
  return request({
    url: '/vip/vip_main/update',
    method: 'post',
    data: param
  })
}
export function saveVip(param){
  return request({
    url: '/vip/vip_main/save',
    method: 'post',
    data: param
  })
}
export function downloadVIPTemp(param){
  return request({
    url: '/vip/vip_main/importTemplate',
    method: 'post',
    data: param
  })
}
/*export function exportVip() {
  return request({
    url: '/vip/vip_main/exportVip',
    method: 'get'
  })
}*/
