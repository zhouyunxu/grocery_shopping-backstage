package com.ruoyi.nuo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 信息对象 zhou_cotent
 *
 * @author ruoyi
 * @date 2021-07-22
 */
public class ZhouCotent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 信息表id */
    private Long id;

    /** 信息编号 */
    @Excel(name = "信息编号")
    private String informationId;

    /** 信息内容 */
    @Excel(name = "信息内容")
    private String content;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setInformationId(String informationId)
    {
        this.informationId = informationId;
    }

    public String getInformationId()
    {
        return informationId;
    }
    public void setContent(String content)
    {
        this.content = content;
    }

    public String getContent()
    {
        return content;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("informationId", getInformationId())
            .append("content", getContent())
            .toString();
    }
}
