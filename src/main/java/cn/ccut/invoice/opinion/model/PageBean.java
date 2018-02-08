package cn.ccut.invoice.opinion.model;

import java.util.List;

public class PageBean {
    //意见ID
    private int oid;
    //页码
    private int pageCode;
    //总记录数
    private int totalRecord;
    //每页记录数
    private int pageSize;
    //当页数据
    private List<OpinionCustom> list;

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getPageCode() {
        return pageCode;
    }

    public void setPageCode(int pageCode) {
        this.pageCode = pageCode;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getTotalPage() {
        int totalPage = totalRecord / pageSize;
        return totalRecord % pageSize == 0 ? totalPage : totalPage + 1;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<OpinionCustom> getList() {
        return list;
    }

    public void setList(List<OpinionCustom> list) {
        this.list = list;
    }
}
