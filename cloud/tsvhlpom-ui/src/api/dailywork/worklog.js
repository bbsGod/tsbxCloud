import request from "@/utils/request";

export function listWorkLog(query){
  return request({
    url: '/dailywork/worklog/getWorkLogList',
    method: 'get',
    params: query
  })
}

export function getWorkLog(pkid){
  return request({
    url: '/dailywork/worklog/getWorkLog/'+pkid,
    method: 'get',
  })
}
export function updateWorkLog(param){
  return request({
    url: '/dailywork/worklog/updateWorkLog',
    method: 'post',
    data: param
  })
}
export function saveWorkLog(param){
  return request({
    url: '/dailywork/worklog/saveWorkLog',
    method: 'post',
    data: param
  })
}
export function deleteWorkLog(pkids){
  return request({
    url: '/dailywork/worklog/deleteWorkLog/'+pkids,
    method:'get'
  })
}
export function getEmployeeInfo(emp_id){
  return request({
    url: '/dailywork/employee/getEmployeeInfo/'+emp_id,
    method: 'get',
  })
}
export  function showAttchment(param) {
  return request({
    url: '/dailywork/worklog/showAttchment',
    method: 'get',
    params: param,
    responseType:'blob'
  })
}
export function getLogAnalysisList(param){
  return request({
    url: '/dailywork/worklog/logAnalysis',
    method: 'post',
    data: param
  })
}
export function exportWorkLog(param){
  return request({
    url: '/dailywork/worklog/exportWorkLog',
    method: 'post',
    data: param
  })
}
