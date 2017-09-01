package com.affinitas.graziani;

import com.affinitas.graziani.util.BaseTest;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by matiasgraziani on 8/31/17.
 */
public class QuestionTest extends BaseTest {

    @Test
    public void testFindAll() throws Exception{
        ResultActions result = mockMvc.perform(get("/question").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk());
        result.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }
}
