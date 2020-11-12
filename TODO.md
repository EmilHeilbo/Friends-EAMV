# TODO liste
###### Inspireret af Hans Iversens Hjælpepakke
#### Tilføj gerne flere punkter, underpunkter, og kommentarer til bedre forståelse af projektet; Se evt. på github.com/Hanses/bekendte for at blive inspireret.

**Step 1.** Find a Client :man_office_worker:
**Step 2.** :question:
**Step 3.** Profit :chart_with_upwards_trend: :moneybag:


### Til at starte med
- [x] Opret Java-projekt
- [x] Opret Trelagsmodel (packages): :open_file_folder: presentation, logic, data
- [x] Opret i logic; record *Friend*, enum *Group*, enum *Interest*, som definere det domain vi arbejder på.
  - [x] *Friend*: String name, String email, String mobile, Group group, Set\<Interest\> interests; toString, toCVS
    - Når vi laver en klasse med data som skal gemmes er det vigtigt at vi har en Nøgle Værdi (Key), fx en static int, eller i vores tilfælde måske Email?
  - [x] *Group*: Friend, Family, Acquaintance, Colleauge, Foe, Flirt, Boss, Other...
  - [x] *Interest*: Chess, Fishing, Cooking, Gaming, Sports, Animals, Photography, CSGO...
- [x] Opret i logic; interface \<\<*Friends*\>\> 
  - [x] Boolean create, update, delete; *Friend* read, Set/List/Map/Array?\<Friend\> search
<br>

### Lidt mere logik
- [x] Lav i logic; class **FriendsImpl**, class **FriendsFactory**
  - [x] Overvej om data skal gemmes ved hver operation, eller ved en seperat metode, fx void save.
  - Når data gemmes, kalder vi commit i **FriendDataImpl...**
<br>

### Data-laget
- [x] Opret i data; interface \<\<*FriendData*\>\>
  - [x] Boolean create, update, delete; *Friend* read; int size; void sort, commit, rollback
- [x] Opret i data; class **FriendDataImplCVS**, class **FriendDataImplObj**; class **FriendDataImplJDB**?
  - De/Serialization kan være meget farlige, hvis projektet anvender bestemte libraies, fx, CommomsCollection. Det er vist nok også muligt at udføre DoS angreb, eftersom nogle klasser, kan opbruge meget RAM, og kræve meget CPU tid; String?
  - Vi kan anvende Singelton DP på vores **FriendDataImpl..**, for at undgå at have flere instancer af vores data loadet i RAM.
  - Vi kan måske anvende Factory DP, når vi vil vælge og skifte mellem, hvordan vi gemmer vores data; CVS, OBJ, Osv..
  - Vi kan måske lave en *Abstract Generic* **Data**, hvor det kun er *Comit* og *Rollback* som er abstrakte. 
  - Overvejelser omkring brug af private transient ved key i Friend, for at undgå, at slutbrugeren laver rod i systemet. Betyder nok at data'en skal have nye nøgler, ved hver rollback, hvilket nok vil være upraktisk.
<br>

### Test af klasserne indtil nu
- [x] Opret i presentation; class **TestFriends**
  - [x] anvend **FriendsFactory**; Opret *Friend* objekt og kald create på objektet. Search på nøgleværdien af objektet, skal retunere objektet, og print:printer: objektet ud på et stykke A3 fotopapir. Gentag for flere forskellige *Friend* objekter.
  - [x] Ændre så der oprettes en fil, hvis filen ikke eksisterer.
  - [x] Får en tom liste tilbage når der søges?


### Andet - Samtale emner: skriv referat af samtalerne under punkterne
- [ ] Userinterface design, UseCase-diagram, Domain-diagram, Class-diagram?
- [ ] Fælels forståelse af systemet?
- [ ] Arbejdsfordeling og ansvar områder?
- [ ] Det vigtigeste er back-end, så UI kan være simpelt til at starte med?
- [ ] Kommunikations platform og hyppighed?
- [ ] Standing meetings - Korte møder, hvor vi tager status, lægger en plan. Måske mere end en gang pr. arbejds session?
- [ ] Læse plan og forventningsafstemning med hinanden?
  - [ ] Hvordan læser vi bedst individuelt?
  - [ ] Opsamling af læste sider / emner?
- [ ] Bekymringer for projektet?
- [ ] Bekymringer for gruppen?
- [ ] Rollefordeling?
<br>

### Fejl og mangler:
- [ ] TestFriends funger korrekt når der køres en test, og forkert ved to forskellige test cases.
- [ ] UI
- [ ] Flere testcases
- [ ] Anvend builder patteren og bedre brug af strategy til at gemme data.