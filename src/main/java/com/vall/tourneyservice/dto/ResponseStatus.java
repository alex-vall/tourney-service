package com.vall.tourneyservice.dto;

import lombok.Getter;

/**
 * Created by alex.volosatov
 * Creation date 1/28/2019.
 */
public enum ResponseStatus {

    OK(0),
    MANDATORY_FIELD(100),
    INVALID_ID_VALUE(101),
    INVALID_TOURNEY_ID (102),
    TYPE_MISMATCH(103),
    SERVER_ERROR(500);

    @Getter
    private long status;

    ResponseStatus(long status) {
        this.status = status;
    }

}
