package com.dhurba.docker.controller;

import com.dhurba.docker.model.Model;
import com.dhurba.docker.repository.ModelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/model")
public class DummyController {
    @Autowired
    ModelRepo modelRepo;

    @PostMapping()
    public ResponseEntity<HttpStatus> create() {
        Model model = new Model();
        model.setName("dummy");
        modelRepo.save(model);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<ModelDto>> read() {
        return ResponseEntity.ok(modelRepo.findAll().stream().map(model -> new ModelDto(model.getName())).toList());
    }

    public record ModelDto(String name) {
    }
}
