"""

KT2

Tee luokka Tilaus, jolla on kolme jäsenmuuttujaa: tilausnumero, tuotekoodi ja maara.

Toteuta lisäksi funktiot hae_tilaukset, talleta_tilaukset sekä tulosta_tilaukset. Käytä tiedostonnimenä globaalin muuttujan filename arvoa. Käytä talletukseen JSON-formaattia.

Pääohjelma on valmiina, älä muokkaa sitä. Alla esimerkki ohjelman ajosta:


Lisataanko tilaustuote (k/e): k
Tilausnumero: a329847
Tuotekoodi: 22323
Maara: 283
Lisataanko tilaustuote (k/e): k
Tilausnumero: 383838b
Tuotekoodi: 234
Maara: 11
Lisataanko tilaustuote (k/e): e
{'tilausnumero': 'a329847', 'tuotekoodi': '22323', 'maara': 283}
{'tilausnumero': '383838b', 'tuotekoodi': '234', 'maara': 11}

"""

import json

filename="./tilaukset.json"

#Replace pass-lines with your code

class Tilaus(dict):
    pass

def hae_tilaukset():
    pass

def talleta_tilaukset(tilaukset):
    pass

def tulosta_tilaukset(tilaukset):
    pass

if __name__ == '__main__':
    tilaukset = hae_tilaukset()

    while(True):
        vast=input("Lisataanko tilaustuote (k/e): ")
        if (vast.upper() != "K"):
            break
        tilausnumero=input("Tilausnumero: ")
        tuotekoodi=input("Tuotekoodi: ")
        maara=int(input("Maara: "))
        tilaus=Tilaus(tilausnumero,tuotekoodi,maara)
        tilaukset.append(vars(tilaus))

    talleta_tilaukset(tilaukset)
    del tilaukset

    #Read JSON structure
    t_list=hae_tilaukset()
    #Print JSON structure
    tulosta_tilaukset(t_list)



