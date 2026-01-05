package jp.co.seminar.beans;

import java.io.Serializable;

public class DictionaryBean implements Serializable {
//フィールド------------------------------------
    private static final long serialVersionUID = 1L;
    private String english;
    private String japanese;
//コンストラクタ--------------------------------
    public DictionaryBean() {}
    public DictionaryBean(String english, String japanese) {
        this.english = english;
        this.japanese = japanese;
    }
//メソッド--------------------------------------
    public String getEnglish() {
        return english;
    }
    public String getJapanese() {
        return japanese;
    }
}