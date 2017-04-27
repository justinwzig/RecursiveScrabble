# RecusriveScrabble
java utility for finding scrabble words that have scrabble words "nested" inside them.

explanation at https://justinwzig.github.io/recursive-scrabble-words-with-java/

## how-to
What you'll need:
Netbeans/IDE of your choice

1. Open the project in your IDE. We don't provide a .jar for the simple reason that a. you need to modify the code to figure out all the possible words and b. the output needs to persist (can't use command line output).
2. Make sure the Words.txt file is in the same folder that the project runs from (the working directory).
3. Run the project. After each execution, it should print the longest words.
4. Change the String _working_ at the top of the package to the next letter to see word combinations based off that letter. Every letter except "A" should work because there are simply too many words with "A" in them and it will cause an overflow error. 

You can view our results at https://docs.google.com/spreadsheets/d/1SHEFM9WZHsK7egdq34nnILXFb2JJTvW7JygyazZp788/edit#gid=0
