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
    @Column("player_choiceid")
    private final Long player_choiceid; //TODO: deal with wrong naming in spring data

    @Column("memberid")
    private final long memberID;

    @Column("tourneyid")
    private final long tourneyID;

    @Wither
    private boolean participation;

    @Column("action_date")
    @Wither
    private Timestamp actionDate;

}
