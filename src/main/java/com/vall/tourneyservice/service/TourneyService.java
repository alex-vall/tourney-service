package com.vall.tourneyservice.service;

import com.vall.tourneyservice.model.Tourney;

import java.util.List;

/**
 * Created by alex.volosatov
 * Creation date 1/28/2019.
 */
public interface TourneyService {

    List<Tourney> getTourneyList(long memberID);

}
