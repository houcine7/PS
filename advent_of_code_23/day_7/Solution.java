package day_7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.lang.model.type.TypeKind;
import javax.swing.RowFilter.Entry;

public class Solution {

    public enum TypeHand {
        five_of_kind,
        four_of_kind,
        full_house,
        three_of_kind,
        two_pair,
        one_pair,
        high_card
    }

    public static final Map<TypeHand, Integer> types = Map.of(
            TypeHand.five_of_kind, 7,
            TypeHand.four_of_kind, 6,
            TypeHand.full_house, 5,
            TypeHand.three_of_kind, 4,
            TypeHand.two_pair, 3,
            TypeHand.one_pair, 2,
            TypeHand.high_card, 1);

    public boolean isDigitCard(char c) {
        return c >= '2' && c <= '9';
    }

    public class Card implements Comparable<Card> {
        public String literal;
        public int bid;
        public TypeHand type;

        public

        Card(TypeHand type, int bid, String literal) {
            this.type = type;
            this.bid = bid;
            this.literal = literal;
        }

        public int getBid() {
            return bid;
        }

        public TypeHand getType() {
            return type;
        }

        @Override
        public int compareTo(Card o) {
            // TODO Auto-generated method stub

            int sub = Solution.types.get(this.type) - Solution.types.get(o.type);
            if (sub == 0) {
                for (int i = 0; i < this.literal.length(); i++) {
                    char temp1 = this.literal.charAt(i);
                    char temp2 = o.literal.charAt(i);
                    if (temp1 == temp2)
                        continue;
                    if ((isDigitCard(temp2) && isDigitCard(temp1))) {
                        return temp1 - temp2;
                    }
                    if (isDigitCard(temp1)) {
                        return -1;
                    }
                    if (isDigitCard(temp2)) {
                        return 1;
                    }

                    else {
                        Map<Character, Integer> temp = Map.of(
                                'A', 5,
                                'K', 4,
                                'Q', 3,
                                'J', 2,
                                'T', 1);

                        return temp.get(temp1) - temp.get(temp2);
                    }
                }
                return 0;
            }

            else
                return sub;

        }

        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return "Card: " + this.literal + " | " + this.bid + " Type: " + this.type;
        }

    }

    public static TypeHand getType(String hand) {
        Map<Character, Integer> st = new HashMap<>();
        for (char c : hand.toCharArray()) {
            st.put(c, st.getOrDefault(c, 0) + 1);
        }

        switch (st.size()) {
            case 1:
                return TypeHand.five_of_kind;
            case 2:
                for (Map.Entry<Character, Integer> entry : st.entrySet()) {
                    if (entry.getValue() == 4)
                        return TypeHand.four_of_kind;
                }
                return TypeHand.full_house;
            case 3:
                for (Map.Entry<Character, Integer> entry : st.entrySet()) {
                    if (entry.getValue() == 3)
                        return TypeHand.three_of_kind;
                }
                return TypeHand.two_pair;
            case 4:
                return TypeHand.one_pair;
            case 5:
                return TypeHand.high_card;
            default:
                break;
        }

        return null;
    }

    public static void main(String[] args) {
        try {

            BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
            List<String> lines = br.lines().toList();
            List<Card> cards = new ArrayList<>();

            for (String st : lines) {
                //
                String[] splittedStr = st.split(" ");
                TypeHand th = getType(splittedStr[0]);
                cards.add(new Solution().new Card(th, Integer.parseInt(splittedStr[1]), splittedStr[0]));
            }

            Collections.sort(cards);
            int total = 0;
            int index = 1;
            for (Card card : cards) {
                total += card.bid * index;
                index++;
            }
            System.out.println(total);
            br.close();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

}
