package de.codecentric.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.codecentric.domain.Developer;

@Repository
public interface DeveloperRepository extends CrudRepository<Developer, Long> {
}