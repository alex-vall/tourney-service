package com.vall.tourneyservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by alex.volosatov
 * Creation date 1/28/2019.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TourneyServiceApplication.class})
@AutoConfigureMockMvc
public class TestTourneyService {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testTourneyListNewMember() throws Exception {

        mockMvc.perform(
                get("/tournaments/list").param("playerid", "500")
        )
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().string(
                        "{\"status\":0," +
                                "\"tourneys\":" +
                                "[" +
                                "{\"id\":2,\"name\":\"test tourney1\",\"startDate\":\"2018-02-01T00:00:00.000+0000\",\"finishDate\":\"2025-02-01T00:00:00.000+0000\",\"active\":true}," +
                                "{\"id\":4,\"name\":\"active tourney1\",\"startDate\":\"2018-02-01T00:00:00.000+0000\",\"finishDate\":\"2025-02-01T00:00:00.000+0000\",\"active\":true}" +
                                "]}"
                ));

    }

    @Test
    public void testTourneyListWithExclusion() throws Exception {

        mockMvc.perform(
                get("/tournaments/list").param("playerid", "10")
        )
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().string(
                        "{\"status\":0," +
                                "\"tourneys\":" +
                                "[" +
                                "{\"id\":4,\"name\":\"active tourney1\",\"startDate\":\"2018-02-01T00:00:00.000+0000\",\"finishDate\":\"2025-02-01T00:00:00.000+0000\",\"active\":true}" +
                                "]}"
                ));

    }


    @Test
    public void testPlayerChoiceSaveNew() throws Exception {

        mockMvc.perform(
                get("/tournaments/player")
                        .param("playerid", "11")
                        .param("tournament", "2")
                        .param("choice", "OPTIN")
        )
                .andExpect(status().isOk())
                .andDo(print());

        //TODO: check if save applies

    }






}
