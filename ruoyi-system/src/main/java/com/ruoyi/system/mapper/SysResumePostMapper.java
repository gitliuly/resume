package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.SysResumePost;

import java.util.List;

/**
 * 简历与企业关联Mapper接口
 *
 * @author mi
 * @date 2020-01-15
 */
public interface SysResumePostMapper {


    /**
     * 删除简历与企业关联
     *
     * @param resumeId 简历与企业关联ID
     * @return 结果
     */
    public int deleteSysResumePostById(Integer resumeId);
    /**
     * 通过企业ID查询企业使用数量
     *
     * @param companyId 企业ID
     * @return 结果
     */
    public int countResumePostById(Long companyId);
    /**
     * 批量新增信息
     *
     * @param sysResumePostList
     * @return 结果
     */
    public int batchResumePost(List<SysResumePost> sysResumePostList);
}
