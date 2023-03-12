;XTAL = 4Mhz 
    ; use timer0 in timer mode and timer1 as counter 
; TIMER0
;1sec = (1ms)*(2^16-init)
;1M= 2^16-init 1million cant be used with oscillator need to slow down clockfreguency use 256
;1M/256 = 2^16-init 1M/256 = 3906.25 <= can tuse cos 265 wont devide 1M use 64
;1M/64 = 2^16-init  1M/64 = 15625  65536-15625 = 49911 hex = > C2F2  = >  Timer high = C2 Timer low = F2 
;T0Con = 00000101 = T0CON = 0x05
; TIMER1
; T1CON = 10000010 = 0x82

    
    org 0 
    goto start
    clrf TrisD
    start:
    movlw 0x05; initialise timer 0
    movwf T0CON
    movlw 0xC0
    movwf TMR0H
    movlw 0xF2
    movwf TMR0L
    
    ;initialise timer 1
    movlw 0x82
    movwf T1CON
    clrf TMR1H
    clrf TMR1L
    
    ;enable timer1
    bsf T1CON,TMR1ON
    ;enable timer0
    bsf T0CON,TMR0ON
    ;check if timer is overflowing
    loop:
    btfss INTCON,TMR0IF
    bra loop
    ;time up stop timers
    bcf T1CON,TMR1ON
    bcf T0CON,TMR0ON
    Bcf INTCON,TMR0IF
    
    movff TMR1L,PORTD;RPS<256

    bra start