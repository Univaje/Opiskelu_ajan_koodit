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


class TestCode(unittest.TestCase):
    def test_Python(self):
        #Test python program
        self.startTest()

        mycode=loadmycode()
        self.assertTrue(mycode.count('numpy')>=1)

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

