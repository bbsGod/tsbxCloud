import request from "@/utils/request";

export function listCovid(query){
  return request({
    url: '/covid/covid/getCovidList',
    method: 'get',
    params: query
  })
}
export function getDoneResult(query){
  return request({
    url: '/covid/covid/getDoneResult',
    method: 'get',
    params: query
  })
}
export function getUndoneDetial(query){
  return request({
    url: '/covid/covid/getUndoneDetial',
    method: 'get',
    params: query
  })
}
