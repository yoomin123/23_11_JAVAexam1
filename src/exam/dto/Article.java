package exam.dto;

public class Article {
  public int 번호;
  public String regDate;
  public String 제목;
  public String 내용;
  public int 조회수;

  public Article(int id, String title, String body, String regDate) {
    this(id, regDate, title, body, 0);
  }

  public Article(int 번호, String 제목, String 내용, String regDate, int 조회수) {
    this.번호 = 번호;
    this.regDate = regDate;
    this.제목 = 제목;
    this.내용 = 내용;
    this.조회수 = 조회수;
  }

  public void 조회수증가() {
    조회수++;
  }
}