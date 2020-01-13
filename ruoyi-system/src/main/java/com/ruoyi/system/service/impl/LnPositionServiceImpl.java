package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.LnPositionMapper;
import com.ruoyi.system.domain.LnPosition;
import com.ruoyi.system.service.ILnPositionService;
import com.ruoyi.common.core.text.Convert;

/**
 * 职位Service业务层处理
 *
 * @author ruoyi
 * @date 2020-01-13
 */
@Service
public class LnPositionServiceImpl implements ILnPositionService {
    @Autowired
    private LnPositionMapper lnPositionMapper;

    /**
     * 查询职位
     *
     * @param positionId 职位ID
     * @return 职位
     */
    @Override
    public LnPosition selectLnPositionById(Integer positionId) {
        return lnPositionMapper.selectLnPositionById(positionId);
    }

    /**
     * 查询职位列表
     *
     * @param lnPosition 职位
     * @return 职位
     */
    @Override
    public List<LnPosition> selectLnPositionList(LnPosition lnPosition) {
        return lnPositionMapper.selectLnPositionList(lnPosition);
    }

    /**
     * 新增职位
     *
     * @param lnPosition 职位
     * @return 结果
     */
    @Override
    public int insertLnPosition(LnPosition lnPosition) {
        lnPosition.setCreateTime(DateUtils.getNowDate());
        return lnPositionMapper.insertLnPosition(lnPosition);
    }

    /**
     * 修改职位
     *
     * @param lnPosition 职位
     * @return 结果
     */
    @Override
    public int updateLnPosition(LnPosition lnPosition) {
        return lnPositionMapper.updateLnPosition(lnPosition);
    }

    /**
     * 删除职位对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLnPositionByIds(String ids) {
        return lnPositionMapper.deleteLnPositionByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除职位信息
     *
     * @param positionId 职位ID
     * @return 结果
     */
    @Override
    public int deleteLnPositionById(Integer positionId) {
        return lnPositionMapper.deleteLnPositionById(positionId);
    }
}
