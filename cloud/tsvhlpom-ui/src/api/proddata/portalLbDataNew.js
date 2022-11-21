import request from '@/utils/request'

export  function getPortalLbDataNewList(query){
  return request({
    url: '/proddata/portalLbDataNew/getPortalLbDataNewList',
    method: 'get',
    params: query
  })
}
export function getPortalLbDataNew(param){
  return request({
    url: '/proddata/portalLbDataNew/getPortalLbDataNew/',
    method: 'post',
    data: param
  })
}
export function updatePortalLbDataNew(param){
  return request({
    url: '/proddata/portalLbDataNew/update',
    method: 'post',
    data: param
  })
}
export function savePortalLbDataNew(param){
  return request({
    url: '/proddata/portalLbDataNew/save',
    method: 'post',
    data: param
  })
}
export function deletePortalLbDataNew(param){
  return request({
    url: '/proddata/portalLbDataNew/delete',
    method:'post',
    data: param
  })
}
