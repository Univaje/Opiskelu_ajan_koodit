import unittest
from helpers import *

# Remove if no python functions are not tested
#from my_code import *

started_tests = 0
completed_tests = 0

code="""
if 'pii' in locals():
    print('pii=%.5f'%(pii))
    if pii>3.141592 and pii<3.141594:
       print('pii oikein')
"""


class TestCode(unittest.TestCase):

    def test_Python(self):
        # Test python program
        self.startTest()

        results = callpythonmaincode(code=code, cmdline_args=[], input='12\n').strip()
        print (results)
        expected_results = ["Piiri on", "37.70", "Pinta-ala on", "113.10", 'pii oikein', 'pii=3.14159']

        for er in expected_results:
            print (er)
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

