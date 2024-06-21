package com.nandu.QuizService.dao;


import com.nandu.QuizService.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz,Integer> {

}
