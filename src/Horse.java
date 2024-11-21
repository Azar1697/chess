public class Horse extends ChessPiece {

    public Horse(String color) {
        super(color); // Конструктор принимает только цвет и передает его в базовый класс
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        // Проверяем, что начальная и конечная позиции находятся в пределах доски
        if (!chessBoard.checkPos(line) || !chessBoard.checkPos(column) ||
                !chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) {
            return false;
        }

        // Конь не может остаться на той же позиции
        if (line == toLine && column == toColumn) {
            return false;
        }

        // Проверяем, может ли конь ходить буквой "Г"
        int deltaX = Math.abs(toLine - line);
        int deltaY = Math.abs(toColumn - column);
        boolean isLMove = (deltaX == 2 && deltaY == 1) || (deltaX == 1 && deltaY == 2);

        if (!isLMove) {
            return false;
        }

        // Проверка на фигуру в конечной позиции
        ChessPiece targetPiece = chessBoard.board[toLine][toColumn];
        // Конь может переместиться на пустую клетку или съесть фигуру противоположного цвета
        return targetPiece == null || !targetPiece.getColor().equals(this.color);
    }

    @Override
    public String getSymbol() {
        return "H"; // Символ коня — "H"
    }
}
