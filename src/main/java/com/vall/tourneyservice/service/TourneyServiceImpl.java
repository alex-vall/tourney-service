package com.vall.tourneyservice.service;

import com.vall.tourneyservice.model.Tourney;
import com.vall.tourneyservice.repository.TourneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by alex.volosatov
 * Creation date 1/28/2019.
 */

@Service("tourneyService")
public class TourneyServiceImpl implements TourneyService {

    private TourneyRepository tourneyRepository;

    @Autowired
    public TourneyServiceImpl(TourneyRepository tourneyRepository) {
        this.tourneyRepository = tourneyRepository;
    }

    @Override
    public List<Tourney> getTourneyList(long playerID) {
        return tourneyRepository.getAllPlayersTourneys(playerID);
    }


}
