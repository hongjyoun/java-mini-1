package com.todoapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TaskList {
  List<Task> taskList;

  public TaskList() {
    this.taskList = new ArrayList<>();
  }

  void showAllList() {
    System.out.println();
    if (taskList.isEmpty()) {
      System.out.println("목록이 비어있습니다");
    } else {
      printList(taskList);
    }
    System.out.println();
  }

  void printList(List<Task> list) {
    list.forEach(item -> printItem(item));
  }

  void printItem(Task task) {
    System.out.println("[ID: " + task.id + "]" + (task.isDone ? " [X]" : " [ ]") + ' ' + task.category + " | " + task.name);
  }

  void printAlert(String text) {
    System.out.println(text);
    System.out.println();
  }

  void printHelp() {
    printAlert("-----가능한 명령어-----\n- list : task의 전체 리스트를 확인합니다.\n- add [category] [task] : 새로운 할일을 추가합니다.\n- find [id] : 특정 task를 taskId로 조회합니다.\n- done [id] : 특정 task의 상태를 완료로 바꿉니다.\n- delete [id] : 특정 task를 삭제합니다.");
  }

  void printError() {
    printAlert("알 수 없는 명령어 입니다. 'help'를 입력하시면 사용 가능한 명령어를 확인하실 수 있습니다.");
  }

  void printExit() {
    printAlert("프로그램을 종료합니다.");
  }

  void printAddTask(String[] commandParts) {
    if(commandParts.length < 3) {
      printAlert("카테고리와 내용 모두 입력해주세요");
      return;
    }
    addTask(commandParts[1], commandParts[2]);
    printAlert("Added!\n");
  }

  void printFoundTask(String[] commandParts) {
    Task founded = findById(Integer.parseInt(commandParts[1]));
    if(founded == null) {
      printAlert("해당 ID와 일치하는 task를 찾을 수 없습니다");
      return;
    }

    System.out.println();
    printItem(founded);
    System.out.println();
  }

  void printDelete(String[] commandParts) {
    Task founded = findById(Integer.parseInt(commandParts[1]));
    if(founded == null) {
      printAlert("해당 ID와 일치하는 task를 찾을 수 없습니다");
      return;
    }

    deleteTask(founded.getId());
    printAlert("Deleted!\n");
  }

  void printToDoneById(String[] commandParts) {
    Task founded = findById(Integer.parseInt(commandParts[1]));
    if(founded == null) {
      printAlert("해당 ID와 일치하는 task를 찾을 수 없습니다");
      return;
    }

    makeToDone(Integer.parseInt(commandParts[1]));
    printAlert("Done!");
  }

  private void makeToDone(int inputId) {
    for (Task task : taskList) {
      if (task.getId() == inputId) {
        task.setIsDone(true);
        break;
      }
    }
  }

  private Task findById(int inputId) {
    return taskList.stream().filter(task -> task.getId() == inputId).findFirst().orElse(null);
  }

  private void addTask(String category, String name) {
    Task newTask = new Task(generateNextId(), category, name);
    taskList.add(newTask);
  }

  private void deleteTask(int taskId) {
    List<Task> filteredTaskList = taskList.stream().filter(task -> task.id != taskId).collect(Collectors.toList());
    setTaskList(filteredTaskList);
  }

  private int generateNextId() {
    if (taskList == null || taskList.isEmpty()) return 1;
    else {
      List<Integer> idList = taskList.stream().map((task) -> task.id).collect(Collectors.toList());
      int maxNum = Collections.max(idList);
      return maxNum + 1;
    }
  }

  private void setTaskList(List<Task> value) {
    this.taskList = value;
  }
}
