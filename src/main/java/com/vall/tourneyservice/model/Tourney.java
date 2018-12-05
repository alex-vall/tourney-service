package com.vall.tourneyservice.model;

import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Timestamp;


/**
 * Created by alex.volosatov
 * Creation date 12/4/2018.
 */

@Value
@Table("tourneys")
@Builder
public class Tourney {

    @Id
    @Column("tourneyid")
    private  Long id;

    private String name;

    @Column("is_active")
    private boolean isActive;

    @Column("start_date")
    private Timestamp startDate;

    @Column("finish_date")
    private Timestamp finishDate;

}
