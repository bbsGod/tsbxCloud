import request from "@/utils/request";

export  function getList(query){
  return request({
    url: '/proddata/webAppVhl/getList',
    method: 'get',
    params: query
  })
}
export function getAppVhl(c_app_no){
  return request({
    url: '/proddata/webAppVhl/getAppVhl/'+c_app_no,
    method: 'get'
  })
}
export function update(param){
  return request({
    url: '/proddata/webAppVhl/update',
    method: 'post',
    data: param
  })
}
export function updatePrint(param){
  return request({
    url: '/proddata/webAppVhl/updatePrint',
    method: 'post',
    data: param
  })
}
