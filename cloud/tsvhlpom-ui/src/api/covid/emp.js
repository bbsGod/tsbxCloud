// 获取用户详细信息
import request from '@/utils/request'

export function getEmplyeeList(query) {
  return request({
    url: '/covid/covid_emp/getEmplyeeList',
    method: 'get',
    params: query
  })
}
export function getEmplyee(c_pk_id){
  return request({
    url: '/covid/covid_emp/getEmplyee/'+c_pk_id,
    method: 'get'
  })
}
export function deleteEmplyee(pkIds){
  return request({
    url: '/covid/covid_emp/deleteEmplyee/'+pkIds,
    method:'get'
  })
}
export function updateEmplyee(param){
  return request({
    url: '/covid/covid_emp/updateEmplyee',
    method: 'post',
    data: param
  })
}
export function saveEmplyee(param){
  return request({
    url: '/covid/covid_emp/saveEmplyee',
    method: 'post',
    data: param
  })
}
