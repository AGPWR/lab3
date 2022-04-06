#include <iostream>
#include <string.h>
#include <math.h>
#include "figury.hpp"
const double PI = 3.14159265359;

double Figura::obliczObwod(){};
double Figura::obliczPole(){};
Czworokat::Czworokat(){};
double Czworokat::obliczObwod(){};
double Czworokat::obliczPole(){};

Kolo::Kolo(int r){this->r = r;};
double Kolo::obliczObwod(){return 2*PI*this->r;};
double Kolo::obliczPole(){return this->r*this->r*PI;};

Pieciokat::Pieciokat(int a){this->a = a;};
double Pieciokat::obliczObwod(){return 5*this->a;};
double Pieciokat::obliczPole(){return ((sqrt(25+10*sqrt(5)))*this->a*this->a)/4;};

Szesciokat::Szesciokat(int a){this->a = a;};
double Szesciokat::obliczObwod(){return 6*this->a;};
double Szesciokat::obliczPole(){return 3*((this->a*this->a*sqrt(3))/2);};

Kwadrat::Kwadrat(int a){this->a = a;};
double Kwadrat::obliczObwod(){return 4*this->a;};
double Kwadrat::obliczPole(){return this->a*this->a;};

Prostokat::Prostokat(int a, int b){this->a = a; this->b = b;};
double Prostokat::obliczObwod(){return 2*this->a+2*this->b;};
double Prostokat::obliczPole(){return this->a*this->b;};

Romb::Romb(int a, int alfa){this->a = a; this->alfa = alfa;};
double Romb::obliczObwod(){return 4*this->a;};
double Romb::obliczPole(){return this->a*this->a*(sin(this->alfa*(PI/180)));};
