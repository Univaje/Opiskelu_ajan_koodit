# -*- coding: utf-8 -*-

"""
KT 4

Kysy käyttäjältä lukujjen määrä ja arvo annettu  kplmäärä  liukulukuja väliltä 1 – 100.
Arvo luku seuraavasti:
    random_decimal = random.randint(100, 10000) / 100
Tulosta arvottu luku käyttäjälle (samalle riville kuin edellinen välilyönnillä erotettuna) ja kirjoita se arvot.txt tiedostoon allekkain.
Jos syötetty luku on < 1, ei ohjelma päättyy ja tulostuu "Virhe!".

Jos tiedosto on jo olemassa, vanhat tiedot menetetään
Älä käytä listaa tms tässä vaiheessa vaan vie luku tiedostoon heti, kun se on arvottu.
Sen jälkeen lue arvot tiedostosta listaan ja lajittele se. Tämän jälkeen tulosta listan  arvot sekä vie
lukujen kplmäärä, summa, keskiarvo, minimiarvo ja maksimiarvo tulokset.txt -tiedostoon
oheisen mallin mukaisesti kahdella desimaalilla (pl kpl):
Kpl: 2
Sum:5.00
Ka: 2.50
Min: 1.00
Max:4.00

Ohessa ajoesimerkki:

Montako lukua arvotaan? 3
Arvottiin seuraavat luvut ja talletetaan tiedostoon arvot.txt:
75.41 12.84 17.27
Luettiin seuraavat luvut (lajiteltuna) tiedostosta arvot.txt:
12.84 17.27 75.41
Ja lopuksi  tiedostosta tulokset.txt löytyy seuraavat tiedot:
Lkm: 3
Sum: 105.52
Ka: 35.17
Min: 12.84
Max: 75.41

Ole taas huolellinen tulostusten kanssa!

"""
import math
import random
import os

directory = "C:/Users/negro/Documents/Läksyt/Python/assignments viikko 3/VK3_04/src"
file= "arvot.txt"

fileWithPath = os.path.join(directory,file)
if not os.path.exists(directory):
    os.mkdir(directory)
if not os.path.exists(fileWithPath):
    kirjoita = open(fileWithPath, "x")
else:
    kirjoita = open(fileWithPath, "w")
maara = int(input("Montako lukua arvotaan? "))
if (maara >1):
    counter = 0
    print("Arvottiin seuraavat luvut ja talletetaan tiedostoon arvot.txt:")
    while (counter != maara):
        random_decimal = random.randint(100, 10000) / 100
        print("{0} ".format(random_decimal), end='')
        kirjoita.writelines("{} ".format(random_decimal))

        counter +=1
    kirjoita.close()
    rfile = open(fileWithPath,"rt")
    luetut = rfile.readline()
    rfile.close()
    rivit = [eval(i) for i in luetut.split()]
    rivit.sort()
    print("\nLuettiin seuraavat luvut (lajiteltuna) tiedostosta arvot.txt:")
    for i in rivit:
        print("{0} ".format(i), end='')
    file = "tulokset.txt"
    fileWithPath = os.path.join(directory, file)
    if (os.path.exists):
        kirjoita = open(fileWithPath, "wt")
    else:
        kirjoita = open(fileWithPath, "xt")
    kirjoita.write("Lkm: {0}\n".format(len(rivit)))
    kirjoita.write("Sum: {0:5.2f}\n".format(math.fsum(rivit)))
    kirjoita.write("Ka: {0:5.2f}\n".format(math.fsum(rivit)/len(rivit)))
    kirjoita.write("Min: {0:5.2f}\n".format(rivit[0]))
    kirjoita.write("Max: {0:5.2f}\n".format(rivit[maara-1]))
    kirjoita.close()
    print("\nJa lopuksi  tiedostosta tulokset.txt löytyy seuraavat tiedot:")
    rfile = open(fileWithPath, "rt")
    rivit = rfile.readlines()
    rfile.close()
    for i in rivit:
        teksti = i.strip()
        print(teksti)
else:
    print("Virhe!")