package com.aroha.kams.payload;

import java.util.ArrayList;
import java.util.List;

public class UserAssignTeamPayload {

    private List<TeamPayloadNew> userTeamName=new ArrayList<>();
    private String userName;
    
	public List<TeamPayloadNew> getUserTeamName() {
		return userTeamName;
	}
	public void setUserTeamName(List<TeamPayloadNew> userTeamName) {
		this.userTeamName = userTeamName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "UserAssignTeamPayload [userTeamName=" + userTeamName + ", userName=" + userName + "]";
	}

}
