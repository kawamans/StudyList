package jp.co.seminar.logic;

import jp.co.seminar.beans.User;

public class UserService {
    // 自己紹介文作成メソッド
    public String generateGreeting(User user) {
        String greeting = "Hello, " + user.getName() + "!";
        // 利用者の年齢が0より大きいか確認
        if (user.getAge() > 0) {
            greeting += "<br>You are " + user.getAge() + " years old.";
        }
        // 利用者のLocationがnull、もしくは空でないか確認
        if (user.getLocation() != null && !user.getLocation().isEmpty()) {
            greeting += "<br>Greetings to you from " + user.getLocation() + ".";
        }
        greeting += "<br>We have sent more information to your email at " + user.getEmail() + ".";
        return greeting;
    }
}