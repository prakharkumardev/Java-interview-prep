package dev.harsh.constructor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

public class Constructors {
    @ToString
    public static class ParameterizedConstructorStudent {
        private int id;
        private int age;
        private String name;
        private int rollNo;

        public ParameterizedConstructorStudent(int id, int age, String name, int rollNo) {
            this.id = id;
            this.age = age;
            this.name = name;
            this.rollNo = rollNo;
        }
    }
    public static class Student {
        private int id;
        protected int age;
        String name;
        public int rollNo;
    }
    @Getter
    @AllArgsConstructor
    @ToString
    public static class CopyConstructorStudent {
        private int id;
        private String name;
        public CopyConstructorStudent(CopyConstructorStudent copyConstructorStudent) {
            this.id = copyConstructorStudent.id;
            this.name = copyConstructorStudent.name;
        }
    }
}
