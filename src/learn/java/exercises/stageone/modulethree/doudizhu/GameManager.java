package learn.java.exercises.stageone.modulethree.doudizhu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * @author xxywindows@hotmail.com
 */
public class GameManager {

    private static HashMap<Integer, String> StaticPokerMap = initPokerMap();

    private static HashMap<Integer, String> initPokerMap() {
        ArrayList<String> color = new ArrayList<>();
        color.add("黑桃");
        color.add("红桃");
        color.add("梅花");
        color.add("方块");

        ArrayList<String> number = new ArrayList<>();
        Collections.addAll(number, "2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3");

        HashMap<Integer, String> pokerMap = new HashMap<>();

        int index = 0;
        pokerMap.put(index++, "大王 ");
        pokerMap.put(index++, "小王 ");

        for (String theNumber : number) {
            for (String theColor : color) {
                pokerMap.put(index, theColor + theNumber + " ");
                index++;
            }
        }
        return pokerMap;
    }

    private static ArrayList<Integer> initCards() {
        ArrayList<Integer> cards = new ArrayList<>();
        for (int i = 0; i < 54; i++) {
            cards.add(i);
        }
        return cards;
    }

    private ArrayList<Integer> player;
    private ArrayList<Integer> player2;
    private ArrayList<Integer> player3;
    private ArrayList<Integer> buttonCards;

    private ArrayList<Integer> cards;

    public GameManager() {
        this.cards = initCards();
        this.player = new ArrayList<>();
        this.player2 = new ArrayList<>();
        this.player3 = new ArrayList<>();
        this.buttonCards = new ArrayList<>();
    }

    public GameManager gameRun() {
        Collections.shuffle(cards);
        return this;
    }

    public GameManager licensing() {

        for (int i = 0; i < cards.size(); i++) {
            if (i <= 50) {
                if (i % 3 == 0) {
                    player.add(cards.get(i));
                } else if (i % 3 == 1) {
                    player2.add(cards.get(i));
                } else {
                    player3.add(cards.get(i));
                }
            } else {
                buttonCards.add(cards.get(i));
            }
        }

        Collections.sort(player);
        Collections.sort(player2);
        Collections.sort(player3);
        return this;
    }

    public void print() {

        System.out.print("玩家1: ");
        for (Integer key : player) {
            String value = StaticPokerMap.get(key);
            System.out.print(value + " ");
        }
        System.out.println();


        System.out.print("玩家2: ");
        for (Integer key : player2) {
            String value = StaticPokerMap.get(key);
            System.out.print(value + " ");
        }
        System.out.println();

        System.out.print("玩家3: ");
        for (Integer key : player3) {
            String value = StaticPokerMap.get(key);
            System.out.print(value + " ");
        }
        System.out.println();

        System.out.print("底牌");
        for (Integer key : buttonCards) {
            String value = StaticPokerMap.get(key);
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public void nextRound() {
        this.cards = initCards();
        this.player = new ArrayList<>();
        this.player2 = new ArrayList<>();
        this.player3 = new ArrayList<>();
        this.buttonCards = new ArrayList<>();
    }
}
