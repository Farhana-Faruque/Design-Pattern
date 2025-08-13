public class TicTacToe {
    private char[][] board = new char[3][3];
    private char currentPlayer = 'X';

    public TicTacToe() {
        for (int i = 0; i < 3; i++)
            for (int j=0; j<3; j++)
                board[i][j] = ' ';
    }

    public boolean placeMark(int row, int col) {
        if (row<0 || row>=3 || col<0 || col>=3) return false;
        if (board[row][col] != ' ') return false;
        board[row][col] = currentPlayer;
        return true;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean checkWin() {
        for (int i=0; i<3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) return true;
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) return true;
        }
        if (board[0][0]==currentPlayer && board[1][1]==currentPlayer && board[2][2]==currentPlayer) return true;
        if (board[0][2]==currentPlayer && board[1][1]==currentPlayer && board[2][0]==currentPlayer) return true;

        return false;
    }

    public boolean isBoardFull() {
        for (int i=0; i<3; i++)
            for (int j=0; j<3; j++)
                if (board[i][j] == ' ') return false;
        return true;
    }

    public void printBoard() {
        System.out.println("-------------");
        for (int i=0; i<3; i++) {
            System.out.print("| ");
            for (int j=0; j<3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public Memento save() {
        char[][] copy = new char[3][3];
        for (int i=0; i<3; i++)
            System.arraycopy(board[i], 0, copy[i], 0, 3);
        return new Memento(copy, currentPlayer);
    }

    public void restore(Memento m) {
        for (int i=0; i<3; i++)
            System.arraycopy(m.getBoard()[i], 0, board[i], 0, 3);
        currentPlayer = m.getCurrentPlayer();
    }

    static class Memento {
        private final char[][] boardState;
        private final char currentPlayer;

        public Memento(char[][] boardState, char currentPlayer) {
            this.boardState = boardState;
            this.currentPlayer = currentPlayer;
        }

        public char[][] getBoard() {
            return boardState;
        }

        public char getCurrentPlayer() {
            return currentPlayer;
        }
    }
}
