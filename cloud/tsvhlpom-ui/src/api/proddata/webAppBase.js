import request from '@/utils/request'

export  function getWebAppBaseList(query){
  return request({
    url: '/proddata/webAppBase/getWebAppBaseList',
    method: 'get',
    params: query
  })
}
export function getWebAppBase(c_ply_no){
  return request({
    url: '/proddata/webAppBase/getWebAppBase/'+c_ply_no,
    method: 'get'
  })
}
export function updateWebAppBase(param){
  return request({
    url: '/proddata/webAppBase/update',
    method: 'post',
    data: param
  })
}
/**修改操作员代码part start*/
export function getWebAppBaseWithOprCde(c_app_no){
  return request({
    url: '/proddata/webAppBase/getAppBaseWithOpeCde/'+c_app_no,
    method: 'get'
  })
}
export function updateOprCde(c_app_no){
  return request({
    url: '/proddata/webAppBase/updateOprCde/'+c_app_no,
    method: 'get'
  })
}
/**修改操作员代码part end*/
