package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.ZyxTagVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ZyxTagMapper;
import com.ruoyi.system.domain.ZyxTag;
import com.ruoyi.system.service.IZyxTagService;

/**
 * 配置广告Service业务层处理
 * 
 * @author zyx
 * @date 2022-05-07
 */
@Service
public class ZyxTagServiceImpl implements IZyxTagService 
{
    @Autowired
    private ZyxTagMapper zyxTagMapper;

    /**
     * 查询配置广告
     * 
     * @param id 配置广告ID
     * @return 配置广告
     */
    @Override
    public ZyxTag selectZyxTagById(Long id)
    {
        return zyxTagMapper.selectZyxTagById(id);
    }

    /**
     * 查询配置广告列表
     * 
     * @param zyxTag 配置广告
     * @return 配置广告
     */
    @Override
    public List<ZyxTag> selectZyxTagList(ZyxTag zyxTag)
    {
        return zyxTagMapper.selectZyxTagList(zyxTag);
    }

    /**
     * 新增配置广告
     * 
     * @param zyxTag 配置广告
     * @return 结果
     */
    @Override
    public int insertZyxTag(ZyxTag zyxTag)
    {
        zyxTag.setCreateTime(DateUtils.getNowDate());
        return zyxTagMapper.insertZyxTag(zyxTag);
    }

    /**
     * 修改配置广告
     * 
     * @param zyxTag 配置广告
     * @return 结果
     */
    @Override
    public int updateZyxTag(ZyxTag zyxTag)
    {
        zyxTag.setUpdateTime(DateUtils.getNowDate());
        return zyxTagMapper.updateZyxTag(zyxTag);
    }

    /**
     * 批量删除配置广告
     * 
     * @param ids 需要删除的配置广告ID
     * @return 结果
     */
    @Override
    public int deleteZyxTagByIds(Long[] ids)
    {
        return zyxTagMapper.deleteZyxTagByIds(ids);
    }

    /**
     * 删除配置广告信息
     * 
     * @param id 配置广告ID
     * @return 结果
     */
    @Override
    public int deleteZyxTagById(Long id)
    {
        return zyxTagMapper.deleteZyxTagById(id);
    }

    /**
     * 查询info信息
     * @param zyxTag
     * @return
     */
    @Override
    public ZyxTagVo selectByInfo(ZyxTag zyxTag) {
        return zyxTagMapper.selectByInfo(zyxTag);
    }
}
