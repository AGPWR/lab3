#pragma once
using namespace std;

class Figura{
    public:
        virtual double obliczObwod();
        virtual double obliczPole();
};

class Kolo: public Figura{
    public:
        int r;
        double obliczObwod();
        double obliczPole();
        Kolo(int r);
};

class Czworokat: public Figura{
    public:
        virtual double obliczObwod();
        virtual double obliczPole();
        Czworokat();
};

class Pieciokat: public Figura{
    public:
        int a;
        double obliczObwod();
        double obliczPole();
        Pieciokat(int a);
};

class Szesciokat: public Figura{
    public:
        int a;
        double obliczObwod();
        double obliczPole();
        Szesciokat(int a);
};

class Kwadrat: public Czworokat{
    public:
        int a;
        double obliczObwod();
        double obliczPole();
        Kwadrat(int a);
};

class Prostokat: public Czworokat{
    public:
        int a, b;
        double obliczObwod();
        double obliczPole();
        Prostokat(int a, int b);
};

class Romb: public Czworokat{
    public:
        int a, alfa;
        double obliczObwod();
        double obliczPole();
        Romb(int a, int alfa);
};

