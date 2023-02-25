package com.ruoyi.nuo.service;

import com.ruoyi.nuo.domain.ZhouCotent;

import java.util.List;


/**
 * 信息Service接口
 *
 * @author ruoyi
 * @date 2021-07-22
 */
public interface IZhouCotentService
{
    /**
     * 查询信息
     *
     * @param id 信息ID
     * @return 信息
     */
    public ZhouCotent selectZhouCotentById(Long id);

    /**
     * 查询信息列表
     *
     * @param zhouCotent 信息
     * @return 信息集合
     */
    public List<ZhouCotent> selectZhouCotentList(ZhouCotent zhouCotent);

    /**
     * 新增信息
     *
     * @param zhouCotent 信息
     * @return 结果
     */
    public int insertZhouCotent(ZhouCotent zhouCotent);

    /**
     * 修改信息
     *
     * @param zhouCotent 信息
     * @return 结果
     */
    public int updateZhouCotent(ZhouCotent zhouCotent);

    /**
     * 批量删除信息
     *
     * @param ids 需要删除的信息ID
     * @return 结果
     */
    public int deleteZhouCotentByIds(Long[] ids);

    /**
     * 删除信息信息
     *
     * @param id 信息ID
     * @return 结果
     */
    public int deleteZhouCotentById(Long id);
}
