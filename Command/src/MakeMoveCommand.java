class MakeMoveCommand implements Command {
    private TicTacToe game;
    private CareTaker caretaker;
    private int row;
    private int col;

    public MakeMoveCommand(TicTacToe game, CareTaker caretaker, int row, int col) {
        this.game = game;
        this.caretaker = caretaker;
        this.row = row;
        this.col = col;
    }

    @Override
    public void execute() {
        if (!game.placeMark(row, col)) {
            throw new IllegalStateException("Position already occupied! Try again.");
        }
        caretaker.save(game.save());
        game.switchPlayer();
    }
}