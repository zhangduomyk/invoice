package cn.ccut.invoice.opinion.service;

import cn.ccut.invoice.opinion.model.OpinionCustom;
import cn.ccut.invoice.opinion.model.PageBean;

public interface OpinionService {
    /**
     * 添加单条意见
     * @param opinionCustom
     * @throws Exception
     */
    public void insertOneRecord(OpinionCustom opinionCustom) throws Exception;

    /**
     * 分页查询
     * @param pageCode
     * @param pageSize
     * @return
     * @throws Exception
     */
    public PageBean selectAll(int pageCode, int pageSize) throws Exception;
}
