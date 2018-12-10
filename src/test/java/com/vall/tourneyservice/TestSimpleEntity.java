package com.vall.tourneyservice;

import com.vall.tourneyservice.config.DataSourceConfig;
import com.vall.tourneyservice.config.RepositoryConfiguration;
import com.vall.tourneyservice.model.PlayerChoice;
import com.vall.tourneyservice.model.Tourney;
import com.vall.tourneyservice.repository.PlayerChoiceRepository;
import com.vall.tourneyservice.repository.TourneyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureJdbc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.Assert.assertEquals;

/**
 * Created by alex.volosatov
 * Creation date 12/5/2018.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DataSourceConfig.class, RepositoryConfiguration.class})
@AutoConfigureJdbc
public class TestSimpleEntity {

    @Autowired
    private TourneyRepository tourneyRepository;

    @Autowired
    private PlayerChoiceRepository choiceRepository;

    @Test
    public void testReadAllTourneys() throws Exception {

        final List<Tourney> tourneys = StreamSupport.stream(tourneyRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

        assertEquals(3, tourneys.size());

        final Tourney oldTourney = Tourney.builder()
                .id(1L)
                .name("test tourney2")
                .isActive(false)
                .startDate(buildTimestamp("2018-02-03 05:05:06.0"))
                .finishDate(buildTimestamp("2018-03-03 05:05:06.0"))
                .build();

        assertEquals(oldTourney, tourneys.get(0));

    }

    @Test
    public void testReadChoices() throws Exception {
        List<PlayerChoice> choices = StreamSupport.stream(choiceRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

        assertEquals(1, choices.size());

        final PlayerChoice expected = PlayerChoice.builder()
                .id(1L)
                .memberID(10L)
                .tourneyID(2L)
                .participation(false)
                .actionDate(buildTimestamp("2018-12-05 05:05:06.0"))
                .build();

        assertEquals(expected, choices.get(0));
    }

    @Test
    public void testAllActiveTourneys() {

        final List<Tourney> tourneys = tourneyRepository.getAllActiveTourneys();

        assertEquals(1, tourneys.size());
        assertEquals("test tourney1", tourneys.get(0).getName());
    }


    @Test
    public void testAllPlayersTourneys() {

        final List<Tourney> tourneys = tourneyRepository.getAllPlayersTourneys(10L);

        assertEquals(1, tourneys.size());
        assertEquals("active tourney1", tourneys.get(0).getName());

    }

    private Timestamp buildTimestamp(String date) throws Exception {

        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd hh:mm:ss.S");

        Date parsedTimeStamp = dateFormat.parse(date);

        return new Timestamp(parsedTimeStamp.getTime());
    }
}
