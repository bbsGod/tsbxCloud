import request from "@/utils/request";

export  function getWebAppVsTaxList(query){
  return request({
    url: '/proddata/webAppVsTax/getWebAppVsTaxList',
    method: 'get',
    params: query
  })
}
export function update(param){
  return request({
    url: '/proddata/webAppVsTax/update',
    method: 'post',
    data: param
  })
}
