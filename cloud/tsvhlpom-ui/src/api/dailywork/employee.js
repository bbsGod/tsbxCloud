import request from "@/utils/request";

export function listEmployee(query){
  return request({
    url: '/dailywork/employee/getEmployeeList',
    method: 'get',
    params: query
  })
}

export function getEmployee(pkid){
  return request({
    url: '/dailywork/employee/getEmployee/'+pkid,
    method: 'get',
  })
}
export function updateEmployee(param){
  return request({
    url: '/dailywork/employee/updateEmployee',
    method: 'post',
    data: param
  })
}
export function saveEmployee(param){
  return request({
    url: '/dailywork/employee/saveEmployee',
    method: 'post',
    data: param
  })
}
export function deleteEmployee(pkids){
  return request({
    url: '/dailywork/employee/deleteEmployee/'+pkids,
    method:'get'
  })
}
