import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
  public static void main(String[] args) {
    System.out.println("== 프로그램 시작 ==");
    Scanner sc = new Scanner(System.in);

    int lastID = 0;
    List<Article> articles = new ArrayList<>();

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

      if (cmd.equals("article list")) {
        if (articles.isEmpty()) {
          System.out.println("게시글이 없습니다.");
        }
        else {
          for (int i = articles.size() - 1; i >= 0; i--) {
            System.out.printf("-- %d번 article --\n", articles.get(i).번호);
            System.out.printf("제목 : %s\n", articles.get(i).제목);
            System.out.printf("내용 : %s\n", articles.get(i).내용);

//            위 문장들과 같은 의미
//            Article article = articles.get(i);
//            System.out.printf("-- %d번 article --\n", article.번호);
//            System.out.printf("제목 : %s\n", article.제목);
//            System.out.printf("내용 : %s\n", article.내용);
          }
        }
      }

      else if (cmd.equals("article write")) {
        System.out.print("제목 : ");
        String 제목 = sc.nextLine();

        System.out.print("내용 : ");
        String 내용 = sc.nextLine();

        int 번호 = lastID + 1;
        lastID = 번호;

        Article article = new Article(번호, 제목, 내용);
        articles.add(article);

        System.out.printf("%d번 글이 생성되었습니다\n", 번호);
      }

      else {
        if (cmd.startsWith("article detail ")) {
          for (int i = 0; i < articles.size(); i++) {
            String j = " "+ (i + 1);
            if (cmd.contains(j)) {
              if (articles.get(i).내용.isEmpty()) {
                System.out.printf("%d번 게시물은 존재하지 않습니다.\n", i+1);
              }
              else {
                System.out.printf("번호 : %d\n날짜 : %s\n제목 : %s\n내용 : %s\n", articles.get(i).번호, "2023-11-12 12:12:12", articles.get(i).제목, articles.get(i).내용);
              }
            }
          }
        }

        else if (cmd.startsWith("article delete ")) {
          for (int i = 0; i < articles.size(); i++) {
            String j = " " + (i + 1);
            if (cmd.contains(j)) {
              if (articles.get(i).내용.isEmpty()) {
                System.out.printf("%d번 게시물은 존재하지 않습니다.\n", i + 1);
              } else {
                articles.remove(articles.get(i));
                System.out.printf("%d번 게시물이 삭제 되었습니다.\n", i+1);
              }
            }
          }
        }

        else {
          System.out.println("존재하지 않는 명령어 입니다.");
        }
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