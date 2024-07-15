package com.todoapp;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    TaskManager taskManager = new TaskManager();

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
          taskManager.printExit();
          isExit = true;
          break;
        case "help":
          taskManager.printHelp();
          break;
        case "list":
          taskManager.showAllList();
          break;
        case "add":
          taskManager.printAddTask(commandParts);
          break;
        case "find":
          taskManager.printFoundTask(commandParts);
          break;
        case "done":
          taskManager.printToDoneById(commandParts);
          break;
        case "delete":
          taskManager.printDelete(commandParts);
          break;
        default:
          taskManager.printError();
      }
      if(isExit) break;
    }

    System.out.println("=========================================");

    scanner.close();
  }
}