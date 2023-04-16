#include <SoftwareSerial.h>



////////////////////////WERKENDE I2C MASTER ALS TEST////////////////


// Wire Master Reader
// by Nicholas Zambetti <http://www.zambetti.com>

// Demonstrates use of the Wire library
// Reads data from an I2C/TWI slave device
// Refer to the "Wire Slave Sender" example for use with this

// Created 29 March 2006

// This example code is in the public domain.

#include <Wire.h>
// Include the Servo library 
#include <Servo.h> 
#include "Adafruit_Thermal.h"
#include "adalogo.h"
#include "adaqrcode.h"
#include "SoftwareSerial.h"

char c1;
char c2;
char c3;
char c4;
char c5;
char c6;
char c7;
char c8;
char c9;
char c10;
char c11;
char c12;
char c13;
char c14;

String rekeningstring;

int totaal;
int e;
char metbon;

char aantal10;
int aantal10int;
char aantal20;
int aantal20int;
char aantal50;
int aantal50int;

// Declare the Servo pin 
int ServoPin1 = 11; 
// Create a servo object 
Servo Servo1; 
// Declare the Servo pin 
int ServoPin2 = 10; 
// Create a servo object 
Servo Servo2; 
// Declare the Servo pin 
int ServoPin3 = 3; 
// Create a servo object 
Servo Servo3; 

#define TX_PIN 6 // Arduino transmit  YELLOW WIRE  labeled RX on printer
#define RX_PIN 5 // Arduino receive   GREEN WIRE   labeled TX on printer

SoftwareSerial mySerial(RX_PIN, TX_PIN); // Declare SoftwareSerial obj first
Adafruit_Thermal printer(&mySerial);     // Pass addr to printer constructor

void setup() {
  Wire.begin();        // join i2c bus (address optional for master)
  Serial.begin(9600);  // start serial for output
  // We need to attach the servo to the used pin number 
  Servo1.attach(ServoPin1); 
  Servo2.attach(ServoPin2); 
  Servo3.attach(ServoPin3); 

}

void loop() {
    for (int i = 8; i <= 11; i++) {

OGloop(i);
if (rekeningstring != "" || rekeningstring != NULL) {
  totaal = 0;
  int telling10 = 0;
  while (aantal10int > telling10) {
    motor1();
    Serial.println("draai 1 keer voor motor 1");
    delay(1000);
    totaal = totaal + 10;
    telling10++;
  }
  int telling20 = 0;
  while (aantal20int > telling20) {
    motor2();
        Serial.println("draai 1 keer voor motor 2");

    delay(1000);
    totaal = totaal + 20;
    telling20++;
  }
  int telling50 = 0;
  while (aantal50int > telling50)
  {
    motor3();
        Serial.println("draai 1 keer voor motor 3");

    delay(1000);
    totaal = totaal + 50;
    telling50++;
  }
  if (metbon == 'j') {
    boncode();
    Serial.println("bon succesvol uitgeprint");
    metbon = 'n';
  }
}
Serial.println(totaal);
delay(1000);
    }
}

