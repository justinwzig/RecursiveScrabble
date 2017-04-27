package scrabbwords;

import java.util.*;
import java.io.*;

public class recursiveScrabble {

    public static ArrayList<String> wordsList = new ArrayList<>();
    public static ArrayList<String> alphabet = new ArrayList<>();
    public static ArrayList<String> latercheck = new ArrayList<>();
    public static ArrayList<Integer> countValue = new ArrayList<>();
    public static ArrayList<Boolean> isStart = new ArrayList<>();
    public static String word = "";
    public static String longest = "";
    public static int record = 0;
    public static String working = "Z";
    public static int counter = 0;
    public static boolean override = false;
    public static boolean skip1 = false;

    public static void main(String[] args) {
        setup();
        work();
        System.out.println(longest);
        System.out.println(longest.length());
    }

    public static void setup() {
        //add all the letters to the alphabet list
        alphabet.add("a");
        alphabet.add("b");
        alphabet.add("c");
        alphabet.add("d");
        alphabet.add("e");
        alphabet.add("f");
        alphabet.add("g");
        alphabet.add("h");
        alphabet.add("i");
        alphabet.add("j");
        alphabet.add("k");
        alphabet.add("l");
        alphabet.add("m");
        alphabet.add("n");
        alphabet.add("o");
        alphabet.add("p");
        alphabet.add("q");
        alphabet.add("r");
        alphabet.add("s");
        alphabet.add("t");
        alphabet.add("u");
        alphabet.add("v");
        alphabet.add("w");
        alphabet.add("x");
        alphabet.add("y");
        alphabet.add("z");
        
        //make them all uppercase because we forgot to do that in the above statements
        for (int j = 0; j < alphabet.size(); j++) {
            String get = alphabet.get(j);
            get = get.toUpperCase();
            alphabet.set(j, get);
        }
        
        //load the file
        //THE Words.txt FILE MUST BE IN THE WORKING DIRECTORY FROM WHICH THIS PROGRAM WAS STARTED
        String path = System.getProperty("user.dir") + "/Words.txt";
        File f = new File(path);
        Scanner s = null;
        try {
            s = new Scanner(f);
            System.out.println("------INFO-----");
            System.out.println("Loading file from "+path);
            System.out.println("File Found.");
            System.out.println("---------------");
        } catch (FileNotFoundException ex) {
            System.out.println("-----ERROR-----");
            System.out.println("Couldn't find the file \"Words.txt\" in the working directory.");
            System.out.println("Please ensure the Dictonary Words.txt file is in the same directory sa this application");
            System.out.println("---------------");
        }
        
        while (s.hasNextLine()) {
            wordsList.add(s.nextLine());
        }
    }

    public static boolean isAWord(String in) {
        for (int c = 0; c < wordsList.size(); c++) {
            if (wordsList.get(c).equals(in)) {
                return true;
            }
        }
        return false;
    }

    public static void work() {
        for (; counter < alphabet.size();) {
            boolean result = false;
            if (!skip1) {
                working += alphabet.get(counter);
                result = check1();
            }
            if (!result || override) {
                working = alphabet.get(counter) + working;

                check2();
            }
        }
        redo();
    }

    public static boolean check1() {
        System.out.println("checking " + working);
        if (!isAWord(working)) {
            System.out.println(working + " is not a word");
            working = working.substring(0, working.length() - 1);
            return false;
        } else {
            System.out.println("WORD!!!!!!!!!" + working);
            int currentLen = working.length();
            if (currentLen > record) {
                longest = working;
                record = currentLen;
            } else if (currentLen == record) {
                longest += (" " + working);
            }
            latercheck.add(working.substring(0, working.length() - 1));
            countValue.add(counter);
            isStart.add(true);
            counter = 0;
            return true;
        }
    }

    public static void check2() {
        override = false;
        skip1 = false;
        System.out.println("checking " + working);
        if (!isAWord(working)) {
            System.out.println(working + " is not a word");
            working = working.substring(1, working.length());
            counter++;
        } else {
            int currentLen = working.length();
            if (currentLen > record) {
                longest = working;
                record = currentLen;
            } else if (currentLen == record) {
                longest += (" " + working);
            }
            latercheck.add(working.substring(1, working.length()));
            countValue.add(counter + 1);
            isStart.add(false);
            counter = 0;
        }
    }

    public static void redo() {
        if (latercheck.size() != 0) {
            int l = latercheck.size() - 1;
            boolean temp = isStart.get(l);
            isStart.remove(l);
            if (temp) {
                working = latercheck.get(l);
                counter = countValue.get(l);
                System.out.println("Ended, moving to start, setting redo to " + working);
                latercheck.remove(l);
                countValue.remove(l);
                skip1 = true;
                override = true;
                work();
            } else {
                working = latercheck.get(l);
                counter = countValue.get(l);
                System.out.println("Started, doing next letter, setting redo to " + working);
                latercheck.remove(l);
                countValue.remove(l);
                work();
            }
        }
    }

}
