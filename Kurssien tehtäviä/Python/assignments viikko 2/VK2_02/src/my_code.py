# -*- coding: utf-8 -*-

"""
KT2
Lue käyttäjältä koenumero 4-10 väliltä. Jos käyttäjä syötti arvosanan väärin (ei väliltä 4-10) ,
niin tulosta "Et antanut arvosanaa annetulta väliltä".
Muussa tapauksessa tulosta:

 Hyvä (jos arvosana oli 9 tai 10)

 Kelpo (jos 7 - 8)

 Tyydyttävä (jos 5 - 6)

 Heikko (jos 4)

 Toteuta ohjelma if-elif-else -rakenteella.

 Ole tarkka, että tulostat juuri sen tekstin, jota pyydettiin.

 
"""

lku = int(input("Anna luku 4-10 : "))
if lku ==9 or lku==10:
    print("Hyvä")
elif lku ==7 or lku==8:
    print("Kelpo")
elif lku == 6 or lku == 5:
    print("Tyydyttävä")
elif lku == 4:
    print("Heikko")
else:
    print("Et antanut arvosanaa annetulta väliltä")