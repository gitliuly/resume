package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 职位对象 ln_position
 *
 * @author ruoyi
 * @date 2020-01-13
 */
public class LnPosition extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 职位Id
     */
    private Integer positionId;

    /**
     * 所属行业id
     */
    @Excel(name = "所属行业id")
    private Long industryId;

    /**
     * 所属行业名称
     */
    private String industryName;

    /**
     * 职位名称
     */
    @Excel(name = "职位名称")
    private String positionName;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public Long getIndustryId() {
        return industryId;
    }

    public void setIndustryId(Long industryId) {
        this.industryId = industryId;
    }

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    @Override
    public String toString() {
        return "LnPosition{" +
                "positionId=" + positionId +
                ", industryId=" + industryId +
                ", industryName='" + industryName + '\'' +
                ", positionName='" + positionName + '\'' +
                '}';
    }
}
