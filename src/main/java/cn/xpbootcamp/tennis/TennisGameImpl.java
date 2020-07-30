package cn.xpbootcamp.tennis;

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
        if (isCommonCase()) {
            score = getPointName(P1point) + "-" + getPointName(P2point);
        }
        return score;
    }

    private boolean isCommonCase() {
        return P1point < 4 && P2point < 4 && P1point != P2point;
    }

    private String getDeuce(String score) {
        if (isDeuce())
            score = "Deuce";
        return score;
    }

    private boolean isDeuce() {
        return P1point == P2point && P1point >= 3;
    }

    private String getAll(String score) {
        if (isAll()) {
            score = getPointName(P1point);
            score += "-All";
        }
        return score;
    }

    private boolean isAll() {
        return P1point == P2point && P1point < 4;
    }

    private String getAdvantage(String score) {
        if (p1Advantage()) {
            score = "Advantage player1";
        }

        if (p2Advantage()) {
            score = "Advantage player2";
        }
        return score;
    }


    private String getWinner(String score) {
        if (p1Win()) {
            score = "Win for player1";
        }
        if (p2Win()) {
            score = "Win for player2";
        }
        return score;
    }

    private boolean p2Win() {
        return P2point >= 4 && P1point >= 0 && (P2point - P1point) >= 2;
    }

    private boolean p1Win() {
        return P1point >= 4 && P2point >= 0 && (P1point - P2point) >= 2;
    }

    private boolean p2Advantage() {
        return P2point > P1point && P1point >= 3;
    }

    private boolean p1Advantage() {
        return P1point > P2point && P2point >= 3;
    }


    private String getPointName(int point) {
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