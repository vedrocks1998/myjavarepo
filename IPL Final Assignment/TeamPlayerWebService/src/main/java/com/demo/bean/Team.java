package com.demo.bean;

public class Team {
	private int teamId;
	private String teamName;
	public Team() {
		teamId=0;
		teamName=null;
	}
	public Team(int teamId, String teamName) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
	}
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	
	
}
