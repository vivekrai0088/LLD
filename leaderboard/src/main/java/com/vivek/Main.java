package com.vivek;

import com.vivek.leaderboard.LeaderBoard;

public class Main {
  public static void main(String[] args) {
    LeaderBoard leaderBoard = new LeaderBoard();
    leaderBoard.addScore(1, 1);
    leaderBoard.addScore(1, 4);

    leaderBoard.addScore(2, 1);
    leaderBoard.addScore(2, 7);

    leaderBoard.addScore(3, 10);

    System.out.println(leaderBoard.getTopK(2));
    System.out.println(leaderBoard.getTopK(3));
  }
}
