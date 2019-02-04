package com.vall.tourneyservice.service;

import com.vall.tourneyservice.dto.Choice;
import com.vall.tourneyservice.model.PlayerChoice;
import com.vall.tourneyservice.model.Tourney;
import com.vall.tourneyservice.repository.PlayerChoiceRepository;
import com.vall.tourneyservice.repository.TourneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

/**
 * Created by alex.volosatov
 * Creation date 1/28/2019.
 */

@Service("tourneyService")
public class TourneyServiceImpl implements TourneyService {

    private TourneyRepository tourneyRepository;
    private PlayerChoiceRepository playerChoiceRepository;

    @Autowired
    public TourneyServiceImpl(TourneyRepository tourneyRepository, PlayerChoiceRepository playerChoiceRepository) {
        this.tourneyRepository = tourneyRepository;
        this.playerChoiceRepository = playerChoiceRepository;
    }

    @Override
    public List<Tourney> getTourneyList(long playerID) {
        return tourneyRepository.getAllPlayersTourneys(playerID);
    }

    @Override
    public void playerChoice(long memberID, long tourneyID, Choice choice) {

        final PlayerChoice playerChoice = Optional.ofNullable(playerChoiceRepository.findByMemberIDAndTourneyID(memberID, tourneyID))
                .map(existing -> existing
                        .withParticipation(choice.isParticipation())
                        .withActionDate(new Timestamp(System.currentTimeMillis()))
                )
                .orElse(PlayerChoice.builder()
                        .memberID(memberID)
                        .tourneyID(tourneyID)
                        .participation(choice.isParticipation())
                        .actionDate(new Timestamp(System.currentTimeMillis()))
                        .build());

        playerChoiceRepository.save(playerChoice);

    }
}
