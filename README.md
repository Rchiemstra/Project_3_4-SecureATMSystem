# Project_3_4-SecureATMSystem

Dit project betreft het opzetten van een bankomgeving met pinautomaten, geldautomaten en beveiliging. Studenten richten in groepen banken op en verzorgen interbancaire communicatie.

## Beschrijving

Dit project betreft de ontwikkeling van een complete bankomgeving, waarbij studenten in groepen een eigen bank zullen oprichten binnen een land en de complexiteit van samenwerking tussen verschillende groepsbanken zullen simuleren. De architectuur van het systeem zal worden ontworpen met aandacht voor kwaliteitsattributen, waaronder security, betrouwbaarheid en robuustheid.

Het project omvat de ontwikkeling van software- en hardwarecomponenten die betrokken zijn bij het pinnen van geld, inclusief geldautomaten en gelddispensers. Daarnaast zullen de studenten zich bezighouden met de communicatie tussen banken, zodat het voor de eindgebruiker mogelijk wordt om bij een andere groepsbank te pinnen op basis van eigen gegevens (pinpas en saldo).

Elke groep zal een land vertegenwoordigen en een eigen bank oprichten. Het project omvat het ontwerpen en ontwikkelen van software voor het beheer van rekeningen, pinautomaten en geldautomaten, evenals het ontwerpen en implementeren van beveiligingsmaatregelen om de privacy en veiligheid van gebruikersgegevens te waarborgen.

Dit project biedt studenten de kans om in een realistische omgeving te werken aan een complex systeem en belangrijke technische vaardigheden te ontwikkelen, zoals systeemarchitectuur, software- en hardwareontwerp en beveiligingsimplementatie.

### Team

