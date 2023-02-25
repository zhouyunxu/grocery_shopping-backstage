package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 配置广告对象 zyx_tag
 * 
 * @author zyx
 * @date 2022-05-07
 */
public class ZyxTagVo
{

    /** 广告json格式字符串 */
    @Excel(name = "广告json格式字符串")
    private String tagInfo;

    public String getTagInfo() {
        return tagInfo;
    }

    public void setTagInfo(String tagInfo) {
        this.tagInfo = tagInfo;
    }


    @Override
    public String toString() {
        return "ZyxTagVo{" +
                "tagInfo='" + tagInfo + '\'' +
                '}';
    }
}
