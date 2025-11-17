;Write a program to generate 1khz square waves to rb3 uset timer0 interrupts
;4mhz /4 = 1mhz = 1ms
;1mhz/2 =1us*(2^^16-init)  (1m=1000)
;500=216-init => init= 65536-500 =65036 => hex(FE0C)
;conreg calculation =0x08 (check the mapping of timer conf)
Org 0
    goto main
    
org 0x00 ISR_T0
    
    
    main:
    ;set up I/Oport B3 bit
    bcf TRISB,3
    ;set up timer
    movlw 0x08
    movwf T0CON
    movlw 0xFE
    movwf TMR0H
    movlw 0x0C
    movwf TMR0L
    ;set up interrupt for timer0
    bsf INTCON,GIE
    bsf INTCON,TMR0IE
    ;enable timer
    bsf T0CON,TMR0ON
    bra $
    
 ISR_T0:
    ;clear the flag t0
    bcf INTCON,TMR0IF
    btg PORTB,3
    movlw 0xFE
    movwf TMR0H
    movlw 0x0C
    movwf TMR0L
    retfie
    
    
    ;1Hz pulse is connected to T13CKI write a program to toggle RB6 every 200cedonds
    ;65536-200=65336 => hex(FF38)
    
    org 0x00
    goto main
    
    Org 0x08
    Goto ISR_T1
    main 
    
    bsf TRISC,6
    movlw 0xFF
    movwf TMR0H
    movlw 0x38
    movwf TMR0L
    movlw 0x82
    bsf INTCON,GIE
    bsf PIE1,TMR1IE
    bsf T1CON,TMR1ON
    bra $
    
    ISR_T1:
    bcf PIR1,TMRIF
    movlw 0xFF
    movwf TMR0H
    movlw 0x38
    movwf TMR0L
    btg PORTC,6
    retfie
    
    ;