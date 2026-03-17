package br.com.sudoku.model;

public class Tabuleiro {
    private int[][] grade;
    private int[][] solucao;
    private int vidas;

    public Tabuleiro(int vidasIniciais){
        this.grade = new int[9][9];
        this.solucao = new int[9][9];
        this.vidas = vidasIniciais;
    }

    public int[][] getGrade() {
        return grade;
    }
    public void setGrade(int[][] grade) {
        this.grade = grade;
    }
    public int[][] getSolucao() {
        return solucao;
    }
    public void setSolucao(int[][] solucao) {
        this.solucao = solucao;
    }
    public int getVidas() {
        return vidas;
    }
    public void setVidas(int vidas) {
        this.vidas = vidas;
    }
    public int getValor(int linha, int col) {
        return this.grade[linha][col];
    }
    public void setValor(int linha, int col, int valor) {
        this.grade[linha][col] = valor;
    }
    public void descontarVida() {
        this.vidas--;
    }
}
