"""
KT5

Dictionarya käytetään autojen rekisteröintietietojen tallentamiseen. Kirjoita seuraavat funktiot:

LueAutot - Lukee näppäimistöltä ensin auton rekisterinumeron ja sitten rekisteröintipäivämäärän ja tallentaa tiedot dictionaryyn.
Tätä toistetaan niin kauan kunnes rekisterinumeroksi syötetään LOPPU. Päivämäärät tallennetaan datetime-tyyppisinä.
Funktio palauttaa täytetyn dictionaryn. datetime-tyypin käyttö on opiskeltava omatoimisesti.
Päivämäärä syötetään muodossa dd.mm.yyyy, siis esimerkiksi 14.1.2022.
Rekisteröintipäivämäärä pyydetään syöttämään uudestaan mikäli päivämäärä on väärässä muodossa.

TalletaTiedostoon - Saa parametrina edellisen dictionaryn ja tallenta sen sisällön tekstitiedostoon autot.txt.
Tiedostossa päivämäärät eivät sisällä kellonaikaa. Tiedoston kukin rivi sisältää auton rekisterinumeron ja
rekisteröintipäivämäärän '\t'-merkillä erotettuna

LueTiedostosta - Lukee autot.txt:n dictionaryyn ja palauttaa sen.

TulostaTiedot - Saa parametrinaan dictionaryn joka sisältää rekisteröintitiedot.
Funktio tulostaa autojen rekisterinumerot ja rekisteröintipäivämäärät.

Kirjoita tarvittaessa testiohjelma funktioiden testaamiseksi.

VINKKI: Jos luet tiedostoa f rakenteella

for line in f:
   ...

niin muuttuja line sisältää myös rivinvaihdon. Sen voit poistaa str.strip()-metodilla.

"""
from datetime import datetime
import os
#Write functions, define global variables, and import modules here!

def LueAutot():
    DICK = {}
    while True:
        rek = input("Anna rekisterinumero: ")
        if rek.upper() == "LOPPU":
            return DICK
        try:
            pvm = input("Anna päivämäärä muodossa dd.mm.yyyy: ")
            agrs = pvm.split(".")
            day = datetime(int(agrs[2]),int(agrs[1]),int(agrs[0]))
        except:
            print("Päivämäärä on väärässä muodossa syötä uudelleen")
        else:
            DICK[rek] = day



def TalletaTiedostoon(kirjasto):
    directory = "C:/Users/negro/Documents/Läksyt/Python/assignments viikko 4/04_funktiot_kt4/src/"
    file = "Rekkarit.txt"
    fileWithPath = os.path.join(directory, file)
    if not os.path.exists(directory):
        os.mkdir(directory)
    if not os.path.exists(fileWithPath):
        kirjoita = open(fileWithPath, "x")
    else:
        kirjoita = open(fileWithPath, "w")
    for key, value in kirjasto.items():
        kirjoita.write(key, '\t', value.day+"."+ value.month+"."+value.year+"\r")
        #kirjoita.write(kirjasto[arg] +"\t"+ )

"""LueTiedostosta - Lukee autot.txt:n dictionaryyn ja palauttaa sen."""
def LueTiedostosta():
    Rekkarit = {}
    polku = "C:/Users/negro/Documents/Läksyt/Python/assignments viikko 4/04_funktiot_kt4/src/Rekkarit.txt"
    Lue = open(polku)
    data = Lue.readline()
    for Rek in data:
        Rek.strip()
        tiedot = Rek.split("\t")
        part1 = tiedot[0]
        day = tiedot[1].split(".")
        part2 = datetime(int(tiedot[2]),int(tiedot[1]),int(tiedot[0]))
        Rekkarit[part1] = part2
    return Rekkarit

"""TulostaTiedot - Saa parametrinaan dictionaryn joka sisältää rekisteröintitiedot.
Funktio tulostaa autojen rekisterinumerot ja rekisteröintipäivämäärät.
"""
def TulostaTiedot(kirjasto):
    for key, value in kirjasto.items():
        print(key, '\t', value.day+"."+ value.month+"."+value.year+"\r")
if __name__ == "__main__":
    #Write main program below this line
    Rekkarit = LueAutot()
    TalletaTiedostoon(Rekkarit)
    Rekkarit.clear()
    Rekkarit = LueTiedostosta()
    TulostaTiedot(Rekkarit)

