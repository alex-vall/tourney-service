package com.vall.tourneyservice.controller;

import com.vall.tourneyservice.dto.BaseResponse;
import com.vall.tourneyservice.dto.Choice;
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
    public TourneyResponse getTourneyList(@RequestParam("playerid") long playerID) {

        if (playerID <= 0) {
            return TourneyResponse.builder().status(ResponseStatus.INVALID_MEMBER_ID.getStatus()).build();
        }

        return TourneyResponse.builder()
                .status(ResponseStatus.OK.getStatus())
                .tourneys(tourneyService.getTourneyList(playerID))
                .build();
    }

    @GetMapping("/tournaments/player")
    public BaseResponse playerChoice(@RequestParam("playerid") long playerID,
                                     @RequestParam("tournament") long tourneyID,
                                     @RequestParam("choice") Choice choice) {

        if (playerID <= 0) {
            return BaseResponse.builder().status(ResponseStatus.INVALID_MEMBER_ID.getStatus()).build();
        }

        if (tourneyID <= 0) {
            return BaseResponse.builder().status(ResponseStatus.INVALID_TOURNEY_ID.getStatus()).build();
        }

        tourneyService.playerChoice(playerID, tourneyID, choice);

        return BaseResponse.builder()
                .status(ResponseStatus.OK.getStatus())
                .build();
    }


}
