package dev.harsh;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Inner1 i1 = new Inner1();
        System.out.println(i1.a);
    }
    public static class Inner1{
        private int a;
    }
    public class Inner3{
        public static void main(String[] args) {
            Inner1 i1 = new Inner1();
          System.out.println(i1.a);
        }
    }
    public static class Inner2{
        public static class Inner3{
            public static void main(String[] args) {
                Inner1 i1 = new Inner1();
                System.out.println(i1.a);
            }
        }
    }
}
class Demo extends Main{
    public static void main(String[] args) {
        System.out.println("Hello world Demo!");
    }
}

class Test{
    public static void main(String[] args) {
      Demo.main(null);
      Main.main(null);
      Main main = new Main();
      main.main(null);
      Main main1 = new Demo();
      ((Demo)main1).main(null);
      Demo demo = new Demo();
      demo.main(null);
    }
}