void OGloop(int i) {
  rekeningstring = "";
  //for (int i = 8; i <= 11; i++) {
    //int re_i = i + 2;
    Wire.requestFrom(i, 18);    // request 6 bytes from slave device #8
 // }

  while (Wire.available()) { // slave may send less than requested
    c1 = Wire.read(); // receive a byte as character
    rekeningstring += c1;
    c2 = Wire.read(); // receive a byte as character
    rekeningstring += c2;
    c3 = Wire.read(); // receive a byte as character
    rekeningstring += c3;
    c4 = Wire.read(); // receive a byte as character
    rekeningstring += c4;
    c5 = Wire.read(); // receive a byte as character
    rekeningstring += c5;
    c6 = Wire.read(); // receive a byte as character
    rekeningstring += c6;
    c7 = Wire.read(); // receive a byte as character
    rekeningstring += c7;
    c8 = Wire.read(); // receive a byte as character
    rekeningstring += c8;
    c9 = Wire.read(); // receive a byte as character
    rekeningstring += c9;
    c10 = Wire.read(); // receive a byte as character
    rekeningstring += c10;
    c11 = Wire.read(); // receive a byte as character
    rekeningstring += c11;
    c12 = Wire.read(); // receive a byte as character
    rekeningstring += c12;
    c13 = Wire.read(); // receive a byte as character
    rekeningstring += c13;
    c14 = Wire.read(); // receive a byte as character
    rekeningstring += c14;

    //totaal = Wire.read();
    //e = Wire.read();

    aantal10 = Wire.read();
    aantal20 = Wire.read();
    aantal50 = Wire.read();

    metbon = Wire.read();

    String converter = "";
    converter += aantal10;
    aantal10int = converter.toInt();
    converter = "";
    converter += aantal20;
    aantal20int = converter.toInt();
    converter = "";
    converter += aantal50;
    aantal50int = converter.toInt();
    
    Serial.println(rekeningstring);         // print the character
    
    //delay(1000);
    Serial.println(totaal);         // print the character
    //delay(1000);

    Serial.println(e);         // print the character
    //delay(1000);

    Serial.println(aantal10);
    //delay(250);

    Serial.println(aantal20);
    //delay(250);

    Serial.println(aantal50);
    //delay(250);

    Serial.println(metbon);
    //delay(1000);

  //}
  }

  delay(500);
}

void motor1() {
   Servo1.write(110);  
   delay(4200); 
   Servo1.write(90);
}

void motor2() {
   // Make servo go to 0 degrees 
   Servo2.write(110); 
   delay(4200);
   // Make servo go to 90 degrees 
   Servo2.write(90); 
}

void motor3() {
   // Make servo go to 0 degrees 
   Servo3.write(110); 
   delay(4200);
   // Make servo go to 90 degrees 
   Servo3.write(90); 
}

void boncode() {
  // This line is for compatibility with the Adafruit IotP project pack,
  // which uses pin 7 as a spare grounding point.  You only need this if
  // wired up the same way (w/3-pin header into pins 5/6/7):
  pinMode(7, OUTPUT);
  digitalWrite(7, LOW);

  // NOTE: SOME PRINTERS NEED 9600 BAUD instead of 19200, check test page.
  mySerial.begin(9600);  // Initialize SoftwareSerial
  //Serial1.begin(19200); // Use this instead if using hardware serial
  printer.begin();        // Init printer (same regardless of serial type)

  // The following calls are in setup(), but don't *need* to be.  Use them
  // anywhere!  They're just here so they run one time and are not printed
  // over and over (which would happen if they were in loop() instead).
  // Some functions will feed a line when called, this is normal.

  // Test inverse on & off
  printer.doubleHeightOn();
  printer.setLineHeight(50);
  printer.boldOn();
  printer.justify('C');
  printer.setSize('L');
  printer.println(F("F.A.I.L."));
  
  printer.boldOff();
  printer.doubleHeightOff();
  printer.setSize('S');
  printer.println(F("2019"));
  
  printer.setLineHeight(0);
  printer.justify('L');
  printer.setSize('S');
  printer.println(F(""));
  printer.println(rekeningstring);
//  printer.print(F(str(c2)));
//  printer.print(F(str(c3)));
//  printer.print(F(str(c4)));
//  printer.print(F(str(c5)));
//  printer.print(F(str(c6)));
//  printer.print(F(str(c7)));
//  printer.print(F(str(c8)));
//  printer.print(F(str(c9)));
//  printer.print(F(str(c10)));
//  printer.print(F(str(c11)));
//  printer.print(F(str(c12)));
//  printer.print(F(str(c13)));
//  printer.print(F(str(c14)));

  printer.println("Het totaal gepinde bedrag: ");
  printer.print(totaal);
  printer.print(" Euro");

  printer.println(F(""));
  printer.println(F(""));
  printer.justify('C');
  printer.setSize("M");
  printer.println(F("BEDANKT VOOR HET PINNEN"));
  printer.println(F(""));
  printer.println(F(""));
  printer.println(F(""));
  
  printer.feed(2);

  printer.sleep();      // Tell printer to sleep
  delay(3000L);         // Sleep for 3 seconds
  printer.wake();       // MUST wake() before printing again, even if reset
  printer.setDefault(); // Restore printer to defaults

}
