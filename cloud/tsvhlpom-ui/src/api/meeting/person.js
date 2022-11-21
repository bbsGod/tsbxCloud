import request from '@/utils/request'

export  function getPersonList(query){
  return request({
    url: '/meetingpreset/person/getPersonList',
    method: 'get',
    params: query
  })
}
export function getPersonById(pk_id){
  return request({
    url: '/meetingpreset/person/getPersonById/'+pk_id,
    method: 'get'
  })
}
export function update(param){
  return request({
    url: '/meetingpreset/person/update',
    method: 'post',
    data: param
  })
}
export function save(param){
  return request({
    url: '/meetingpreset/person/save',
    method: 'post',
    data: param
  })
}
export function deletePerson(pk_ids){
  return request({
    url: '/meetingpreset/person/delete/'+pk_ids,
    method:'get'
  })
}
