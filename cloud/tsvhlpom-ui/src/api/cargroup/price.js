import request from '@/utils/request'

// 查询用户列表
export function getBasePriceList(query) {
  return request({
    url: '/cargroup/basePrice/getBasePriceList',
    method: 'get',
    params: query
  })
}

// 查询用户详细
export function getPriceById(pk_id) {
  return request({
    url: '/cargroup/basePrice/getPriceById/' + pk_id,
    method: 'get'
  })
}
// 新增用户
export function save(data) {
  return request({
    url: '/cargroup/basePrice/save',
    method: 'post',
    data: data
  })
}
// 修改用户
export function update(data) {
  return request({
    url: '/cargroup/basePrice/update',
    method: 'post',
    data: data
  })
}
// 删除用户
export function delPrice(sp_ids) {
  return request({
    url: '/cargroup/basePrice/delete/' + sp_ids,
    method: 'delete'
  })
}

export function price(data){
  return request({
    url: '/cargroup/basePrice/price',
    method: 'post',
    data: data
  })
}
export function updatePriceStatus(data){
  return request({
    url: '/cargroup/basePrice/updatePriceStatus',
    method: 'post',
    data: data
  })
}
