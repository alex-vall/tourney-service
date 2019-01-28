package com.vall.tourneyservice.dto;

import com.vall.tourneyservice.model.Tourney;
import lombok.Builder;
import lombok.Value;

import java.util.List;

/**
 * Created by alex.volosatov
 * Creation date 1/28/2019.
 */

@Value
@Builder
public class TourneyResponse {

    private long status;

    private List<Tourney> tourneys;

}
