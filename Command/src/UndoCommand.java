class UndoCommand implements Command {
    private TicTacToe game;
    private CareTaker caretaker;

    public UndoCommand(TicTacToe game, CareTaker caretaker) {
        this.game = game;
        this.caretaker = caretaker;
    }

    @Override
    public void execute() {
        TicTacToe.Memento prev = caretaker.undo();
        if (prev != null) {
            game.restore(prev);
        }
    }
}