package com.todoapp;

public class Task {
  int id;
  String name;
  String category;
  boolean isDone;

  public Task(int id, String category, String name) {
    this.id = id;
    this.name = name;
    this.category = category;
    this.isDone = false;  // 기본값으로 false 설정
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getCategory() {
    return category;
  }

  public boolean getIsDone() {
    return isDone;
  }

  void setName(String name) {
    this.name = name;
  }

  void setCategory(String category) {
    this.category = category;
  }

  void setIsDone(boolean value) {
    this.isDone = value;
  }
}
