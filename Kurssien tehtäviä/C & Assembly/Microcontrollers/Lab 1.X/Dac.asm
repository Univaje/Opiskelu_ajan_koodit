    clrf trisa
    movlw 0x59
    movwf porta
    bra $
    
    #include<PIC18F87J11.h>
    
    void main(void){
    TRISBbits.RB0 = 1;
    TRISBbits.RB1 =1;
    TRISBbits.RB2=1;
    Triscbits.RC5=0;
    
    while(1){
    if ((portbbits.RB0 ^ portbbits.RB1 ^ portbbits.RB2)==0)
    PortDbits.RD5 = 1;
    else
    portDbits.RD5 = 0;
    }
    return; 
    }
    
    
    
    
    
    ;TrisA = 0;
    ;Trisabits.RA1 = 1;
    


