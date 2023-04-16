#include <SPI.h>
#include <MFRC522.h>
#include <Keypad.h>


#define RST_PIN         9           // Configurable, see typical pin layout above
#define SS_PIN          10          // Configurable, see typical pin layout above

uint32_t timer;



String incomingByte;   // for incoming serial data

const byte ROWS = 4; //four rows
const byte COLS = 4; //four columns
//define the cymbols on the buttons of the keypads
char hexaKeys[ROWS][COLS] = {
  {'1', '2', '3', 'A'},
  {'4', '5', '6', 'B'},
  {'7', '8', '9', 'C'},
  {'*', '0', '#', 'D'}
};
byte rowPins[ROWS] = {A0, 2, 3, 4}; //connect to the row pinouts of the keypad
byte colPins[COLS] = {5, 6, 7, 8}; //connect to the column pinouts of the keypad

//initialize an instance of class NewKeypad
Keypad customKeypad = Keypad( makeKeymap(hexaKeys), rowPins, colPins, ROWS, COLS);


MFRC522 mfrc522(SS_PIN, RST_PIN);   // Create MFRC522 instance

void setup() {

  Serial.begin(9600);                                           // Initialize serial communications with the PC
  SPI.begin();                                                  // Init SPI bus

  timer = millis();

}


String getIBAN() {

  mfrc522.PCD_Init();                                              // Init MFRC522 card

  String c;

  // Prepare key - all keys are set to FFFFFFFFFFFFh at chip delivery from the factory.
  MFRC522::MIFARE_Key key;

  for (byte i = 0; i < 6; i++) key.keyByte[i] = 0xFF;

  //some variables we need
  byte block;
  byte len;
  MFRC522::StatusCode status;

  if (millis() - timer > (2000)) {

    timer = millis();
    
  }else{
    return "XXXXXXXXXXXXXX" ;
  }
  

  // Look for new cards
  if ( ! mfrc522.PICC_IsNewCardPresent()) {

    return "XXXXXXXXXXXXXX" ;
  }

  // Select one of the cards
  if ( ! mfrc522.PICC_ReadCardSerial()) {

    return "XXXXXXXXXXXXXX" ;
  }

  byte buffer2[100];
  block = 1;



  status = mfrc522.PCD_Authenticate(MFRC522::PICC_CMD_MF_AUTH_KEY_A, 1, &key, &(mfrc522.uid)); //line 834
  if (status != MFRC522::STATUS_OK) {
    //Serial.print(F("Authentication failed: "));
    //Serial.println(mfrc522.GetStatusCodeName(status));
    return "XXXXXXXXXXXXXX" ;
  }

  status = mfrc522.MIFARE_Read(block, buffer2, &len);
  if (status != MFRC522::STATUS_OK) {
    // Serial.print(F("Reading failed: "));
    //Serial.println(mfrc522.GetStatusCodeName(status));
    return "XXXXXXXXXXXXXX";
  }


  c = String((char *)buffer2);
  //delay(1000); //change value if you want to read cards faster

  mfrc522.PICC_HaltA();
  mfrc522.PCD_StopCrypto1();

  return c;


}


void loop() {



  // send data only when you receive data:
  if (Serial.available() > 0) {
    incomingByte = Serial.readString();
    incomingByte.toInt();
  }


  String  iban;

  iban = getIBAN();
  //Serial.println(timer);

  char customKey = customKeypad.getKey();

  boolean x = ((iban == "XXXXXXXXXXXXXX") || iban == "");
  if (!x) {
    Serial.print(iban);
    Serial.print("-");
    Serial.print("X");
    Serial.print("-");
    Serial.println(" ");
  } if (customKey) {

    Serial.print("XXXXXXXXXXXXXX");
    Serial.print("-");
    Serial.print(customKey);
    Serial.print("-");
    Serial.println(" ");
  }




}
