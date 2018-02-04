package cn.ccut.invoice.criticism.dao;

import cn.ccut.invoice.criticism.model.Criticism;

public interface CriticismMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(Criticism record);

    int insertSelective(Criticism record);

    Criticism selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(Criticism record);

    int updateByPrimaryKeyWithBLOBs(Criticism record);

    int updateByPrimaryKey(Criticism record);
}