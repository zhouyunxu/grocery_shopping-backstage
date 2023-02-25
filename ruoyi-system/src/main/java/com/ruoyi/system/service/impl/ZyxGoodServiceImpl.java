package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.token.Token;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ZyxGoodMapper;
import com.ruoyi.system.domain.ZyxGood;
import com.ruoyi.system.service.IZyxGoodService;

/**
 * 商品Service业务层处理
 * 
 * @author yunszhou
 * @date 2022-01-12
 */
@Service
public class ZyxGoodServiceImpl implements IZyxGoodService 
{
    @Autowired
    private ZyxGoodMapper zyxGoodMapper;


    /**
     * 查询商品
     * 
     * @param id 商品ID
     * @return 商品
     */
    @Override
    public ZyxGood selectZyxGoodById(Long id)
    {
        return zyxGoodMapper.selectZyxGoodById(id);
    }

    /**
     * 查询商品列表
     * 
     * @param zyxGood 商品
     * @return 商品
     */
    @Override
    public List<ZyxGood> selectZyxGoodList(ZyxGood zyxGood)
    {
        return zyxGoodMapper.selectZyxGoodList(zyxGood);
    }

    /**
     * 新增商品
     * 
     * @param zyxGood 商品
     * @return 结果
     */
    @Override
    public int insertZyxGood(ZyxGood zyxGood)
    {
        zyxGood.setCreateTime(DateUtils.getNowDate());
        return zyxGoodMapper.insertZyxGood(zyxGood);
    }

    /**
     * 修改商品
     * 
     * @param zyxGood 商品
     * @return 结果
     */
    @Override
    public int updateZyxGood(ZyxGood zyxGood)
    {
        zyxGood.setUpdateTime(DateUtils.getNowDate());
        return zyxGoodMapper.updateZyxGood(zyxGood);
    }

    /**
     * 批量删除商品
     * 
     * @param ids 需要删除的商品ID
     * @return 结果
     */
    @Override
    public int deleteZyxGoodByIds(Long[] ids)
    {
        return zyxGoodMapper.deleteZyxGoodByIds(ids);
    }

    /**
     * 删除商品信息
     * 
     * @param id 商品ID
     * @return 结果
     */
    @Override
    public int deleteZyxGoodById(Long id)
    {
        return zyxGoodMapper.deleteZyxGoodById(id);
    }
}
