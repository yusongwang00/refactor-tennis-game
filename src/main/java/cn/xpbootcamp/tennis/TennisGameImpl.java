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

        score = getLove(score);

        score = getCommon(score);

        score = getAdvantage(score);

        score = getWinner(score);

        return score;
    }

    private String getCommon(String score) {
        if (P1point > P2point && P1point < 4) {
            if (P1point == 2)
                P1res = "Thirty";
            if (P1point == 3)
                P1res = "Forty";
            if (P2point == 1)
                P2res = "Fifteen";
            if (P2point == 2)
                P2res = "Thirty";
            score = P1res + "-" + P2res;
        }
        if (P2point > P1point && P2point < 4) {
            if (P2point == 2)
                P2res = "Thirty";
            if (P2point == 3)
                P2res = "Forty";
            if (P1point == 1)
                P1res = "Fifteen";
            if (P1point == 2)
                P1res = "Thirty";
            score = P1res + "-" + P2res;
        }
        return score;
    }

    private String getLove(String score) {
        if (P1point > 0 && P2point == 0) {
            P1res = getPointName(P1point);
            P2res = "Love";
            score = P1res + "-" + P2res;
        }
        if (P2point > 0 && P1point == 0) {
           P2res = getPointName(P2point);
            P1res = "Love";
            score = P1res + "-" + P2res;
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
            if (P1point == 0)
                score = "Love";
            if (P1point == 1)
                score = "Fifteen";
            if (P1point == 2)
                score = "Thirty";
            score += "-All";
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

    public void wonPoint(String player) {
        if (player == "player1")
            P1point++;
        else
            P2point++;;
    }
}