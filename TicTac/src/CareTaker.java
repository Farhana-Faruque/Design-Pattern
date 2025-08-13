import java.util.Stack;

public class CareTaker {
    private Stack<TicTacToe.Memento> history = new Stack<>();

    public void save(TicTacToe.Memento m) {
        history.push(m);
    }

    public TicTacToe.Memento undo() {
        if (!history.isEmpty()) {
            return history.pop();
        }
        return null;
    }

    public boolean canUndo() {
        return !history.isEmpty();
    }
}
