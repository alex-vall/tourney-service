package com.vall.tourneyservice.repository;

import com.vall.tourneyservice.model.Tourney;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by alex.volosatov
 * Creation date 12/5/2018.
 */
public interface TourneyRepository extends CrudRepository<Tourney, Long> {


}
