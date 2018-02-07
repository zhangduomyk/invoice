package cn.ccut.invoice.criticism.service;

import cn.ccut.invoice.criticism.model.CriticismCustom;
import cn.ccut.invoice.criticism.model.PageBean;

public interface CriticismService {

    /**
     * 添加单条评论
     *
     * @param criticismCustom
     * @throws Exception
     */
    public void insertOneRecord(CriticismCustom criticismCustom) throws Exception;

    /**
     * 查询所有评论
     *
     * @param pageCode
     * @param pageSize
     * @return
     * @throws Exception
     */
    public PageBean selectAll(int pageCode, int pageSize) throws Exception;

    /**
     * 删除单条评论
     *
     * @param cid
     * @throws Exception
     */
    public void deleteOneRecord(Integer cid) throws Exception;
}
