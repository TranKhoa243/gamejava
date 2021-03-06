package mypackage.model;

import java.io.Serializable;

public class HighScore implements Serializable,Comparable<HighScore>{
	private String name;
	private int score;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public HighScore(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	@Override
	public String toString() {
		return this.name+"\t"+this.score;
	}
	public HighScore() {
		super();
	}
	@Override
	public int compareTo(HighScore o) {
		return (int)(o.getScore()-score);
	}
}
