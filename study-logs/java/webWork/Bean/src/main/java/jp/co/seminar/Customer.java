package jp.co.seminar;

import java.io.Serializable;

public class Customer implements Serializable {
    //フィールド-----------------------------------------
	private static final long serialVersionUID = 1L;
    private String name;
    private String job;
    private int age;
    //コンストラクタ------------------------------------
    public Customer() {}
    //メソッド-------------------------------------------
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getAdmission() {
          int fee = 2000;
          if (this.age < 3) {
              fee = 0;
          } else if (this.age <= 18) {
              fee = 1000;
          } else if (this.age >= 60) {
              fee = 1300;
          } else if (this.job.equals("student")) {
              fee = 1500;
          }
          return fee;
    }
}
