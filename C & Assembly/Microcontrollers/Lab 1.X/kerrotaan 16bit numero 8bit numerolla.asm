
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



  Low1 equ 0x10
  hgh1 equ 0x11
  num2 equ 0x12
  resu1 equ 0x13
  resu2 equ 0x14
  resu3 equ 0x15
 
  movf num2
  mulwf low1 
  movff PRODL, resu1
  movff PRODH, resu2
  
  mulwf hgh1
  movf PRODL 
  addwf resu2
  
  movff PRODH, resu3
  bnc skip
  incf resu3
  
  skip:
    Bra $


