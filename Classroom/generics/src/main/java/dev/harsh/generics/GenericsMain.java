package dev.harsh.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsMain implements Comparable<GenericsMain> {
    private int age;

    public GenericsMain(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(GenericsMain o) {
        return Integer.compare(this.age, o.age);
    }

    @Override
    public String toString() {
        return "GenericsMain{" +
                "age=" + age +
                '}';
    }

    public static class TypeErasedStudent{
        private Object age;
        private Object getAge(){return this.age;}
        private void setAge(Object age){this.age = age;}

        public static void main(String[] args) {
            TypeErasedStudent student = new TypeErasedStudent();
            student.setAge(20);
            student.setAge(30);
            Integer age = (Integer) student.getAge();
            System.out.println(age);
        }
    }

    public static class Student<T>{
        private T age;
        public T getAge() {return this.age;}
        public void setAge(T age) {this.age = age;}
        public static void main(String[] args) {
            Student<Integer> student = new Student<>();
            student.setAge(10);
            System.out.println(student.getAge());
        }
    }

    public static class StudentUpperBound<T extends Number & Comparable<T>>{
        private T age;
        public T getAge() {return this.age;}
        public void setAge(T age) {this.age = age;}
        public static void main(String[] args) {
            StudentUpperBound<Integer> studentUpperBound = new StudentUpperBound<>();
            studentUpperBound.setAge(10);
            int age = studentUpperBound.getAge();
            System.out.println(age);
        }
    }

    ///This is not allowed
//    public static class StudentLowerBound<T super Number>{
//
//    }

    public static class GetMax{
        public static <T extends Comparable<T>> T getMax(List<T> list){
            T maxVal = list.get(0);
            for(T obj : list){
                maxVal = obj.compareTo(maxVal) < 0 ? maxVal : obj;
            }
            return maxVal;
        }

        public static void main(String[] args) {

            List<String> list = List.of("111","22","3","4","5");
            System.out.println(getMax(list));
            List<GenericsMain> genericsMainList = List.of(new GenericsMain(1), new GenericsMain(2), new GenericsMain(3), new GenericsMain(4));
            System.out.println(getMax(genericsMainList));

        }
    }
    public static class Wildcard{
        public static void doSomething(List<? super Number> list){

        }
        public static void printList(List<?> list){
            for(Object obj : list){
                System.out.println(obj);
            }
            //Addition is blocked in this list through this ? path
        }
        public static void printListUpperBound(List<? extends Number> list){
            for(Number obj : list){
                System.out.println(obj);
            }
           //Addition is blocked from extends path
        }

    public static void printLowerBound(List<? super Object> list){
            for(Object obj : list){
                System.out.println(obj);
            }
            list.add(123);
            list.add(2.0);
            list.add(1L);
            //Addition is allowed from this path but Number and it's subclasses
            doSomething(list);
    }

    }



}
