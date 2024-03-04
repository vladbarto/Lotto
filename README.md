# Lotto
Implementation of a Lotto game simulator - console application.  
The application was developed for the module _Object-Oriented Programming_.

## Functional requirements
    Implement an application for any lottery.
    a) compute winning chances for a "6 of 49" game;
    b) simulate the numbers' extraction
        Tip: for generating random numbers use Math.random
    c) display in ascending order the extracted numbers without using sorting either
        - sorting methods or
        - arrays
        Suggestion: use packing/unpacking/extraction of bits stored in a long
[Link to original requirements (in romanian)](./Indicatie.png)
## Modules
The following .java files can be found in `src` folder:  
- `Main.java` which is to be run;  
  - prompts in console the welcoming messages
  - manages the input-validity (i.e. you can "play" only certain numbers)
  - if everything works fine, the programme calls some methods which solve our functional requirements
- `Lotto.java` implements solutions for `a)`, `b)` and `c)`
  - the chances are computed using known formulas in Statistics


