package hw2;
import hw2.Percolation;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
public class PercolationStats {
    private int T;
    private double[] x;
    public PercolationStats(int N, int T, PercolationFactory pf){
        if (N <= 0 || T < 0){
            throw new IllegalArgumentException();
        }
        x = new double[T];
        for (int i = 0; i < T; i++) {
            Percolation p = pf.make(N);
            while (!p.percolates()) {
                int randomRow = StdRandom.uniform(N);
                int randomCol = StdRandom.uniform(N);
                p.open(randomRow, randomCol);
            }
            x[i] = (double) p.numberOfOpenSites()/(N*N);
        }
    }

    public double mean() {
        return StdStats.mean(x);
    }

    public double stddev() {
        return StdStats.stddev(x);
    }

    public double confidenceLow() {
        return mean() - 1.96*stddev() / Math.sqrt(T);
    }

    public double confidenceHigh() {
        return mean() + 1.96*stddev() / Math.sqrt(T);
    }


}
