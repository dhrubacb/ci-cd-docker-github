package com.dhurba.docker.service;

import com.dhurba.docker.dto.ModelDto;
import com.dhurba.docker.model.Model;

import java.util.List;

public interface DummyService {

    void create(Model model);

    List<ModelDto> fetchAll();
}
