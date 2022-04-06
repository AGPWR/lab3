#include <iostream>
#include <string.h>
#include <stdbool.h>
#include "figury.hpp"

bool czyLiczba(const char *pStr){
        if(*pStr == '\0')
            return false;

        int licznikMinusow = 0;
        
        while (*pStr){
            switch(*pStr){
                case '-':
                    if(++licznikMinusow > 1)
                        return false;
                    break;
                default:
                    if(*pStr < '0' || *pStr > '9')
                        return false;
            }
            pStr++;
        }
        return true;   
    };

int main(int argc, char *argv[]){
    double obiekty[strlen(argv[1])][2];
    int pozycja = 2, bok1, bok2, bok3, bok4, kat;

    for (int charInt = 0; charInt < strlen(argv[1]); charInt++){
        if(argv[1][charInt] == 'o'){
            try{
                if(pozycja >= argc){
                    obiekty[charInt][0] = 0, obiekty[charInt][1] = 0;
                    throw std::runtime_error("brak argumentow");
                }
                if(atoi(argv[pozycja]) < 0 || !czyLiczba(argv[pozycja])){
                    obiekty[charInt][0] = 0;
                    obiekty[charInt][1] = 0;
                    throw std::invalid_argument("nieprawidlowy promien");
                } 
                Kolo *o = new Kolo(atoi(argv[pozycja]));
                obiekty[charInt][0] = o->obliczObwod();
                obiekty[charInt][1] = o->obliczPole();
                delete o;
            }catch(const std::invalid_argument& e){
                cout << argv[pozycja] << " - " << e.what() << endl;
            }catch(const std::runtime_error& e){
                cout << e.what() << endl;
            }
            pozycja++;
        }
        else if(argv[1][charInt] == 'c'){
            try{   
                if(pozycja+4 >= argc){
                    obiekty[charInt][0] = 0, obiekty[charInt][1] = 0;
                    throw std::invalid_argument("brak argumentow");
                }
                if(atoi(argv[pozycja]) < 0 || !czyLiczba(argv[pozycja]) || atoi(argv[pozycja+1]) < 0 || !czyLiczba(argv[pozycja+1]) || atoi(argv[pozycja+2]) < 0 ||
                 !czyLiczba(argv[pozycja+2]) || atoi(argv[pozycja+3]) < 0 || !czyLiczba(argv[pozycja+3]) || atoi(argv[pozycja+4]) < 0 || !czyLiczba(argv[pozycja+4])){
                    obiekty[charInt][0] = -1, obiekty[charInt][1] = -1;
                    throw std::invalid_argument("nieprawidlowy parametr");
                } 
                
                bok1 = atoi(argv[pozycja]);
                bok2 = atoi(argv[pozycja+1]);
                bok3 = atoi(argv[pozycja+2]);
                bok4 = atoi(argv[pozycja+3]);
                kat = atoi(argv[pozycja+4]);
                if(kat !=90 && kat < 180){
                    Romb *r = new Romb(bok1, kat);
                    obiekty[charInt][0] = r->obliczObwod();
                    obiekty[charInt][1] = r->obliczPole();
                    delete r;
                } 
                else if(kat%360 == 90){
                    if(bok1 == bok2 && bok2 == bok3 && bok3 == bok4){
                        Kwadrat *k = new Kwadrat(bok1);
                        obiekty[charInt][0] = k->obliczObwod();
                        obiekty[charInt][1] = k->obliczPole();
                        delete k;
                    } 
                    else{
                        Prostokat *p = new Prostokat(bok1, bok3);
                        obiekty[charInt][0] = p->obliczObwod();
                        obiekty[charInt][1] = p->obliczPole();
                        delete p;
                    }
                }
                else{
                    cout << kat << " - niepoprawny kat!" << endl;
                }
                
            } catch(const std::invalid_argument& e){
                cout << e.what() << endl;
            }
            pozycja += 5;
        }
        else if(argv[1][charInt] == 'p'){
            try{
                if(pozycja >= argc){
                    obiekty[charInt][0] = 0, obiekty[charInt][1] = 0;
                    throw std::runtime_error("brak argumentow");
                }
                if(atoi(argv[pozycja]) < 0 || !czyLiczba(argv[pozycja])){
                    obiekty[charInt][0] = 0, obiekty[charInt][1] = 0;
                    throw std::invalid_argument("nieprawidlowy bok");
                } 
                bok1 = atoi(argv[pozycja]);
                Pieciokat *p = new Pieciokat(bok1);
                obiekty[charInt][0] = p->obliczObwod();
                obiekty[charInt][1] = p->obliczPole();
                delete p;
            } catch(const std::invalid_argument& e){
                cout << argv[pozycja] << " - " << e.what() << endl;
            } catch(const std::runtime_error& e){
                cout << e.what() << endl;
            }
            pozycja++;
        }

        else if(argv[1][charInt] == 's'){
            try{
                if(pozycja >= argc){
                    obiekty[charInt][0] = 0, obiekty[charInt][1] = 0;
                    throw std::runtime_error("brak argumentow");
                }
                if(atoi(argv[pozycja]) < 0 || !czyLiczba(argv[pozycja])){
                    obiekty[charInt][0] = 0, obiekty[charInt][1] = 0;
                    throw std::invalid_argument("nieprawidlowy bok");
                }
                bok1 = atoi(argv[pozycja]);
                Szesciokat *s = new Szesciokat(bok1);
                obiekty[charInt][0] = s->obliczObwod();
                obiekty[charInt][1] = s->obliczPole();
                delete s;
            }catch(const std::invalid_argument& e){
                cout << argv[pozycja] << " - " << e.what() << endl;
            } catch(const std::runtime_error& e){
                cout << e.what() << endl;
            }
            pozycja++;
        }
        else{
            cout << argv[1][charInt] << " - niepoprawny format figury" << endl;
        }
    };
    
    for(int i = 0; i < strlen(argv[1]); i++){
        if(!obiekty[i][0] == 0){
            cout << "Obwod: " << obiekty[i][0] << endl;
            cout << "Pole: " << obiekty[i][1] << endl;
        }
    }
};