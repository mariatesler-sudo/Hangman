import java.util.Scanner;

class ConsoleHangman {
    private final Dictionary dictionary = new SimpleDictionary();
    private final Scanner scanner = new Scanner(System.in);

    public void run() {
        String word = dictionary.randomWord();
        Session session = new Session(word, 5);
        System.out.println("Welcome to Hangman!");
        printState(new FailedGuess(session.getUserAnswer(), 0, 5));

        while (true) {
            System.out.print("> Guess a letter: ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.isEmpty()) continue;

            if (input.equals("exit")) {
                System.out.println("You gave up! The word was: " + word);
                break;
            }

            char guess = input.charAt(0);
            GuessResult result = session.guess(guess);
            printState(result);

            if (result instanceof Win) {
                System.out.println(result.message());
                break;
            }

            if (result instanceof Defeat) {
                System.out.println(result.message());
                break;
            }
        }
    }

    private void printState(GuessResult result) {
        System.out.println();
        System.out.println(new String(result.state()));
        System.out.println(result.message());
    }

    public static void main(String[] args) {
        new ConsoleHangman().run();
    }
}

