package com.wf.bean;

public class Teacher {
    private String tno;
    private String tname;
    private String tsex;

    public Teacher() {
    }

    public Teacher(String tno, String tname, String tsex) {
        this.tno = tno;
        this.tname = tname;
        this.tsex = tsex;
    }

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTsex() {
        return tsex;
    }

    public void setTsex(String tsex) {
        this.tsex = tsex;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tno='" + tno + '\'' +
                ", tname='" + tname + '\'' +
                ", tsex='" + tsex + '\'' +
                '}';
    }
}
