;80ms = (1us)*(0xFFFF-init+1)
;80k=(0xFFFF-init+1)
;80k > oxFFFF pakko k‰ytt‰‰ jako oscillaattorista
;80k = (2us)*(0xFFFF-init+1)
    ;40k =(0xFFFF-init+1)=2^16-init
    ;2^16 = 65536
    ;65536-40000 = 25536
    ;desimal to hex: 25536 =63C0
    ;TMR1H=0x63
    ;TMR1L=0xC0
    
    ;T1 control value 10010001 = T1CON = 0x