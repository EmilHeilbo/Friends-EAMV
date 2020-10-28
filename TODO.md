# TODO liste
###### Inspireret af Hans Iversens Hjaelpepakke
#### Tilfoej gerne flere punkter, underpunkter, og kommentarer til bedre forstaaelse af projektet; Se evt. paa github.com/Hanses/bekendte for at blive inspireret.

**Step 1.** Find a Client :man_office_worker:
**Step 2.** :question:
**Step 3.** Profit :chart_with_upwards_trend: :moneybag:


### Til at starte med
- [x] Opret Java-projekt
- [x] Opret Trelagsmodel (packages): :open_file_folder: presentation, logic, data
- [ ] Opret i logic; record *Friend*, enum *Group*, enum *Interest*, som definere det domain vi arbejder paa.
  - [ ] *Friend*: String name, String email, String mobile, Group group, Set\<Interest\> interests; toString, toCVS
    - Naar vi laver en klasse med data som skal gemmes, er det vigtigt at vi har en Noegle Vaerdi (Key), fx en static int, eller i vores tilfaelde maaske Email?
  - [ ] *Group*: Friend, Family, Acquaintance, Colleauge, Foe, Flirt, Boss, Other...
  - [ ] *Interest*: Chess, Fishing, Cooking, Gaming, Sports, Animals, Photography, CSGO...
- [ ] Opret i logic; interface \<\<*Friends*\>\> 
  - [ ] boolean create, update, delete; *Friend* read, Set/List/Map/Array?\<Friend\> search
<br>

### Lidt mere logik
- [ ] Lav i logic; class **FriendsImpl**, class **FriendsFactory**
  - [ ] Overvej om data skal gemmes ved hver operation, eller ved en seperat metode, fx void save.
  - naar data gemmes, kalder vi commit i **FriendDataImpl...**
<br>

### Data-laget
- [ ] Opret i data; interface \<\<*FriendData*\>\>
  - [ ] boolean create, update, delete; *Friend* read; int size; void sort, commit, rollback
- [ ] Opret i data; class **FriendDataImplCVS**, class **FriendDataImplObj**; class **FriendDataImplJDB**?
  - De/Serialization kan vaere meget farlige, hvis projektet anvender bestemte libraies, fx, CommomsCollection. Det er vist nok ogsaa muligt at udfoere DoS angreb, eftersom nogle klasser, kan opbruge meget RAM, og kraeve meget CPU tid; String?
  - Vi kan anvende Singelton DP paa vores **FriendDataImpl..**, for at undgaa at have flere instancer af vores data loadet i RAM.
  - Vi kan maaske anvende Factory DP, naar vi vil vaelge og skifte mellem, hvordan vi gemmer vores data; CVS, OBJ, Osv..
  - Vi kan maaske lave en *Abstract Generic* **Data**, hvor det kun er *Comit* og *Rollback* som er abstrakte. 
<br>

### Test af klasserne indtil nu
- [ ] Opret i presentation; class **TestFriends**
  - [ ] anvend **FriendsFactory**; Opret *Friend* objekt og kald create paa objektet. Search paa noeglevaerdien af objektet, skal retunere objektet, og print:printer: objektet ud paa et stykke A3 fotopapir.; Gentag for flere forskellige *Friend* objekter.


### Andet - Samtale emner: skriv referat af samtalerne under punkterne
- [ ] Userinterface design, UseCase-diagram, Domain-diagram, Class-diagram?
- [ ] Faelels forstaaelse af systemet?
- [ ] Arbejdsfordeling og ansvar omraaeder?
- [ ] Det vigtigeste er back-end, saa UI kan vaere simpelt til at starte med?
- [ ] Kommunikations platform og hyppighed?
- [ ] Standing meetings - Korte moeder, hvor vi tager status, laegger en plan. Maaeske mere end en gang pr. arbejds session?
- [ ] Laese plan og forventningsafstemning med hinanden?
  - [ ] Hvordan laeser vi bedst individuelt?
  - [ ] hvordan laerer vi bedst individuelt?
  - [ ] Opsamling af laeste sider / emner?
- [ ] Bekymringer for projektet?
- [ ] Bekymringer for gruppen?
- [ ] Rollefordeling?