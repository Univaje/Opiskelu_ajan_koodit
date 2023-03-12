import unittest
from helpers import *

# Remove if no python functions are not tested
# from my_code import *  # Jatetty tarkoituksella tässä tapauksessa

# HUOM! Tuo yllä oleva rivi ajaa my_code.py:n ja siellä tehdyt muuttujat jäävät
#      globaaleiksi muuttujiksi. test_Python-metodissa my_code.py:tä ei enää
#      ajeta, vaan siellä tarkastetaan vain vaaaditut globaalit muuttujat.


started_tests = 0
completed_tests = 0


class TestCode(unittest.TestCase):

    def test_Python(self):
        # Test python program
        self.startTest()


        # Ajetaan sitten ohjelma uudelleen ja katsotaan mitä se kirjoittaa stdoutiin
        results = callpython(cmdline_args=[], input='0\n').strip()
        self.assertTrue(results.count("Virhe!")== 1)
        
        results = callpython(cmdline_args=[], input='3\n').strip()
        rivit = results.split("\n")
        for r  in rivit:
            print(r)
        
        arvotstr1 = rivit[1].strip().split(" ") # Lajittelematon
        arvot1 = list()
        for a in arvotstr1:
            arvot1.append(float(a))
        arvot1.sort()
        print(arvot1)

        arvotstr2 = rivit[3].strip().split(" ") # Lajiteltu
        arvot2= list()

        for a in arvotstr2:
            arvot2.append(float(a))
        print(arvot2)

        self.assertTrue(arvot1 == arvot2)

        l = len(arvot2)
        print("kpl =" + str(l))
        s = sum(arvot2)
        print("Summa = " + str(s))
        mi = min(arvot2)
        ma = max(arvot2)
        ka = s / l
        #Tsekataan, että tiedosto arvot.txt on olemassa
        try:
                with open('./src/arvot.txt', 'rt') as f:
                    arvotStr = f.read()
 
        except:
                self.fail("Arvot.txt ei löydy")

        # Tsekataan, että tiedosto tulokset.txt on olemassa
        try:
            with open('./src/tulokset.txt', 'rt') as f:
                tulokset = f.read()
                print(tulokset)

                self.assertTrue("{0:d}".format(l) in tulokset)
                self.assertTrue("{0:.2f}".format(s) in tulokset)
                self.assertTrue("{0:.2f}".format(mi) in tulokset)
                self.assertTrue("{0:.2f}".format(ma) in tulokset)
                self.assertTrue("{0:.2f}".format(ka) in tulokset)

        except:
            self.fail("Tulokset.txt ei löydy")



        self.endTest()


    def startTest(self):
        global started_tests
        started_tests = started_tests + 1
        print('\nStart test', started_tests)

    def endTest(self):
        global completed_tests
        print('End test', started_tests)
        completed_tests = completed_tests + 1


def completed():
    global completed_tests
    return completed_tests


def started():
    global started_tests
    return started_tests

