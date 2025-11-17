// Include Libraries
#include "Arduino.h"
#include "Buzzer.h"
#include "FSR.h"
#include "NewPing.h"
#include "LED.h"

// Pin Definitions
#define BUZZER_PIN_SIG 2       
#define FSR_PIN_1 A1                  
#define HCSR04_PIN_TRIG 5    
#define HCSR04_PIN_ECHO  4 
#define LEDG_PIN_VIN      3 
// Global variables and defines
// object initialization
Buzzer buzzer(BUZZER_PIN_SIG);
FSR fsr(FSR_PIN_1);
NewPing hcsr04(HCSR04_PIN_TRIG , HCSR04_PIN_ECHO);
LED ledG(LEDG_PIN_VIN);
// define vars for testing menu
int timeout = 10;       //define timeout of 10 sec
long time0;
int j = 0;
void setup()
{
    Serial.begin(9600);
    while (!Serial);
}
void loop()
{
    while (Serial.available())
    {
        char c = Serial.read();
        if (isAlphaNumeric(c))
        {  
            if(c == '1'){
              float erotus = hcsr04.ping_cm();
              float pituus = (300 - erotus);
              Serial.print(pituus);
              int lahetus = pituus*100;
              while(j < timeout){
                for(int i=100 ; i> 0 ; i -= 5)
                {
                ledG.dim(i);                    
                delay(1);                             
                }                                         
                ledG.off();                       
                j++;
                }   
              j = 0;
              delay(1000);
              timeout=100;
              while (j < timeout){
                buzzer.on();       
                delay(5);             
                buzzer.off();      
                delay(5);             
                j++;
              }
              j=0;
            }
            else if(c == '2') {
              float paino = fsr.getForce();
              Serial.print((paino));
            }
            time0 = millis();  
      }
    }
}