| Naam                 | LinkedIn                                                                |
| -------------------- | ----------------------------------------------------------------------- |
| Ruben Hiemstra       | [LinkedIn](https://www.linkedin.com/in/ruben-hiemstra-84b9b6127/)       |
| Keanu van der Linden | [LinkedIn](https://www.linkedin.com/in/keanu-van-der-linden-697188183/) |
| TBA                  | [LinkedIn]                                                              |
| TBA                  | [LinkedIn]                                                              |
| TBA                  | [LinkedIn]                                                              |

### Bestanden / Files

doc: Deze map bevat documentatie over het project. Er is een submap genaamd "Fusion360" die 3D-modellen bevat van verschillende componenten in het project, zoals geldautomaten en pinautomaten. Er is ook een PDF-bestand genaamd "pinautomaat v6 v16.pdf" dat een tekening bevat van een pinautomaat.

img: Deze map bevat afbeeldingen die in het project worden gebruikt. Er zijn twee submappen:

- eurobiljetten: Deze submap bevat afbeeldingen van verschillende eurobiljetten, inclusief "10_euro.jpeg", "20_euro.jpeg" en "50_euro.jpeg".

- UI_Ruben_Hiemstra: Deze submap bevat afbeeldingen van de gebruikersinterface van het bankgedeelte van het project, gemaakt door Ruben Hiemstra. Er zijn 12 PNG-bestanden genaamd "1.PNG" tot en met "12.PNG" die screenshots bevatten van verschillende delen van de UI.

src: Deze map bevat alle broncode voor het project, georganiseerd in verschillende submappen.

- Arduino: Deze map bevat de broncode voor de Arduino-microcontroller die wordt gebruikt in het project. Er zijn verschillende submappen binnen "Arduino" die code bevatten voor specifieke componenten en functies, waaronder tests voor verschillende componenten zoals RFID-kaarten en keypads, code voor het printen van bonnen en code voor de master- en node-nodes.

- UI: Deze map bevat de broncode voor de gebruikersinterface van het bankgedeelte van het project, geschreven in Java. Er is een submap genaamd ".vscode" met instellingen voor de Visual Studio Code-editor. De "bank" submap bevat broncode voor het beheer van rekeningen, pinautomaten en geldautomaten, evenals tests en afbeeldingen.

### Media

## Rubben Hiemstra

#### Ontwerp pinautomaat

<a href="https://youtu.be/MVlD1MDzszY" target="_blank"   rel="noopener"  >
    <img src="https://img.youtube.com/vi/MVlD1MDzszY/2.jpg" width="480" height="360" />
</a>

#### Test pinautomaat

<a href="https://youtu.be/q1xSIUnEXdo" target="_blank"   rel="noopener"  >
    <img src="https://img.youtube.com/vi/q1xSIUnEXdo/0.jpg" width="480" height="360" />
</a>

## Groepsgedeelte

#### Ontwerp geldlade

<a href="https://youtu.be/ZYODidJn9q8" target="_blank"   rel="noopener"  >
    <img src="https://img.youtube.com/vi/ZYODidJn9q8/0.jpg" width="480" height="360" />
</a>

#### Ontwerp geldlades

<a href="https://youtu.be/2BWyQDWWHVI" target="_blank"   rel="noopener"  >
    <img src="https://img.youtube.com/vi/2BWyQDWWHVI/0.jpg" width="480" height="360" />
</a>

#### Pinpas blokkeren voor alle bij alle pinautomaten

<a href="https://youtu.be/CWAH8InKsuk" target="_blank"   rel="noopener"  >
    <img src="https://img.youtube.com/vi/CWAH8InKsuk/0.jpg" width="480" height="360" />
</a>

#### Meerdere pinautomaten tegelijk

<a href="https://youtu.be/7Nd1Y9njzbA" target="_blank"   rel="noopener"  >
    <img src="https://img.youtube.com/vi/7Nd1Y9njzbA/0.jpg" width="480" height="360" />
</a>

### unittest

Geld spiraal

Voor het bankproject moeten we geld kunnen afgeven nadat er is gepind. Daarom moeten we een systeem bedenken dat veilig is en geen geld verliest. We hebben besloten om een spiraal te gebruiken waar het geld uit kan vallen. Om zo'n spiraal te maken, hebben we verschillende dingen geprobeerd: het vervormen van staaldraad, 3D-printen en zoeken op internet. Hieronder beschrijven we de stappen die we hebben genomen tot aan onze beslissing.
<table >
  <tbody>
    <tr>
      <th>Poging 1</th>
      <th></th>
    </tr>
    <tr>
      <td>De grijze</td>
      <td>De witte</td>
    </tr>
    <tr>
      <td><img src="doc\img\geld_spiraal–unittest\grijze.png" alt="image_description"></img></td>
      <td><img src="doc\img\geld_spiraal–unittest\witte.png" alt="image_description"></img></td>
    </tr>
    <tr>
      <td>Voor het bankproject moeten we geld kunnen afgeven nadat er is gepind. Daarom moeten we een systeem bedenken dat veilig is en geen geld verliest. We hebben besloten om een spiraal te gebruiken waar het geld uit kan vallen. Om zo'n spiraal te maken, hebben we verschillende dingen geprobeerd: het vervormen van staaldraad, 3D-printen en zoeken op internet. Hieronder beschrijven we de stappen die we hebben genomen tot aan onze beslissing.</img></td>
      <td>De grijze spiraal is hetzelfde als de witte, maar we hebben ondersteuning gebruikt tijdens het printen. Hierdoor ziet het er beter uit en zijn de cirkels gladder, waardoor het papier niet vast komt te zitten.</img></td>
    </tr>
  </tbody>
</table>



    De grijze:

    <img src="image_file_name.png" alt="image_description"></img>

    De grijze spiraal is hetzelfde als de witte, maar we hebben ondersteuning gebruikt tijdens het printen. Hierdoor ziet het er beter uit en zijn de cirkels gladder, waardoor het papier niet vast komt te zitten.



Poging #2
<img src="image_file_name.png" alt="image_description">
<img src="image_file_name.png" alt="image_description">

Bij deze spiraal hebben we meer ruimte voor het papier gemaakt door de afstand tussen de cirkels en de diameter van de cirkels te verminderen. Helaas hebben we te veel afstand weggehaald, waardoor de ruimte te krap was en de cirkels te zwak waren. Deze poging voldeed daarom ook niet aan onze eisen.

Poging #3
<img src="image_file_name.png" alt="image_description">

Bij deze poging hebben we geprobeerd staaldraad te gebruiken, omdat dit stevig is en vervormd kan worden. We hebben een stuk hout gebruikt om de draad omheen te draaien en het daarna een tijdje laten zitten om te zorgen dat het goed bleef zitten. Helaas bleek na het verwijderen van de draad dat deze zeer asymmetrisch was en niet bruikbaar was. We zijn daarom weer teruggegaan naar de 3D-printer.

Poging #4
Bij deze 3D-print hebben we ondersteuning gebruikt en hebben we de afmetingen op alle mogelijke manieren geoptimaliseerd (dikte, afstand tussen de cirkels en de voet van de print). Dit zou de definitieve versie worden, maar helaas is de 3D-printer uitgevallen en konden we niet verder gaan. We hebben daarom maar de helft van de spiraal kunnen printen. Desondanks zijn we zeer tevreden met het resultaat en zullen we dit gebruiken in onze dispenser
