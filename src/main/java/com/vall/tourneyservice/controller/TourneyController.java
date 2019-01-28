package com.vall.tourneyservice.controller;

import com.vall.tourneyservice.dto.ResponseStatus;
import com.vall.tourneyservice.dto.TourneyResponse;
import com.vall.tourneyservice.service.TourneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by alex.volosatov
 * Creation date 12/10/2018.
 */

@RestController
public class TourneyController {

    private TourneyService tourneyService;

    @Autowired
    public TourneyController(TourneyService tourneyService) {
        this.tourneyService = tourneyService;
    }

    @GetMapping(value = "/tournaments/list")
    public TourneyResponse getTourneyList(@RequestParam(value = "playerid") long playerID) {

        if (playerID <= 0) {
            return TourneyResponse.builder().status(ResponseStatus.INVALID_MEMBER_ID.getStatus()).build();
        }

        return TourneyResponse.builder()
                .status(ResponseStatus.OK.getStatus())
                .tourneys(tourneyService.getTourneyList(playerID))
                .build();
    }

}
