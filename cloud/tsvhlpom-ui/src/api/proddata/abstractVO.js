import request from '@/utils/request'
export function getAbstractVOList(query){
  //修改邮箱
  if(query.c_type == '0'){
    return request({
      url: '/proddata/abstract/getAppEmailList',
      method: 'get',
      params: query
    })
  }
}
export function updateEmail(param){
  return request({
    url: '/proddata/abstract/updateEmail',
    method: 'post',
    data: param
  })
}
