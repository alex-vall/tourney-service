package com.vall.tourneyservice.dto;

import lombok.Getter;

/**
 * Created by alex.volosatov
 * Creation date 1/28/2019.
 */
public enum ResponseStatus {

    OK(0),
    INVALID_MEMBER_ID (100),
    INVALID_TOURNEY_ID (101);

    @Getter
    private long status;

    ResponseStatus(long status) {
        this.status = status;
    }

}
