package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    /** create a N-by-N ds, with all sites initially blocked*/
    public WeightedQuickUnionUF ds, auxi_ds;
    public int numOpenSites;
    public int size;
    private int[] grid;
    private int length;
    public Percolation(int N) {
        if (N < 0) {
            throw new IllegalArgumentException();
        } else {
            size = N;
            length = N * N;
            ds = new WeightedQuickUnionUF(length + 2);
            auxi_ds = new WeightedQuickUnionUF(length + 2);
            grid = new int [length];
            for (int i = 0; i < length; i++){
                grid[i] = 0;
            }
            for (int i = 0; i < size; i++){
                ds.union(length,i);
                auxi_ds.union(length,i);
            }
            for (int i = length-size; i < length; i++){
                ds.union(length+1, i);
            }
        }
    }

    public int xyTo1D(int row, int col){
        if (row < 0 || row >= size) {
            return -1;
        } else if (col < 0 || col >= size) {
            return -2;
        } else {
            return row * size + col;
        }
    }

    /** open the site (row, col) if it is not open already*/
    public void open(int row, int col) {
        int index = xyTo1D(row, col);
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (grid[index] == 0) {
            grid[index] = 1;
            numOpenSites++;
            int []row_ = new int []{row+1, row-1};
            int []col_ = new int []{col+1, col-1};
            for (int i: row_){
                int index_ = xyTo1D(i, col);
                if (index_ >= 0 && isOpen(i, col)){
                    ds.union(index, index_);
                    auxi_ds.union(index, index_);
                    }
                }

            for (int j: col_){
                int index_ = xyTo1D(row, j);
                if (index_ >= 0 && isOpen(row, j)){
                    ds.union(index, index_);
                    auxi_ds.union(index, index_);
                }
            }
        }
    }

    /** is the site (row, col) open?*/
    public boolean isOpen(int row, int col) {
        int index = xyTo1D(row, col);
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return grid[index] > 0 ;
    }

    /** is the site full? */
    public boolean isFull(int row, int col) {
        int index = xyTo1D(row, col);
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return auxi_ds.connected(index, length) && isOpen(row, col);
    }

    public int numberOfOpenSites() {
        return numOpenSites;
    }

    public boolean percolates() {
        return ds.connected(length+1, length);
    }
}
