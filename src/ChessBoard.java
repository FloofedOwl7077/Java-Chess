package src;

public class ChessBoard {
    private Piece[][] board;

    public ChessBoard() {
        this.board = new Piece[8][8]; // 8x8 chessboard
        setupPieces();
    }

    private void setupPieces() {
        // initial setup will be detailed in subsequent snippets
    }
}
