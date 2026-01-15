package com.dhurba.docker.service;

import com.dhurba.docker.dto.ModelDto;
import com.dhurba.docker.model.Model;
import com.dhurba.docker.repository.ModelRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DummyServiceTest {
    @InjectMocks
    DummyServiceImpl dummyService;
    @Mock
    ModelRepo modelRepo;

    @Test
    void fetchAll() {
        when(modelRepo.findAll()).thenReturn(Collections.singletonList(createModel()));
        List<ModelDto> modelDtos = dummyService.fetchAll();
        verify(modelRepo).findAll();
        assert modelDtos.size() == 1;
    }

    private Model createModel() {
        Model model = new Model();
        model.setName("test");
        model.setId("test-id");
        return model;
    }

    @Test
    void create() {
        when(modelRepo.save(any())).thenReturn(createModel());
        dummyService.create(new Model());
        verify(modelRepo).save(any(Model.class));
    }
}
