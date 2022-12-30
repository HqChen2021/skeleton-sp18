package hw2;
import static org.junit.Assert.*;
import hw2.Percolation;
import org.junit.Test;

public class TestPercolation {

    @Test
    public void sanityInitialTest() {
        int N = 4;
        Percolation p = new Percolation(N);
        for (int i = 0; i < N; i++) {
            assertTrue(p.ds.connected(i, N*N));
        }
    }

    @Test
    public void check_xyTo1D() {

    }
}