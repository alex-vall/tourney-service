package com.vall.tourneyservice.dto;

import lombok.Builder;
import lombok.Value;

/**
 * Created by alex.volosatov
 * Creation date 1/29/2019.
 */

@Value
@Builder
public class BaseResponse {

    @Builder.Default
    private long status = ResponseStatus.OK.getStatus();

    @Builder.Default
    private String error = "";

}
