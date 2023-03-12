"""
KT1


Tee ohjelma, jossa kysytään KysyJaTestaaLuku() nimisessä funktiossa  käyttäjältä kokonaisluku. 

Funktio palauttaa kokonaislukuarvon seuraavasti:

 

1, jos syötetty luku on positiivinen.
0, jos syötetty luku on nolla.

-1, jos syötetty luku on negatiivinen. 

 

Tulosta näiden paluuarvojen perusteella pääohjelmassa ilmoitus ruudulle.


”Luku oli positiivinen”, jos paluuarvo oli 1.
”Luku oli nolla”, jos paluuarvo oli 0
”Luku oli negatiivinen”, jos paluuarvo oli -1.

"""

#Write KysyJaTestaaLuku function here!
def KysyJaTestaaLuku():
    luku = int(input("Anna Luku: "))
    if luku <0:
        return -1
    elif luku >0:
        return 1
    else:
        return 0


if __name__ == "__main__":
    #Write main program below this line
    lukusi = KysyJaTestaaLuku()
    if lukusi == 1:
        print("Luku oli positiivinen")
    elif lukusi == -1:
        print("Luku oli negatiivinen")
    else:
        print("Luku oli nolla")