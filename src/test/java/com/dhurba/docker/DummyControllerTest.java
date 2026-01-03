package com.dhurba.docker;

import com.dhurba.docker.controller.DummyController;
import com.dhurba.docker.repository.ModelRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

@ExtendWith(MockitoExtension.class)
public class DummyControllerTest {

    @Mock
    private ModelRepo modelRepo;

    @InjectMocks
    private DummyController dummyController;


    @Test
    public void testCreate() {
        Assertions.assertEquals(HttpStatus.OK, dummyController.create().getStatusCode());
    }

    @Test
    public void testRead() {
        Assertions.assertEquals(HttpStatus.OK, dummyController.read().getStatusCode());
    }
}
