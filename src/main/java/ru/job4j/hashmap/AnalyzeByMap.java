package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int score = 0;
        int countSubjects = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
                countSubjects++;
            }
        }
        return !pupils.isEmpty() ? (double) score / countSubjects : 0;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        int score = 0;
        int countOfSubjects = 0;
        List<Label> rsl = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
                countOfSubjects++;
            }
            rsl.add(new Label(pupil.name(), (double) score / countOfSubjects));
            score = 0;
            countOfSubjects = 0;
        }
        return rsl;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.merge(subject.name(), subject.score(), (oldValue, newValue) -> oldValue + subject.score());
            }
        }
        for (String subject : map.keySet()) {
            rsl.add(new Label(subject, (double) map.get(subject) / pupils.size()));
        }
        return rsl;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        int score = 0;
        List<Label> labelList = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
            }
            labelList.add(new Label(pupil.name(), score));
            score = 0;
        }
        Collections.sort(labelList);
        return labelList.get(labelList.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> labelList = new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.merge(subject.name(), subject.score(), (oldValue, newValue) -> oldValue + subject.score());
            }
        }
        for (String subject : map.keySet()) {
            labelList.add(new Label(subject, (double) map.get(subject)));
        }
        Collections.sort(labelList);
        return labelList.get(labelList.size() - 1);
    }
}
