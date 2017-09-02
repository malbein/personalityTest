package com.affinitas.graziani;

import com.affinitas.graziani.util.BaseTest;
import com.fasterxml.jackson.databind.JavaType;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.Assert.assertEquals;

/**
 * Created by matiasgraziani on 9/1/17.
 */
public class CategoryTest extends BaseTest {

    @Test
    public void testFindAll() throws Exception{
        ResultActions result = mockMvc.perform(get("/category").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk());
        result.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));

        String content = result.andReturn().getResponse().getContentAsString();

        JavaType type = objectMapper.getTypeFactory().constructCollectionType(List.class, String.class);
        List<String> arrayOfT = objectMapper.readValue(content, type);

        assertEquals(arrayOfT.size(), 4);
    }
}
