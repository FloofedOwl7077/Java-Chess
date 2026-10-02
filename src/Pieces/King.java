package src.Pieces;

public class King extends Piece {
    public King(PieceColor color, Position position) {
        super(color, position);
    }

    @Override
    public boolean isValidMove(Position newPosition, Piece[][] board) {
        int rowDiff = Math.abs(position.getRow() - newPosition.getRow());
        int colDiff = Math.abs(position.getCol() - newPosition.getCol());

        // Kings ca move one square in any direction
        boolean isOneSquareMove = rowDiff <= 1 && colDiff <=1 && !(RowDiff == 0 && colDiff == 0);
        
        if (!isOneSquareMove) {
            return false; // Move is not within one square.
        }

        Piece destinationPiece = board[newPosition.getRow()][newPosition.getCol()];
        // The move is valid if the destination square is empty or contains an opponent's
        // piece.

        return destinationPiece == null || destinationPiece.getColor() != this.getColor();
    }
}
