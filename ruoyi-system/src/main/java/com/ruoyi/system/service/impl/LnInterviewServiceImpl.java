package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.LnInterviewMapper;
import com.ruoyi.system.domain.LnInterview;
import com.ruoyi.system.service.ILnInterviewService;
import com.ruoyi.common.core.text.Convert;

/**
 * 面试记录Service业务层处理
 *
 * @author guzf
 * @date 2020-01-16
 */
@Service
public class LnInterviewServiceImpl implements ILnInterviewService {
    @Autowired
    private LnInterviewMapper lnInterviewMapper;

    /**
     * 查询面试记录
     *
     * @param id 面试记录ID
     * @return 面试记录
     */
    @Override
    public LnInterview selectLnInterviewById(Long id) {
        return lnInterviewMapper.selectLnInterviewById(id);
    }

    /**
     * 查询面试记录列表
     *
     * @param lnInterview 面试记录
     * @return 面试记录
     */
    @Override
    public List<LnInterview> selectLnInterviewList(LnInterview lnInterview) {
        return lnInterviewMapper.selectLnInterviewList(lnInterview);
    }

    /**
     * 新增面试记录
     *
     * @param lnInterview 面试记录
     * @return 结果
     */
    @Override
    public int insertLnInterview(LnInterview lnInterview) {
        lnInterview.setCreateTime(DateUtils.getNowDate());
        return lnInterviewMapper.insertLnInterview(lnInterview);
    }

    /**
     * 修改面试记录
     *
     * @param lnInterview 面试记录
     * @return 结果
     */
    @Override
    public int updateLnInterview(LnInterview lnInterview) {
        return lnInterviewMapper.updateLnInterview(lnInterview);
    }

    /**
     * 删除面试记录对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLnInterviewByIds(String ids) {
        return lnInterviewMapper.deleteLnInterviewByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除面试记录信息
     *
     * @param id 面试记录ID
     * @return 结果
     */
    @Override
    public int deleteLnInterviewById(Long id) {
        return lnInterviewMapper.deleteLnInterviewById(id);
    }
}
