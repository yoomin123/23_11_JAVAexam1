package exam;

import exam.util.Util;
import exam.dto.Article;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
  private static List<Article> articles;

  App() {
    articles = new ArrayList<>();
  }

  public void start() {
    System.out.println("== 프로그램 시작 ==");
    Scanner sc = new Scanner(System.in);
    makeTestData();


    while (true) {

      System.out.print("명령어 ) ");
      String cmd = sc.nextLine().trim(); //trim()은 양 옆의 공백을 없애주는 것

      if (cmd.isEmpty()) {
        continue;
      }

      if (cmd.equals("system exit")) {
        System.out.println("== 프로그램 종료 ==");
        break;
      }

      if (cmd.startsWith("article list")) {
        if (articles.size() == 0) {
          System.out.println("게시글이 없습니다.");
          continue;
        }

        String searchKeyword = cmd.substring("article list".length()).trim();
        List<Article> forPrintArticles = articles;

        if (searchKeyword.length() > 0) {
          System.out.printf("검색어 : %s\n", searchKeyword);
          forPrintArticles = new ArrayList<>();

          for (Article article : articles) {
            if (article.제목.contains(searchKeyword)) {
              forPrintArticles.add(article);
            }
          }

          if (forPrintArticles.size() == 0) {
            System.out.println("검색 결과가 없습니다.");
            continue;
          }
          // 향상된 for문 ==> articles의 요소만큼 반복
        }

        for (int i = forPrintArticles.size() - 1; i >= 0; i--) {
          System.out.printf("-- %d번 article --\n", articles.get(i).번호);
          System.out.printf("제목 : %s\n", articles.get(i).제목);
          System.out.printf("내용 : %s\n", articles.get(i).내용);
          System.out.printf("조회수 : %d\n", articles.get(i).조회수);

//           위 문장들과 같은 의미
//           Article article = articles.get(i);
//           System.out.printf("-- %d번 article --\n", article.번호);
//           System.out.printf("제목 : %s\n", article.제목);
//           System.out.printf("내용 : %s\n", article.내용);
        }
      } else if (cmd.equals("article write")) {
        int 번호 = articles.size() + 1;
        String regDate = Util.getNowDateStr();

        System.out.print("제목 : ");
        String 제목 = sc.nextLine();

        System.out.print("내용 : ");
        String 내용 = sc.nextLine();


        Article article = new Article(번호, 제목, 내용, regDate);
        articles.add(article);

        System.out.printf("%d번 글이 생성되었습니다\n", 번호);
      } else {
        if (cmd.startsWith("article detail ")) {
          String[] cmdBits = cmd.split(" ");
          int ID = Integer.parseInt(cmdBits[2]);
          Article foundArticle = null;

          for (int i = 0; i < articles.size(); i++) {
            Article article = articles.get(i);
            if (article.번호 == ID) {
              foundArticle = article;
              break;
            }
          }
          // 문자열.startsWith() ==> 괄호 안의 문자열로 시작되는지 판단
          // 문자열.split() ==> 괄호 안의 것을 기준으로 문자열을 나눔
          // Integer.parseInt(문자열) ==> 괄호 안의 문자열을 정수열로 변환

          if (foundArticle == null) {
            System.out.printf("%d번 게시물은 존재하지 않습니다.\n", ID);
          } else {
            foundArticle.조회수증가();
            System.out.printf("번호 : %d\n", foundArticle.번호);
            System.out.printf("날짜 : %s\n", foundArticle.regDate);
            System.out.printf("제목 : %s\n", foundArticle.제목);
            System.out.printf("내용 : %s\n", foundArticle.내용);
            System.out.printf("조회수 : %d\n", foundArticle.조회수);
          }

        } else if (cmd.startsWith("article delete ")) {
          String[] cmdBits = cmd.split(" ");
          int ID = Integer.parseInt(cmdBits[2]);
          Article foundArticle = null;

          for (int i = 0; i < articles.size(); i++) {
            Article article = articles.get(i);
            if (article.번호 == ID) {
              foundArticle = article;
              break;
            }
          }

          if (foundArticle == null) {
            System.out.printf("%d번 게시물은 존재하지 않습니다.\n", ID);
          }

          else {
            articles.remove(ID - 1);
            if (ID < articles.size()) {
              for (int i = ID - 1; i < articles.size(); i++) {
                articles.get(i).번호 -= 1;
              }
            }
            System.out.printf("%d번 게시물이 삭제 되었습니다.\n", ID);
          }
        } else if (cmd.startsWith("article modify ")) {
          String[] cmdBits = cmd.split(" ");
          int ID = Integer.parseInt(cmdBits[2]);

          Article foundArticle = null;
          for (int i = 0; i < articles.size(); i++) {
            Article article = articles.get(i);
            if (article.번호 == ID) {
              foundArticle = article;
              break;
            }
          }

          if (foundArticle == null) {
            System.out.printf("%d번 게시물은 존재하지 않습니다\n", ID);
          } else {
            System.out.print("제목 : ");
            String 제목 = sc.nextLine();

            System.out.print("내용 : ");
            String 내용 = sc.nextLine();

            foundArticle.제목 = 제목;
            foundArticle.내용 = 내용;

            System.out.printf("%d번 게시물이 수정 되었습니다\n", ID);
          }
        } else {
          System.out.println("존재하지 않는 명령어 입니다.");
        }
      }
    }
  }

  private void makeTestData() {
    System.out.println("게시물 테스트데이터를 생성합니다.");
    articles.add(new Article(1, "title1", "body1", Util.getNowDateStr(), 11));
    articles.add(new Article(2, "title2", "body2", Util.getNowDateStr(), 22));
    articles.add(new Article(3, "title3", "body3", Util.getNowDateStr(), 33));
  }
}