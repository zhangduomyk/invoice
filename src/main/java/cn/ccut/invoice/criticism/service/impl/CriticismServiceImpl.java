package cn.ccut.invoice.criticism.service.impl;

import cn.ccut.invoice.criticism.dao.CriticismMapperCustom;
import cn.ccut.invoice.criticism.model.Criticism;
import cn.ccut.invoice.criticism.model.CriticismCustom;
import cn.ccut.invoice.criticism.model.PageBean;
import cn.ccut.invoice.criticism.service.CriticismService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "criticismServiceImpl")
public class CriticismServiceImpl implements CriticismService {

    @Autowired
    private CriticismMapperCustom criticismMapperCustom;

    /**
     * 添加单条评论
     *
     * @param criticism
     * @throws Exception
     */
    public void insertOneRecord(Criticism criticism) throws Exception {
        criticismMapperCustom.insertSelective(criticism);
    }

    /**
     * 分页查询所有记录
     *
     * @param pageCode
     * @param pageSize
     * @return
     * @throws Exception
     */
    public PageBean selectAll(int pageCode, int pageSize) throws Exception {
        PageBean pageBean = new PageBean();
        pageBean.setPageCode(pageCode);
        pageBean.setPageSize(pageSize);
        int total = criticismMapperCustom.selectAllCount();
        pageBean.setTotalRecord(total);
        List<CriticismCustom> list = criticismMapperCustom.selectByLimit((pageCode - 1) * pageSize, pageSize);
        pageBean.setList(list);
        return pageBean;
    }

    public void deleteOneRecord(Integer cid) throws Exception {
        criticismMapperCustom.deleteByPrimaryKey(cid);
    }
}
