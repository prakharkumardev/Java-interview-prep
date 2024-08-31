package dev.harsh.accessModifiers;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *
 * Testing public private protected default within the same package
 * */
public class AccessModifiers {
  //Testing public
    public static class TestingPublicSamePackage{
      public static void main(String[] args) {
          Student student = new Student(1,12,"Sa",123);
          System.out.println(student.rollNo);
      }
  }
  //Testing protected
  public static class TestingProtectedSamePackage{
      public static void main(String[] args) {
          Student student = new Student(14,12,"Sa",123);
          System.out.println(student.age);
      }
  }

  public static class TestingDefaultSamePackage{
      public static void main(String[] args) {
          Student student = new Student(124,12,"Sa",123);
          System.out.println(student.name);
      }
  }

  //In case of private it's not accessible


}

