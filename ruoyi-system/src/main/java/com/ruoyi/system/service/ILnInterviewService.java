package com.ruoyi.system.service;

import com.ruoyi.system.domain.LnInterview;

import java.util.List;

/**
 * 面试记录Service接口
 *
 * @author guzf
 * @date 2020-01-16
 */
public interface ILnInterviewService {
    /**
     * 查询面试记录
     *
     * @param id 面试记录ID
     * @return 面试记录
     */
    public LnInterview selectLnInterviewById(Long id);

    /**
     * 查询面试记录列表
     *
     * @param lnInterview 面试记录
     * @return 面试记录集合
     */
    public List<LnInterview> selectLnInterviewList(LnInterview lnInterview);

    /**
     * 新增面试记录
     *
     * @param lnInterview 面试记录
     * @return 结果
     */
    public int insertLnInterview(LnInterview lnInterview);

    /**
     * 修改面试记录
     *
     * @param lnInterview 面试记录
     * @return 结果
     */
    public int updateLnInterview(LnInterview lnInterview);

    /**
     * 批量删除面试记录
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLnInterviewByIds(String ids);

    /**
     * 删除面试记录信息
     *
     * @param id 面试记录ID
     * @return 结果
     */
    public int deleteLnInterviewById(Long id);
}
