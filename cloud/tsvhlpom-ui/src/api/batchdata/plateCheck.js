import request from "@/utils/request";

export function getPalteCheckList(query){
  return request({
    url: '/mysqlClient/vpdc/getCheckList',
    method: 'get',
    params: query
  })
}
export function deleteCheckData(query){
  return request({
    url: '/batchdata/vpdc/deleteData',
    method: 'get',
    params: query
  })
}
export function genCheckData(query){
  return request({
    url: '/batchdata/vpdc/makeData',
    method: 'get',
    params: query
  })
}
