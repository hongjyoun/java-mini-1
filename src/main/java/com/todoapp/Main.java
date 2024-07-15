package com.todoapp;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    TaskList manageTasks = new TaskList();

    System.out.println("=============== Todo List ===============");
    while (true) {
      System.out.print("명령어를 입력하세요 (종료하려면 'exit' 입력): ");
      String input = scanner.nextLine();
      String[] commandParts = input.toLowerCase().split(" ", 3);
      String command = commandParts.length > 0 ? commandParts[0] : null;

      boolean isExit = false;
      if(command == null) command = "exit";

      switch (command) {
        case "exit":
          manageTasks.printExit();
          isExit = true;
          break;
        case "help":
          manageTasks.printHelp();
          break;
        case "list":
          manageTasks.showAllList();
          break;
        case "add":
          manageTasks.printAddTask(commandParts);
          break;
        case "find":
          manageTasks.printFoundTask(commandParts);
          break;
        case "done":
          manageTasks.printToDoneById(commandParts);
          break;
        case "delete":
          manageTasks.printDelete(commandParts);
          break;
        default:
          manageTasks.printError();
      }
      if(isExit) break;
    }

    System.out.println("=========================================");

    scanner.close();
  }
}