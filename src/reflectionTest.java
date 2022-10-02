public class reflectionTest {

    public static void main(String[] args) throws Exception
    {
        doRegular();
        doReflection();
        doReflection2();
        long start = System.currentTimeMillis();
        for (int i=0; i<10000; i++) {
            doReflection3();
        }
        System.out.println(System.currentTimeMillis() - start);
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

    public static void doReflection2() throws Exception
    {
        long start = System.currentTimeMillis();
        A a = (A) Class.forName("reflectionTest$A").newInstance();
        for (int i=0; i<10000; i++)
        {
            a.doSomeThing();
        }
        System.out.println(System.currentTimeMillis() - start);
    }
    public static void doReflection3() throws Exception
    {
        A a = (A) Class.forName("reflectionTest$A").newInstance();
        a.doSomeThing();
    }

    public static class A {
        public void doSomeThing() {

        }
    }
}
