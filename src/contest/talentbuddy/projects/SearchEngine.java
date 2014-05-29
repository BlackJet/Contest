package contest.talentbuddy.projects;


import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchEngine {

    public static void main(String[] args) {

//        token_stemming(new String[]{"times", "outgoing", "powerful", "in"}, new String[]{"es","s"});
        search_query2(new String[]{"the", "new", "store"}, new String[]{"the new store is in san francisco", "the boy enters a new and cool store", "this boy enters a new store", "The new store is in the city", "the newstore is a brand", "there is newton in the store"});

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

    // TODO pre sort
    public static void token_stemming(String[] tokens, String[] suffixes) {
        for (String token : tokens) {
            int longestMatchedSuffixLen = 0;
            for (String suffix : suffixes) {
                boolean matches = token.endsWith(suffix);
                boolean longer = longestMatchedSuffixLen < suffix.length();
                if(matches && longer) longestMatchedSuffixLen = suffix.length();
            }

            int tokenLen = token.length();

            System.out.println(token.substring(0,tokenLen - longestMatchedSuffixLen));
        }
    }

    public static void search_query(String[] query, String[] pages) {

        StringBuilder re = new StringBuilder();
        for (String q : query) {
            re.append(q).append(".*");
        }

        Pattern pattern = Pattern.compile(re.toString());

        int matchedCount = 0;
        for (String page : pages) {
            Matcher matcher = pattern.matcher(page);
            if(matcher.matches()) matchedCount++;

        }

        System.out.println(matchedCount);

    }

    public static void search_query2(String[] query, String[] pages) {

        int matchedCount = 0;

        for (String page : pages) {

            for (int i = 0, idx = 0; i < query.length; i++) {
                idx = page.indexOf(query[i]);
                if(idx != -1) {
                    if (i == query.length - 1) {
                        matchedCount++;
                    }
                }
            }
        }

        System.out.println(matchedCount);

    }

//    public static int findWord(String word, String text) {
//
//        int i = 0, j = 0;
//
//        while (i < word.length() && j < text.length()) {
//            if (word.charAt(i) == text.charAt(j)) {
//                i++;
//            }
//            else if (i != 0) {
//                i = 0;
//            }
//            j++;
//        }
//
//
//    }

}
