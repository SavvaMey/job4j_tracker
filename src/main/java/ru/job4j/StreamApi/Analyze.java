package ru.job4j.StreamApi;

import java.util.Comparator;
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

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return List.of();
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return  stream.map(pupil -> new Tuple(pupil.getName(),
                pupil.getSubjects()
                        .stream()
                        .mapToDouble(Subject::getScore)
                        .sum()))
                        .max(Comparator.comparing(Tuple::getScore))
                        .orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return null;
    }
}
