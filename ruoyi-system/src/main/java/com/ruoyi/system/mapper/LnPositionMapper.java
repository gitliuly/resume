package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.LnPosition;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 职位Mapper接口
 *
 * @author guzf
 * @date 2020-01-13
 */
public interface LnPositionMapper {
    /**
     * 查询职位
     *
     * @param positionId 职位ID
     * @return 职位
     */
    public LnPosition selectLnPositionById(Integer positionId);

    /**
     * 查询职位列表
     *
     * @param lnPosition 职位
     * @return 职位集合
     */
    public List<LnPosition> selectLnPositionList(LnPosition lnPosition);

    /**
     * 查询职位名称
     *
     * @param positionName 职位名称
     * @return 结果
     */
    public int checkPositionName(@Param("positionName") String positionName, @Param("industryId") Long industryId);

    /**
     * 新增职位
     *
     * @param lnPosition 职位
     * @return 结果
     */
    public int insertLnPosition(LnPosition lnPosition);

    /**
     * 修改职位
     *
     * @param lnPosition 职位
     * @return 结果
     */
    public int updateLnPosition(LnPosition lnPosition);

    /**
     * 删除职位
     *
     * @param positionId 职位ID
     * @return 结果
     */
    public int deleteLnPositionById(Integer positionId);

    /**
     * 批量删除职位
     *
     * @param positionIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteLnPositionByIds(String[] positionIds);

    /**
     * 删除行业前判断是否存在子目录（职位）
     *
     * @param industryId 需要删除的行业ID
     * @return 结果
     */
    public int selectPositionResult(String industryId);


}
