import request from '@/utils/request'

// 查询配置广告列表
export function listTag(query) {
  return request({
    url: '/system/tag/list',
    method: 'get',
    params: query
  })
}

// 查询配置广告详细
export function getTag(id) {
  return request({
    url: '/system/tag/' + id,
    method: 'get'
  })
}

// 新增配置广告
export function addTag(data) {
  return request({
    url: '/system/tag',
    method: 'post',
    data: data
  })
}

// 修改配置广告
export function updateTag(data) {
  return request({
    url: '/system/tag',
    method: 'put',
    data: data
  })
}

// 删除配置广告
export function delTag(id) {
  return request({
    url: '/system/tag/' + id,
    method: 'delete'
  })
}

// 导出配置广告
export function exportTag(query) {
  return request({
    url: '/system/tag/export',
    method: 'get',
    params: query
  })
}