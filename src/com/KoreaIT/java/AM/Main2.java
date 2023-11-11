package com.KoreaIT.java.AM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
  public static void main(String[] args) {
    System.out.println("== 프로그램 시작 ==");
    Scanner sc = new Scanner(System.in);

    int lastid = 0;
    List<Article> articles = new ArrayList<>();

    while (true) {

      System.out.print("명령어 ) ");
      String cmd = sc.nextLine().trim(); //trim()은 양 옆의 공백을 없애주는 것

      if (cmd.length() == 0) {
        continue;
      }

      if (cmd.equals("system exit")) {
        System.out.println("== 프로그램 종료 ==");
        break;
      }

      if (cmd.equals("article list")) {
        if (articles.isEmpty()) {
          System.out.println("게시글이 없습니다.");
        }
        else {
          for (int i = 0; i < articles.size(); i++) {
            System.out.printf("-- %d번 article --\n", articles.get(i).번호);
            System.out.printf("제목 : %s\n", articles.get(i).제목);
            System.out.printf("내용 : %s\n", articles.get(i).내용);
          }
        }
      }


      else if (cmd.equals("article write")) {
        System.out.print("제목 : ");
        String 제목 = sc.nextLine();

        System.out.print("내용 : ");
        String 내용 = sc.nextLine();

        int 번호 = lastid + 1;
        lastid = 번호;

        Article article = new Article(번호, 제목, 내용);
        articles.add(article);

        System.out.printf("%d번 글이 생성되었습니다\n", 번호);
      }

      else {
        System.out.println("존재하지 않는 명령어 입니다.");
      }
    }
  }
}

class Article {
  String 제목;
  String 내용;
  int 번호;
  public Article(int 번호, String 제목, String 내용) {
    this.제목 = 제목;
    this.내용 = 내용;
    this.번호 = 번호;
  }
}