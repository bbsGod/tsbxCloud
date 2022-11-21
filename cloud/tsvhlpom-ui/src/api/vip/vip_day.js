import request from '@/utils/request'
import { praseStrEmpty } from "@/utils/ruoyi";

// 查询用户列表
export function listDay(query) {
  return request({
    url: '/vip/vip_day/list',
    method: 'get',
    params: query
  })
}

// 查询用户详细
export function getDay(pkId) {
  return request({
    url: '/vip/vip_day/getDay/' + pkId,
    method: 'get'
  })
}
// 新增用户
export function addDay(data) {
  return request({
    url: '/vip/vip_day/add',
    method: 'post',
    data: data
  })
}
// 修改用户
export function updateDay(data) {
  return request({
    url: '/vip/vip_day/edit',
    method: 'post',
    data: data
  })
}
// 删除用户
export function delDay(pkId) {
  return request({
    url: '/vip/vip_day/' + pkId,
    method: 'delete'
  })
}
