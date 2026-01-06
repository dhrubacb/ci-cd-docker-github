package com.dhurba.docker.service;

import com.dhurba.docker.dto.ModelDto;
import com.dhurba.docker.model.Model;
import com.dhurba.docker.repository.ModelRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DummyServiceImpl implements DummyService {
    private final ModelRepo modelRepo;

    public DummyServiceImpl(ModelRepo modelRepo) {
        this.modelRepo = modelRepo;
    }

    @Override
    public void create(Model model) {
        modelRepo.save(model);
    }

    @Override
    public List<ModelDto> fetchAll() {
        return modelRepo.findAll().stream().map(model -> new ModelDto(model.getName())).toList();
    }
}
