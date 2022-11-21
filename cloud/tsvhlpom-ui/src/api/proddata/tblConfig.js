import request from '@/utils/request'

export  function getTblConfigList(query){
  return request({
    url: '/proddata/tblConfig/getTblConfigList',
    method: 'get',
    params: query
  })
}
export function getTblConfig(c_pk_id){
  return request({
    url: '/proddata/tblConfig/getTblConfig/'+c_pk_id,
    method: 'get'
  })
}
export function updateTblConfig(param){
  return request({
    url: '/proddata/tblConfig/update',
    method: 'post',
    data: param
  })
}
export function saveTblConfig(param){
  return request({
    url: '/proddata/tblConfig/save',
    method: 'post',
    data: param
  })
}
export function deleteTblConfig(c_pk_ids){
  return request({
    url: '/proddata/tblConfig/delete/'+c_pk_ids,
    method:'get'
  })
}
