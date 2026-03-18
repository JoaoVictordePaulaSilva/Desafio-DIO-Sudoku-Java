package br.com.sudoku.ui;

import br.com.sudoku.model.Tabuleiro;
import br.com.sudoku.service.SudokuService;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SudokuGUI extends Application {

    private Tabuleiro jogo;
    private SudokuService service;
    private Label labelVidas;

    @Override
    public void start(Stage primaryStage) {
        service = new SudokuService();
        jogo = new Tabuleiro(3); // 3 vidas
        service.gerarNovoJogo(jogo, 20); // Gera 20 números iniciais

        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);

        labelVidas = new Label("Vidas: " + jogo.getVidas());
        labelVidas.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setStyle("-fx-padding: 10; -fx-background-color: black; -fx-hgap: 2; -fx-vgap: 2;");

        for (int linha = 0; linha < 9; linha++) {
            for (int col = 0; col < 9; col++) {
                TextField field = new TextField();
                field.setPrefSize(45, 45);
                field.setAlignment(Pos.CENTER);

                int valorSetado = jogo.getValor(linha, col);

                if (valorSetado != 0) {
                    // Se o número já vem do gerador, preenchemos e bloqueamos
                    field.setText(String.valueOf(valorSetado));
                    field.setEditable(false);
                    field.setStyle("-fx-background-color: #e0e0e0; -fx-font-weight: bold;");
                } else {
                    // Se estiver vazio, adicionamos um "ouvinte" para validar quando o usuário digitar
                    configurarEventoInput(field, linha, col);
                }

                grid.add(field, col, linha);
            }
        }

        root.getChildren().addAll(labelVidas, grid);
        Scene scene = new Scene(root, 500, 600);
        primaryStage.setTitle("Sudoku Dinâmico");

        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private void configurarEventoInput(TextField field, int linha, int col) {
        field.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.isEmpty()) {
                try {
                    int num = Integer.parseInt(newValue);
                    // Valida usando o nosso SudokuService
                    if (service.validarJogada(jogo, linha, col, num)) {
                        jogo.setValor(linha, col, num);
                        field.setStyle("-fx-text-fill: blue;"); // Acertou
                    } else {
                        // ERROU: Desconta vida
                        jogo.descontarVida();
                        labelVidas.setText("Vidas: " + jogo.getVidas());
                        field.setText(""); // Limpa o erro
                        field.setStyle("-fx-border-color: red;");

                        if (jogo.getVidas() <= 0) {
                            System.out.println("GAME OVER!");
                            // Aqui depois podemos colocar um alerta visual
                        }
                    }
                } catch (NumberFormatException e) {
                    field.setText(""); // Se digitar letra, limpa
                }
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}