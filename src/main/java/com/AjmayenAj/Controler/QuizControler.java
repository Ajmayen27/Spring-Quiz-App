package com.AjmayenAj.Controler;

import com.AjmayenAj.Service.QuizService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuizControler {

    private final QuizService quizService;

    public QuizControler(QuizService quizService) {
        this.quizService = quizService;
    }
    @GetMapping("/")
    public String getHomePage(){
        return "HomePage";
    }
}
