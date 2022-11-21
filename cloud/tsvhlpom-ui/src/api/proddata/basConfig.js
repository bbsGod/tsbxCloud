import request from '@/utils/request'

export  function getBasConfigList(query){
  return request({
    url: '/proddata/basConfig/getBasConfigList',
    method: 'get',
    params: query
  })
}
export function getBasConfig(c_pk_id){
  return request({
    url: '/proddata/basConfig/getBasConfig/'+c_pk_id,
    method: 'get'
  })
}
export function updateBasConfig(param){
  return request({
    url: '/proddata/basConfig/update',
    method: 'post',
    data: param
  })
}
export function saveBasConfig(param){
  return request({
    url: '/proddata/basConfig/save',
    method: 'post',
    data: param
  })
}
export function deleteBasConfig(c_pk_ids){
  return request({
    url: '/proddata/basConfig/delete/'+c_pk_ids,
    method:'get'
  })
}
