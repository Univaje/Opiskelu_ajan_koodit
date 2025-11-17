
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

  ; TCON setup:
  ;	TMR1ON = 0
  ;	TMR1CS = 1
  ;	T1SYNC = 1
  ;	T1OSCEN = 1
  ;	T1CKPS0 = 0
  ;	T1CKPS1 = 0
  ;	T1RUN = 1 
  ;	RD16 = 0
  
  ;TMR1H&TMR1L:	RegValue = 
  ;32kHz/4 = 8kHz
  ;1ms= (1/(8khz))*(FFFF)-init
  ;init=65536-8=65528 = FFF7 or if i understood incorrectly it is T1CON = 0x04 init=65536-1250=65528 = FB1D
    org 0x0
 goto start
 
 
 settimer:
    ;Write into TMR1H first and then TMR1L
    movlw 0xFF
    movwf TMR1H
    movlw 0xF0
    movwf TMR1L
    ;Turn on timer1
    bsf T1CON, TMR1ON
    return
    
    
    
start:
    bcf TRISE,3
    movlw 0x4A
    movwf T1CON
restart:
; Clear TMR1IF and go to set the timer
    call settimer
;Stay in the loop untill interrupt flag is set
loop:
    btfss PIR1, TMR1IF
    bra loop
    ;Turn off timer1
    bcf T1CON,TMR1ON
    ;Toggle PRTE.3
    btg PORTE,3
    bcf PIR1,0 ; bcf T1CON, TMR1IF
    ;Go back to restart
    Bra restart
    end