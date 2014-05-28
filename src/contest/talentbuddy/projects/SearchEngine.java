package contest.talentbuddy.projects;


import java.util.HashSet;
import java.util.Set;

public class SearchEngine {

    public static void main(String[] args) {

        token_stemming(new String[]{"friendly", "outgoing", "powerful", "in"}, new String[]{"ing", "ly", "ul", "ful"});

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

    public static void token_stemming(String[] tokens, String[] suffixes) {

        for (String token : tokens) {
            int suffixLen = 0;
            for (String suffix : suffixes) {
                if (token.endsWith(suffix)) {
                    suffixLen = suffix.length();
                }
            }
            int tokenLen = token.length();

            System.out.println(token.substring(0,tokenLen - suffixLen));

        }

    }

}
