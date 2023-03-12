
org 0x00
    bra start:
    
org 0x08
    bra intersept
    
org 0x100
    start:
    
    movlw 0x90
    movwf SPBRG
    movlw 0x0F
    movwf RCSTA
    bsf intcon, gie 
    bsf intcon,peie
    bsf PIE1.RCIE
    bsf TRISC,7
    clrf TRISB
    BRA $
    
    org 0x150
    intercept:
    movff RCREG, PORTB
    retfie
    
    void interrupt isr() {
    PORTB = RCREG;
    }
    
    void main(){  
    RCSTA = 0x0F
    SPBRG = 0x90
    Intconbits.gie =1
    intconbits.peie =1
    piebits.rcie =1
    Triscbits.RC7 = 1
    TRISB = 1
    while(1);
    
    
    
    vector_in equ 0x10
    vector_out equ 00x40
    sum equ 0x05
    size equ 0x14
    counter equ 0x04
    row equ 0x06
 
    org 0x00
    bra main
    org 0x07
    matrix: db 12,56,....;400 numbers
 
    org 0x100
    main:
    
    
    LFSR 1,Vector_out;
    movlw  low(matrix)
    movwf TBLPTRL
    movlw  high(matrix)
    movwf TBLPTRH
    movlw  upper(matrix)
    movwf TBLPTRU
    
    
    movlw size
    movwf row
    loop_row:
    movwf count
    Clrf sum
    LFSR 0,Vector_in;

    loop:
    TBLRD*+
    movf POSTINC0
    mulwf tablat ;assume *< 256
    movf prodl
    addwf sum,f
    decf count
    bnz loop
    
    movff sum, postinc1
    decf row
    bnz	loop_row
    bra $
    end
    
size equ 0x09    
count1 equ 0x10
count equ 0x12
sum equ 013
 
org 0x600
 dataset db []
 
movlw .100
movwf count1
movlw count
 LFSR 0,0x600
 LFSR 1,0x601

    loop:
    loop2:
    movf postinc0
    cpfslt 