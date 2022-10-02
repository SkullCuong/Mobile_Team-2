package com.example.test_1;

public class User {
    private int resultId;
    private String Name;

    public User(int resultId, String name) {
        this.resultId = resultId;
        Name = name;
    }

    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
