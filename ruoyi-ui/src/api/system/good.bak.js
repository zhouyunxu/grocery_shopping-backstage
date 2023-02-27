import request from '@/utils/request'

// 查询商品列表
export function listGood(query) {
  return request({
    url: '/system/good/list',
    method: 'get',
    params: query
  })
}

// 查询商品详细
export function getGood(id) {
  return request({
    url: '/system/good/' + id,
    method: 'get'
  })
}

// 新增商品
export function addGood(data) {
  return request({
    url: '/system/good',
    method: 'post',
    data: data
  })
}

// 修改商品
export function updateGood(data) {
  return request({
    url: '/system/good',
    method: 'put',
    data: data
  })
}

// 删除商品
export function delGood(id) {
  return request({
    url: '/system/good/' + id,
    method: 'delete'
  })
}

// 导出商品
export function exportGood(query) {
  return request({
    url: '/system/good/export',
    method: 'get',
    params: query
  })
}
