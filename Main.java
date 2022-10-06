import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        countWords("the cat is in the bag");
    }

    public static void countWords(String sentence){
        String[] words = sentence.split(" ");
        Arrays.stream(words)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(t -> System.out.println(t.getValue() + " , " + t.getKey()));
    }
}