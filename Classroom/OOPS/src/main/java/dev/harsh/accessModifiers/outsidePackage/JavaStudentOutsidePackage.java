package dev.harsh.accessModifiers.outsidePackage;

import dev.harsh.accessModifiers.Student;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JavaStudentOutsidePackage extends Student {
    private int javaProficiency;
    public JavaStudentOutsidePackage(int id, int age, String name, int rollNo,int javaProficiency) {
        super(id, age, name, rollNo);
        this.javaProficiency = javaProficiency;
    }//Testing public extends
    public void testPublicExtendsOutside(){
        System.out.println(this.rollNo);
    }
    //Testing protected extends
    public void testProtectedExtendsOutside(){
        System.out.println(this.age);
    }
}
