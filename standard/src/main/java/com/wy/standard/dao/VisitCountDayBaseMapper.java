package com.wy.standard.dao;

import org.apache.ibatis.annotations.Mapper;

import com.wy.standard.model.VisitCountDayBase;
@Mapper
public interface VisitCountDayBaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(VisitCountDayBase record);

    int insertSelective(VisitCountDayBase record);

    VisitCountDayBase selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(VisitCountDayBase record);

    int updateByPrimaryKey(VisitCountDayBase record);
}