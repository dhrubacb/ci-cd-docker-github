package com.dhurba.docker.controller;

import com.dhurba.docker.dto.ModelDto;
import com.dhurba.docker.model.Model;
import com.dhurba.docker.service.DummyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/model")
public class DummyController {

    private final DummyService dummyService;

    public DummyController(DummyService dummyService) {
        this.dummyService = dummyService;
    }

    @PostMapping()
    public ResponseEntity<HttpStatus> create() {
        Model model = new Model();
        model.setName("Model_Name" + Math.abs(new Random().nextInt()));
        dummyService.create(model);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<ModelDto>> read() {
        return ResponseEntity.ok(dummyService.fetchAll());
    }


}
