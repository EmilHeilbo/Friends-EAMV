```mermaid
stateDiagram
    [*] --> DataFactory
    DataFactory --> data : provide data
    data --> add
    data --> remove
    data --> update
    update --> data
    data --> search
    data --> persist : save data to file
    persist --> CSV : as CSV
    CSV --> fil
    persist --> OBJECT : as binary data
    OBJECT --> fil
 %% Vi skal måske overveje at bruge class diagram og sequence diagram, idet state diagram er svært at få noget brugbart ud af. For at undgå at representere kode basen, hvor i burde vise Business Object Model.