interface GuessResult {
    char[] state();
    int attempt();
    int maxAttempts();
    String message();
}
class Defeat implements GuessResult {
    private final char[] state;
    private final int attempts;
    private final int maxAttempts;

    public Defeat(char[] state, int attempts, int maxAttempts) {
        this.state = state;
        this.attempts = attempts;
        this.maxAttempts = maxAttempts;
    }

    @Override
    public char[] state() {
        return state;
    }

    @Override
    public int attempt() {
        return attempts;
    }

    @Override
    public int maxAttempts() {
        return maxAttempts;
    }

    @Override
    public String message() {
        return "You lost! The word was: " + String.valueOf(state);
    }
}

class Win implements GuessResult {
    private final char[] state;
    private final int attempts;
    private final int maxAttempts;

    public Win(char[] state, int attempts, int maxAttempts) {
        this.state = state;
        this.attempts = attempts;
        this.maxAttempts = maxAttempts;
    }

    @Override
    public char[] state() {
        return state;
    }

    @Override
    public int attempt() {
        return attempts;
    }

    @Override
    public int maxAttempts() {
        return maxAttempts;
    }

    @Override
    public String message() {
        return "You won! The word is: " + String.valueOf(state);
    }
}

class SuccessfulGuess implements GuessResult {
    private final char[] state;
    private final int attempts;
    private final int maxAttempts;

    public SuccessfulGuess(char[] state, int attempts, int maxAttempts) {
        this.state = state;
        this.attempts = attempts;
        this.maxAttempts = maxAttempts;
    }

    @Override
    public char[] state() {
        return state;
    }

    @Override
    public int attempt() {
        return attempts;
    }

    @Override
    public int maxAttempts() {
        return maxAttempts;
    }

    @Override
    public String message() {
        return "Good guess!";
    }
}

class FailedGuess implements GuessResult {
    private final char[] state;
    private final int attempts;
    private final int maxAttempts;

    public FailedGuess(char[] state, int attempts, int maxAttempts) {
        this.
                state = state;
        this.attempts = attempts;
        this.maxAttempts = maxAttempts;
    }

    @Override
    public char[] state() {
        return state;
    }

    @Override
    public int attempt() {
        return attempts;
    }

    @Override
    public int maxAttempts() {
        return maxAttempts;
    }

    @Override
    public String message() {
        return "Missed, mistake " + attempts + " out of " + maxAttempts + ".";
    }
}
