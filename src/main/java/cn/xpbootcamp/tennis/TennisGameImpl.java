package cn.xpbootcamp.tennis;

public class TennisGameImpl implements TennisGame {
    private int P1point = 0;
    private int P2point = 0;

    private String player1Name;
    private String player2Name;

    public TennisGameImpl(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        if (isAll())
            return getAll();

        if (isDeuce())
            return getDeuce();

        if (isCommonCase())
            return getCommon();

        if (p1Win() || p2Win())
            return getWinner();

        if (p1Advantage() || p2Advantage())
            return getAdvantage();

        return "";
    }

    private String getCommon() {
        return getPointName(P1point) + "-" + getPointName(P2point);
    }

    private boolean isCommonCase() {
        return P1point < 4 && P2point < 4 && P1point != P2point;
    }

    private String getDeuce() {
        return "Deuce";
    }

    private boolean isDeuce() {
        return P1point == P2point && P1point >= 3;
    }

    private String getAll() {
        return getPointName(P1point) + "-All";
    }

    private boolean isAll() {
        return P1point == P2point && P1point < 3;
    }

    private String getAdvantage() {
        if (p1Advantage()) {
            return  "Advantage player1";
        }
         return  "Advantage player2";
    }


    private String getWinner() {
        if (p1Win()) {
            return "Win for player1";
        }
        return  "Win for player2";

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