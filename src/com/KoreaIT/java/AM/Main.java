package com.KoreaIT.java.AM;
// com파일 안에 KoreaIT파일 안에 .. 들어가게 됨

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    System.out.println("===프로그램 시작===");

    Scanner sc = new Scanner(System.in);
    while (true){
      System.out.print("명령어 : ");
      String cmd = sc.nextLine();

      if (cmd.equals("System exit")) {
        break;
      }
    }
    // sc.next(); : 입력하고 엔터 누르기 전까지 대기하고 있는 실행문
    // next ==> 띄어쓰기 하기 전 한 단어만 입력됨.
    // nextLine으로 입력된 것은 String 타입.
    // nextint로 입력된 것은 int 타입.

    sc.close(); // 없어도 문법적으로 문제는 없지만 닫아주는 것이 좋음.

    System.out.println("===프로그램 종료===");
  }
}