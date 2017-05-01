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

Here's some sample output. The key letter is "Z" to keep the list _relatively_ short (I've also cut out quite a few lines and replaced it with vertical ellipses):

```
run:
------INFO-----
Loading file from ScrabbWords/Words.txt
File Found.
---------------
checking ZA
WORD!!!!!!!!!ZA
checking ZAA
ZAA is not a word
checking AZA
AZA is not a word
checking ZAB
.
.
.
EZA is not a word
checking ZAF
ZAF is not a word
checking FZA
FZA is not a word
checking ZAG
WORD!!!!!!!!!ZAG
checking ZAGA
ZAGA is not a word
checking AZAG
AZAG is not a word
.
.
.
checking YZ
YZ is not a word
checking ZZ
ZZ is not a word
checking ZZ
ZZ is not a word
ZAGS ZAPS
9
BUILD SUCCESSFUL (total time: 3 seconds)
```
