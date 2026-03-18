module br.com.sudoku {
    requires javafx.controls;
    requires javafx.fxml;

    exports br.com.sudoku.ui;
    exports br.com.sudoku.model;
    exports br.com.sudoku.service;

    opens br.com.sudoku.ui to javafx.graphics, javafx.fxml;
}