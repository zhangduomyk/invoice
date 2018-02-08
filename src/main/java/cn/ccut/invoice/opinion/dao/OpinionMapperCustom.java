package cn.ccut.invoice.opinion.dao;

import cn.ccut.invoice.opinion.model.OpinionCustom;

import java.util.List;

public interface OpinionMapperCustom extends OpinionMapper{
    /**
     * 返回对应用户的总记录数
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
    public List<OpinionCustom> selectByLimit(int start, int pageSize);
}
