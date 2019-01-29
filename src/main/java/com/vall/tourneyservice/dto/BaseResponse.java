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

    private long status;

}
