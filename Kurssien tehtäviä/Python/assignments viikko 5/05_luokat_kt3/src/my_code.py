"""
KT3

Tarvitset luokan Tekstiviesti, jossa käsitellään perinteisiä tekstiviestejä. Tekstiviestin tiedoissa on puhelinnumerot 2 kpl, joista toinen on siis lähettäjä ja toinen vastaanottaja. Samoin tarvitset tiedon siitä, jolloin viesti lähetettiin. Kyseinen aika ei tietenkään voi olla suurempi kuin nykyhetki. Lisäksi tiedoissa on luonnollisesti itse viestin teksti. 

Tee toinen luokka SMSUtils, jossa on ainoastaan kaksi kaksi metodia. Metodi haePaivanViestit saa parametrinaan listan Tekstiviesti-olioita sekä päiväyksen ja metodi palauttaa listassa ne tekstiviestit, jotka on lähetetty kyseisenä päivänä. Metodi tulostaNumeronViestit saa samoin parametrinaan listan Tekstiviesti -olioita sekä numeron. Metodi tulostaa kaikki ne viestit, jotka on lähetetty kyseisestä numerosta. Metodi ei palauta mitään.

Testiohjelma on valmiiksi kirjoitettu, toteuta siis luokat jotka toimivat sen kanssa.

Alla testiajon tulosteet:

Kaikki viestit:
+35844123123 +35840632123 02.11.2021 Kotiin ja heti
+35844126783 +358406334523 12.01.2021 Osta makkaraa
+35845678533 +3584007243 12.01.2021 I Love You!!
+35844126783 +358406334523 13.01.2021 Muistitko makkaran?!?!

Päivän 12.01.2021 viestit:
+35844126783 +358406334523 12.01.2021 Osta makkaraa
+35845678533 +3584007243 12.01.2021 I Love You!!

Lähettäjän +35844126783 viestit ovat:
+35844126783 +358406334523 12.01.2021 Osta makkaraa
+35844126783 +358406334523 13.01.2021 Muistitko makkaran?!?!
"""
from datetime import datetime
#Write class and imports here!

if __name__ == "__main__":
    viestit=[]
    dateFormat='%d.%m.%Y'
    timeFormat='%d.%m.%Y %H:%M:%S'
    viestit.append(Tekstiviesti('+35844123123', '+35840632123', datetime.strptime('02.11.2021 11:38:15', timeFormat), 'Kotiin ja heti'))
    viestit.append(Tekstiviesti('+35844126783', '+358406334523', datetime.strptime('12.01.2021 23:45:34', timeFormat), 'Osta makkaraa'))
    viestit.append(Tekstiviesti('+35845678533', '+3584007243', datetime.strptime('12.01.2021 22:33:44', timeFormat), 'I Love You!!'))
    viestit.append(Tekstiviesti('+35844126783', '+358406334523', datetime.strptime('13.01.2021 00:55:01', timeFormat), 'Muistitko makkaran?!?!'))

    print('Kaikki viestit:')
    for v in viestit:
        print(v)

    print()
    dt=datetime.strptime('12.01.2021', dateFormat)
    paivanViestit=SMSUtils.haePaivanViestit(viestit, dt)
    print('Päivän', datetime.strftime(dt, '%d.%m.%Y'),'viestit:')
    for v in paivanViestit:
        print(v)
    
    print()
    lahettaja='+35844126783'
    print('Lähettäjän', lahettaja, 'viestit ovat:')
    SMSUtils.tulostaNumeronViestit(viestit, lahettaja)
