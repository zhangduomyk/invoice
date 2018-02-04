package cn.ccut.invoice.criticism.model;

import java.util.List;

public class PageBean {
    //评论ID
    private int cid;
    //页码
    private int pageCode;
    //总记录数
    private int totalRecord;
    //每页记录数
    private int pageSize;
    //当页数据
    private List<CriticismCustom> list;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
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

    public List<CriticismCustom> getList() {
        return list;
    }

    public void setList(List<CriticismCustom> list) {
        this.list = list;
    }
}
