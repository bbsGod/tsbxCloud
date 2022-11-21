import request from '@/utils/request'

// 查询用户列表
export function getPersonList(query) {
  return request({
    url: '/cargroup/basePerson/getPersonList',
    method: 'get',
    params: query
  })
}

// 查询用户详细
export function getPersonById(sp_id) {
  return request({
    url: '/cargroup/basePerson/getPersonById/' + sp_id,
    method: 'get'
  })
}
// 新增用户
export function save(data) {
  return request({
    url: '/cargroup/basePerson/save',
    method: 'post',
    data: data
  })
}
// 修改用户
export function update(data) {
  return request({
    url: '/cargroup/basePerson/update',
    method: 'post',
    data: data
  })
}
// 删除用户
export function delPerson(sp_ids) {
  return request({
    url: '/cargroup/basePerson/delete/' + sp_ids,
    method: 'delete'
  })
}
