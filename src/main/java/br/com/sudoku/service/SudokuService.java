package br.com.sudoku.service;

import br.com.sudoku.model.Tabuleiro;

import java.util.Random;

public class SudokuService {

    public boolean validarJogada(Tabuleiro tabuleiro, int linha, int col, int valor){
        for(int i = 0; i < 9; i++){
            if (tabuleiro.getValor(linha, i) == valor) return false;
        }
        for (int i=0; i<9; i++){
            if (tabuleiro.getValor(i, col) == valor) return false;
        }

        int linhaInicio = (linha / 3) * 3;
        int colInicio = (col / 3) * 3;

        for (int i = linhaInicio; i < linhaInicio + 3; i++){
            for (int j = colInicio; j < colInicio + 3; j++){
                if(tabuleiro.getValor(i, j) == valor) return false;
            }
        }
        return true;
    }
    public void gerarNovoJogo(Tabuleiro tabuleiro, int numerosIniciais){
        Random random = new Random();
        int preenchidos = 0;

        while (preenchidos < numerosIniciais) {
            int linha = random.nextInt(9);
            int col = random.nextInt(9);
            int valor = random.nextInt(9)+ 1;

            if (tabuleiro.getValor(linha,col) == 0 &&
                    validarJogada(tabuleiro, linha, col, valor)){
            tabuleiro.setValor(linha,col,valor);
            preenchidos++;

            }
        }
    }
}
