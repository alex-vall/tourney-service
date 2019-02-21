package com.vall.tourneyservice.dto;

import com.vall.tourneyservice.model.Tourney;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Value;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex.volosatov
 * Creation date 1/28/2019.
 */

@Value
@Builder
public class TourneyResponse {

    //TODO: remove aggregation, just clone fields
    @Builder.Default
    private BaseResponse baseResponse = BaseResponse.builder().build();

    @Builder.Default
    private List<Tourney> tourneys = new ArrayList<>();

}
