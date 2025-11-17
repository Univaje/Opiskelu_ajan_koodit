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
    #Call function and capture stdout
    def captureFunctionStdout(f_name, parameters='()'):
        """
        f = StringIO()
        with redirect_stdout(f):
            eval(f_name+parameters)

        return f.getvalue().strip()
        """
        my_code="""
import sys
sys.path.insert(0, '../src')
from my_code import *\n
"""
        my_code=my_code+f_name+parameters+'\n'
        print('Call:\n'+ my_code)
        ret=callpythoncode(my_code)
        print('ret="'+ret+'"')
        return ret
        
    def test_PythonFunction(self):
        #Test python function (in this case function name is combine)
        #my_code must be imported
        self.startTest()

        print(32*'*')
        print('Test Tsekkaus')
        
        ret=TestCode.captureFunctionStdout('Tsekkaus', '()')
        self.assertTrue('0' in ret)
        self.assertFalse('14' in ret)
        self.assertTrue('Virhe' in ret)
        self.assertFalse('oppimaan' in ret)
        self.assertFalse('opiskella' in ret)
        self.assertFalse('En' in ret)

        ret=TestCode.captureFunctionStdout('Tsekkaus', '("opettaja")')
        self.assertTrue('1' in ret)
        self.assertFalse('14' in ret)
        self.assertFalse('Virhe' in ret)
        self.assertTrue('oppimaan' in ret)
        self.assertFalse('opiskella' in ret)
        self.assertFalse('En' in ret)

        ret=TestCode.captureFunctionStdout('Tsekkaus', '("opettaja", "opiskelija", 9999)')
        self.assertTrue('3' in ret)
        self.assertFalse('14' in ret)
        self.assertFalse('Virhe' in ret)
        self.assertTrue('oppimaan' in ret)
        self.assertFalse('opiskella' in ret)
        self.assertFalse('En' in ret)

        ret=TestCode.captureFunctionStdout('Tsekkaus', '("opettaja", 1,2,3,3,4,4,5,6,6,7,7,8,8)')
        self.assertTrue('14' in ret)
        self.assertFalse('Virhe' in ret)
        self.assertTrue('oppimaan' in ret)
        self.assertFalse('opiskella' in ret)
        self.assertFalse('En' in ret)
        

        ret=TestCode.captureFunctionStdout('Tsekkaus', '("opiskelija")')
        self.assertTrue('1' in ret)
        self.assertFalse('14' in ret)
        self.assertFalse('Virhe' in ret)
        self.assertFalse('oppimaan' in ret)
        self.assertTrue('opiskella' in ret)
        self.assertFalse('En' in ret)

        ret=TestCode.captureFunctionStdout('Tsekkaus', '("opiskelija", "opettaja", 9999)')
        self.assertTrue('3' in ret)
        self.assertFalse('14' in ret)
        self.assertFalse('Virhe' in ret)
        self.assertFalse('oppimaan' in ret)
        self.assertTrue('opiskella' in ret)
        self.assertFalse('En' in ret)

        ret=TestCode.captureFunctionStdout('Tsekkaus', '("opiskelija", 1,2,3,3,4,4,5,6,6,7,7,8,8)')
        self.assertTrue('14' in ret)
        self.assertFalse('Virhe' in ret)
        self.assertFalse('oppimaan' in ret)
        self.assertTrue('opiskella' in ret)
        self.assertFalse('En' in ret)

        ret=TestCode.captureFunctionStdout('Tsekkaus', '("opiskeli")')
        self.assertTrue('1' in ret)
        self.assertFalse('14' in ret)
        self.assertFalse('Virhe' in ret)
        self.assertFalse('oppimaan' in ret)
        self.assertFalse('opiskella' in ret)
        self.assertTrue('En' in ret)

        ret=TestCode.captureFunctionStdout('Tsekkaus', '("opet", "opettaja", 9999)')
        self.assertTrue('3' in ret)
        self.assertFalse('14' in ret)
        self.assertFalse('Virhe' in ret)
        self.assertFalse('oppimaan' in ret)
        self.assertFalse('opiskella' in ret)
        self.assertTrue('En' in ret)

        ret=TestCode.captureFunctionStdout('Tsekkaus', '("talkkari", 1,2,3,3,4,4,5,6,6,7,7,8,8)')
        self.assertTrue('14' in ret)
        self.assertFalse('Virhe' in ret)
        self.assertFalse('oppimaan' in ret)
        self.assertFalse('opiskella' in ret)
        self.assertTrue('En' in ret)
        
        print('Accepted\n')
        
        
        print(32*'*')
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

