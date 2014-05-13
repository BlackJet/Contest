package contest.talentbuddy.projects;


import java.util.HashSet;
import java.util.Set;

public class SearchEngine {

    public static void main(String[] args) {

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

}
