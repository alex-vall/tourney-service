package com.vall.tourneyservice.dto;

/**
 * Created by alex.volosatov
 * Creation date 1/28/2019.
 */
public enum ResponseStatus {

    OK(0),
    INVALID_MEMBER_ID (100);


    private long status;

    ResponseStatus(long status) {
        this.status = status;
    }

    public long getStatus() {
        return status;
    }}
