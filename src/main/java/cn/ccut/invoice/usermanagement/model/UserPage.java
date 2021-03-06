package cn.ccut.invoice.usermanagement.model;

import java.util.List;

public class UserPage {
    //当前页码
    private int pageCode;
    //总记录数
    private int totalRecord;
    //页面大小
    private int pageSize;
    //当页数据
    private List<UserManagementCustom> list;

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

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        int totalPage = this.totalRecord/this.pageSize;
        return this.totalRecord%this.pageSize == 0?totalPage : totalPage + 1;
    }

    public List<UserManagementCustom> getList() {
        return list;
    }

    public void setList(List<UserManagementCustom> list) {
        this.list = list;
    }
}
