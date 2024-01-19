package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFirstName("Ivan");
        student.setSecondName("Petrov");
        student.setPatronymic("Vladimirovich");
        student.setGroup(413);
        student.setDateOfAdmission(new Date());
        System.out.println(student.getSecondName() + " " + student.getFirstName() + " " + student.getPatronymic()
                + " is in " + student.getGroup() + " group. Date of admission to college - " + student.getDateOfAdmission());
    }
}
