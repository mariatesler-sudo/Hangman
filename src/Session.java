class Session {
    private final String answer;
    private final char[] userAnswer;
    private final int maxAttempts;
    private int attempts;

    public Session(String word, int maxAttempts) {
        this.answer = word;
        this.userAnswer = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            userAnswer[i] = '*';
        }
        this.maxAttempts = maxAttempts;
        this.attempts = 0;
    }
    public GuessResult guess(char guess) {
        boolean found = false;
        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) == guess) {
                userAnswer[i] = guess;
                found = true;
            }
        }
        if (found) {
            return new SuccessfulGuess(userAnswer, attempts, maxAttempts);
        } else {
            attempts++;
            if (attempts >= maxAttempts) {
                return new Defeat(userAnswer, attempts, maxAttempts);
            }
            return new FailedGuess(userAnswer, attempts, maxAttempts);
        }
    }
    public GuessResult giveUp() {
        return new Defeat(userAnswer, attempts, maxAttempts);
    }
    public char[] getUserAnswer() {
        return userAnswer;
    }
    public int getAttempts() {
        return attempts;
    }
    public int getMaxAttempts() {
        return maxAttempts;
    }
    public String getAnswer() {
        return answer;
    }
}
