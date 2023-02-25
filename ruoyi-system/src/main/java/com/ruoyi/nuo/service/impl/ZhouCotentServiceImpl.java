package com.ruoyi.nuo.service.impl;

import java.util.List;

import com.ruoyi.nuo.domain.ZhouCotent;
import com.ruoyi.nuo.mapper.ZhouCotentMapper;
import com.ruoyi.nuo.service.IZhouCotentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 信息Service业务层处理
 *
 * @author ruoyi
 * @date 2021-07-22
 */
@Service
public class ZhouCotentServiceImpl implements IZhouCotentService
{
    @Autowired
    private ZhouCotentMapper zhouCotentMapper;

    /**
     * 查询信息
     *
     * @param id 信息ID
     * @return 信息
     */
    @Override
    public ZhouCotent selectZhouCotentById(Long id)
    {
        return zhouCotentMapper.selectZhouCotentById(id);
    }

    /**
     * 查询信息列表
     *
     * @param zhouCotent 信息
     * @return 信息
     */
    @Override
    public List<ZhouCotent> selectZhouCotentList(ZhouCotent zhouCotent)
    {
        return zhouCotentMapper.selectZhouCotentList(zhouCotent);
    }

    /**
     * 新增信息
     *
     * @param zhouCotent 信息
     * @return 结果
     */
    @Override
    public int insertZhouCotent(ZhouCotent zhouCotent)
    {
        return zhouCotentMapper.insertZhouCotent(zhouCotent);
    }

    /**
     * 修改信息
     *
     * @param zhouCotent 信息
     * @return 结果
     */
    @Override
    public int updateZhouCotent(ZhouCotent zhouCotent)
    {
        return zhouCotentMapper.updateZhouCotent(zhouCotent);
    }

    /**
     * 批量删除信息
     *
     * @param ids 需要删除的信息ID
     * @return 结果
     */
    @Override
    public int deleteZhouCotentByIds(Long[] ids)
    {
        return zhouCotentMapper.deleteZhouCotentByIds(ids);
    }

    /**
     * 删除信息信息
     *
     * @param id 信息ID
     * @return 结果
     */
    @Override
    public int deleteZhouCotentById(Long id)
    {
        return zhouCotentMapper.deleteZhouCotentById(id);
    }
}
