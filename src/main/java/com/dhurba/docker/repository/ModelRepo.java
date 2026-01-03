package com.dhurba.docker.repository;

import com.dhurba.docker.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepo extends JpaRepository<Model, String> {
}
