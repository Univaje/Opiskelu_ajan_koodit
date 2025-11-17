; Q1 Convert an 8-bit number into 16-bit number in addresses 0x33 0x34 using sighn extension.
; ensimm‰inen bitti vasemmalta m‰‰ritt‰‰ mit‰ yl‰bittiin laitetaan. jos R7 on 1 yl‰ bitti on 1111 1111
; jos R7 on 0 yl‰bitti on 0000 0000 
    bit8 equ 0x10
    highbit equ 0x33
    lowbit equ 0x34
    clrf hightbit
    movff bit8, lowbit
   
    btfsc bit8,7
    bra skip
    setf highbit
    skip:
    bra $
   
    
    
    
    
    
    
    
    
    
    

; Q2 Write a program that monitors RB2 if RB2 is zero, then program sets RA1 to 1 otherwise it 
; generates a pulse with 25% duty cycle (25 prosenttia ajasta sen tulisi olla 1 ja 75 prosenttia ajasta 0) -___-___-___ jne

    counter equ 0x10
 
    bcf TRISB,2
    bsf TRISA,1
    
   
    btfss PORTB,2
    bra sendone
    Monitor:
     bsf PORTA,1
     call Delay
     bcf PORTA,1
     call delay
     call delay
     call delay
    bra Monitor
       
    
    Delay:
	movlw 0xff
	movwf counter
	loop:
	    Nop
	    Nop
	    Nop
	    decf counter
	    bnz loop
    return
;show simple code to move 30H and 97H to locations 5 and 6 respectively
    Movlw 0x30H
    movwf 0x05
    movlw 0x97H
    movwf 0x06
 ; Write a code to complement content of location 8 and place the result in WREG
   comf 0x08, w
 ;Show a simple code to 
 ;(a) load value 15H into location 7, and 
 location equ 0x07
 movlw 0x15H
 movwf location
 ;(b) add it to WREG five times and place the result in WREG as the values are added.
 ;WREG should be zero before the addition starts
 movlw 0
 addwf location,w
 addwf location,w
 addwf location,w
 addwf location,w
 addwf location,w
 
 ;Write a program to get 8bit data from portd and send it to ports portb and portc
 outputdata equ 0x11
 clrf TRISB
 nop ; tarvitaan tauko asetuksessa
 setf TRISD
 nop
 clrf TRISC
 
 loop:
 movff PORTB, outputdata
 movlw outputdata
 movwf PORTC
 movwf PORTB
 bra loop
 
 ;write a program to toggle all the bits of portb and portc continously using AAH and 55H or using COMF instruction
 dataset1 equ 0x15
 dataset2 equ 0x16
 counter equ 0x17
 
 
 movlw 55H
 movwf dataset1
 movlw AAH
 
 loop:
    movff PORTB,dataset1
    call delay
    movff portC,dataset1
    call delay
    addwf PORTB
    call delay
    addwf PORTC
    bra loop
    
 delay:
    movlw .255
    movwf counter
    stop:
    nop
    decf counter
    bnz stop
    movlw AAH
    
    return
counter equ 0x32

Movlw 55H
movwf PORTB
movwf PORTC
start:
    comf PORTB
    call delay
    comf PORTC
    bra start
    
 ;write program to toggle br2 and rb5 continuously without disturbing the rest of the bits
 counter equ 0x34
 
 bcf PORTB,2
 start:
    btfsc PORTB,2
    bra jumping
   bsf PORTB,2
   call delay
   bcf PORTB,5
   call delay
   bra start
   jumping:
    bcf PORTB,2
    call delay
    bsf PORTB,5
    call delay
    bra start
   bra start
    
 
 ;write a porgram to monitor RC3 when it is high send 55H to portD
 

 bsf TRISC,3
 clrf TRISD
 movlw 55H
 again:
    btfss PORTB,3
    bra again
    movwf PORD
    bra again
 
 ;write a program to monitor rb7bit when it is low send 55H and AAh to portc continuously
 
 counter equ 0x99
 fivefive equ 0x47
 bsf TRISB,7
 clrf TRISC
 movlw 55H
 movwf fivefive
 movlw AAH
 again:
    btfsc PORTB,7
    bra again
    loop:
    movff fivefive, PORTC
    call delay
    addwf PORTC
    call delay
    bra loop
    
 ;write a program to monitor rb5bit when it is high make low to high to lopw pulse on rb3
 
 
 
 ;write a program to get the status of RC3 and put it to RC4
 
 
 
 ;write a program to get statuses of rd7 and rd6 and put them on rc0 and rc7 respectively
 
 
 ;Write a program that sets 0x024 to one if value in address 0x20 is multiple of 16.

 compare equ 0x20
 target equ 0x21
 result equ 0x024
 
 movlw 0
 movwf result
 
 movlw .16
 movwf target
 loop:
    movf compare, w
    cpfseq target
    bra ending
    bra loop
    
 ending:
    incf result
    bra $
 
    ;make if (x<y) x=x+5 else y=10
    
    x equ 0x20
    y equ 0x21

 loop:
    movf y,w
    Cpfslt x
    bra addingy
    movlw 0x05
    addwf x,f
    bra ending
 addition:
    movlw 0x10
    movwf y,f
   
    eniding:
    bra $