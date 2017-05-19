------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all he/she needs to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE: Labyrinter
PURPOSE OF PROJECT: instudering av datastrukturer och plåga studenter.
VERSION or DATE: 18/5 - 2017
HOW TO START THIS PROJECT: start gui
AUTHORS: Joakim Willard & Johan Martinson
USER INSTRUCTIONS:

1:  Vi börjar med att i gui skapa en maze(labyrint) och en boardDisplay. BoardDisplay läggs sedan till som mazens observer.
    Sedan anropar vi create i maze.
    Create ritar först ut ett rutnär vars vägar sedan slås ner med hjälp av union som skapar mängder.
    När alla rutor tillhör samma mängd så är labyrinten klar.

2:  Vi la till edges i create för att skapa broar mellan noderna. Sen använder vi en for each loop för att gå igenom listan som
    returneras av getPath för att fylla noderna som ger den snabbaste lösningen.
    GetPath använder sig av dijkstras algoritm för att hitta den snabbaste lösningen. Sedan lägger vi till destinations namnet
    i en lista. detta görs rekursivt tills alla noder är tilllagda och då har vägen ritats klart.


