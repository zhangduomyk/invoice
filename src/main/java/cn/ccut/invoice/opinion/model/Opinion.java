package cn.ccut.invoice.opinion.model;

public class Opinion {
    private Integer oid;

    private Integer uid;

    private String opinions;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getOpinions() {
        return opinions;
    }

    public void setOpinions(String opinions) {
        this.opinions = opinions == null ? null : opinions.trim();
    }
}