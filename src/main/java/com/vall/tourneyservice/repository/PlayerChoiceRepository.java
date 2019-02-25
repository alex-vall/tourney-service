package com.vall.tourneyservice.repository;

import com.vall.tourneyservice.model.PlayerChoice;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by alex.volosatov
 * Creation date 12/7/2018.
 */
public interface PlayerChoiceRepository extends CrudRepository<PlayerChoice, Long> {


    @Query("SELECT * from player_choices  where member_id = :memberID and tourney_id = :tourneyID")
    PlayerChoice findByMemberIDAndTourneyID(@Param("memberID")long memberID, @Param("tourneyID")long tourneyID);



}
