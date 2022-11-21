import request from '@/utils/request'

export  function getBasLbUrlList(query){
  return request({
    url: '/proddata/basLbUrl/getBasLbUrlList',
    method: 'get',
    params: query
  })
}
export function getBasLbUrl(c_pk_id){
  return request({
    url: '/proddata/basLbUrl/getBasLbUrl/'+c_pk_id,
    method: 'get'
  })
}
export function updateBasLbUrl(param){
  return request({
    url: '/proddata/basLbUrl/update',
    method: 'post',
    data: param
  })
}
export function saveBasLbUrl(param){
  return request({
    url: '/proddata/basLbUrl/save',
    method: 'post',
    data: param
  })
}
export function deleteBasLbUrl(c_pk_ids){
  return request({
    url: '/proddata/basLbUrl/delete/'+c_pk_ids,
    method:'get'
  })
}
