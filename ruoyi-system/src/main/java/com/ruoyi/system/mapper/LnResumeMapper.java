package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.LnResume;

import java.util.List;

/**
 * 个人简历Mapper接口
 *
 * @author mi
 * @date 2020-01-13
 */
public interface LnResumeMapper {

    /**
     * 查询所有求职者
     *
     * @param
     * @return 求职者姓名
     */
    public List<LnResume> selectAllPeople();


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
     * 删除个人简历
     *
     * @param id 个人简历ID
     * @return 结果
     */
    public int deleteLnResumeById(Integer id);

    /**
     * 批量删除个人简历
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLnResumeByIds(String[] ids);

    /**
     * 删除职位前判断是否有求职该职位
     *
     * @param positionId 职位ID
     * @return 结果
     */
    public int selectResumeResult(String positionId);
}
