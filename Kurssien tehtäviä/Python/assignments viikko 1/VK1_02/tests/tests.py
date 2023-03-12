import unittest
from helpers import *

# Remove if no python functions are not tested
# from my_code import *  # Jatetty tarkoituksella tässä tapauksessa

# HUOM! Tuo yllä oleva rivi ajaa my_code.py:n ja siellä tehdyt muuttujat jäävät
#      globaaleiksi muuttujiksi. test_Python-metodissa my_code.py:tä ei enää
#      ajeta, vaan siellä tarkastetaan vain vaaaditut globaalit muuttujat.


started_tests = 0
completed_tests = 0

code="""

if 'enimi' in locals():
    print('enimi="'+enimi+'"')

if 'snimi' in locals():
    print('snimi="'+snimi+'"')

if 'knimi' in locals():
    print('knimi="'+knimi+'"')
"""

class TestCode(unittest.TestCase):

    def test_Python(self):
        # Test python program
        self.startTest()

        input='Jussi\nJuonio\n'
        print('Test with input:')
        print(input)
        results = callpythonmaincode(code=code, cmdline_args=[], input=input).strip()
        #results = results.split('\n')
        #print (results)
        expected_results = ["Nimesi on Jussi Juonio", "?? ??", 'enimi="Jussi"', 'snimi="Juonio"', 'knimi="Jussi Juonio"']

        for er in expected_results:
            #print (er)
            print('Is ' + er + ' in output?')
            self.assertTrue(er in results)

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

