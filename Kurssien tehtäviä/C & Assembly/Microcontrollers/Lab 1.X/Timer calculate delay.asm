; find largest delay if Fosc = 4mhz
    ; laske 1/4mhz/4 ?
    ; NO PRescaler: delay=1/(4Mhz/4)*(216-init) =1us (microsec)*2^16=65.536 ms
    ; Prescaler=256: delay=1/(4Mhz/4/256)*(216-init) =256* 1us (microsec)*2^16=256*65.536 ms =16.777216 s
    
restart:
bcf TRISA,0
bcf PORTA,0
call sub_delay
call sub_delay
call sub_delay
bsf PORTA,1
call sub_delay
bra Restart
    
sub_delay:
    movlw 0x48
    movwf T0CON
    
    Movlw 0xE7
    movwf TMR0l
    
    bcf INITCON,TMR0IF
    bsf T0CON,TMR0ON
    
    loop:
    btfss INTCON,TMR0IF
    bra loop

    bcf INITCON,TMR0IF
    bcf T0CON,TMR0ON
return
