package com.aroha.kams.payload;

import java.util.Date;

public class QuestionAnswerResponse {
    private Integer questionId;
    private String question;
    private String askedBy;
    private String clientName;
    private String questionDate;
    private String answer;
    private String answerdBy;
    private String answeredDate;

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAskedBy() {
        return askedBy;
    }

    public void setAskedBy(String askedBy) {
        this.askedBy = askedBy;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

   
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswerdBy() {
        return answerdBy;
    }

    public void setAnswerdBy(String answerdBy) {
        this.answerdBy = answerdBy;
    }

	public String getQuestionDate() {
		return questionDate;
	}

	public void setQuestionDate(String questionDate) {
		this.questionDate = questionDate;
	}

	public String getAnsweredDate() {
		return answeredDate;
	}

	public void setAnsweredDate(String answeredDate) {
		this.answeredDate = answeredDate;
	}

  
}
