package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ZhdGoodMapper;
import com.ruoyi.system.domain.ZhdGood;
import com.ruoyi.system.service.IZhdGoodService;

/**
 * 杂货店商品管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-02-26
 */
@Service
public class ZhdGoodServiceImpl implements IZhdGoodService 
{
    @Autowired
    private ZhdGoodMapper zhdGoodMapper;

    /**
     * 查询杂货店商品管理
     * 
     * @param goodId 杂货店商品管理ID
     * @return 杂货店商品管理
     */
    @Override
    public ZhdGood selectZhdGoodById(Long goodId)
    {
        return zhdGoodMapper.selectZhdGoodById(goodId);
    }

    /**
     * 查询杂货店商品管理列表
     * 
     * @param zhdGood 杂货店商品管理
     * @return 杂货店商品管理
     */
    @Override
    public List<ZhdGood> selectZhdGoodList(ZhdGood zhdGood)
    {
        return zhdGoodMapper.selectZhdGoodList(zhdGood);
    }

    /**
     * 新增杂货店商品管理
     * 
     * @param zhdGood 杂货店商品管理
     * @return 结果
     */
    @Override
    public int insertZhdGood(ZhdGood zhdGood)
    {
        zhdGood.setCreateTime(DateUtils.getNowDate());
        return zhdGoodMapper.insertZhdGood(zhdGood);
    }

    /**
     * 修改杂货店商品管理
     * 
     * @param zhdGood 杂货店商品管理
     * @return 结果
     */
    @Override
    public int updateZhdGood(ZhdGood zhdGood)
    {
        zhdGood.setUpdateTime(DateUtils.getNowDate());
        return zhdGoodMapper.updateZhdGood(zhdGood);
    }

    /**
     * 批量删除杂货店商品管理
     * 
     * @param goodIds 需要删除的杂货店商品管理ID
     * @return 结果
     */
    @Override
    public int deleteZhdGoodByIds(Long[] goodIds)
    {
        return zhdGoodMapper.deleteZhdGoodByIds(goodIds);
    }

    /**
     * 删除杂货店商品管理信息
     * 
     * @param goodId 杂货店商品管理ID
     * @return 结果
     */
    @Override
    public int deleteZhdGoodById(Long goodId)
    {
        return zhdGoodMapper.deleteZhdGoodById(goodId);
    }
}
