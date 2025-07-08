package ru.job4j.lombok;

import lombok.*;

import java.util.List;

@ToString
@Getter
@Builder(builderMethodName = "of")
public class Permission {
    private int id;
    private String name;
    @Singular("rules")
    private List<String> rules;
}