package com.aroha.kams.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Topics {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int topicsId;
	private String topicName;
	
	public int getTopicsId() {
		return topicsId;
	}
	public void setTopicsId(int topicsId) {
		this.topicsId = topicsId;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

}
