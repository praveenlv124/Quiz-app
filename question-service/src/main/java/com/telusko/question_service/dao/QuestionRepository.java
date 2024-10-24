package com.telusko.question_service.dao;

import com.telusko.question_service.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    List<Question> findByCategory(String category);

    @Query(value = "SELECT q.id FROM question q where q.category LIKE LOWER(CONCAT('%', :category, '%')) ORDER BY rand() LIMIT :numQ", nativeQuery = true)
    List<Integer>
    findRandomQuestionByCategory(String category, int numQ);
}
