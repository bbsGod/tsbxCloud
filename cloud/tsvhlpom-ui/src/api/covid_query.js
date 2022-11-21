import request from "@/utils/request";

export function getAnalyseAnswer(param) {
  return request({
    url: 'covid/covid/statistics',
    method: 'post',
    data:param
  })
}
