package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 行业对象 ln_industry
 *
 * @author guzf
 * @date 2020-01-13
 */
public class LnIndustry extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    private Long industryId;

    /**
     * 行业名称
     */
    @Excel(name = "行业名称")
    private String industryName;

    public void setIndustryId(Long industryId) {
        this.industryId = industryId;
    }

    public Long getIndustryId() {
        return industryId;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    public String getIndustryName() {
        return industryName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("industryId", getIndustryId())
                .append("industryName", getIndustryName())
                .append("createTime", getCreateTime())
                .toString();
    }
}
