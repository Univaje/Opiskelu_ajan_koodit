"""
KT4

Pääset suunnittelemaan Tuote-sovellusta suuren kauppaketjun tuotekehitysosastolla. Tehtävänäsi on suunnitella luokkarakenne, jolla voidaan hallinnoida yrityksen tuotteita. Kaikilla tuotteilla on samat yhteiset ominaisuudet: nimi, hinta, hyllypaikka sekä koodi. Nämä esitellään tuote-luokassa, jonka aliluokat perivät. Aliluokkia on kolme, joilla on omia ominaisuuksia:

a.                         vaate: koko, materiaali
b.                         ruoka: maa, paivays
c.                         kodinkone: takuu, paino 

Tee yksinkertainen ohjelma, jolla voit syöttää tuotteita yhdelle tuotelistalle sekä tulostaa koko listan sisällön. Luokkien jäsenmuuttujien tyyppejä ei ole määritelty eli saat päättää ne itse. Ohjelmassa ensin valitaan minkä tyyppistä tuotetta ollaan syöttämässä, jonka jälkeen tiedot täytetään. Miten lopetat syötön on sinun päätettävissä. Tietysti lopuksi lista tulostetaan.

Ohessa esimerkkiajo:

Mikä tuote lisätään listaan (1 = Ruoka, 2 = Vaate, 3 = Kodinkone, muu = Lopetus: 1
Anna tuotteen nimi: Sokeri
Anna hinta: 2.45
Anna hyllypaikka: Ruoka 11
Anna koodi: 111-222-333-22
Ruuan alkuperämaa: Tanska
Päiväys: 1.3.2024

Mikä tuote lisätään listaan (1 = Ruoka, 2 = Vaate, 3 = Kodinkone, muu = Lopetus: 2
Anna tuotteen nimi: Paita
Anna hinta: 22.10
Anna hyllypaikka: Vaate 3
Anna koodi: 222-122-232-11
Vaatteen koko: M
Vaatteen materiaali: Puuvilla

Mikä tuote lisätään listaan (1 = Ruoka, 2 = Vaate, 3 = Kodinkone, muu = Lopetus: 3
Anna tuotteen nimi: Pakastin
Anna hinta: 320.00
Anna hyllypaikka: Varasto 12
Anna koodi: 543-234-232-22
Kodinkoneen takuu: 1 vuosi
Kodinkoneen paino: 100kg

Mikä tuote lisätään listaan (1 = Ruoka, 2 = Vaate, 3 = Kodinkone, muu = Lopetus: l

Nimi:       Sokeri
Hinta:      2.45
Hylly:      Ruoka 11
Koodi:      111-222-333-22
Alkuperä:   Tanska
Päiväys:    1.3.2024

Nimi:       Paita
Hinta:      22.10
Hylly:      Vaate 3
Koodi:      222-122-232-11
Koko:       M
Materiaali: Puuvilla

Nimi:       Pakastin
Hinta:      320.00
Hylly:      Varasto 12
Koodi:      543-234-232-22
Takuu:      1 vuosi
Paino:      100kg

"""

from datetime import datetime
#Write class and imports here!


if __name__ == "__main__":
    #Main program here!
