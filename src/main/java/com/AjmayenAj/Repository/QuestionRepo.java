package com.AjmayenAj.Repository;

import com.AjmayenAj.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepo extends JpaRepository<Question, Integer> {
}
