# -*- coding: utf-8 -*-

#
# KT1
#
# Luo aluksi tyhjä lista (muuttujanimi: luvut) ja lue siihen käyttäjältä 5 kokonaislukuarvoa.
# Tulosta lopuksi syötettyjen lukujen summa (kokonaislukuna) ja keskiarvo kolmella desimaalilla
#
# Esimerkkiajo ohessa
#
# Anna luku: 1
# Anna luku: 2
# Anna luku: 3
# Anna luku: 4
# Anna luku: 5
# Summa on: 15
# Keskiarvo on: 3.000
#
luvut = []
while True:
 summa = 0
 luvut.append(input("anna luku: "))
 size = len(luvut)
 if (size == 5):
     for u in luvut:
         summa += int(u)
     print("Summa on:", summa)
     print("Keskiarvo on:{0:5.3f}".format(summa / size))
     break




