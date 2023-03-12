import unittest
from helpers import *
from contextlib import redirect_stdout
from io import StringIO

#Comment out if no python functions are tested
#NOTE: If this is not commented out, src/my_code.py will be executed.
#(You can abuse this, for example, if you like to check global variables etc.)
#from my_code import *



started_tests = 0
completed_tests = 0

my_code="""
import sys
sys.path.insert(0, '../src')

from my_code import *

print(palautteen_tila())
"""

class TestCode(unittest.TestCase):
    def test_Python(self):
        #Test python program
        self.startTest()

        res=callpythoncode(code=my_code, cmdline_args=[], input='').strip()
        #self.assertTrue(palautteen_tila()=='Olen antanut palautteen')
        self.assertTrue('Olen antanut palautteen' in res)
        
        self.endTest()

    def startTest(self):
        global started_tests
        started_tests=started_tests+1
        print('\nStart test', started_tests)

    def endTest(self):
        global completed_tests
        print('End test', started_tests)
        completed_tests=completed_tests+1


def completed():
    global completed_tests
    return completed_tests

def started():
    global started_tests
    return started_tests

