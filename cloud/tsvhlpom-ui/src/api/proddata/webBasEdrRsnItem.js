import request from "@/utils/request";

export function saveWebBasEdrRsnItem(param){
  return request({
    url: '/proddata/webBasEdrRsnItem/save',
    method: 'post',
    data: param
  })
}
export function deleteWebBasEdrRsnItem(c_pk_ids){
  return request({
    url: '/proddata/webBasEdrRsnItem/delete/'+c_pk_ids,
    method:'get'
  })
}
export function getWebBasEdrRsnItem(c_pk_id){
  return request({
    url: '/proddata/webBasEdrRsnItem/getWebBasEdrRsnItem/'+c_pk_id,
    method: 'get'
  })
}
