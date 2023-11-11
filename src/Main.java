import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    System.out.println("===프로그램 시작===");

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String cmd = br.readLine();
    System.out.printf("%s\n", cmd);
    br.close();

    System.out.println("===프로그램 종료===");
  }
}