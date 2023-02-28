import request from '@/utils/request'
// 改变商品状态
export function changeShopStatus(shopId, status) {
  const data = {
    shopId,
    status
  }
  return request({
    url: '/system/good/changeShopStatus',
    method: 'put',
    data: data
  })
}
// 查询杂货店商品管理列表
export function listGood(query) {
  return request({
    url: '/system/good/list',
    method: 'get',
    params: query
  })
}

// 查询杂货店商品管理详细
export function getGood(goodId) {
  return request({
    url: '/system/good/' + goodId,
    method: 'get'
  })
}

// 新增杂货店商品管理
export function addGood(data) {
  return request({
    url: '/system/good',
    method: 'post',
    data: data
  })
}

// 修改杂货店商品管理
export function updateGood(data) {
  return request({
    url: '/system/good',
    method: 'put',
    data: data
  })
}

// 删除杂货店商品管理
export function delGood(goodId) {
  return request({
    url: '/system/good/' + goodId,
    method: 'delete'
  })
}

// 导出杂货店商品管理
export function exportGood(query) {
  return request({
    url: '/system/good/export',
    method: 'get',
    params: query
  })
}