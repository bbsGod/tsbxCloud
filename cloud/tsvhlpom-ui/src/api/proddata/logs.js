import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listLogs(query) {
  return request({
    url: '/proddata/webPolicyThirdErrLogs/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getLogs(cpkId) {
  return request({
    url: '/proddata/webPolicyThirdErrLogs/' + cpkId,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addLogs(data) {
  return request({
    url: '/proddata/webPolicyThirdErrLogs',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateLogs(data) {
  return request({
    url: '/proddata/webPolicyThirdErrLogs',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delLogs(cpkIds) {
  return request({
    url: '/proddata/webPolicyThirdErrLogs/' + cpkIds,
    method: 'delete'
  })
}
