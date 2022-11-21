import request from "@/utils/request";

export  function getList(query){
  return request({
    url: '/proddata/webBasNoVhlFeePropConf/getList',
    method: 'get',
    params: query
  })
}
export function getNoVhlConfig(c_pk_id){
  return request({
    url: '/proddata/webBasNoVhlFeePropConf/getNoVhlConfig/'+c_pk_id,
    method: 'get'
  })
}
export function update(param){
  return request({
    url: '/proddata/webBasNoVhlFeePropConf/update',
    method: 'post',
    data: param
  })
}
