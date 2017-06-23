package com.wy.standard.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.wy.standard.model.VisitCountDay;
@Mapper
public interface VisitCountDayDao {
    int deleteByPrimaryKey(Integer id);

    int insert(VisitCountDay record);

    int insertSelective(VisitCountDay record);

    VisitCountDay selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(VisitCountDay record);

    int updateByPrimaryKey(VisitCountDay record);
    
    List<VisitCountDay> getList(Map<String,Object> modal);
}