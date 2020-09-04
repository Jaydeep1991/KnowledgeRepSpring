package com.aroha.kams.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aroha.kams.model.Topics;

@Repository
public interface TopicRepository extends JpaRepository<Topics, Integer> {

}
