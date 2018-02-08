package cn.ccut.invoice.opinion.dao;

import cn.ccut.invoice.opinion.model.Opinion;

public interface OpinionMapper {
    int deleteByPrimaryKey(Integer oid);

    int insert(Opinion record);

    int insertSelective(Opinion record);

    Opinion selectByPrimaryKey(Integer oid);

    int updateByPrimaryKeySelective(Opinion record);

    int updateByPrimaryKeyWithBLOBs(Opinion record);

    int updateByPrimaryKey(Opinion record);
}