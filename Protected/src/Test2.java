public class Test2 {

    public static void main(String[] args) {
        System.out.println(new A().get());
    }

    static class A {

        Integer i = 0;

        public int get() {
            try {
                i = 2;
                return i;
            } finally {
                i = 5;
                System.out.println("===>" + i);
            }

        }

    }

}
