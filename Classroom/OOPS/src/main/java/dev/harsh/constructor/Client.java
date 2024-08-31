package dev.harsh.constructor;

public class Client {
    public static void main(String[] args) {
        Constructors.Student student = new Constructors.Student();
        Constructors.ParameterizedConstructorStudent parameterizedConstructorStudent = new Constructors.ParameterizedConstructorStudent(12,23,"sa",32);       System.out.println(parameterizedConstructorStudent);

        System.out.println(student);
        System.out.println(parameterizedConstructorStudent);

        Constructors.CopyConstructorStudent copyConstructorStudent = new Constructors.CopyConstructorStudent(12,"harsh");
        Constructors.CopyConstructorStudent copyConstructorStudentCopy = new Constructors.CopyConstructorStudent(copyConstructorStudent);

        System.out.println(copyConstructorStudentCopy);
        System.out.println(copyConstructorStudent);
    }
}
