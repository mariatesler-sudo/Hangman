
import java.util.Random;
import java.util.Scanner;

interface Dictionary {
    String randomWord();
}

class SimpleDictionary implements Dictionary {
    private final String[] words = {"defenestration", "supercalifragilisticepialidocious" , "incomprehensibility", "mammoth", "gargantuan", "java"};

    @Override
    public String randomWord() {
        Random rand = new Random();
        return words[rand.nextInt(words.length)];
    }
}