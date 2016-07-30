package com.myobit.domain;

/**
 * Created by Phillip on 7/29/2016.
 */
public enum ObitStatus {

    DRAFT("DRAFT"),
    FINAL("FINAL");

    public String status;

    ObitStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
