package cn.ccut.invoice.opinion.service.impl;

import cn.ccut.invoice.opinion.dao.OpinionMapperCustom;
import cn.ccut.invoice.opinion.model.OpinionCustom;
import cn.ccut.invoice.opinion.model.PageBean;
import cn.ccut.invoice.opinion.service.OpinionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "opinionServiceImpl")
public class OpinionServiceImpl implements OpinionService{

    @Autowired
    private OpinionMapperCustom opinionMapperCustom;

    public void insertOneRecord(OpinionCustom opinionCustom) throws Exception {
        opinionMapperCustom.insertSelective(opinionCustom);
    }

    public PageBean selectAll(int pageCode, int pageSize) throws Exception {
        PageBean pageBean = new PageBean();
        pageBean.setPageCode(pageCode);
        pageBean.setPageSize(pageSize);
        int total = opinionMapperCustom.selectAllCount();
        pageBean.setTotalRecord(total);
        List<OpinionCustom> list = opinionMapperCustom.selectByLimit((pageCode - 1) * pageSize, pageSize);
        pageBean.setList(list);
        return pageBean;
    }
}
