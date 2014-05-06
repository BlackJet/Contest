package talentbuddy;

import java.util.Arrays;
import java.util.List;

public class Languages {

        public static void sort_words(String s) {
            String[] words = s.replace(',', ' ').replaceAll("\\s+", " ").split(" ");
            Arrays.sort(words);
            for (String word : words) {
                System.out.println(word);
            }
        }

        public static void count_words(String s) {

            boolean wordStarted = false;
            int wCount = 0;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                boolean letter = ch != ' ' && ch != ',';
                if (letter) {
                    wordStarted = true;
                } else {
                    if(wordStarted) {
                        wCount++;
                    }
                    wordStarted = false;

                }
            }

            System.out.println(wCount);
        }

        public static void convert_to_binary(Integer n) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 32; i++) {
                sb.append(n >> i & 1);
            }
            sb.reverse();
            System.out.println(sb.substring(sb.indexOf("1")));
        }

        public static void convert_seconds(Integer seconds) {
            int h = seconds / 3600;
            int min = seconds % 3600 / 60;
            int sec = seconds % 3600 % 60;

            System.out.println(String.format("%02d:%02d:%02d", h, min, sec));
        }

        public static void caesar_shift(String s) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i), xChar = ch;
                if (ch >= 65 && ch <= 90) {
                    xChar = (char)(ch == 90 ? 65 : ch + 1);
                } else if (ch >= 97 && ch <= 122) {
                    xChar = (char)(ch == 122 ? 97 : ch + 1);
                }

                sb.append(xChar);
            }

            System.out.println(sb.toString());
        }

        public static void precision(Double p1, Double p2, Integer v) {
            int r1 = (int)Math.round(p1 * v);
            int r2 = v - r1;

            System.out.println(r1 + " " + r2);
        }

        public static void count_one(Integer a) {
            int count = 0;
            for (int i = 0; i < 32; i++) {
                count += (a >> i) & 1;
            }
            System.out.println(count);
        }

        public static void count_vowels(String s) {
            s = s.toLowerCase();
            int count = 0;
            List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');
            for (int i = 0; i < s.length(); i++) {
                if(vowels.contains(s.charAt(i))) count++;
            }

            System.out.println(count);
        }

        public static void fizzbuzz(Integer n) {
            for (int i = 1; i <= n; i++) {
                if(i % 3 == 0) {
                    if(i % 5 == 0)
                        System.out.println("FizzBuzz");
                    else
                        System.out.println("Fizz");
                }

                else
                if(i % 5 == 0) System.out.println("Buzz");
                else System.out.println(i);
            }
        }

        public static void count_digits(String s) {

            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch >= '0' && ch <= '9') count++;
            }

            System.out.println(count);

        }

        public static void odd_square_sum(Integer x, Integer y) {
            int sum = 0;
            for (int i = x; i <= y; i++) {
                if(i % 2 != 0) {
                    sum += i * i;
                }
            }

            System.out.println(sum);
        }

}
