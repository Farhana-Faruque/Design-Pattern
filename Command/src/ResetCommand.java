class ResetCommand implements Command {
    private TicTacToe game;
    private CareTaker caretaker;

    public ResetCommand(TicTacToe game, CareTaker caretaker) {
        this.game = game;
        this.caretaker = caretaker;
    }

    @Override
    public void execute() {
        game.reset();
        caretaker.clearHistory();
        caretaker.save(game.save());
    }
}