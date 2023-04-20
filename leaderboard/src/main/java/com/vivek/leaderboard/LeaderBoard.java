package com.vivek.leaderboard;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
Design a Leaderboard class, which has the following features:

addScore(playerId, score): Update the leaderboard by adding score to the given player's score. If there is no player with such id in the leaderboard, add him to the leaderboard with the given score.
top(K): Return the score sum of the top K players.
reset(playerId): Reset the score of the player with the given id to 0 (in other words erase it from the leaderboard). It is guaranteed that the player was added to the leaderboard before calling this function.
 */

// Solution using Balanced Binary Search Tree
// Time Complexity:
// addScore, reset: O(logN)
// top(K): O(K)
// Space Complexityt: O(N)

public class LeaderBoard {

  TreeMap<Integer, Integer> sortedScores;
  Map<Integer, Integer> leaderboard;

  public LeaderBoard() {
    sortedScores = new TreeMap<>(Collections.reverseOrder());
    leaderboard = new HashMap<>();
  }

  public void addScore(Integer playerId, Integer score) {
    int newScore = leaderboard.getOrDefault(playerId, 0) + score;
    leaderboard.put(playerId, newScore);

    sortedScores.put(newScore, sortedScores.getOrDefault(newScore, 0) + 1);

    if(newScore != score) {
      int oldScore = newScore - score;
      sortedScores.put(oldScore, sortedScores.get(oldScore) - 1);
    }
  }

  public Integer getTopK(int k) {
    int remaining = k;
    int sum = 0;
    for(Map.Entry<Integer, Integer> entry: sortedScores.entrySet()) {
      int score = entry.getKey();
      int players = entry.getValue();
      if(remaining >= players) {
        sum += (score * players);
      } else {
        sum += score * remaining;
      }
      remaining -= players;
      if(remaining <= 0) break;
    }
    return sum;
  }

  public void reset(int playerId) {
    int score = leaderboard.get(playerId);
    leaderboard.remove(playerId);
    int numberOfPlayersWithThisScore = sortedScores.get(score);
    if (numberOfPlayersWithThisScore == 1) {
      sortedScores.remove(score);
    } else {
      sortedScores.put(score, sortedScores.get(score) - 1);
    }
  }
}
