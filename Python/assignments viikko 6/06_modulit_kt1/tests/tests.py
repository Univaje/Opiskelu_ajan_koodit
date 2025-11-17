import unittest
from helpers import *
from contextlib import redirect_stdout
from io import StringIO

#Comment out if no python functions are tested
#NOTE: If this is not commented out, src/my_code.py will be executed.
#(You can abuse this, for example, if you like to check global variables etc.)
from my_code import *



started_tests = 0
completed_tests = 0





class TestCode(unittest.TestCase):
    def test_Python(self):
        #Test python program
        self.startTest()

        print('Test laske:')
        print('  list with many items')
        luvut = [2,5,99,12,3]
        self.assertEqual(laske(tulo, luvut), 35640)
        self.assertEqual(laske(summa, luvut), 121)

        luvut = [3,4,5,2,1]
        self.assertEqual(laske(tulo, luvut), 120)
        self.assertEqual(laske(summa, luvut), 15)

        print('  list with one item')
        luvut = [777]
        self.assertEqual(laske(tulo, luvut), 777)
        self.assertEqual(laske(summa, luvut), 777)

        luvut = [-4]
        self.assertEqual(laske(tulo, luvut), -4)
        self.assertEqual(laske(summa, luvut), -4)

        print('  list no items')
        luvut = []
        self.assertEqual(laske(tulo, luvut), 0)
        self.assertEqual(laske(summa, luvut), 0)

        print('Test tulo')
        self.assertEqual(tulo(3,7), 21)
        self.assertEqual(tulo(-2,2), -4)
        print('Test summa')
        self.assertEqual(summa(3,7), 10)
        self.assertEqual(summa(-2,2), 0)
        
        print('Passed')
        
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

