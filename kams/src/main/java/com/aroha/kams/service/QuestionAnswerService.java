package com.aroha.kams.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aroha.kams.model.Answer;
import com.aroha.kams.model.CompanyEntity;
import com.aroha.kams.model.Question;
import com.aroha.kams.model.UserEntity;
import com.aroha.kams.payload.AddQuestionPayload;
import com.aroha.kams.payload.AnswerPayload;
import com.aroha.kams.payload.AssignResponsePayload;
import com.aroha.kams.payload.QuestionAnswerResponse;
import com.aroha.kams.payload.QuestionResponse;
import com.aroha.kams.repository.AnswerRepository;
import com.aroha.kams.repository.CompanyRepository;
import com.aroha.kams.repository.QuestionRepository;
import com.aroha.kams.repository.UserRepository;


@Service
public class QuestionAnswerService {

	@Autowired
	private QuestionRepository questionRepository;
	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AnswerRepository answerRepository;

	public AssignResponsePayload saveQuestion(AddQuestionPayload addQuestion) {
		try {
			int clientId = addQuestion.getClientId();
			CompanyEntity comPany = companyRepository.findById(clientId).get();
			Question ques = new Question();
			ques.setClientName(comPany.getCompanyName());
			UserEntity user = userRepository.findByeMail(addQuestion.getUserEmail());
			ques.setAskedBy(user.getUserName());
			ques.setTopic(addQuestion.getTopic());
			ques.setQuestion(addQuestion.getQuestion());
			Date date = new Date();
			ques.setQustionDate(date);
			questionRepository.save(ques);
			return new AssignResponsePayload("Successfully added question", "Success");

		} catch (Exception ex) {
			return new AssignResponsePayload("Failed to add Question", "Error");
		}
	}


	public AssignResponsePayload addAnswer(AnswerPayload answerPayload) {
		Question question = questionRepository.findById(answerPayload.getQuestionId()).get();
		UserEntity user = userRepository.findByeMail(answerPayload.getEmailUser());
		Answer ans = new Answer();
		ans.setAnswer(answerPayload.getAnswer());
		ans.setUserName(user.getUserName());
		Date date = new Date();
		ans.setDate(date);
		question.getAnswer().add(ans);
		ans.setQuestion(question);
		try {
			answerRepository.save(ans);
			return new AssignResponsePayload("Successfully added answer", "Success");
		} catch (Exception ex) {
			return new AssignResponsePayload("Failed to add answer", "Error");
		}
	}

	public List<QuestionAnswerResponse> getAllQuestionAnsAnswer() {
		List<Object[]> list = answerRepository.getAllAnswers();
		List<QuestionAnswerResponse> data = new ArrayList<>();
		for (Object[] object : list) {
			QuestionAnswerResponse quesObj=new QuestionAnswerResponse();
			quesObj.setQuestionId((Integer)object[0]);
			quesObj.setQuestion((String)object[1]);
			quesObj.setClientName((String)object[3]);
			quesObj.setAskedBy((String)object[2]);
			SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
			quesObj.setQuestionDate(formatter.format((Date)object[4]));
			if((String)object[5]!=null) {
				quesObj.setAnswer((String)object[5]);
			}
			if((String)object[6]!=null) {
				quesObj.setAnswerdBy((String)object[6]);
			}
			if((Date)object[7]!=null) {
				SimpleDateFormat formatterObj = new SimpleDateFormat("dd MMMM yyyy");
				quesObj.setAnsweredDate(formatterObj.format((Date)object[7]));
			}
			data.add(quesObj);
		}
		return data;
	}


	public List<QuestionResponse> showQuestion() {
		List<Question>list=questionRepository.findAll();
		Iterator<Question>itr=list.iterator();
		List<QuestionResponse>obj=new ArrayList<>();
		while(itr.hasNext()) {
			Question q=itr.next();
			QuestionResponse quesObj=new QuestionResponse();
			quesObj.setQuestionId(q.getQuestionId());
			quesObj.setQuestion(q.getQuestion());
			quesObj.setClientName(q.getClientName());
			quesObj.setAskedBy(q.getAskedBy());
			SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
			quesObj.setQuestionDate(formatter.format(q.getQustionDate()));
			obj.add(quesObj);
		}
		return obj;
	}
	
}