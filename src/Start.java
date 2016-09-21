public class Start {

    private int i = 5;
    private static int q = 5;

    static class StaticClass {
        void method() {
            //System.out.println(i); // доступа к i нет!
            System.out.println(q);
        }
    }

    public static void main(String[] args) {

        // внутренни класс и внешний класс видят приватные поля друг друга
        Start start = new Start();
        start.method();

        // вариант создания
        Inner inner = start.new Inner();
        inner.method2();
    }

    void method() {
        Inner inner = new Inner();
        inner.method2();
        System.out.println(inner.k);
    }

    class Inner {
        private int k = 6;
        void method2() {
            System.out.println(i);
        }
    }
}

// чтобы получить экземпляр внутреннего класса, нужно создать экземпляр внешнего класса
class Second {
    void method() {
        Start.Inner inner = new Start().new Inner();
        inner.method2();
    }
}