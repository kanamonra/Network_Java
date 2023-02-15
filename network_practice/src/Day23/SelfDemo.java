package Day23;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SelfDemo {
    public static void main(String[] args) {
        List<selfPracticeDay23> list = Arrays.asList(
                new selfPracticeDay23("Charlie", 88, 23),
                new selfPracticeDay23("Monica", 99, 22),
                new selfPracticeDay23("Mike", 70, 20),
                new selfPracticeDay23("Minji", 89, 23),
                new selfPracticeDay23("Skarlet", 95, 22)
        );
        // first
        // Stream<selfPracticeDay23> selfPracticeDay23Stream = list.stream();
        // IntStream scoreStream = selfPracticeDay23Stream.mapToInt(selfPracticeDay23 -> getScore());
        // double avg = scoreStream.average().getAsDouble();

        // second
        double avg = list.stream()
                .mapToInt(selfPracticeDay23 -> selfPracticeDay23.getGPA())
                .average()
                .getAsDouble();

        System.out.println("The average of student score is " + avg);
    }
}
