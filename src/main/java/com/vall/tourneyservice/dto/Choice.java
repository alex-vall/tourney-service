package com.vall.tourneyservice.dto;

import lombok.Getter;

/**
 * Created by alex.volosatov
 * Creation date 1/29/2019.
 */
public enum Choice {
    OPTIN (true),
    OPTOUT (false);

    @Getter
    private boolean participation;

    Choice(boolean participation) {
        this.participation = participation;
    }


}

