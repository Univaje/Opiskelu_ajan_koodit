 ;Write a program that determines whether the number of ones in a given byte is an even 
 ;or an odd number. For example, if X=01101100, then the number of ones is even. 
 ;Your program should write zero into address 0x20 if number of ones is even
 ;; otherwise, it should write 1. 
databyte equ 0x21
result equ 0x20
counter equ 0x22
temp equ 0x23

 clrf trisb
 movlw 0x08
 movwf counter
 clrf temp
 again:
 movff portb, databyte
 bcf STATUS,C
 forloop:
    rrncf databyte
    btfsc Status,C
    incf temp,f
    decf counter
    bnz forloop
    btfsc temp,1
    incf result
    bra $
 
    
    
 ;V2
 result equ 0x20
 clrf trisb
  movf portb
  Andlw 0x01
  movwf result
  
 ;Use timer1 to generate a 1-KHz square wave on pin RB4 (Fosc=4-Mhz, TMRIF is in PIR1 register) 
;T1CON:
 ;TMR1ON = 0
 ;TMR1CS = 0
 ;T1SYNC = 0
 ;T1OSEN = 1
 ;T1CKPS0 = 0
 ;T1CKPS2 = 0
 ;D6 = 0
 ;RD16 = 0
 ;T1CON =0000100 = 0x08
 ;TMR1H&TMR1L:
 ;1kHz/2 = 500
 ;4Mhz=4 =1Mhz
 ;initialvalue=FFFF-(1ms/2) =1us* FFFF-7D0=F8

    org 0x00
 goto start
 
 Start:
    bcf TRISB,4
    bcf PORTB,4
 again:
    Movlw 0x08
    movwf T1CON
    movlw 0xF8
    movwf TMR1H
    movlw 0x2F
    movlw TMR1L

    bcf INITCON, TMR1IF

 check:
    bsf T1CON, TMR1ON
    btfss T1CON, TMR1IF
       bra check
    btg PORTB,4
    bra again
    end