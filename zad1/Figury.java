public class Figury {

    interface Metody{
        public double ObliczPole();
        public double ObliczObwod();
    }
    abstract static class Figura implements Metody{};
    abstract static class Czworokat implements Metody{};

    static class Kolo extends Figura{
        int a;
        Kolo(int a){
            this.a = a;
        }
        public double ObliczObwod(){
            return 2*Math.PI*this.a;
        }
        public double ObliczPole() {
            return Math.PI*this.a*this.a;
        }
    }
    static class Pieciokat extends Figura{
        int a;
        Pieciokat(int a){
            this.a = a;
        }
        public double ObliczObwod() {
            return 5 * this.a;
        }
        public double ObliczPole() {
            return this.a * this.a * Math.sqrt(25 + 10 * Math.sqrt(5)) / 4;
        }
    }
    static class Szesciokat extends Figura{
        int a;
        Szesciokat(int a){
            this.a = a;
        }
        public double ObliczObwod() {
            return 6 * this.a;
        }
        public double ObliczPole() {
            return (this.a * this.a * Math.sqrt(3) / 4) * 6;
        }
    }
    static class Kwadrat extends Czworokat{
        int a;
        Kwadrat(int a){
            this.a = a;
        }
        public double ObliczObwod() {
            return 4 * this.a;
        }
        public double ObliczPole() {
            return this.a * this.a;
        }
    }
    static class Romb extends Czworokat{
        int a, alfa;
        Romb(int a, int alfa){
            this.a = a;
            this.alfa = alfa;
        }
        public double ObliczObwod() {
            return 4 * this.a;
        }
        public double ObliczPole() {
            return Math.sin(Math.toRadians(this.alfa)) * this.a * this.a;
        }
    }
    static class Prostokat extends Czworokat{
        int a, b;
        Prostokat(int a, int b){
            this.a = a;
            this.b = b;
        }
        public double ObliczObwod() {
            return (2 * this.a) + (2 * this.b);
        }
        public double ObliczPole() {
            return this.a * this.b;
        }
    }

    public static void main(String[] args) {
        int pozycja = 1; 
        int bok1, bok2, bok3, bok4, kat;
        int iloscFigur = args[0].length();
        double objekty[][] = new double[iloscFigur][2];
 
        for (int charInt = 0; charInt < args[0].length(); charInt++) {
            if (args[0].toLowerCase().charAt(charInt) == 'o') {
                try {
                    int promien = Integer.parseInt(args[pozycja]);
                    Kolo o = new Kolo(promien);
                    objekty[charInt][0] = o.ObliczObwod();
                    objekty[charInt][1] = o.ObliczPole();
                }
                catch (NumberFormatException ex) {
                    System.out.println(args[pozycja] + " - nieprawidlowy promien");
                    System.exit(0);
                }
                pozycja++;
            }
            else if (args[0].toLowerCase().charAt(charInt) == 'c') {
                try {
                    bok1 = Integer.parseInt(args[pozycja]);
                    bok2 = Integer.parseInt(args[pozycja+1]);
                    bok3 = Integer.parseInt(args[pozycja+2]);
                    bok4 = Integer.parseInt(args[pozycja+3]);
                    kat = Integer.parseInt(args[pozycja+4]);
                    if (kat != 90 && kat < 180) {
                        Romb r = new Romb(bok1, kat);
                        objekty[charInt][0] = r.ObliczObwod();
                        objekty[charInt][1] = r.ObliczPole();
                    }
                    else if (kat%360 == 90) {
                        if (bok1 == bok2 && bok2 == bok3 && bok3 == bok4) {
                            Kwadrat k = new Kwadrat(bok1);
                            objekty[charInt][0] = k.ObliczObwod();
                            objekty[charInt][1] = k.ObliczPole();
                        }
                        else {
                            Prostokat p = new Prostokat(bok1, bok3);
                            objekty[charInt][0] = p.ObliczObwod();
                            objekty[charInt][1] = p.ObliczPole();
                        }
                    }
                    else {
                        System.out.println(kat+" - niepoprawny kat!");
                        System.exit(0);
                    }
                }
                catch (NumberFormatException ex) {
                    System.out.println("Jeden z argumentow nieprawidlowy! ("+args[pozycja]+" "+args[pozycja+1]+" "+args[pozycja+2]+" "+args[pozycja+3]+" "+args[pozycja+4]+")");
                    System.exit(0);
                }
                pozycja += 5;
            }

            else if (args[0].toLowerCase().charAt(charInt) == 'p') {
                try {
                    bok1 = Integer.parseInt(args[pozycja]);
                    Pieciokat p = new Pieciokat(bok1);
                    objekty[charInt][0] = p.ObliczObwod();
                    objekty[charInt][1] = p.ObliczPole();
                }
                catch (NumberFormatException ex) {
                    System.out.println(args[pozycja] + " - nieprawidlowy bok");
                    System.exit(0);
                }
                pozycja++;
            }

            else if (args[0].toLowerCase().charAt(charInt) == 's') {
                try {
                    bok1 = Integer.parseInt(args[pozycja]);
                    Szesciokat s = new Szesciokat(bok1);
                    objekty[charInt][0] = s.ObliczObwod();
                    objekty[charInt][1] = s.ObliczPole();
                }
                catch (NumberFormatException ex) {
                    System.out.println(args[0] + " - nieprawidlowy bok");
                    System.exit(0);
                }
                pozycja++;
            }
            
            else {
                System.out.println(args[0]+" - podano niepoprawne figury!");
                System.exit(0);
            }

        }

        for(int charInt = 0; charInt < args[0].length(); charInt++){
            System.out.println("Obwod: "+objekty[charInt][0]);
            System.out.println("Pole: "+objekty[charInt][1]);
        }
    }
}
// obsluga braku argumetow i ujemnych