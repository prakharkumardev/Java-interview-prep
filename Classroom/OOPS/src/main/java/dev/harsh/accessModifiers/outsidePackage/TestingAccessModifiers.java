package dev.harsh.accessModifiers.outsidePackage;

import dev.harsh.accessModifiers.AccessModifiers;
import dev.harsh.accessModifiers.Student;

public class TestingAccessModifiers {
    //Testing public
    public static class TestingPublicOutsidePackage{
        public static void main(String[] args) {
            Student student = new Student(16,12,"Sa",123);
            System.out.println(student.rollNo);
        }
    }
    //Not Accessible
    //Testing protected
//    public static class TestingProtectedOutsidePackage{
//        public static void main(String[] args) {
//            Student student = new Student(14,12,"Sa",123);
//            System.out.println(student.age);
//        }
//    }
//
//    public static class TestingDefaultSamePackage{
//        public static void main(String[] args) {
//            Student student = new Student(124,12,"Sa",123);
//            System.out.println(student.name);
//        }
//    }

    //In case of private it's not accessible

}
