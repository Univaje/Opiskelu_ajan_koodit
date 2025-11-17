"""
KT2
Luo dictionary, jossa sinulla henkilöiden arvosanoja (0-5). Jos arvosana < 0, niin laitetaan nollaksi ja jos > 5, niin laitetaan viitoseksi.
Henkilön nimi on avain ja arvosana arvo. Dictionaryyn ei luonnollisestikaan saa lisätä samannimistä henkilöä uudelleen. Nimiä/arvosanoja kysytään,
kunnes nimeksi annetaan LOPPU.

Jos hylättyjä ei ole, niin tulosta kaikkien arvosanojen tiedot (nimi + arvosana). Jos hylättyjä on, niin tulosta
hylättyjen määrä näytölle ja sen lisäksi tulosta hylätyn saaneiden henkilöiden nimet.

Toteuta seuraavat funktiot:
LuoNimetJaArvosanat - Kysyy nimet ja arvosanat käyttäjältä ja palauttaa dictionaryn 
TulostaHylatyt - Saa parametrina dictionaryn ja tulostaa siitä nollan saaneiden henkilöiden nimet
PalautaHylattyjenMaara - Saa parametrina dictionaryn ja tulostaa siitä nollan saaneiden henkilöiden lukumäärän
TulostaKaikki - Saa parametrina dictionaryn ja tulostaa siitä kaikkien henkilöiden nimet ja arvosanat

Huolehdi, että ohjelma ei kaadu, jos arvosanaksi annetaan muuta kuin numeroita 

"""

#Write functions here!
def LuoNimetJaArvosanat():
    dick = {}
    while True:
        nimi = input("Anna Oppilaan nimi: ")
        if nimi.upper() == "LOPPU":
            return dick
        if not nimi in dick:
            while True:
                try:
                    arvosana = int(input("Anna Arvosana: "))
                except:
                    print("jotain meni pieleen! anna arvoasna uudelleen!")
                else:
                    if arvosana < 0:
                        arvosana = 0
                    elif arvosana > 5:
                        arvosana = 5
                    dick[nimi] = arvosana
                    break
        else:
            print("Nimi lisätty jo!")

def TulostaHylatyt(dick):
    for x,y in dick.items():
        if y == 0:
            print(x)
def PalautaHylattyjenMaara(dick):
    count = 0
    for x, y in dick.items():
        if y == 0:
            count += 1
    return count
def TulostaKaikki(dick):
    for x, y in dick.items():
        print(x,y)
if __name__ == "__main__":
    lista = LuoNimetJaArvosanat()
    nollat = PalautaHylattyjenMaara(lista)
    if (nollat > 0):
        print(nollat)
        TulostaHylatyt(lista)
    else:
        TulostaKaikki(lista)
