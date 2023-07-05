package com.firstproj;

public class Matrix {
    private int row,col;

    private int [][] mat;

    public Matrix(int row,int col){
        this.row = row;
        this.col = col;
        mat = new int[row][col];
        init();
    }
    private void init(){
        for (int i = 0; i < row ; i++) {
            for (int j = 0; j < col; j++) {
                mat[i][j] = 0;
            }
        }
    }
    public void display(){
        for (int i = 0; i < row ; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
    public Matrix add(Matrix m){
        Matrix result = new Matrix(m.getRow(),m.getCol());
        for (int i = 0; i < row ; i++) {
            for (int j = 0; j < col; j++) {
                result.mat[i][j] = this.mat[i][j]+m.mat[i][j];
            }
        }
        return result;
    }
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int[][] getMat() {
        return mat;
    }

    public void setMat(int[][] mat) {
        this.mat = mat;
    }
}
