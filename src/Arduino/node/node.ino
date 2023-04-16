#include <SPI.h>
#include <MFRC522.h>
#include <Keypad.h>
#include <Wire.h>
#define SS_PIN 10
#define RST_PIN 9
MFRC522 mfrc522(SS_PIN, RST_PIN);   // Create MFRC522 instance.


// Change te block where the bank number is stored.
int block = 1;

byte readBackBlock[14];
MFRC522::MIFARE_Key key;
String a;
const byte ROWS = 4; //four rows
const byte COLS = 4; //three
char rekeningnummer[19] = "";
int bedrag = 70;
int totaal = 200;
int aantal10 = 0;
int dddd = 1;
int getal;
int m = 0;
int aantal20 = 0;
int aantal50 = 0;
boolean klaarOmTeGaan = false;
String Text = "";
//define the symbols
char stdKeys[ROWS][COLS] = {
  { '1' , '2' , '3' , 'A' },
  { '4' , '5' , '6' , 'B' },
  { '7', '8', '9', 'C' },
  { '*' , '0' , '#' , 'D'}
};
byte rowPins[ROWS] = {A0, 2, 3, 4}; //connect to the row pinouts of the keypad
byte colPins[COLS] = {5, 6, 7, 8}; //connect to the column pinouts of the keypad
int PinCode = 0;
byte digitCount = 0;

//initialize an instance of class NewKeypad
Keypad customKeypad = Keypad( makeKeymap(stdKeys), rowPins, colPins, ROWS, COLS);




void setup()
{
  Serial.begin(9600);   // Initiate a serial communication
  SPI.begin();      // Initiate  SPI bus
  mfrc522.PCD_Init();   // Initiate MFRC522
  Wire.begin(8);                // join i2c bus with address #8
  Wire.onRequest(requestEvent); // register event

}
void loop() {
  if (Serial.available()) {
    while (Serial.available()) {
      a = Serial.readString(); // read the incoming data as string
       Serial.println("arduino zegt"+a);
      if (a != "" || a != NULL) {
        a.toCharArray(rekeningnummer, 19);
      }
    }
  }

  if (char Key = customKeypad.getKey()) {
    Serial.print("XXXXXXXXXXXXXX-");
    Serial.println(Key);
  }
  /*
  if ( ! mfrc522.PICC_IsNewCardPresent())
  {
    return;
  }
  // Select one of the cards
  if ( ! mfrc522.PICC_ReadCardSerial())
  {
    return;
  }
  //Show UID on serial monitor
  String content = "";
  byte letter;
  for (byte i = 0; i < mfrc522.uid.size; i++) {
    Serial.print(mfrc522.uid.uidByte[i] < 0x10 ? " 0" : " ");
    Serial.print(mfrc522.uid.uidByte[i], HEX);
    content.concat(String(mfrc522.uid.uidByte[i] < 0x10 ? " 0" : " "));
    content.concat(String(mfrc522.uid.uidByte[i], HEX));

  }
  content.toUpperCase();*/
  RFIDcode();

}

void requestEvent() {
  int i = 0;
  while (i < 18) {
    Wire.write(rekeningnummer[i]); // respond with message of 6 bytes
    rekeningnummer[i] = char(0);
    i++;
  }
}

void RFIDcode() {
  // Look for new cards
  if ( ! mfrc522.PICC_IsNewCardPresent())
  {
    return;
  }
  // Select one of the cards
  if ( ! mfrc522.PICC_ReadCardSerial())
  {
    return;
  }

      // Set authentication key
    for (byte index = 0; index < 6; index++) {
        key.keyByte[index] = 0xFF;
    }
      readBlock(block, readBackBlock);
          String content = "";
    for(int index = 0; index < sizeof(readBackBlock); index++){
        content += char(readBackBlock[index]);
    }
    Serial.print(content);
    Serial.println("-X");
    // End authentication
    mfrc522.PICC_HaltA();
    mfrc522.PCD_StopCrypto1();
}

void readBlock(int blockNumber, byte arrayAddress[]){
    authenticateBlockAction(block);

    byte buffersize = 18;

    byte status = mfrc522.MIFARE_Read(blockNumber, arrayAddress, &buffersize);\
    if (status != MFRC522::STATUS_OK) {
        //Serial.println("Read failed");
            mfrc522.PICC_HaltA();
    mfrc522.PCD_StopCrypto1();
        loop();
        //return;
    }

    //Serial.println("Block was read");
}

void authenticateBlockAction(int blockNumber){
    int largestModulo4Number = blockNumber / 4 * 4;
    int trailerBlock = largestModulo4Number + 3;

    byte status = mfrc522.PCD_Authenticate(MFRC522::PICC_CMD_MF_AUTH_KEY_A, trailerBlock, &key, &(mfrc522.uid));
    if (status != MFRC522::STATUS_OK) {
        Serial.println("Authentication failed");
        return;
    }
}
