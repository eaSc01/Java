package BinarySearch;


public class NthRootOfM {
    public double multiply(double x, double n) {
        double a = 1;
        
        for (int i = 0; i<n; i++) {
            a *= x;
        }
        
        return a;
    }
    
    public int NthRoot(int n, int m)
    {
        double eps = 1e-6;
        double low = 1;
        double high = m;
        
        while ((high - low) > eps) {
            double mid = (low + high)/2.0;
            
            if (multiply(mid, n) < m) {
                low = mid;
            } else {
                high = mid;
            }
        }
        
        int approxRoot = (int)Math.round(low);
        
        // Check if this approximation is really the nth root of m
        if (Math.pow(approxRoot, n) == m) {
            return approxRoot;
        } else {
            return -1; // If not a perfect nth root, return -1 as per convention
        }
    }
}