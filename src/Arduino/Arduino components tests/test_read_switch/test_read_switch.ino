String incomingByte;   // for incoming serial data
int var;
void setup() {
        Serial.begin(9600);     // opens serial port, sets data rate to 9600 bps
}

void loop() {

        // send data only when you receive data:
       if (Serial.available() > 0) {
               incomingByte = Serial.readString();
               var = incomingByte.toInt();
           }

          switch (var) {
          case 1:
            Serial.println("1");
            break;
          case 2:
            Serial.println("2");
            break;

        }
   
        }

 
