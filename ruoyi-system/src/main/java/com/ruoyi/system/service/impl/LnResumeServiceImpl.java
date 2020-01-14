package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.LnResume;
import com.ruoyi.system.mapper.LnResumeMapper;
import com.ruoyi.system.service.ILnResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 个人简历Service业务层处理
 *
 * @author mi
 * @date 2020-01-13
 */
@Service
public class LnResumeServiceImpl implements ILnResumeService {
    @Autowired
    private LnResumeMapper lnResumeMapper;

    /**
     * 查询个人简历
     *
     * @param id 个人简历ID
     * @return 个人简历
     */
    @Override
    public LnResume selectLnResumeById(Integer id)
    {
        return lnResumeMapper.selectLnResumeById(id);
    }

    /**
     * 查询个人简历列表
     *
     * @param lnResume 个人简历
     * @return 个人简历
     */
    @Override
    public List<LnResume> selectLnResumeList(LnResume lnResume)
    {
        return lnResumeMapper.selectLnResumeList(lnResume);
    }

    /**
     * 新增个人简历
     *
     * @param lnResume 个人简历
     * @return 结果
     */
    @Override
    public int insertLnResume(LnResume lnResume)
    {
        lnResume.setCreateTime(DateUtils.getNowDate());
        return lnResumeMapper.insertLnResume(lnResume);
    }

    /**
     * 修改个人简历
     *
     * @param lnResume 个人简历
     * @return 结果
     */
    @Override
    public int updateLnResume(LnResume lnResume)
    {
        return lnResumeMapper.updateLnResume(lnResume);
    }

    /**
     * 删除个人简历对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLnResumeByIds(String ids)
    {
        return lnResumeMapper.deleteLnResumeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除个人简历信息
     *
     * @param id 个人简历ID
     * @return 结果
     */
    @Override
    public int deleteLnResumeById(Integer id)
    {
        return lnResumeMapper.deleteLnResumeById(id);
    }
}
