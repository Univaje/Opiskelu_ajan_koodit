
; PIC18F87J11 Configuration Bit Settings

; Assembly source line config statements

#include "p18f87j11.inc"

; CONFIG1L
  CONFIG  WDTEN = OFF           ; Watchdog Timer Enable bit (WDT disabled (control is placed on SWDTEN bit))
  CONFIG  STVREN = OFF          ; Stack Overflow/Underflow Reset Enable bit (Reset on stack overflow/underflow disabled)
  CONFIG  XINST = OFF           ; Extended Instruction Set Enable bit (Instruction set extension and Indexed Addressing mode disabled (Legacy mode))

; CONFIG1H
  CONFIG  CP0 = OFF             ; Code Protection bit (Program memory is not code-protected)

; CONFIG2L
  CONFIG  FOSC = HS             ; Oscillator Selection bits (HS oscillator)
  CONFIG  FCMEN = ON            ; Fail-Safe Clock Monitor Enable bit (Fail-Safe Clock Monitor enabled)
  CONFIG  IESO = ON             ; Two-Speed Start-up (Internal/External Oscillator Switchover) Control bit (Two-Speed Start-up enabled)

; CONFIG2H
  CONFIG  WDTPS = 32768         ; Watchdog Timer Postscaler Select bits (1:32768)

; CONFIG3L
  CONFIG  EASHFT = ON           ; External Address Bus Shift Enable bit (Address shifting enabled, address on external bus is offset to start at 000000h)
  CONFIG  MODE = MM             ; External Memory Bus Configuration bits (Microcontroller mode - External bus disabled)
  CONFIG  BW = 16               ; Data Bus Width Select bit (16-bit external bus mode)
  CONFIG  WAIT = OFF            ; External Bus Wait Enable bit (Wait states on the external bus are disabled)

; CONFIG3H
  CONFIG  CCP2MX = DEFAULT      ; ECCP2 MUX bit (ECCP2/P2A is multiplexed with RC1)
  CONFIG  ECCPMX = DEFAULT      ; ECCPx MUX bit (ECCP1 outputs (P1B/P1C) are multiplexed with RE6 and RE5; ECCP3 outputs (P3B/P3C) are multiplexed with RE4 and RE3)
  CONFIG  PMPMX = DEFAULT       ; PMP Pin Multiplex bit (PMP port pins connected to EMB (PORTD and PORTE))
  CONFIG  MSSPMSK = MSK7        ; MSSP Address Masking Mode Select bit (7-Bit Address Masking mode enable)

  ; T3CON setup:
  ;	TMR3ON = 0
  ;	TMR3CS = 1
  ;	T1SYNC = 0
  ;	T3CKPS = 00
  ;	T3CCP = 00
  ;	RD16 =0
  
    ; T0CON setup:
  ;	TMR0ON = 0
  ;	T08BIT = 0
  ;	T0CS = 1
  ;	T0SE = 0
  ;	PSA = 1
  ;	T0PS = 000
  ;T3CON = 0x80
  ;T0CON = 0x28
  
  ;TMR3H&TMR3L:	RegValue = 
  ;32kHz/4 = 8kHz
  ;1s= (1/(8khz))*(FFFF)-init
  ;init=65536-125=65528 = FF82 
hilo equ 0x20
  org 0x0
    goto start
 
 org 0x08
    goto ISR
    
ISR:
    ;check which is making the interrupt
    ;1second is up go to interrupt for 3
    btfsc PIR2,TMR3IF
    bra timer3isr
    ;interrupt for timer0 womething went wrong? start over
    btfss INTCON,TMR0IF
    bra start
    retfie
    
timer3isr:
    ;stop timers for duration of sending values to leds
    bcf INTCON,GIE
    bcf T3CON, TMR3ON
    bcf T0CON, TMR0ON
    ;testi which value should be sent 0=High 1=low
    btfss hilo, 0
    bra lowbyte
    ;send first lowbyte the high byte
    movff TMR0L,PORTD
    movff TMR0H,PORTD
    ;setting hilo for next round
    bsf hilo,0
    bra ending
lowbyte:
	;only lowbyte needs to be sent
	movff TMR0L,PORTD
	;setting hilo for next round
	bcf hilo,0
ending:
    ;restart the values on timers to do it again
	bcf PIR2, TMR3IF
	bsf INTCON,GIE
	movlw 0xff
	movwf TMR3H
	movlw 0x82
	movwf TMR3L
	clrf TMR0H
	clrf TMR0L
	;Start timers again
	bsf T3CON,TMR3ON
	bsf T0CON,TMR0ON
 retfie
    
intsetup:
    ;set ports
    clrf TRISD
    bsf TRISA,4
    ;timer1 values need to be set for timer3
    bsf T1CON,TMR1CS
    ;clear values for timer 0 to begin counting
    clrf TMR0H
    clrf TMR0L
    ;interrupt setup
    bcf T0CON, TMR0IF
    bsf INTCON,TMR0IE
    bcf PIR2, TMR3IF    
    bsf PIE2, TMR3IE
    bsf INTCON, PEIE
    bsf INTCON, GIE
    ;initial values for counter and timer
    movlw 0x28
    movwf T0CON
    movlw 0x80
    movwf T3CON
    movlw 0xff
    movwf TMR3H
    movlw 0x82
    movwf TMR3L
    return
start:
    clrf hilo
    call intsetup
    ;turn on counters and stay on busy loop interrupts should handle the value resets
    bsf T0CON,TMR0ON
    bsf T3CON,TMR3ON
    bra $
    end


