public abstract class ChessPiece {
    protected String color;      // Цвет фигуры
    protected boolean check = true; // Флаг для проверки состояния (по умолчанию true)

    // Конструктор, принимающий цвет фигуры
    public ChessPiece(String color) {
        this.color = color;
    }

    // Метод, возвращающий цвет фигуры
    public String getColor() {
        return color;
    }

    // Метод для получения значения флага check
    public boolean getCheck() {
        return check;
    }

    // Метод для изменения значения флага check
    public void setCheck(boolean check) {
        this.check = check;
    }

    // Абстрактный метод, проверяющий возможность хода на указанную позицию
    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    // Абстрактный метод, возвращающий символ фигуры (тип фигуры)
    public abstract String getSymbol();
}
