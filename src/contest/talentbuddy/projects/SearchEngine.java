package contest.talentbuddy.projects;


import java.util.HashSet;
import java.util.Set;

public class SearchEngine {

    public static void main(String[] args) {

        tokenize_query("car? dealers! bmw, audi", "?!");

    }

    public static void remove_stopwords(String[] query, String[] stopwords) {

        Set<String> stopWordSet = new HashSet<>();

        for (String s : stopwords) {
            stopWordSet.add(s);
        }

        for (String word : query) {
            if(!stopWordSet.contains(word)) {
                System.out.println(word);
            }
        }
    }

    public static void tokenize_query(String query, String punctuation) {

        StringBuilder token = new StringBuilder();
        for (int i = 0; i < query.length(); i++) {
            char c = query.charAt(i);
            boolean separator = punctuation.indexOf(c) != -1 || c == ' ';
            if (separator) {
                if (token.length() > 0) {
                    System.out.println(token);
                    token.setLength(0);
                }
                continue;
            }
            token.append(c);
        }

        System.out.println(token);

    }

}
