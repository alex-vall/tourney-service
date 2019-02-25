package com.vall.tourneyservice.repository;

import com.vall.tourneyservice.model.Tourney;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by alex.volosatov
 * Creation date 12/5/2018.
 */
public interface TourneyRepository extends CrudRepository<Tourney, Long> {


    @Query("SELECT * from tourneys where is_active=true")
    List<Tourney> getAllActiveTourneys();


    @Query("SELECT ts.* " +
            "from tourneys ts " +
            "LEFT JOIN player_choices pc ON ts.tourney_id = pc.tourney_id and pc.member_id = :memberID " +
            "WHERE (pc.tourney_id IS NULL OR pc.participation = true) AND ts.is_active = true")
    List<Tourney> getAllPlayersTourneys(@Param("memberID") long memberID);


}
