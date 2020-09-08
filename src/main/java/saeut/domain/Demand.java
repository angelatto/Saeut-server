package saeut.domain;

import java.io.Serializable;

/*
* Demand Domain Class
* */
@SuppressWarnings("serial")
public class Demand implements Serializable{
	
	private int ranks;
	private float score;
	private String description;
	private int type; // (FK)
	private String id; // (FK) - PK
	
	public int getRank() {
		return ranks;
	}
	public void setRank(int rank) {
		this.ranks = rank;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
