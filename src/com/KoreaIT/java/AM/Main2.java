package com.KoreaIT.java.AM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
  public static void main(String[] args) {
    System.out.println("== 프로그램 시작 ==");
    Scanner sc = new Scanner(System.in);

    while (true) {
      List<Article> article = new ArrayList<>();

      System.out.print("명령어 ) ");
      String cmd = sc.nextLine();

      if (cmd.length() == 0) {
        continue;
      }

      if (cmd.equals("system exit")) {
        System.out.println("== 프로그램 종료 ==");
        break;
      }

      if (cmd.equals("article list")) {
        if (article.isEmpty()) {
          System.out.println("게시글이 없습니다.");
        }
        else {
          for (int i = 0; i < article.size(); i++) {
            System.out.printf("%d번 제목 : %s", article.get(i).번호, article.get(i).제목);
            System.out.printf("%d번 내용 : %s", article.get(i).번호, article.get(i).내용);
          }
        }
      }


      else if (cmd.equals("article write")) {
        System.out.print("제목 : ");
        String 제목 = sc.nextLine();

        System.out.print("내용 : ");
        String 내용 = sc.nextLine();

        article.add(new Article(제목, 내용));

        System.out.printf("%d번 글이 생성되었습니다\n", article.get(article.size() - 1).번호);
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
  static int 번호;
  Article(String 제목, String 내용) {
    this.제목 = 제목;
    this.내용 = 내용;

    번호 ++;
  }
}