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
code="""
import sys
sys.path.insert(0, '../src')
from my_code import *


arvosanat = LuoNimetJaArvosanat()

if type(arvosanat) is dict:
    print('uidsuhfis')
else:
    print('jshdfjhsdgfhjgs')

TulostaKaikki(arvosanat)
PalautaHylattyjenMaara(arvosanat)
"""


class TestCode(unittest.TestCase):
    def test_Python(self):
        #Test python program
        self.startTest()

        test_input=['aaa\n0\nBBB\n1\nccc\n-1\nLOPPU\n\n\n', 'aaa\n6\nbbb\n1\nccc\n3\nLOPPU\n\n\n']
        expected_output=[['aaa', 'ccc', '2'], ['aaa', 'ccc', 'bbb', '5', '1', '3']]
        not_expected_output=[['bbb'], []]

        for n, eo, neo in zip(test_input, expected_output, not_expected_output):
            print('Test main with input : \n"""')
            print(n)
            print('"""')
            res=callpython(cmdline_args=[], input=n+'\n').strip()
            #print('%',res,'%')
            for e in eo:
                #print("#", e, "#")
                self.assertTrue(e in res)

            for ne in neo:
                #print("-", ne, "-")
                self.assertFalse(ne in res)
                
            print('Passed\n')

        test_input=['aaa\n0\nbbb\n1\nccc\n-1\nLOPPU\n\n\n', 'aaa\n6\nbbb\n1\nccc\n3\nLOPPU\n\n\n']
        expected_output=[['aaa', 'ccc', '2', '0', 'bbb', 'uidsuhfis'], ['aaa', 'ccc', 'bbb', '5', '1', '3', '0', 'uidsuhfis']]

        for n, eo in zip(test_input, expected_output):
            print('Test functions with input : \n"""')
            print(n)
            print('"""')
            res=callpythoncode(code=code, cmdline_args=[], input=n+'\n').strip()
            for e in eo:
                #print('@',e,'@')
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

