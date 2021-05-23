package com.decathlon.nps.repository;

import com.decathlon.nps.model.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, UUID> {

    Boolean existsByProject(String project);

    Survey getById(UUID id);

}
