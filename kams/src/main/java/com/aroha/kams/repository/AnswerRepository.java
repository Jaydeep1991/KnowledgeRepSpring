package com.aroha.kams.repository;

import com.aroha.kams.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {

    @Query(value = " select\r\n" + 
    		"        q.question_id,\r\n" + 
    		"        q.question,\r\n" + 
    		"        q.asked_by,\r\n" + 
    		"        q.client_name,\r\n" + 
    		"        q.qustion_date,\r\n" + 
    		"        a.answer,\r\n" + 
    		"        a.user_name,\r\n" + 
    		"        a.date              \r\n" + 
    		"    from\r\n" + 
    		"        question q \r\n" + 
    		"    left join\r\n" + 
    		"        answer a \r\n" + 
    		"            on q.question_id=a.question_id\r\n" + 
    		"            order by date Desc",nativeQuery = true)
    public List<Object[]> getAllAnswers();
}
