package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.ZyxTag;
import com.ruoyi.system.domain.ZyxTagVo;

/**
 * 配置广告Mapper接口
 * 
 * @author zyx
 * @date 2022-05-07
 */
public interface ZyxTagMapper 
{
    /**
     * 查询配置广告
     * 
     * @param id 配置广告ID
     * @return 配置广告
     */
    public ZyxTag selectZyxTagById(Long id);

    /**
     * 查询配置广告列表
     * 
     * @param zyxTag 配置广告
     * @return 配置广告集合
     */
    public List<ZyxTag> selectZyxTagList(ZyxTag zyxTag);

    /**
     * 新增配置广告
     * 
     * @param zyxTag 配置广告
     * @return 结果
     */
    public int insertZyxTag(ZyxTag zyxTag);

    /**
     * 修改配置广告
     * 
     * @param zyxTag 配置广告
     * @return 结果
     */
    public int updateZyxTag(ZyxTag zyxTag);

    /**
     * 删除配置广告
     * 
     * @param id 配置广告ID
     * @return 结果
     */
    public int deleteZyxTagById(Long id);

    /**
     * 批量删除配置广告
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZyxTagByIds(Long[] ids);

    /**
     * 查询info信息
     * @param zyxTag
     * @return
     */
    ZyxTagVo selectByInfo(ZyxTag zyxTag);
}
