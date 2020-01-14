package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
/**
 * 个人简历对象 ln_resume
 *
 * @author mi
 * @date 2020-01-13
 */
public class LnResume extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 主键Id */
    private Integer id;

    /** 个人姓名 */
    @Excel(name = "个人姓名")
    private String personName;

    private String phone;

    /** 性别(0未知，1男生，2女生) */
    @Excel(name = "性别(0未知，1男生，2女生)")
    private Long sex;

    /** 年龄 */
    @Excel(name = "年龄")
    private Long age;

    /** 行业Id */
    @Excel(name = "行业Id")
    private Long industryId;

    /** 职位Id */
    @Excel(name = "职位Id")
    private Integer positionId;

    /** 简历存储地址 */
    @Excel(name = "简历存储地址")
    private String resumeUrl;

    /** 推荐公司Id（推荐多个） */
    @Excel(name = "推荐公司Id", readConverterExp = "推=荐多个")
    private String recommendCompanyId;

    /** 是否入职（0否 1是） */
    @Excel(name = "是否入职", readConverterExp = "0=否,1=是")
    private String status;

    /** 入职公司Id */
    @Excel(name = "入职公司Id")
    private String entryCompanyId;

    private String industryName;
    private String positionName;

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }
    public void setPersonName(String personName)
    {
        this.personName = personName;
    }

    public String getPersonName()
    {
        return personName;
    }
    public void setSex(Long sex)
    {
        this.sex = sex;
    }

    public Long getSex()
    {
        return sex;
    }
    public void setAge(Long age)
    {
        this.age = age;
    }

    public Long getAge()
    {
        return age;
    }
    public void setIndustryId(Long industryId)
    {
        this.industryId = industryId;
    }

    public Long getIndustryId()
    {
        return industryId;
    }
    public void setPositionId(Integer positionId)
    {
        this.positionId = positionId;
    }

    public Integer getPositionId()
    {
        return positionId;
    }
    public void setResumeUrl(String resumeUrl)
    {
        this.resumeUrl = resumeUrl;
    }

    public String getResumeUrl()
    {
        return resumeUrl;
    }
    public void setRecommendCompanyId(String recommendCompanyId)
    {
        this.recommendCompanyId = recommendCompanyId;
    }

    public String getRecommendCompanyId()
    {
        return recommendCompanyId;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
    public void setEntryCompanyId(String entryCompanyId)
    {
        this.entryCompanyId = entryCompanyId;
    }

    public String getEntryCompanyId()
    {
        return entryCompanyId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("personName", getPersonName())
                .append("phone", getPhone())
                .append("sex", getSex())
                .append("age", getAge())
                .append("industryId", getIndustryId())
                .append("positionId", getPositionId())
                .append("resumeUrl", getResumeUrl())
                .append("recommendCompanyId", getRecommendCompanyId())
                .append("status", getStatus())
                .append("entryCompanyId", getEntryCompanyId())
                .append("createTime", getCreateTime())
                .toString();
    }
}
