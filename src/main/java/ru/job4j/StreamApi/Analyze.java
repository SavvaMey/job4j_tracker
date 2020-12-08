package ru.job4j.StreamApi;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(x -> x.getSubjects().stream())
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0D);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.map(x ->
                new Tuple(x.getName(),
                        x.getSubjects()
                                .stream()
                                .mapToInt(Subject::getScore)
                                .average()
                                .orElse(0D)))
                                .collect(Collectors.toList());
    }

    public static LinkedList<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .flatMap(x -> x.getSubjects().stream())
        .collect(Collectors.groupingBy(Subject::getName, LinkedHashMap::new, Collectors.averagingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(x -> new Tuple(x.getKey(), x.getValue()))
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return  stream.map(pupil -> new Tuple(pupil.getName(),
                pupil.getSubjects()
                        .stream()
                        .mapToInt(Subject::getScore)
                        .sum()))
                        .max(Comparator.comparing(Tuple::getScore))
                        .orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream
                .flatMap(x -> x.getSubjects().stream())
                .collect(Collectors.toMap(
                        Subject::getName,
                        Subject::getScore,
                        Integer::sum)
                ).entrySet()
                .stream()
                .map(x -> new Tuple(x.getKey(), x.getValue()))
                .max(Comparator.comparing(Tuple::getScore))
                .orElse(null);
    }
}
