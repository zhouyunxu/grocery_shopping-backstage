import request from '@/utils/request'

// 查询个人用户列表
export function listNuoyi(query) {
  return request({
    url: '/nuo/nuoyi/list',
    method: 'get',
    params: query
  })
}

// 查询个人用户详细
export function getNuoyi(id) {
  return request({
    url: '/nuo/nuoyi/' + id,
    method: 'get'
  })
}

// 新增个人用户
export function addNuoyi(data) {
  return request({
    url: '/nuo/nuoyi',
    method: 'post',
    data: data
  })
}

// 修改个人用户
export function updateNuoyi(data) {
  return request({
    url: '/nuo/nuoyi',
    method: 'put',
    data: data
  })
}

// 删除个人用户
export function delNuoyi(id) {
  return request({
    url: '/nuo/nuoyi/' + id,
    method: 'delete'
  })
}

// 导出个人用户
export function exportNuoyi(query) {
  return request({
    url: '/nuo/nuoyi/export',
    method: 'get',
    params: query
  })
}