import unittest
from helpers import *

# Remove if no python functions are not tested
#from my_code import *  # Jatetty tarkoituksella tässä tapauksessa

# HUOM! Tuo yllä oleva rivi ajaa my_code.py:n ja siellä tehdyt muuttujat jäävät
#      globaaleiksi muuttujiksi. test_Python-metodissa my_code.py:tä ei enää
#      ajeta, vaan siellä tarkastetaan vain vaaaditut globaalit muuttujat.


started_tests = 0
completed_tests = 0

code="""

for l in luvut:
    print('A'+str(l)+'A')

"""


class TestCode(unittest.TestCase):

    def test_Python(self):
        # Test python program
        self.startTest()

        # Tarkastetaan ensin muuttujat ja niiden arvot
        #global luvut

        #self.assertTrue(isinstance(luvut, list))


        # Ajetaan sitten ohjelma uudelleen ja katsotaan mitä se kirjoittaa stdoutiin
        results = callpythonmaincode(code=code, cmdline_args=[], input='1\n2\n3\n4\n5\n').strip()

        expected_results = ["15", "3.000", 'A1A', 'A2A', 'A3A', 'A4A', 'A5A' ]

        for r in expected_results:
            print('Is ' + r + ' in output?')
            self.assertTrue(r in results)

        # Ajetaan sitten ohjelma uudelleen ja katsotaan mitä se kirjoittaa stdoutiin
        results = callpythonmaincode(code=code, cmdline_args=[], input='2\n2\n4\n6\n6\n').strip()

        expected_results = ["20", "4.000", 'A2A', 'A4A', 'A6A']

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

