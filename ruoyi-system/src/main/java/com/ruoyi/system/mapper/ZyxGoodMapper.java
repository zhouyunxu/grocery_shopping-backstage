package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.ZyxGood;

/**
 * 商品Mapper接口
 * 
 * @author yunszhou
 * @date 2022-01-12
 */
public interface ZyxGoodMapper 
{
    /**
     * 查询商品
     * 
     * @param id 商品ID
     * @return 商品
     */
    public ZyxGood selectZyxGoodById(Long id);

    /**
     * 查询商品列表
     * 
     * @param zyxGood 商品
     * @return 商品集合
     */
    public List<ZyxGood> selectZyxGoodList(ZyxGood zyxGood);

    /**
     * 新增商品
     * 
     * @param zyxGood 商品
     * @return 结果
     */
    public int insertZyxGood(ZyxGood zyxGood);

    /**
     * 修改商品
     * 
     * @param zyxGood 商品
     * @return 结果
     */
    public int updateZyxGood(ZyxGood zyxGood);

    /**
     * 删除商品
     * 
     * @param id 商品ID
     * @return 结果
     */
    public int deleteZyxGoodById(Long id);

    /**
     * 批量删除商品
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZyxGoodByIds(Long[] ids);
}
