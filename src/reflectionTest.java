import java.lang.reflect.Method;

public class reflectionTest {

    public static void main(String[] args) throws Exception
    {
        doRegular();
        doReflection();
        doReflection2();
    }

    public static void doRegular() throws Exception
    {
        long start = System.currentTimeMillis();
        for (int i=0; i<10000; i++)
        {
            A a = new A();
            a.doSomeThing();
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    public static void doReflection() throws Exception
    {
        long start = System.currentTimeMillis();
        for (int i=0; i<10000; i++)
        {
            A a = (A) Class.forName("reflectionTest$A").newInstance();
            a.doSomeThing();
        }
        System.out.println(System.currentTimeMillis() - start);
    }

//    public static void doReflection2() throws Exception
//    {
//        long start = System.currentTimeMillis();
//        A a = (A) Class.forName("reflectionTest$A").newInstance();
//        for (int i=0; i<10000; i++)
//        {
//            a.doSomeThing();
//        }
//        System.out.println(System.currentTimeMillis() - start);
//    }
    public static void doReflection2() throws Exception
    {
        long start = System.currentTimeMillis();
        Class klass = Class.forName("reflectionTest$A");
        Method getName = Class.forName("reflectionTest$A").getMethod("doSomeThing");
        for (int i=0; i<10000; i++)
        {
            getName.invoke(new A());
        }
        System.out.println(System.currentTimeMillis() - start);
    }
//    public static void doReflection3() throws Exception
//    {
//        A a = (A) Class.forName("reflectionTest$A").newInstance();
//        a.doSomeThing();
//    }

    public static class A {
        public void doSomeThing() {

        }
    }
}
