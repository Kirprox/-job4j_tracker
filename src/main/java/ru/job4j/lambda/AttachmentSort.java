package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AttachmentSort {
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 2", 34),
                new Attachment("image 3", 13)
        );
        Comparator<Attachment> comparator = (left, right) ->
                Integer.compare(left.getSize(), right.getSize());
        attachments.sort(comparator);
        System.out.println(attachments);
        Comparator<Attachment> nameComparator = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment o1, Attachment o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        Comparator<String> comparatorText = (left, right) ->
                left.compareTo(right);
        Comparator<String> comparatorDescSize = (left, right) ->
                Integer.compare(right.length(), left.length());
    }
}
