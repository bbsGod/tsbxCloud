import request from "@/utils/request";

export  function getVatList(query){
  return request({
    url: '/proddata/webPlyVatInvoice/getVatList',
    method: 'get',
    params: query
  })
}
export function updateStatus(param){
  return request({
    url: '/proddata/webPlyVatInvoice/updateStatus',
    method: 'post',
    data: param
  })
}
