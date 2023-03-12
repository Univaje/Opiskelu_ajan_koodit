import LCD1602
import time
from tkinter import *
import tkinter.font
import RPi.GPIO
import serial
RPi.GPIO.setmode(RPi.GPIO.BCM)
LCD1602.init(0x27,1)


###Variables###
ser = serial.Serial('/dev/ttyUSB0',9600)
inputPinWeight = 1
inputPinHeight = 2
reseivedData = str(" ")
reseivedData2 = str(" ")
inputPinWStr = str(inputPinWeight)
inputPinWStrBytes = inputPinWStr.encode()
inputPinHStr = str(inputPinHeight)
inputPinHStrBytes = inputPinHStr.encode()
###GUI CRAP###
win = Tk()
win.title("BMICalculator")
myFont = tkinter.font.Font(family='Helvetica',size = 12,weight = "bold")

###Funktions###
def CalculateBMI():
    ser.write(inputPinWStrBytes)
    ser.flushInput()
    try:
        while True:
            reseivedData = ser.readline()
            printableW = reseivedData.decode('utf-8')
            while reseivedData == " ":
                reseivedData = ser.readline()
                printableW = reseivedData.decode('utf-8')
            reseivedData = "-"
            ser.write(inputPinHStrBytes)
            ser.flushInput()
            reseivedData2 = ser.readline()
            printableH = reseivedData.decode('utf-8')
            print(printableH)
            while reseivedData2 == " ":
                reseivedData2 = ser.readline()
                printableH = reseivedData.decode('utf-8')
            reseivedData2 = ""
            calculating = str(printableW/(printableH*printableH))
            BMI = eval(calculating)
            #printingRelevant = str('H:'+ printableH +'W:'+printableW)
            #print(printingRelevant)
            #LCD1602.write(0,0,printingRelevant)            
            if BMI < 15.00:
                LCD1602.write(0,1,'SKINNY B"#¤%')
            elif BMI > 15.00 and BMI < 21:
                LCD1602.write(0,1,'HELL YEAH!')
            else:
                LCD1602.write(0,1,'FAT ASS!!')
    except KeyboardInterrupt:
        LCD1602.clear()
        LCD1602.write(0,0,'Press Start')
        
def Resetti():
    try:
            LCD1602.write(0,0,'')
            LCD1602.write(0,1,'')
    except KeyboardInterrupt:
        LCD1602.clear()
        print('Press Start!')
        
def Close():
    RPi.GPIO.cleanup()
    win.destroy()

###WIGLES###
startButton = Button(win, text ='Start doing stuff',font=myFont,command=CalculateBMI,bg='bisque2',width=34)
startButton.grid(row=0,column=1)
resetButton = Button(win, text ='Start doing other stuff',font=myFont,command=Resetti,bg='bisque2',width=34)
resetButton.grid(row=2,column=1)
closeButton = Button(win, text ='Closing stuff',font=myFont,command=Close,bg='red',width=6)
closeButton.grid(row=4,column=1)
win.protocol("WM_DELETE_WINDOW",Close)
win.mainloop()