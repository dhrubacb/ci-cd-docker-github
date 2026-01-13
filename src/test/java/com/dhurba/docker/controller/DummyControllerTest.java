package com.dhurba.docker.controller;

import com.dhurba.docker.dto.ModelDto;
import com.dhurba.docker.model.Model;
import com.dhurba.docker.service.DummyServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DummyController.class)
public class DummyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private DummyServiceImpl dummyService;

    @Test
    public void testCreate() throws Exception {
        mockMvc.perform(post("/model")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("\"CREATED\""));

        verify(dummyService).create(any(Model.class));
    }

    @Test
    public void testRead() throws Exception {
        ModelDto modelDto = new ModelDto("test-name");
        when(dummyService.fetchAll()).thenReturn(Collections.singletonList(modelDto));

        mockMvc.perform(get("/model")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("test-name"));

        verify(dummyService).fetchAll();
    }
}
