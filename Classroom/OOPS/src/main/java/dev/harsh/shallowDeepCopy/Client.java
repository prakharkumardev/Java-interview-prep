package dev.harsh.shallowDeepCopy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        List<String> subjects = new ArrayList<>(List.of("Maths,English"));
        ShallowDeepCopy.ShallowCopyStudent student = new ShallowDeepCopy.ShallowCopyStudent(1,subjects);
        ShallowDeepCopy.ShallowCopyStudent student1 = new ShallowDeepCopy.ShallowCopyStudent(2,subjects);
        //We will add subject to student1
        student1.getSubjects().add("Physics");

        System.out.println(student.getSubjects());

        List<String> subjects1 = new ArrayList<>(List.of("Maths,English"));


        ShallowDeepCopy.DeepCopyStudent student3 = new ShallowDeepCopy.DeepCopyStudent(1,subjects1);
        ShallowDeepCopy.DeepCopyStudent student4 = new ShallowDeepCopy.DeepCopyStudent(2,subjects1);

        student4.getSubjects().add("Physics");
        System.out.println(student3.getSubjects());
        System.out.println(student4.getSubjects());



    }
}
