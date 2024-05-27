package com.AjmayenAj.Service;

import com.AjmayenAj.Model.Question;
import com.AjmayenAj.Model.Result;
import com.AjmayenAj.Repository.QuestionRepo;
import com.AjmayenAj.Repository.ResultRepo;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class QuizService {
    private final QuestionRepo questionRepo;
    private final ResultRepo resultRepo;

    public QuizService(QuestionRepo questionRepo, ResultRepo resultRepo) {
        this.questionRepo = questionRepo;
        this.resultRepo = resultRepo;
    }

    public List<Question> getQuestions() {
        List<Question> allquestions = questionRepo.findAll();
        List<Question> questionsList = new ArrayList<Question>();

        Random random = new Random();
        for(int i = 0; i < 5;i++){
            int randomNumber = random.nextInt(allquestions.size());
            questionsList.add(allquestions.get(randomNumber));
            allquestions.remove(randomNumber);
        }
    return questionsList;
    }

    public int getResult(List<Question> questionList){
        int correct = 0;
        for(Question question : questionList){
            if(question.getAns() == question.getChosen())
            {
                correct++;
            }
        }
        return correct;
    }
    public void svaeResult(Result result){
        resultRepo.save(result);
    }
    public List<Result> getTopScore() {
        return resultRepo.findAll(Sort.by(Sort.Direction.DESC, "totalCorrect"));
    }
}
