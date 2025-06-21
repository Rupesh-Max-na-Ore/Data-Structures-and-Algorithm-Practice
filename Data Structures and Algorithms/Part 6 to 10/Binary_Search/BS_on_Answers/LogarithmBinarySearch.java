package Binary_Search.BS_on_Answers;

public class LogarithmBinarySearch {
    // Method to calculate log base b of x using binary search
    public static double logBaseB(double x, double base, double precision) {
        if (x <= 0 || base <= 0 || base == 1) {
            throw new IllegalArgumentException("Invalid input values");
        }

        double low = 0;
        double high = x;
        double mid = 0;

        while ((high - low) > precision) {
            mid = (low + high) / 2;
            double power = Math.pow(base, mid);
            if (power > x) {
                high = mid;
            } else if (power < x) {
                low = mid;
            } else if(power == x){
                return mid;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        double x = 1000; // The no. for which we want to find the logarithm
        double base = 10; // The base of the logarithm
        double precision = 1e-12; // The desired precision

        double result = logBaseB(x, base, precision);
        System.out.println("log_" + base + "(" + x + ") = " + result);
    }
}
