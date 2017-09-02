package com.affinitas.graziani;

import com.affinitas.graziani.domain.Answer;
import com.affinitas.graziani.domain.Question;
import com.affinitas.graziani.dto.AnswerDTO;
import com.affinitas.graziani.repository.AnswerRepository;
import com.affinitas.graziani.repository.QuestionRepository;
import com.affinitas.graziani.util.BaseTest;
import com.fasterxml.jackson.databind.JavaType;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by mgraz1 on 9/1/17.
 */
public class AnswerTest extends BaseTest{

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public void initTest() {
        try{
            initJsonToModel();
        }catch (Exception e){
            fail("Fail to initialize data");
        }
    }

    @Test
    public void testSave() throws Exception{
        AnswerDTO answerDTO = new AnswerDTO();
        answerDTO.setAnswer("test answer");
        answerDTO.setQuestion(1L);

        mockMvc.perform(post("/answer").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(objectMapper.writeValueAsString(answerDTO)))
                .andExpect(status().isCreated());

        List<Answer> answers = answerRepository.findAll();

        assertEquals(1, answers.size());
        assertEquals("test answer", answers.get(0).getAnswer() );
        assertTrue(1L == answers.get(0).getQuestion().getId());
    }

    @Test
    public void testList() throws Exception{
        Question question = questionRepository.getOne(1L);
        Answer answer = new Answer();
        answer.setAnswer("test answer");
        answer.setQuestion(question);

        answerRepository.save(answer);

        ResultActions result = mockMvc.perform(get("/answer").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk());
        result.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));

        String content = result.andReturn().getResponse().getContentAsString();

        JavaType type = objectMapper.getTypeFactory().constructCollectionType(List.class, AnswerDTO.class);
        List<AnswerDTO> arrayOfT = objectMapper.readValue(content, type);

        assertEquals(1, arrayOfT.size());
        assertEquals("test answer", arrayOfT.get(0).getAnswer() );
        assertTrue(1L == arrayOfT.get(0).getQuestion());
    }
}
