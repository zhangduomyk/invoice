package cn.ccut.invoice.criticism.dao;

import cn.ccut.invoice.criticism.model.CriticismCustom;

import java.util.List;

public interface CriticismMapperCustom extends CriticismMapper {
    /**
     * 返回对应用户的总记录数
     *
     * @return
     */
    public int selectAllCount();

    /**
     * 分页的查询
     *
     * @param start
     * @param pageSize
     * @return
     */
    public List<CriticismCustom> selectByLimit(int start, int pageSize);
}
