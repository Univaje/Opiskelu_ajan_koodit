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



#Test program
code="""
import sys
sys.path.insert(0, '../src')
from my_code import *
from datetime import datetime

dt=datetime.strptime('1.1.2021', '%d.%m.%Y')
a=Havainto('Tikka', 32, 'Muuttava', dt, 'Kiuruvesi', 'Tornissa oli kylma')
print(a)
a.lintulaji='varis'
a.maara=8237
a.paikka='Kallansillat'
dt=datetime.strptime('17.1.1999', '%d.%m.%Y')
a.havaintopvm=dt
for i in range(11):
    a.kuvaus=a.kuvaus
    a.havaintopvm=a.havaintopvm
    a.lintulaji=a.lintulaji
    a.tyyppi=a.tyyppi
    a.maara=a.maara
print(a)
"""


class TestCode(unittest.TestCase):
    def test_Python(self):
        #Test python program
        self.startTest()

        expected_output=['Tikka', '32', '21', '1', '99', '17', 'Kiuruvesi', 'Tornissa oli kylma', 'varis', '8237', 'Kallansillat']

        res=callpythoncode(code=code, cmdline_args=[], input='\n\n').strip()

        for eo in expected_output:
            print('Is ', eo, 'in output?')
            self.assertTrue(eo in res)


        mycode=loadmycode()
        print('Setters implemented?')
        self.assertTrue(res.count('setter')>=58)
        print('Getters implemented?')
        self.assertTrue(res.count('getter')>=55)
        
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

