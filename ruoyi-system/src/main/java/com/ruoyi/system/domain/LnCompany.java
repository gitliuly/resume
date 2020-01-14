package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 公司对象 ln_company
 *
 * @author mi
 * @date 2020-01-13
 */
public class LnCompany extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 公司Id */
    private Integer companyId;

    /** 公司名称 */
    @Excel(name = "公司名称")
    private String companyName;

    /** 所属行业id */
    @Excel(name = "所属行业id")
    private Long industryId;


    private String industryName;
    /** 需求职位（多个职位，存储职位表的id 已逗号隔开） */
    @Excel(name = "需求职位", readConverterExp = "多=个职位，存储职位表的id,已=逗号隔开")
    private String jobsOnOffer;

    /** 公司地址（手填） */
    @Excel(name = "公司地址", readConverterExp = "手=填")
    private String address;

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    public void setCompanyId(Integer companyId)
    {
        this.companyId = companyId;
    }

    public Integer getCompanyId()
    {
        return companyId;
    }
    public void setCompanyName(String companyName)
    {
        this.companyName = companyName;
    }

    public String getCompanyName()
    {
        return companyName;
    }
    public void setIndustryId(Long industryId)
    {
        this.industryId = industryId;
    }

    public Long getIndustryId()
    {
        return industryId;
    }
    public void setJobsOnOffer(String jobsOnOffer)
    {
        this.jobsOnOffer = jobsOnOffer;
    }

    public String getJobsOnOffer()
    {
        return jobsOnOffer;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return address;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("companyId", getCompanyId())
                .append("companyName", getCompanyName())
                .append("industryId", getIndustryId())
                .append("jobsOnOffer", getJobsOnOffer())
                .append("address", getAddress())
                .append("createTime", getCreateTime())
                .toString();
    }
}