package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.LnIndustryMapper;
import com.ruoyi.system.domain.LnIndustry;
import com.ruoyi.system.service.ILnIndustryService;
import com.ruoyi.common.core.text.Convert;

/**
 * 行业Service业务层处理
 *
 * @author guzf
 * @date 2020-01-13
 */
@Service("industry")
public class LnIndustryServiceImpl implements ILnIndustryService {
    @Autowired
    private LnIndustryMapper lnIndustryMapper;


    /**
     * 查询行业数据信息
     *
     * @param
     * @return 行业信息
     */
    public List<LnIndustry> selectIndustry() {
        return lnIndustryMapper.selectIndustry();
    }


    /**
     * 查询行业
     *
     * @param industryId 行业ID
     * @return 行业
     */
    @Override
    public LnIndustry selectLnIndustryById(Long industryId) {
        return lnIndustryMapper.selectLnIndustryById(industryId);
    }

    /**
     * 查询行业列表
     *
     * @param lnIndustry 行业
     * @return 行业
     */
    @Override
    public List<LnIndustry> selectLnIndustryList(LnIndustry lnIndustry) {
        return lnIndustryMapper.selectLnIndustryList(lnIndustry);
    }

    /**
     * 查询行业名称
     *
     * @param industryName 行业名称
     * @return 结果
     */
    @Override
    public int checkIndustryName(String industryName) {
        return lnIndustryMapper.checkIndustryName(industryName);
    }

    /**
     * 新增行业
     *
     * @param lnIndustry 行业
     * @return 结果
     */
    @Override
    public int insertLnIndustry(LnIndustry lnIndustry) {
        lnIndustry.setCreateTime(DateUtils.getNowDate());
        return lnIndustryMapper.insertLnIndustry(lnIndustry);
    }

    /**
     * 修改行业
     *
     * @param lnIndustry 行业
     * @return 结果
     */
    @Override
    public int updateLnIndustry(LnIndustry lnIndustry) {
        return lnIndustryMapper.updateLnIndustry(lnIndustry);
    }

    /**
     * 删除行业对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLnIndustryByIds(String ids) {
        return lnIndustryMapper.deleteLnIndustryByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除行业信息
     *
     * @param industryId 行业ID
     * @return 结果
     */
    @Override
    public int deleteLnIndustryById(Long industryId) {
        return lnIndustryMapper.deleteLnIndustryById(industryId);
    }
}
