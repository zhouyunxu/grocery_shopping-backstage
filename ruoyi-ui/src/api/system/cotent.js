import request from '@/utils/request'

// 查询信息列表
export function listCotent(query) {
  return request({
    url: '/system/cotent/list',
    method: 'get',
    params: query
  })
}

// 查询信息详细
export function getCotent(id) {
  return request({
    url: '/system/cotent/' + id,
    method: 'get'
  })
}

// 新增信息
export function addCotent(data) {
  return request({
    url: '/system/cotent',
    method: 'post',
    data: data
  })
}

// 修改信息
export function updateCotent(data) {
  return request({
    url: '/system/cotent',
    method: 'put',
    data: data
  })
}

// 删除信息
export function delCotent(id) {
  return request({
    url: '/system/cotent/' + id,
    method: 'delete'
  })
}

// 导出信息
export function exportCotent(query) {
  return request({
    url: '/system/cotent/export',
    method: 'get',
    params: query
  })
}