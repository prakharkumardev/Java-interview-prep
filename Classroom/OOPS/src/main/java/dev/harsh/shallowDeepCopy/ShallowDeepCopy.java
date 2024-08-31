package dev.harsh.shallowDeepCopy;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ShallowDeepCopy {
    @Getter
    public static class ShallowCopyStudent{
        private int age;
        private List<String> subjects;
        public ShallowCopyStudent(int age, List<String> subjects) {
            this.age = age;
            this.subjects = subjects;
        }
    }
    @Getter
    public static class DeepCopyStudent{
        private int age;
        private List<String> subjects;
        public DeepCopyStudent(int age, List<String> subjects) {
            this.age = age;
            this.subjects = new ArrayList<>(subjects);
        }
    }
}
