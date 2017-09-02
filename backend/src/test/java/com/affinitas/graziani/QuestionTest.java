package com.affinitas.graziani;

import com.affinitas.graziani.domain.Question;
import com.affinitas.graziani.util.BaseTest;
import com.fasterxml.jackson.databind.JavaType;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by matiasgraziani on 8/31/17.
 */
public class QuestionTest extends BaseTest {

    @Override
    public void initTest() {
        try{
            initJsonToModel();
        }catch (Exception e){
            fail("Fail to initialize data");
        }
    }

    @Test
    public void testFindAll() throws Exception{
        ResultActions result = mockMvc.perform(get("/question").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk());
        result.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));

        String content = result.andReturn().getResponse().getContentAsString();

        JavaType type = objectMapper.getTypeFactory().constructCollectionType(List.class, Question.class);
        List<Question> arrayOfT = objectMapper.readValue(content, type);

        assertEquals(25, arrayOfT.size());
        assertEquals("single_choice", arrayOfT.get(0).getQuestionType().getQuestionType() );
    }
}
