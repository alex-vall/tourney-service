package com.vall.tourneyservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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

        assertNotNull(mockMvc);

        MvcResult result = mockMvc.perform(
                get("/tournaments/list").param("playerid", "500")
        )
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        //TODO: split controller tests and logic tests

    }


}
