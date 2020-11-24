public class SeventhExcercise {

    public static void main(String... args){
        a();
        /*b();
        c();
        d();*/
    }

    public static void a(){
        Basis basis = new Unten(13);
        basis.print();
        basis.berechne();
        //basis.ausfuehren();
        System.out.println(basis);
        /*Unten unten = basis; 
        unten.berechne();
        unten.ausfuehren();*/
    }

    public static void b(){
        Unten unten = new Unten(11);
        unten.print();
        unten.ausfuehren();
        unten.berechne();
        Basis basis = unten;
        basis.print();
        basis.berechne();
    }

    public static void c(){
        Mitte mitte = new Unten(14);
        mitte.print();
        mitte.berechne();
        mitte.ausfuehren();
        System.out.println(mitte);
        /*Basis basis = new Basis(3);
        basis.berechne();
        basis.print();*/
    }

    public static void d(){
        Mitte mitte = new Mitte(9);
        mitte.print();
        mitte.berechne();
        mitte.ausfuehren();
        Basis basis = mitte;
        basis.print();
        basis.berechne();
        System.out.println(basis);
    }

    public static abstract class Basis {

        protected double a;

        public Basis(double a) {
            this.a = a;
            System.out.println("Basis: Konstruktor " + a);
        }

        public void print() {
            System.out.println("Basis.print() a = " + a);
        }

        public abstract void berechne();

        @Override
        public String toString() {
            return "Basis.toString: a = " + a;
        }
    }

    public static class Mitte extends Basis {

        protected double b;

        public Mitte(int b) {
            super(b / 3);
            System.out.println("Mitte: Konstruktor " + b);
            this.b = b;
        }

        @Override
        public void berechne() {
            System.out.println("Mitte.berechne(), a + b = " + (a + b));
        }

        public void ausfuehren() {
            System.out.println("Mitte.ausfuehren()");
        }

        @Override
        public String toString() {
            return super.toString() + "\nMitte.toString: b = " + b;
        }
    }

    public static class Unten extends Mitte {

        private int c;

        public Unten(int c) {
            super(c / 2);
            System.out.println("Unten: Konstruktor " + c);
            this.c = c;
        }

        public void print() {
            System.out.println("Unten.print() a = " + a + ", b = " + b + ", c = " + c);
        }

        @Override
        public void ausfuehren() {
            System.out.println("Unten.ausführen()");
        }

        @Override
        public String toString() {
            return super.toString() + "\nUnten.toString: c = " + c;
        }
    }

}
