    ;40k = (2^16*4/4)-init
    ;TMR0ON = 0
    ;T08BIT = 0
    ;TOCS = 0
    ;TOSE = 0
    ;PSA = 1
    ;TOPS2 = 0
    ;TOPS1 = 0
    ;TOPS0 = 0
#include <PIC18F87J11.h>
    
    void interrupt ISR_T0(){
    INTCONbits.TMR0IF = 0;
    PORTAbits.RA3 = ~PORTAbits.RA3;
    TMR0H =;
    TMR0L =;
    return;
    }
    
    
    
void main(void){
    TMR0H = ;
    TMR0L =;
    T0CON = 0x08;
    INTCONbits.GIE = 1;
    ITNCONbits.TMR0IE = 1
    TRISAbits.RA3 = 0;
    T0CONbits.TMR0ON = 1;
    
    while(1);
    
    return;
    }
    
    
    ; with polling
    
    #include <PIC18F87J11.h>
    
    void interrupt ISR_T0(){
    INTCONbits.TMR0IF = 0;
    PORTAbits.RA3 = ~PORTAbits.RA3;
    TMR0H =;
    TMR0L =;
    return;
    }
    
    
    
void main(void){
    TMR0H =;
    TMR0L =;
    T0CON = 0x08;
    TRISAbits.RA3 = 0;
    T0CONbits.TMR0ON = 1;
    while(1){
	while(INTCONbits.TMR0IF == 0);
    INTCONbits.TMR0IF = 0;
    PORTAbits.RA3 = ~PORTAbits.RA3;
    TMR0H =;
    TMR0L =;
    }
    
    return;
    }