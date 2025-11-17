# -*- coding: utf-8 -*-
"""

KT4

Lue nimi, pituus ja paino em nimisiin muuttujiin. Käytä juuri noita muuttujanimiä.
Esittele lisäksi bmi muuttuja ja alusta se nollaksi. Kysy käyttäjältä nimi, pituus metreinä ja paino kiloina.
Laske painoindeksi bmi muuttujaan seuraavasti:


bmi = paino / pituus ^ 2



Tulosta lopuksi:


Jussi Juonio pituutesi on 1.81 m ja painosi 104.0 kg
Painoindeksisi on siten 31.75

Huomaa, että bmi tulee kahdella desimaalilla

"""
if __name__ == '__main__':
    nimi = input("nimi:")
    pituus = float(input("Pituus :"))
    paino = float(input("Paino :"))
    bmi = paino / (pituus*pituus)
    print("{0} pituutesi on {1} m ja painosi {2} kg\nPainoindeksisi on siten {3:3.2f}".format(nimi, pituus, paino, bmi ))
