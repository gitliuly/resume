package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.LnIndustry;

import java.util.List;

/**
 * 行业Mapper接口
 *
 * @author ruoyi
 * @date 2020-01-13
 */
public interface LnIndustryMapper {

    /**
     * 查询行业数据信息
     *
     * @param
     * @return 行业信息
     */
    public List<LnIndustry> selectIndustry();

    /**
     * 查询行业
     *
     * @param industryId 行业ID
     * @return 行业
     */
    public LnIndustry selectLnIndustryById(Long industryId);

    /**
     * 查询行业列表
     *
     * @param lnIndustry 行业
     * @return 行业集合
     */
    public List<LnIndustry> selectLnIndustryList(LnIndustry lnIndustry);

    /**
     * 新增行业
     *
     * @param lnIndustry 行业
     * @return 结果
     */
    public int insertLnIndustry(LnIndustry lnIndustry);

    /**
     * 修改行业
     *
     * @param lnIndustry 行业
     * @return 结果
     */
    public int updateLnIndustry(LnIndustry lnIndustry);

    /**
     * 删除行业
     *
     * @param industryId 行业ID
     * @return 结果
     */
    public int deleteLnIndustryById(Long industryId);

    /**
     * 批量删除行业
     *
     * @param industryIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteLnIndustryByIds(String[] industryIds);
}
