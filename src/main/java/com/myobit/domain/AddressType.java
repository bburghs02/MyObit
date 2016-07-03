package com.myobit.domain;

/**
 * Created by Phillip on 6/19/2016.
 */
public enum AddressType {

    HOME("Home"),
    VACATION("Vacation"),
    SENIOR_CARE("Senior Care");

    private String type;

    AddressType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
