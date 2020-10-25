## Hvordan kommer jeg i gang?
###### [27/09 11.11] Hans Iversen
##### Hermed en lille introduktion til opstart af et projekt. Flere afsnit vil følge efter.

- Et projekt startes oftest med at man i Eclipse laver et selvstændigt java-projekt. Navngivning bør være sigende i forhold til projektet (med små bogstaver, fx "venner", "vennerOgBekendte", "bekendte", "kontakter").
- Da alle projekter oftest vil have et skelet opbygget over en trelagsmodel, kan man starte med at lave tre packages. Navngivning ligeledes med små bogstaver, ofte med omvendt url-notation (fx "dk.eamv.bekendte.presentation", osv, eller blot "presentation". Det er ikke så vigtigt - man kan altid omdøbe med "Refactor-rename")
- Identificer nu systemets funktionalitet. Hvad skal man kunne udføre i systemet? Der er nævnt noget med vedligehold af venner og bekendte, søgning og noget med interesser. Lav evt. et UseCase-diagram, der viser disse funktioner.
Identificer nu de ting, begreber, personer (roller), der optræder i systemt, og som vi må formodes at gemme oplysninger om. Som udgangspunkt vil jeg kunne pege på to begreber "Ven" eller "Bekendt" og "Interesse". Lav to klasser i logik-pakken med de ønskede attributter. (Interesse kunne have tre: id (int), navn (String) og beskrivelse (String). Lav dem private, og lav i stedet getters og setters (Brug eclipse. Højreklik, vælg "source", og "generate getters and setters")). Overvej tilsvarende attributter til "Ven" / "Bekendt", og lav den også med getters og setters.
- Lav nu et Interface (fx kaldet "VennerOgBekendte") med metoder, der afspejler funktionaliteten i systemet (fx "public void gem(Ven ven);", osv).

##### Det må være nok til en start. Næste afsnit kommer til at handle om klasser i data-laget.

<br>
<br>
<br>
<br>

## Lidt mere logik
###### [02/10 21.22] Hans Iversen
    
Inden vi går til data-laget, lige et par betragtninger. Den letteste måde at komme videre på, er at betragte de to klasser Interesse og Ven som rent databærende klasser eller DTO'er, dvs klassser med attributter og getters og setters (og toString), men uden funktionalitet. Funktionaliteten kan så med fordel placeres i en ny klasse, fx VennerOgBekendteImpl, som implementerer interfacet VennerOgBekendte. 
For at skjule implementationen for presentations-lagets klasser, er det så man kan lave en factory, der returnerer en instans af interfacet. Det er ikke så vigtigt lige nu. Men opdelingen af funktionalitet og data har nogle fordele, selvom men kan indvende, at det ikke er specielt objekt-orienteret. Men det giver mulighed for at forankre objekter fra datalaget, hvilket ellers kan være svært.
Med denne opdeling er der altså nu eet Interface og tre klasser (fire med factory) i logiklaget. 

<br>
<br>
<br>
<br>

## Data-laget
###### [02/10 21.34] Hans Iversen
    
I data-laget vil vi simulere persistens, dvs det er her vi vil opbevare vores venner og interesser indtil vi kan skrive dem til disk.
Lav fx en klasse i data-laget der hedder "InteresseData", og en klasse, der hedder "VenData". I den ene kan der nu laves en attribut, der kan indeholde vores Interesser, og i den anden en attribut, der indeholder vores venner. Her kan man vælge mellem en List, eller en Map. Det er op til jer. Der er fordele og ulempe ved begge.
Metoderne i begge klasser vil minde om dem, der er defineret i Interfacet til logik-laget, der ofte blot vil viderestille kald til data-laget, som jo opbevarer vores data.
Hvis I vil anvende faste oplysninger om Interesser i klassen InteresseData, kan I overveje om I vil lade constructoren til denne klasse lave objekterne til List'en (eller Map'en). Den eneste metode klassen så behøver er en metode med signaturen: public List\<Interesse\> allInteresser();
VenData vil til gengæld have de øvrige metoder fra interfacet, og logik-klassen vil så blot viderestille til denne. 
Hvorfor så overhovedet have et logik-lag, kunne man spørge? Jo hvis der skal være noget validering (navn og email skal fx være udfyldt). så vil denne type forretningsmæssig validering altid skulle placeres i logik-laget.
Klassen VennerOgBekendteImpl kan nu have to attributter, som initialiseres med instanser af de to klasser i data-laget. Fx
 private VenData venner = new Vendata();
 private InteresseData interesser = new InteresseData();
Dermed er de forankrede, og kan kaldes fra logikken.

<br>
<br>
<br>
<br>

## Test af klasserne indtil nu
###### [02/10 21.37] Hans Iversen
I præsentations-laget laves nu en testklasse med en main-metode, der via en instans af logik-lagets funktionalitetesklasse, tester de forskellige metoder. Lav et Ven-objekt, kald create, Kald en søgning, der returnerer dit Ven-objekt. Skriv det ud. Lav flere Ven-objekter, og tilføj dem til systemet, Søg dem frem og skriv dem ud. osv.