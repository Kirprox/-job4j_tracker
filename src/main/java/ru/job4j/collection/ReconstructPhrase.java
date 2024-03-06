package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ReconstructPhrase {
    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder result = new StringBuilder();
        List<Character> list = new ArrayList<>(evenElements);
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < list.size(); i += 2) {
            deque.add(list.get(i));
        }
        int size = evenElements.size() / 2;
        for (int i = 0; i < size; i++) {
            result.append(deque.poll());
        }
        return result.toString();
    }

    private String getDescendingElements() {
        StringBuilder result = new StringBuilder();
        int size = descendingElements.size();
        for (int i = 0; i < size; i++) {
            result.append(descendingElements.pollLast());
        }
        return result.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
