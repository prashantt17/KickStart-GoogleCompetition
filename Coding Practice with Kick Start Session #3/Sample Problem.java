import java.util.Scanner;

public class Solution {
  static Scanner inputObject = new Scanner(System.in);

  public static void main(String args[]) {
    int T;
    T = inputObject.nextInt();
    for (int test_case = 1; test_case <= T; ++test_case) {
      System.out.print("Case #" + test_case + ": ");
      solve();
    }
    inputObject.close();
  }

  static void solve() {
    int N, M;
    N = inputObject.nextInt();
    M = inputObject.nextInt();
    int[] C = new int[N];
    for (int i = 0; i < N; ++i) {
      C[i] = inputObject.nextInt();
    }
    int totalCandies = 0;
    for (int i = 0; i < N; ++i) {
      totalCandies += C[i];
    }
    int leftOutCandies = totalCandies % M;
    System.out.println(leftOutCandies);
  }
}
