package jp.co.seminar;

import java.io.Serializable;

public class Bmi implements Serializable {
	private static final long serialVersionUID = 1L;
	private double height;
	private double weight;
	private double bmi;
	
	public Bmi() {}
	public Bmi(double height, double weight) {
		this.height = height;
		this.weight = weight;
	}
	
	public double getHeight() {
		return height;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public double result() {
		double expo = 2;
		double base = 10;
		double result = Math.pow(base, expo);
		return result;
	}
	
	public void bmiKeisan() {
		this.bmi = this.weight / (this.height * this.height);
	}
	
	public String bmiAnswer(double result) {
		String message = "BMI：" + Math.round(this.bmi*result)/result;
		return message;
	}
	
}
