package com.ruoyi.system.service;

import com.ruoyi.system.domain.LnResume;

import java.util.List;

/**
 * 个人简历Service接口
 *
 * @author mi
 * @date 2020-01-13
 */
public interface ILnResumeService {

    /**
     * 查询个人简历
     *
     * @param id 个人简历ID
     * @return 个人简历
     */
    public LnResume selectLnResumeById(Integer id);

    /**
     * 查询个人简历列表
     *
     * @param lnResume 个人简历
     * @return 个人简历集合
     */
    public List<LnResume> selectLnResumeList(LnResume lnResume);

    /**
     * 新增个人简历
     *
     * @param lnResume 个人简历
     * @return 结果
     */
    public int insertLnResume(LnResume lnResume);

    /**
     * 修改个人简历
     *
     * @param lnResume 个人简历
     * @return 结果
     */
    public int updateLnResume(LnResume lnResume);

    /**
     * 批量删除个人简历
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLnResumeByIds(String ids);

    /**
     * 删除个人简历信息
     *
     * @param id 个人简历ID
     * @return 结果
     */
    public int deleteLnResumeById(Integer id);
}
