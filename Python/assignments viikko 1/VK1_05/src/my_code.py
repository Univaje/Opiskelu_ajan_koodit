# -*- coding: utf-8 -*-

"""

KT5

Esittele muuttuja pii, jolle annat alkuarvoksi piin likiarvon 6 desimaalin tarkkuudella.
Lue käyttäjältä ympyrän halkaisija ja tulosta ympyrän piiri ja pinta-ala kahden desimaalin tarkkuudella

Malli ohessa:

Anna ympyrän halkaisija: 12
Piiri on 37.70
Pinta-ala on 113.10

"""
if __name__ == '__main__':
    pii = 3.141593;
    ympyra = int(input("Anna ympyrän halkaisija: "))
    print("Piiri on {0:3.2f}".format(2*pii*(ympyra/2)))
    print("Pinta-ala on {0:3.2f}".format(pii*(ympyra/2)**2))


