import request from "@/utils/request";

export  function getTblPasswordList(query){
  return request({
    url: '/proddata/tblPassword/getTblPasswordList',
    method: 'get',
    params: query
  })
}
export function update(param){
  return request({
    url: '/proddata/tblPassword/update',
    method: 'post',
    data: param
  })
}
