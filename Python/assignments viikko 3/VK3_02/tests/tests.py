import unittest
from helpers import *

# Remove if no python functions are not tested
#from my_code import *  # Jatetty tarkoituksella tässä tapauksessa

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
        #print (results)
        self.assertTrue("Virhe!" in results)
        
        # Ajetaan sitten ohjelma uudelleen ja katsotaan mitä se kirjoittaa stdoutiin
        results = callpython(cmdline_args=[], input='5\n').strip()


        for r in range(3, 21, 2): # Ykkönen on paha testattava, menköön läpi
            print('Is ' + str(r) + ' in output?')
            self.assertFalse(str(r) in results)

        # Tsekataan, että viimeinen merkki ei ole pilkku

        rivit = results.split("\n")
        for r  in rivit:
            print(r)
        numerotStr = rivit[-1]
        # Tsekataan, että viimeinen merkki ei ole pilkku
        viimeinen = numerotStr[-1]
        self.assertFalse(viimeinen  == ",")

        numerot = numerotStr.split(",")
        suurin = -1
        pienin = 21
        for n in numerot:
            n = int(n)
            self.assertTrue((n % 2) == 0)

            if n > suurin:
                suurin = n
            if n < pienin:
                pienin = n

        expected_results = ["Suurin: "+ str(suurin), "pienin: "+ str(pienin)]

        for r in expected_results:
                print('Is ' + r + ' in output?')
                self.assertTrue(r in results)


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

