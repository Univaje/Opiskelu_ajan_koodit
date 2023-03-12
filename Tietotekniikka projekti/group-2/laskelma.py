Tyokalut = {}
Nominaalit = {}
Toleranssit = {}
Mittaustulos = {}
Korjaustarve ={}
Keys = []
 # ("""Palautetaan dictionery? palautetaan työkalunumero ja korjausluku""")
"""Laskelmat tallennetaan multi arrey listaan muodossa [Työkalu,Nominaali,Toleranssi,Mittaustulos]"""
laskelma = [[2,28,"D",0.135,28.15],[19,16,"D",0.05,16.10],[19,3,"L",0.05,3.02],[19,18,"L",0.05,18.02],[19,80,"D",0.00,80.07],[2,75,"D",-0.03,75.00],[19,40,"D",0.03,40.30],[19,54,"D",0.05,54.05]]
index = 0
def LaskeKorjaustarve(Lista,paikka):
    Koko = len(Lista)
    for rivi in range(Koko):
        apulistaD = ["D"]
        apulistaL = ["L"]
        toleranssit = []
        nominaalit = []
        mittatulokset = []
        if (Lista[rivi][paikka] in Mittaustulos):
            continue
        for Tarkasteltava in range(0, Koko - rivi):
            if (Lista[rivi][paikka] == Lista[Tarkasteltava][paikka]):
                if Lista[Tarkasteltava][paikka+3] > 0:
                    korjaustarve = round((Lista[Tarkasteltava][paikka+1] + Lista[Tarkasteltava][paikka+3])- Lista[Tarkasteltava][paikka+4],3)
                else:
                    korjaustarve = round((Lista[Tarkasteltava][paikka + 1] - Lista[Tarkasteltava][paikka + 3]) - Lista[Tarkasteltava][paikka + 4] , 3)
                toleranssit.append(Lista[Tarkasteltava][paikka+3])
                nominaalit.append(Lista[Tarkasteltava][paikka+1])
                mittatulokset.append(Lista[Tarkasteltava][paikka+4])
                if (Lista[Tarkasteltava][paikka + 2] == "D"):
                    apulistaD.append(korjaustarve)
                else:
                    apulistaL.append(korjaustarve)
        apulistaD.extend(apulistaL)
        Keys.append(Lista[rivi][paikka])
        Korjaustarve[Lista[rivi][paikka]] = apulistaD
        Toleranssit[Lista[rivi][paikka]] = toleranssit
        Nominaalit[Lista[rivi][paikka]] = nominaalit
        Mittaustulos[Lista[rivi][paikka]] = mittatulokset
    Koko = len(Korjaustarve)
    for laskettavat in range(0,Koko):
        #Tarkistin onko kyseessä pituus vai Halkaisija
        korjainvaihto = False
        # Kyseisen työkalun Halkaisijan tiedot
        Dkorjaimet = []
        Dnominal = []
        Dtol = []
        Dmitta = []
        # Kyseisen työkalun pituus tiedot
        Lkorjaimet = []
        Lnominal = []
        Ltol = []
        Lmitta = []
        # Kyseisen työkalun purettavat tiedot (nollattava joka työkalun kohdalla
        KT = []
        tol = []
        mittatulos = []
        nominaali = []
        #Täytetään tarvittavat tiedot purkuun
        KT = Korjaustarve[Keys[laskettavat]]
        tol = Toleranssit[Keys[laskettavat]]
        nominaali = Nominaalit[Keys[laskettavat]]
        mittatulos = Mittaustulos[Keys[laskettavat]]
        Koko = len(KT)
        #Tarkistetaan onko kyseessä halkaisija vai pituus ja täytetään niihin kohdistuvat listat laskemista varten
        for i in range(Koko):
            if (KT[i] == "L"):
                korjainvaihto = True
            if (not korjainvaihto):
                if (KT[i] != "D"):
                    Dkorjaimet.append(KT[i])
                    Dtol.append(tol[i-1])
                    Dnominal.append(nominaali[i-1])
                    Dmitta.append(mittatulos[i-1])
            else:
                if (KT[i] != "L"):
                    Lkorjaimet.append(KT[i])
                    Ltol.append(tol[i-2])
                    Lnominal.append(nominaali[i-2])
                    Lmitta.append(mittatulos[i - 2])
        Koko = len(Dkorjaimet)
        Meni = len(Dmitta)
        #Käydään läpi halkaisia korjaimien maksimi sallittu korjaus luku jolla kaikki toleranssit ovat hyväksyttyjä
        MaxKorjaus = []
        LDkorjaustarve = ["D"]
        for D in range(Koko):
            Korjattava = Dkorjaimet[D]
            for mitta in range(Meni):
                toleranssilapi = False
                while(not toleranssilapi):
                    if (Dtol[D] > 0):
                        alaraja = Dnominal[mitta] - Dtol[D]
                    else:
                        alaraja = Dnominal[mitta] + Dtol[D]
                    if (Dtol[D] < 0):
                        ylaraja = Dnominal[mitta] - Dtol[D]
                    else:
                        ylaraja = Dnominal[mitta] + Dtol[D]
                    if Korjattava < 0:
                        testi = round(Dmitta[mitta]+Korjattava,3)
                    else:
                        testi = round(Dmitta[mitta] - Korjattava, 3)
                    if alaraja <= testi <= ylaraja:
                        toleranssilapi = True
                    elif ( Korjattava == 0.00):
                        toleranssilapi = True
                    else:
                        toleranssilapi = False
                        if Korjattava < 0:
                            Korjattava = round(Korjattava + 0.001, 3)
                        else:
                            Korjattava = round(Korjattava - 0.001, 3)
            MaxKorjaus.append(Korjattava)
        if max(MaxKorjaus) == 0:
            LDkorjaustarve.append(min(MaxKorjaus))
        else:
            LDkorjaustarve.append(max(MaxKorjaus))
        #L korjain
        Koko = len(Lkorjaimet)
        Meni = len(Lmitta)
        apulista = []
        LDkorjaustarve.append("L")
        for L in range(Koko):
            Korjattava = Lkorjaimet[L]
            for mitta in range(Meni):
                toleranssilapi = False
                while (not toleranssilapi):
                    if (Dtol[L] > 0):
                        alaraja = Lnominal[mitta] - Ltol[L]
                    else:
                        alaraja = Lnominal[mitta] + Ltol[L]
                    if (Dtol[L] < 0):
                        ylaraja = Lnominal[mitta] - Ltol[L]
                    else:
                        ylaraja = Lnominal[mitta] + Ltol[L]
                    if Korjattava < 0:
                        testi = round(Lmitta[mitta] + Korjattava, 3)
                    else:
                        testi = round(Lmitta[mitta] - Korjattava, 3)
                    if alaraja <= testi <= ylaraja:
                        toleranssilapi = True
                    elif (Korjattava == 0.00):
                        toleranssilapi = True
                    else:
                        toleranssilapi = False
                        if Korjattava < 0:
                            Korjattava = round(Korjattava + 0.001, 3)
                        else:
                            Korjattava = round(Korjattava - 0.001, 3)
            apulista.append(Korjattava)
        if apulista:
            if max(MaxKorjaus) == 0:
                LDkorjaustarve.append(min(apulista))
            else:
                LDkorjaustarve.append(max(apulista))
        Tyokalut[Lista[laskettavat][paikka]] = LDkorjaustarve
        print(Tyokalut)


    return Tyokalut

"""Palauta dick sisällä Dick"""


#mrBubbles(laskelma, index)
Done = LaskeKorjaustarve(laskelma,index)
done = laskelma