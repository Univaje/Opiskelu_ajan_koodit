# -*- coding: utf-8 -*-

"""

Lue käyttäjältä arvot kahteen lukumuuttujaan. Nimeä muuttujat nimillä eka ja toka sekä alusta ne arvolla nolla.
Tulosta näiden muuttujien summa, erotus ja tulo alla olevalla tavalla
(HUOM! Laskutoimituksen tulostus alkaa kaikissa samasta kohdasta!)

Anna eka luku: 10

Anna toka luku: 5

Summa :        10 + 5 = 15

Erotus :       10 - 5 = 5

Tulo :         10 * 5 = 50
"""

if __name__ == '__main__':
    eka = 0
    toka = 0
    eka = int(input("Anna eka luku: "))
    toka = int(input("Anna toka luku: "))
    print("Summa :\t\t10 + 5 = ", eka+toka)
    print("Erotus :\t10 - 5 = ", eka-toka)
    print("Tulo :\t\t10 * 5 = ", eka*toka)
