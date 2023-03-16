package com.example.sqlitedatabase;

public class CongViec {
    private int IDCV;
    private String TenCV;

    public CongViec(int IDCV, String tenCV) {
        this.IDCV = IDCV;
        TenCV = tenCV;
    }

    public int getIDCV() {
        return IDCV;
    }

    public void setIDCV(int IDCV) {
        this.IDCV = IDCV;
    }

    public String getTenCV() {
        return TenCV;
    }

    public void setTenCV(String tenCV) {
        TenCV = tenCV;
    }
}
