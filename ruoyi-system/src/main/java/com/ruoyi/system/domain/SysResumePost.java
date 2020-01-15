package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 简历与企业关联对象 sys_resume_post
 *
 * @author mi
 * @date 2020-01-15
 */
public class SysResumePost {
    private static final long serialVersionUID = 1L;

    /** 简历ID */
    private Long resumeId;

    /** 合作企业ID */
    private Long companyId;

    public void setResumeId(Long resumeId)
    {
        this.resumeId = resumeId;
    }

    public Long getResumeId()
    {
        return resumeId;
    }
    public void setCompanyId(Long companyId)
    {
        this.companyId = companyId;
    }

    public Long getCompanyId()
    {
        return companyId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("resumeId", getResumeId())
                .append("companyId", getCompanyId())
                .toString();
    }

}
