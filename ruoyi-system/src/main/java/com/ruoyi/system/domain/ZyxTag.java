package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 配置广告对象 zyx_tag
 * 
 * @author zyx
 * @date 2022-05-07
 */
public class ZyxTag extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 广告标题 */
    @Excel(name = "广告标题")
    private String tag;

    /** 广告版本 */
    @Excel(name = "广告版本")
    private String tagVersion;

    /** 广告功能 */
    @Excel(name = "广告功能")
    private String tagFunctions;

    /** 广告json格式字符串 */
    @Excel(name = "广告json格式字符串")
    private String tagInfo;

    /** 默认版本 */
    @Excel(name = "默认版本")
    private String buserCount;

    /** 未知阿普弗 */
    @Excel(name = "未知阿普弗")
    private String appver;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTag(String tag) 
    {
        this.tag = tag;
    }

    public String getTag() 
    {
        return tag;
    }
    public void setTagVersion(String tagVersion) 
    {
        this.tagVersion = tagVersion;
    }

    public String getTagVersion() 
    {
        return tagVersion;
    }
    public void setTagFunctions(String tagFunctions) 
    {
        this.tagFunctions = tagFunctions;
    }

    public String getTagFunctions() 
    {
        return tagFunctions;
    }
    public void setTagInfo(String tagInfo) 
    {
        this.tagInfo = tagInfo;
    }

    public String getTagInfo() 
    {
        return tagInfo;
    }
    public void setBuserCount(String buserCount) 
    {
        this.buserCount = buserCount;
    }

    public String getBuserCount() 
    {
        return buserCount;
    }
    public void setAppver(String appver) 
    {
        this.appver = appver;
    }

    public String getAppver() 
    {
        return appver;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("tag", getTag())
            .append("tagVersion", getTagVersion())
            .append("tagFunctions", getTagFunctions())
            .append("tagInfo", getTagInfo())
            .append("buserCount", getBuserCount())
            .append("appver", getAppver())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
