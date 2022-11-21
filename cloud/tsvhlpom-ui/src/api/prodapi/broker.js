import request from '@/utils/request'

export  function getBrokerList(query){
  return request({
    url: '/prodapi/broker/getBrokerList',
    method: 'get',
    params: query
  })
}
export function getBroker(c_pk_id){
  return request({
    url: '/prodapi/broker/getBroker/'+c_pk_id,
    method: 'get'
  })
}
export function updateBroker(param){
  return request({
    url: '/prodapi/broker/update',
    method: 'post',
    data: param
  })
}
export function saveBroker(param){
  return request({
    url: '/prodapi/broker/save',
    method: 'post',
    data: param
  })
}
export function deleteBroker(c_pk_ids){
  return request({
    url: '/prodapi/broker/delete/'+c_pk_ids,
    method:'get'
  })
}
