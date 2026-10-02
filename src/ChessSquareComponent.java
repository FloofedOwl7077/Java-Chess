package src;

import java.awt.*;
import javax.swing.*;

public class ChessSquareComponent extends JButton{
    private int row;
    private int col;

    public ChessSquareComponent(int row, int col) {
        this.row = row;
        this.col = col;
        initButton();
    }

    private void initButton() {
        // Set preferred button size for uniformity
        setPreferredSize(new Dimension(64, 64));

        // Set background color based on row and col for checkerboard effect
        if ((row + col) % 2 == 0) {
            setBackground(new Color(255, 255, 225));
        } else {
            setBackground(new Color(123, 205, 44));
        }

        // Ensure text (chess piece symbols) is centered
        setHorizontalAlignment(CENTER);
        setVerticalAlignment(CENTER);

        // Font Settings can be adjusted for visual enhancement
        setFont(new Font("Serif", Font.BOLD, 36));
    }

    public void setPieceSymbol(String symbol, Color color) {
        this.setText(symbol);
        this.setForeground(color); // Adjust for better visibility against background
    }

    public void clearPieceSymbol() {
        this.setText("");
    }
}
