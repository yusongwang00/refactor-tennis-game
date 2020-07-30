package cn.xpbootcamp.tennis;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGameImpl implements TennisGame {
    public int P1point = 0;
    public int P2point = 0;

    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGameImpl(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String score = "";

        score = getAll(score);

        score = getDeuce(score);

        score = getCommon(score);

        score = getAdvantage(score);

        score = getWinner(score);

        return score;
    }

    private String getCommon(String score) {
        if (P1point < 4 && P2point < 4 && P1point != P2point) {
            score = getPointName(P1point) + "-" + getPointName(P2point);
        }
        return score;
    }

    private String getDeuce(String score) {
        if (P1point == P2point && P1point >= 3)
            score = "Deuce";
        return score;
    }

    private String getAll(String score) {
        if (P1point == P2point && P1point < 4) {
            score = getPointName(P1point);
            score += "-All";
        }
        return score;
    }

    private String getAdvantage(String score) {
        if (P1point > P2point && P2point >= 3) {
            score = "Advantage player1";
        }

        if (P2point > P1point && P1point >= 3) {
            score = "Advantage player2";
        }
        return score;
    }

    private String getWinner(String score) {
        if (P1point >= 4 && P2point >= 0 && (P1point - P2point) >= 2) {
            score = "Win for player1";
        }
        if (P2point >= 4 && P1point >= 0 && (P2point - P1point) >= 2) {
            score = "Win for player2";
        }
        return score;
    }

    private String  getPointName(int point) {
        switch (point) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                return "";
        }

    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1point++;
        else
            P2point++;;
    }
}