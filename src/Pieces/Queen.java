package src.Pieces;

import src.Position;

public class Queen extends Piece{
    public Queen(PieceColor color, Position position) {
        super(color, position);
    }

    @Override 
    public boolean isValidMove(Position newPosition, Piece[][] board) {
        // Check if the new position is the same as the current position
        if (newPosition.equals(this.position)) {
            return false;
        }
        
        int rowDiff = Math.abs(newPosition.getRow() - this.position.getRow());
        int colDiff = Math.abs(newPosition.getCol() - this.position.getCol());

        // Check for straight line movement
        boolean straightLine = this.position.getRow() == newPosition.getRow()
                || this.position.getColumn() == newPosition.getColumn();

        // Check for diagonal movement
        boolean diagonal = rowDiff == colDiff;

        if (!straightLine && !diagonal) {
            return false; // The move is neighter straight nor diagonal
        }

        // Calculate direction of movement
        int rowDirection = Integer.compare(newPosition.getRow(), this.position.getRow());
        int colDirection = Integer.compare(newPosition.getCol(), this.position.getCol());

        // Check for any pieces in the path
        int currentRow = this.position.getRow() + rowDirection;
        int currentCol = this.position.getCol() + colDirection;

        while (currentRow != newPosition.getRow() || currentCol != newPosition.getCol()) {
            if (board[currentRow][currentCol] != null) {
                return false; // Path is blocked
            }
            currentRow += rowDirection;
            currentCol += colDirection;
        }

        // The move is valid if the destination is empty or contains an opponent's piece
        Piece destinationPiece = board[newPosition.getRow()][newPosition.getCol()];
        return destinationPiece == null || destinationPiece.getColor() != this.color;
    }
}
