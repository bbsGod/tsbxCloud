import request from "@/utils/request";

export function getBaseCustomersList(query){
  return request({
    url: '/cargroup/customers/getBaseCustomersList',
    method: 'get',
    params: query
  })
}
export function getCustomers(c_pk_id){
  return request({
    url: '/cargroup/customers/getBaseCustomers/'+c_pk_id,
    method: 'get'
  })
}
export function updateVisit(param){
  return request({
    url: '/cargroup/customers/updateVisit',
    method: 'post',
    data: param
  })
}
export function updateCustomers(param){
  return request({
    url: '/cargroup/customers/update',
    method: 'post',
    data: param
  })
}
export function deleteCustomers(c_pk_ids){
  return request({
    url: '/cargroup/customers/delete/'+c_pk_ids,
    method:'get'
  })
}
export function saveCustomers(param){
  return request({
    url: '/cargroup/customers/insert',
    method: 'post',
    data: param
  })
}
export function showVisitList(c_id){
  return request({
    url: '/cargroup/customers/getVisitList/'+c_id,
    method: 'get'
  })
}
export function getSpCust(query){
  return request({
    url: '/cargroup/customers/getSpCust?query='+query,
    method: 'get'
  })
}
