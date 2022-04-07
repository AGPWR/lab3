class UjemnyAgrumentExeption extends Exception{};
public class Figury{
    interface JednoArg {
        
        public double ObliczPole(int arg1) throws UjemnyAgrumentExeption;
        public double ObliczObwod(int arg1) throws UjemnyAgrumentExeption;
    }
    
    interface DwuArg {
        public double ObliczPole(int arg1, int arg2) throws UjemnyAgrumentExeption;
        public double ObliczObwod(int arg1, int arg2) throws UjemnyAgrumentExeption;
    }

    public enum JednoParametrowe implements JednoArg{
        OKRAG {
            public double ObliczObwod(int arg1) throws UjemnyAgrumentExeption {
                if(arg1 < 0) throw new UjemnyAgrumentExeption();
                return 2*Math.PI*arg1;
            }
            public double ObliczPole(int arg1) throws UjemnyAgrumentExeption{
                if(arg1 < 0) throw new UjemnyAgrumentExeption();
                return Math.PI*arg1*arg1;
            }
        },
        KWADRAT {
            public double ObliczObwod(int arg1) throws UjemnyAgrumentExeption{
                if(arg1 < 0) throw new UjemnyAgrumentExeption();
                return 4 * arg1;
            }
            public double ObliczPole(int arg1) throws UjemnyAgrumentExeption{
                if(arg1 < 0) throw new UjemnyAgrumentExeption();
                return arg1 * arg1;
            }
        },
        PIECIOKAT {
            public double ObliczObwod(int arg1) throws UjemnyAgrumentExeption{
                if(arg1 < 0) throw new UjemnyAgrumentExeption();
                return 5 * arg1;
            }
            public double ObliczPole(int arg1) throws UjemnyAgrumentExeption{
                if(arg1 < 0) throw new UjemnyAgrumentExeption();
                return arg1 * arg1 * Math.sqrt(25 + 10 * Math.sqrt(5)) / 4;
            }
        },
        SZESCIOKAT {
            public double ObliczObwod(int arg1) throws UjemnyAgrumentExeption{
                if(arg1 < 0) throw new UjemnyAgrumentExeption();
                return 6 * arg1;
            }
            public double ObliczPole(int arg1) throws UjemnyAgrumentExeption{
                if(arg1 < 0) throw new UjemnyAgrumentExeption();
                return (arg1 * arg1 * Math.sqrt(3) / 4) * 6;
            }
        };

    }

    public enum DwuParametrowe implements DwuArg {
        PROSTOKAT {
            public double ObliczObwod(int arg1, int arg2) throws UjemnyAgrumentExeption{
                if(arg1 < 0 || arg2 <0 ) throw new UjemnyAgrumentExeption();
                return (2 * arg1) + (2 * arg2);
            }
            public double ObliczPole(int arg1, int arg2) throws UjemnyAgrumentExeption{
                if(arg1 < 0 || arg2 <0 ) throw new UjemnyAgrumentExeption();
                return arg1 * arg2;
            }
        },
        ROMB {
            public double ObliczObwod(int arg1, int arg2) throws UjemnyAgrumentExeption{
                if(arg1 < 0 || arg2 <0 ) throw new UjemnyAgrumentExeption();
                return 4 * arg1;
            }
            public double ObliczPole(int arg1, int arg2) throws UjemnyAgrumentExeption{
                if(arg1 < 0 || arg2 <0 ) throw new UjemnyAgrumentExeption();
                return Math.sin(Math.toRadians(arg2)) * arg1 * arg1;
            }
        };

    }

    public static void main(String[] args) {

        int pozycja = 1; 
        int bok1, bok2, bok3, bok4, kat;
        double objekty[][] = new double[args[0].length()][2];
 
        for (int charInt = 0; charInt < args[0].length(); charInt++) {
            // o - okrag ; c - czworokat ; p - pieciokat ; s - szesciokat

            if (args[0].toLowerCase().charAt(charInt) == 'o') {
                try {
                    int promien = Integer.parseInt(args[pozycja]);
                    objekty[charInt][0] = JednoParametrowe.OKRAG.ObliczObwod(promien);
                    objekty[charInt][1] = JednoParametrowe.OKRAG.ObliczPole(promien);
                }
                catch (NumberFormatException | UjemnyAgrumentExeption ex) {
                    System.out.println(args[pozycja] + " - nieprawidlowy promien");
                    System.exit(0);
                }
            
                pozycja ++;
            }

            else if (args[0].toLowerCase().charAt(charInt) == 'c') {
                try {
                    bok1 = Integer.parseInt(args[pozycja]);
                    bok2 = Integer.parseInt(args[pozycja+1]);
                    bok3 = Integer.parseInt(args[pozycja+2]);
                    bok4 = Integer.parseInt(args[pozycja+3]);
                    kat = Integer.parseInt(args[pozycja+4]);
                    if (kat != 90 && kat < 180) {
                        objekty[charInt][0] = DwuParametrowe.ROMB.ObliczObwod(bok1, kat);
                        objekty[charInt][1] = DwuParametrowe.ROMB.ObliczPole(bok1, kat);
                    }
                    else if (kat%360 == 90) {
                        if (bok1 == bok2 && bok2 == bok3 && bok3 == bok4) {
                            objekty[charInt][0] =JednoParametrowe.KWADRAT.ObliczObwod(bok1);
                            objekty[charInt][1] = JednoParametrowe.KWADRAT.ObliczPole(bok1);
                        }
                        else {
                            objekty[charInt][0] = DwuParametrowe.PROSTOKAT.ObliczObwod(bok1, bok3);
                            objekty[charInt][1] = DwuParametrowe.PROSTOKAT.ObliczPole(bok1, bok3);
                        }
                    }
                    else {
                        System.out.println(kat+" - niepoprawny kat!");
                        System.exit(0);
                    }
                }
                catch (NumberFormatException | UjemnyAgrumentExeption ex) {
                    System.out.println("Jeden z bokow lub kat jest nieprawidlowy! ("+args[pozycja]+" "+args[pozycja+1]+" "+args[pozycja+2]+" "+args[pozycja+3]+" "+args[pozycja+4]+")");
                    System.exit(0);
                }
                pozycja += 5;
            }

            else if (args[0].toLowerCase().charAt(charInt) == 'p') {
                try {
                    bok1 = Integer.parseInt(args[pozycja]);
                    objekty[charInt][0] =JednoParametrowe.PIECIOKAT.ObliczObwod(bok1);
                    objekty[charInt][1] = JednoParametrowe.PIECIOKAT.ObliczPole(bok1);
                }
                catch (NumberFormatException | UjemnyAgrumentExeption ex) {
                    System.out.println(args[pozycja] + " - nieprawidlowy bok");
                    System.exit(0);
                }
                pozycja++;
            }

            else if (args[0].toLowerCase().charAt(charInt) == 's') {
                try {
                    bok1 = Integer.parseInt(args[pozycja]);
                    objekty[charInt][0] =JednoParametrowe.SZESCIOKAT.ObliczObwod(bok1);
                    objekty[charInt][1] = JednoParametrowe.SZESCIOKAT.ObliczPole(bok1);
                }
                catch (NumberFormatException | UjemnyAgrumentExeption ex) {
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


