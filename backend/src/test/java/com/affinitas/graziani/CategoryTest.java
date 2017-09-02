package com.affinitas.graziani;

import com.affinitas.graziani.util.BaseTest;
import com.fasterxml.jackson.databind.JavaType;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.Assert.assertEquals;

/**
 * Created by matiasgraziani on 9/1/17.
 */
public class CategoryTest extends BaseTest {

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
        ResultActions result = mockMvc.perform(get("/category").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk());
        result.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));

        String content = result.andReturn().getResponse().getContentAsString();

        JavaType type = objectMapper.getTypeFactory().constructCollectionType(List.class, String.class);
        List<String> arrayOfT = objectMapper.readValue(content, type);

        assertEquals(4, arrayOfT.size());
        assertTrue("Category hard_fact",arrayOfT.contains("hard_fact"));
        assertTrue("Category lifestyle",arrayOfT.contains("lifestyle"));
        assertTrue("Category introversion",arrayOfT.contains("introversion"));
        assertTrue("Category passion",arrayOfT.contains("passion"));
    }

}
