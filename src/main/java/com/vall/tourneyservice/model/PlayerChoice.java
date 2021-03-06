package com.vall.tourneyservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Wither;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Timestamp;

/**
 * Created by alex.volosatov
 * Creation date 12/7/2018.
 */

@Data
@AllArgsConstructor
@Table("player_choices")
@Builder
public class PlayerChoice {

    @Id
    @Wither
    @Column("choice_id")
    private final Long choiceID;

    @Column("member_id")
    private final long memberID;

    @Column("tourney_id")
    private final long tourneyID;

    @Wither
    private boolean participation;

    @Column("action_date")
    @Wither
    private Timestamp actionDate;

}
