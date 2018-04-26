package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entities.Societe;

@RepositoryRestResource
public interface ISocieteRepository extends JpaRepository<Societe, Long>{

}
