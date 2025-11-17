# -*- coding: utf-8 -*-

"""
KT 5

Kirjoita Python-kielinen ohjelma, joka kysyy käyttäjän nimeä, kuitenkin enintään 18 merkkiä.
Merkeissä saa olla tyhjeitä. Jos merkkejä > 18, tulostuu teksti "Virhe!".
Ohjelma tulostaa nimen alla kuvatusti laskevana ja pituudesta riippumatta sivusuunnassa alkaen oikeasta reunasta.
Jotta teksti hahmottuisi riviksi, lisää kaksi välilyöntiä perättäisten merkkien väliin. Kirjoita tämä myös nimi.txt-tiedostoon samassa muodossa.

Esimerkkiajo:
Anna nimesi:Jukka
        a
      k
    k
  u
J

"""
import os

directory = "C:/Users/negro/Documents/Läksyt/Python/assignments viikko 3/VK3_05/src"
file= "nimi.txt"

fileWithPath = os.path.join(directory,file)
if not os.path.exists(directory):
    os.mkdir(directory)
if not os.path.exists(fileWithPath):
    kirjoita = open(fileWithPath, "x")
else:
    kirjoita = open(fileWithPath, "w")

nimi = input("Anna nimesi:")
if len(nimi) <= 18:
    loop = len(nimi)-1
    while loop >=0:
        loop2 = 0
        while loop2 < loop:
            kirjoita.write("  ")
            print("  ", end='')
            loop2 += 1
        kirjoita.write("{0}\n".format(nimi[loop]))
        print(nimi[loop])
        loop -=1
else:
    print("Virhe!")
