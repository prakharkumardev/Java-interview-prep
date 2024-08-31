package dev.harsh.constructor.chaining;

import lombok.ToString;

public class ConstructorChaining {
    @ToString(callSuper = true)
    public static class A{
        private int a;
        public A(int a) {
            this.a = a;
        }
    }
    @ToString(callSuper = true)
    public static class B extends A{
        private int b;
        public B(int a,int b){
            super(a);
            this.b = b;
        }
    }
    @ToString(callSuper = true)
    public static class C extends B{
        private int c;
        public C(int a,int b,int c){
            super(a,b);
            this.c = c;
        }
    }
    @ToString(callSuper = true)
    public static class D extends  C{
        private int d;
        public D(){
            this(1,2,3,4);
        }
        public D(int a,int b,int c,int d){
            super(a,b,c);
            this.d = d;
        }
    }
}
