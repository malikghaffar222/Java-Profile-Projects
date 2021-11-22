class Task3
{
    // Rrecursive Function to Calculate power using indirect recursion
    static int power(int x, int y) {

        if (y == 0) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }
        if (y == 1) {
            return x;
        }

        return multiplyByAddition(x, power(x, y - 1));
    }
    // Find multiplication by using addition
    static int multiplyByAddition(int x, int y) {
        if (y != 0)
            return (x + multiplyByAddition(x, y - 1));
        else
            return 0;
    }
    //Drive method to test the fucntion of power
    public static void main(String[] args)
    {
        int x = 2;
        int n = 3;
 
        System.out.println("pow(" + x + ", " + n + ") = " + power(x, n));
    }
}