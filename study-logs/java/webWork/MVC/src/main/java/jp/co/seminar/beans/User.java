package jp.co.seminar.beans;

import java.io.Serializable;

public class User implements Serializable {
	// フィールド-----------------------------------------
	private static final long serialVersionUID = 1L;
	private String name;
    private int age;
    private String email;
    private String location;
    // コンストラクタ-------------------------------------
    public User() {}
    public User(String name, int age, String email, String location) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.location = location;
    }
    // メソッド-------------------------------------------
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
}
