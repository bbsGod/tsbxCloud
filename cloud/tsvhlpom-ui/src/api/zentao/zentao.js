import request from "@/utils/request";

export function getProductList(){
  return request({
    url: '/zentao/product/getProduct',
    method: 'get',
  })
}
export function findDemandList(param){
  return request({
    url: '/zentao/demand/findList',
    method: 'post',
    data: param
  })
}
export function findDemandById(query) {
  return request({
    url: '/zentao/demand/findDemandById',
    method: 'get',
    params: query
  })
}
export function saveDemand(param) {
  return request({
    url: '/mysqlClient/demand/save',
    method: 'post',
    data: param
  })
}
