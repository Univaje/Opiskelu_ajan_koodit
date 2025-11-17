"""
KT3
Tee ohjelma, joka laskee mäkihyppääjän yhden kierroksen suorituspisteet. Ensin ohjelma kysyy hypyn pituuden
(liukuluku 0.5 metrin välein) jonka jälkeen se kysyy viiden arvostelutuomarin tyylipisteet
(0-20 välillä 0.5 välein eli esim. 16.5 tai 17.0 tai 18.5). Hyppääjän pisteet muodostuvat kaavasta.

pisteet = (hypyn pituus - kriittinen piste) * 1.8 + kolmen keskimmäisen tuomarin tyylipisteet + 60. 

Tyylipisteissä siis parhain ja huonoin pistemäärä tipahtaa pois.

Ohjelman hyppyrimäen kriittinen piste on 90 metrin kohdalla. Laita kriittinen piste globaaliin vakioon KR_PISTE.
Tulosta lopuksi hypyn pituus ja hypyn pisteet. Käytä ohjelmassa funktioita:


KysyHypynPituus - Kysyy hypyn pituuden ja palauttaa sen reaalilukuna
KysyTuomareidenPisteet - Kysyy tuomareiden pisteet yksi kerrallaan. Palauttaa listan jossa on kunkin tuomarin antamat pisteet reaalilukuina.
LaskeHypynPisteet - Saa ensimmäisenä parametrina hypyn pituuden sekä toisena parametrina listan joka sisältää kaikkien tuomareiden antamat tyylipisteet. Palauttaa hypyn pisteet lukuna.


"""
import math

KR_PISTE = 90
#Write functions and define global variables here!
def KysyHypynPituus():
    try:
        Pituus = float(input("Anna hypyn pituus 0,5 metrin tarkkuudella:"))
    except:
        print("Jotain meni pieleen!")
    else:
        Pituus = round(math.ceil(Pituus*2))/2
    return Pituus
def KysyTuomareidenPisteet():
    Pisteet= []
    counter = 1
    while counter != 6:
        try:
            arvo = float(input("Anna {0} tuomarin arvosana(0-20) 0,5 pisteen tarkkuudella:".format(counter)))
        except:
            print("Jotain meni pieleen!")
            continue
        else:
            if(arvo < 0 or arvo > 20):
                print("Anna arvo väliltä 0-20")
                continue
            else:
                Pisteet.append(arvo)
        counter += 1
    Pisteet.sort()
    Pisteet[0] = 0
    Pisteet[4] = 0
    return Pisteet
def LaskeHypynPisteet(Pituus, PisteLista):
    Pisteet = (((Pituus - KR_PISTE) * 1.8) + 60)
    for i in PisteLista:
        Pisteet += i
    return Pisteet
    
if __name__ == "__main__":
    tPisteet5 = []

    Pituus = KysyHypynPituus()
    PisteLista = KysyTuomareidenPisteet()
    Pisteet = LaskeHypynPisteet(Pituus, PisteLista);
    print("Hypyn pituus oli {0:5.2f} ja pisteet {1:5.2f}".format(Pituus, Pisteet))
