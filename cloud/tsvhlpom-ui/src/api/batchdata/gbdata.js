import request from "@/utils/request";

export function getGbdataList(query){
  return request({
    url: '/mysqlClient/gbmonthdata/findAll',
    method: 'get',
    params: query
  })
}
export function handleInitData(query){
  return request({
    url: '/batchdata/gbMonthData/initMiddleData',
    method: 'get',
    params: query
  })
}
export function deleteGbData(query){
  return request({
    url: '/batchdata/gbMonthData/deleteData',
    method: 'get',
    params: query
  })
}
export function getErrMsg(query){
  return request({
    url: '/batchdata/gbMonthData/getErrMsg',
    method: 'get',
    params: query
  })
}
export function downLoadErrMsg(query){
  return request({
    url: '/batchdata/gbMonthData/downLoadErrMsg',
    method: 'get',
    params: query
  })
}
