;5.10 Write a program to  subtract 7F9AH to BC48H and save the result in RAM memory locations starting at 40H
    
    f1hnum equ 0x20
    filnum equ 0x21
    sehnum equ 0x22
    selnum equ 0x23
    reshgh equ 0x40
    serlow equ 0x41
 
 movlw 0x7f
 movwf fihnum
 movlw 0xah
 movwf filnum
 movlw 0xbc
 movwf sehnum
 movlw 0x48
 movwf selnum    
 
 movf filnum
 subwf selnum,w
 movwf reslow
 movf fihnum
 subwfb selnum,w
 movwf reshgh
    
    
    
;5.11 Write a program to add BCD 7795H to 9548H and save the BCD result in Ram memory locations starting at 40H
;5.28 Assume that MYREG = 85H indicate if it skips after comare is executed in each of the following cases:
    ;a) Movlw 0x90	    b)  movlw 0x70	c)  movlw 0x85	    d)	Movl w0x5D 
    ;	cpfsgt Myreg		cpfsgt myreg	    cpfseq Myreg	cpfslt Myreg 
    ;	incf Myreg, f		incf myreg,f	    incf Myreg,f	incf Myreg,f
    ;   addwl 0x2		addlw 0x2	    addlw 0x2		addlw 0x2
;5.32 write a program that finds the number of zeros in an 8-bit data item.
;5.34 Write a program that finds the position of the first high in an 8-bit data item   
;9.20 assume that XTAL = 10MHz Find the TMR1H,TMR1L value needed to generatea time delay of 2ms Use 16-bit mode and the larest prescaler possible
;9.25 Program Timer0 to generate square wave of 1kHz assume that XTAL=10MHz
;9.51Program timer3 in C to toggle pin RB3 when it counts up from 0 to 200 Assume that XTAL = 10Mhz