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



#Test program
code1="""
import sys
from os.path import exists
from os import remove

sys.path.insert(0, '../src')
from my_code import *

if exists('autot.txt'):
    remove('autot.txt')

autot=LueAutot()
TalletaTiedostoon(autot)

if exists('autot.txt'):
    print('928374987234')
"""

code2="""
import sys
sys.path.insert(0, '../src')
from my_code import *

autot=LueTiedostosta()
TulostaTiedot(autot)
"""


class TestCode(unittest.TestCase):
    def test_Python(self):
        #Test python program
        self.startTest()

        test_input=['a13\n11.12.1900\nb 12 34\n21.11.2022\nLOPPU\n\n', 'a 13\n11.11.1901\nb1234\n21.11.2021\nabcde\n10.10.2010\nLOPPU\n\n']
        expected_output=[['a13', '11.12.1900', 'b 12 34', '21.11.2022'], ['a 13', '11.11.1901', 'b1234', '21.11.2021', 'abcde', '10.10.2010']]

        for n, eo in zip(test_input, expected_output):
            print('Test functions with input : \n"""')
            print(n)
            print('"""')
            res=callpythoncode(code=code1, cmdline_args=[], input=n+'\n').strip()
            self.assertTrue('928374987234' in res)
            res=callpythoncode(code=code2, cmdline_args=[], input='').strip()
            #print(res)
            for e in eo:
                #print(e)
                self.assertTrue(e in res)

            print('Passed\n')

        self.endTest()

    """
    #Call function and capture stdout
    def captureFunctionStdout(f_name, parameters='()'):
        f = StringIO()
        with redirect_stdout(f):
            eval(f_name+parameters)

        return f.getvalue().strip()
    
    def test_PythonFunction(self):
        #Test python function (in this case function name is combine)
        #my_code must be imported
        self.startTest()

        print(32*'*')
        print('Test Tulosta')
        
        expected=['Teuvo Testaaja','32','111151-1234']
        par='('
        for p in expected:
            par=par+'"'+p+'",'
        par=par.strip(',')
        par=par+')'
        ret=TestCode.captureFunctionStdout('Tulosta', par)
        ret=ret.split('\n')

        for s in expected:
            self.assertTrue(s in ret)
        
        print('Accepted\n')

        
        print('Test main program')
        expected=['Kaisa Testaaja','31','111151-1244']
        par=''
        for p in expected:
            par=par+p+'\n'
        par=par.strip('\n')

        ret=callpython(cmdline_args=[], input=par).strip()
        ret=ret.split('\n')

        for s in expected:
            self.assertTrue(s in ret)

        
        print('Accepted\n')
        
        
        print(32*'*')
        self.endTest()
    """

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

