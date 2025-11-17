# -*- coding: utf-8 -*-

"""
KT2

Esittele muuttujat etunimi (enimi, "??"), sukunimi (snimi, "??") ja kokonimi (knimi, "?? ??") ja
laita niille oletusarvot. Muuttujanimet ja oletusarvot annettu suluissa. Tulosta kokonimi,
jolloin pitäisi tulostua aluksi "?? ??".
Lue käyttäjältä etunimi ja sukunimi ja yhdistä nämä kokonimi-muuttujaan.
Tulosta nimi näytölle kokonimi-muuttujasta. Alla esimerkki ohjelmasta:

?? ??

Anna etunimi : Jussi

Anna sukunimi : Juonio

Nimesi on Jussi Juonio
"""

enimi = "??"
snimi = "??"
knimi = enimi + " " + snimi

if __name__ == '__main__':
    print(knimi)
    enimi = input("Anna etunimi : ")
    snimi = input("Anna sukunimi : ")
    print("enimi="+enimi)
    print("snimi="+snimi)
    knimi = enimi + " " + snimi
    print("Nimesi on " + knimi)
