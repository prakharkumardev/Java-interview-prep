package dev.harsh.accessModifiers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JavaStudent extends Student{
    private int javaProficiency;
    public JavaStudent(int id, int age, String name, int rollNo,int javaProficiency) {
        super(id, age, name, rollNo);
        this.javaProficiency = javaProficiency;
    }
    //Testing public extends
    public void testPublicExtends(){
        System.out.println(this.rollNo);
    }
    //Testing protected extends
    public void testProtectedExtends(){
        System.out.println(this.age);
    }
    public void testDefaultExtends(){
        System.out.println(this.name);
    }


}
