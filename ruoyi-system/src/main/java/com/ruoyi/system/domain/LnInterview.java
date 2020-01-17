package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 面试记录对象 ln_interview
 *
 * @author guzf
 * @date 2020-01-16
 */
public class LnInterview extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    private Long id;

    /**
     * 面试人
     */
    @Excel(name = "面试人")
    private String name;

    /**
     * 面试单位
     */
    @Excel(name = "面试单位")
    private String companyName;

    /**
     * 面试内容
     */
    @Excel(name = "面试内容")
    private String content;

    /**
     * 面试结果（0失败 1成功）
     */
    @Excel(name = "面试结果", readConverterExp = "0=失败,1=成功")
    private String status;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("companyName", getCompanyName())
                .append("content", getContent())
                .append("status", getStatus())
                .append("createTime", getCreateTime())
                .toString();
    }
}
