
    ;ADCON 
    ;VCFG1 = 0
    ;VCFG0 = 0
    ;CHS<3:0> = 0000
    ;GO/DONE = 0
    ;ADON = 1
    ;ADCON0 =0x01
    ;ADFM = 1
    ;ADCAL = 0
    ;ACQT<2:0> = 100
    ;ADCS<2:0> = 001
    ;ADCON1 = 0xA1
    X equ 0x10
    Y equ 0x11
    Q equ 0x12
    R equ 0x13
 
    sub_div:
    clrf Q
    movf Y
    start:
    
    cpfslt X
    bra jatka
    bra exit
    
    jatka:
    subwf X,f
    incf Q
    bra start
    exit:
    movff X,R
    return
    
    
    
    
    bsf TRISA,0
    clrf TRISB
    clrf TIRSC
    movlw 0x01
    movwf ADCON0 
    movlw 0xA1
    movwf ADCON1
    ;set convertion on
    bsf ADCON0,go
    
    Again:
    btfsc ADCON0,GO
    bra Again
    
    movff ADRESL, X
    movlw .51
    movwf Y
    call suv_div
    movff Q, PORTB
    
    movff R, X
    movlw .5
    movwf Y
    call sub_div
    movff Q PORTC
    


