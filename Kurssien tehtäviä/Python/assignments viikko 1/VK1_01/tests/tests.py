import unittest
from helpers import *

# Remove if no python functions are not tested
from my_code import *  # Jatetty tarkoituksella tässä tapauksessa

# HUOM! Tuo yllä oleva rivi ajaa my_code.py:n ja siellä tehdyt muuttujat jäävät
#      globaaleiksi muuttujiksi. test_Python-metodissa my_code.py:tä ei enää
#      ajeta, vaan siellä tarkastetaan vain vaaaditut globaalit muuttujat.


started_tests = 0
completed_tests = 0


class TestCode(unittest.TestCase):

    def test_Python(self):
        # Test python program
        self.startTest()

        # Tarkastetaan ensin muuttujat ja niiden arvot
        global pii, henkilotunnus,lampotila, nimi_eka, lahiosoite

        self.assertTrue(isinstance(pii, float) or isinstance(pii, double))
        self.assertTrue(pii < 3.2 and pii > 3.1)

        self.assertTrue(isinstance(lampotila, float)
                        or isinstance(lampotila, double)
                        or isinstance(lampotila, int))
        self.assertTrue(lampotila < 20.0 and lampotila > 0)

        self.assertTrue(isinstance(nimi_eka, str))
        self.assertTrue(len(nimi_eka) == 1)
        self.assertTrue(nimi_eka.isalpha())

        self.assertTrue(isinstance(lahiosoite, str))
        self.assertTrue(len(lahiosoite) == 13)

        self.assertTrue(isinstance(henkilotunnus, str))
        self.assertTrue(len(henkilotunnus) == 11)
        self.assertTrue("-" in henkilotunnus)

        # Ajetaan sitten ohjelma uudelleen ja katsotaan mitä se kirjoittaa stdoutiin
        results = callpython(cmdline_args=[], input='etunimi\nsukunimi\n').strip()
        results = results.split('\n')

        expected_results = [str(pii), str(lampotila), nimi_eka, lahiosoite, henkilotunnus]

        # Tarkastetan että tulostus oli oikein
        for r in results:
            print('Is ' + r + ' in expected output?')
            self.assertTrue(r in expected_results)

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

