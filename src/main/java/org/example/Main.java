package org.example;

import br.com.sudoku.model.Tabuleiro;
import br.com.sudoku.service.SudokuService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Tabuleiro jogo = new Tabuleiro(3);
        SudokuService service = new SudokuService();

        service.gerarNovoJogo(jogo, 20);

        System.out.println("SUDOKU - VIDAS: " + jogo.getVidas());
        for(int i = 0; i<9; i++){
            for(int j = 0; j < 9; j++){
                System.out.println(jogo.getValor(i, j)+ " ");
            }
            System.out.println();
        }
    }
}