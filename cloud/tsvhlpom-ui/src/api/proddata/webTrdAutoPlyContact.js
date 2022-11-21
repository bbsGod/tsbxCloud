import request from '@/utils/request'

export  function getWebTrdAutoPlyContactList(query){
  return request({
    url: '/proddata/plyContact/getWebTrdAutoPlyContactList',
    method: 'get',
    params: query
  })
}
export function getWebTrdAutoPlyContact(c_pk_id){
  return request({
    url: '/proddata/plyContact/getWebTrdAutoPlyContact/'+c_pk_id,
    method: 'get'
  })
}
export function update(param){
  return request({
    url: '/proddata/plyContact/update',
    method: 'post',
    data: param
  })
}
export function save(param){
  return request({
    url: '/proddata/plyContact/save',
    method: 'post',
    data: param
  })
}
export function deletePlyContact(c_pk_ids) {
  return request({
    url: '/proddata/plyContact/delete/'+c_pk_ids,
    method:'get'
  })
}
