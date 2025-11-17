    ;6.2 
    ;Identigy the adressing mode for each of the following:
    ;a MOVWF PORTB - Direct mode
    ;b MOVLW 0x50 - Immediate mode
    ;c MOVWF MYREG - Direct mode
    ;d MOVLW 0 - Immeadiate mode
    ;e MOVFF MYBREG,YOUREG - Direct mode
    ;f MOVWF YOURREG - Direct mode
    
    ;6.15
    ;Write a program to copy ffh into ram locations 50h to 6fh 
    counter equ 0x20
    org 0x00
    bra start
    
    
    org 0x100
    start:
    
    movlw .31
    movwf counter
    movlw 0xff
    LFSR 0, 0x50
    loop:
    Movwf INDF0
    incf FSR0L, f
    decf counter, f
    bnz loop
    bra $
    
    ;6.16
    ;Write a program to copy 10 bytes of data starting at ram address 40h to ramlocations starting at 70h
    counter equ 0x20
    org 0x00
    bra start
    org 0x100
    start:
    
    movlw .10
    movwf counter
    movlw 0xff
    LFSR 0, 0x40
    LFSR 1, 0x70
    uudelleen:
    movf Postinc0, w
    movwf Postinc1
    decf counter, f
    bnz uudelleen
    bra $
    ;6.22
    ;how much ram space does FSRx register cover?
    FSR is 12 bit register and covers the entire 4096 byte register space
 
 
    ;6.29
    ;Write a program to read the following message from rom and plase the data in ram starting at 50:
    org 0x00
    bra start
    
    org 0x600
    mydata DB "1-800-999-999,0"
    org 0x100
    start:
    movlw 0x00
    movwf TBLPTRL
    movlw 0x06
    movwf TBLPTRH
    LSRF 0, 0x50
    uudelleen:
    TBLRD*+
    movf TABLAT,w
    bz loppu
    mowf POSTINC0
    bra uudelleen
    loppu:
    Bra $
    
    ;6.35
    ;Assume tha the lower four bits of portb are connected to four switches
    ;writhe a program to send the following ASCII characters to a portC on the status of the switches:
    ;0000 '0'
    ;0001 '1'
    ;0010 '2'
    ;0011 '3'
    ;0100 '4'
    ;0101 '5'
    ;0110 '6'
    ;0111 '7'
    ;1000 '8'
    ;1001 '9'
    ;1010 'A'
    ;1011 'B'
    ;1100 'C'
    ;1101 'D'
    ;1110 'E'
    ;1111 'F'
    org 0x00
    bra start:
    
    org 0x100
    start:
    setf TRISB
    CLRF TRISC
    uudelleen:
    movf PORTB,w
    andlw B'00001111'
    call LOOKUP
    movwf portC
    bra uudelleen
    
    LOOKUP:
    mullw 0x2
    movff prol, wreg
    addwg PCL
    retlw '0'
    retlw '1'
    retlw '2'
    retlw '3'
    retlw '4'
    retlw '5'
    retlw '6'
    retlw '7'
    retlw '8'
    retlw '9'
    retlw 'A'
    retlw 'B'
    retlw 'C'
    retlw 'D'
    retlw 'E'
    retlw 'F'
    end
    
    
    ;6.46 Give an instruction to clear the carry flag
    bcf STATUS,C
    ;6.59 Write a program to find the number of zeros in the file register location 05
    counter equ 0x60
    result equ 0x61
    datacontent 0x05 <--- assuming there is some data to be calculated
    org 0x00
    bra start
    
    org 0x100
    start:
    clrf result
    movlw .8
    movwf counter
    bsf STATUS,C
    uudeleen:
    rlcf datacontent, f
    btfss STATUS, C
    incf result,f
    decf counter
    bnz uudelleen
    bra $
    ;11.31
    ;Wrute a program using timer0 interrupt tu greate squate wave of 1Hz on on RB7 while data from PORTC is 
    ;being sent to PortD
    ;Assume XTAL = 10MHz
    ;1k/2 = (1/10/4)*(FFFF-init)
    ;500 = 0,4*FFFF-init+1
    ;init = 65536-500/0,4 = 64 285 = FB1D
    
    
    org 0x00
    bra start
    
    org 0x08
    bra ISR
    org 0x100
    start:
    SETF TRISC
    CLRF TRISD
    
    movwf T0CON
    movlw 0xFB
    movwf TMR0H
    movlw 0x1D
    movwf RMR0L
    BSF INTCON,GIE
    BSF INTCON,TMR0IE
    BCF INTCON,TMR0IF
    BCF T0CON, TMR0ON
    
    loop:
    movff PORTC,PORTD
    bra loop
    
    org 0x150
    ISR:
    movlw 0xFB
    movwf TMR0H
    movlw 0x1D
    movwf TMR0L
    btg PORTB,7
    BCF INTCON,TMR0IF
    Retfie
    ;11.41
    The INT0IF bit belongs to the INTCON register
    
    ;11.63
    ;Provide the following information for the PORTB.Change interrupt
    ;a the flag associated with the portb-change interrupt
    INTCON,RBIF
    ;b the reister to which these flags belong
    INTCON
    ;c the differentce between the portb-change and int0-int2 interrupts
    Each of the INT0-INT2 has their own pin and are independant from each other
    Portb-change four pins and is considered a single interrupt that can use all four pins
    int0-int2 has own interrupts and portb-change has a single interrupt
    int0-int2 interrupts can trigger on positive or negative egde. Portb-change interrupt is triggered
    if any of the pins status shanges from high to low or low to high
    ;d the pins that are part of the portb-change interrupt
    RB4-RB7
    ;11.74
    ;Explain what happens if a high priority interrupt is activated while PIC18 is serving a low-priority interrupt?
    High interrupt stops the low interrupt. low interrupt is put on a stack whlie high interrupt is ran. High interrupt 
    puts GIE = 0 to stop other interrupts to occur. When high interrupt is done its work it sets GIE back to 1 ann low 
    low interrupt is taken from stack to continue its work.