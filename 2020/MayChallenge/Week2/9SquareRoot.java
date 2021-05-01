/**
    Valid Perfect Square
    --------------------
    Given a positive integer num, write a function which returns True if num is a perfect square else False.

    Note: Do not use any built-in library function such as sqrt.

    Example 1:
        Input: 16
        Output: true
    
    Example 2:
        Input: 14
        Output: false
 */
 class ValidSquareRoot {
    public boolean isPerfectSquare(int num) {
        if (num == 1)
            return true;
        if (num < 4)
            return false;

        int r = num;
        int i = 0;
        /*
            Since int will only hold 2 ^ 31. The test case with max number 2147483647 failed
            Because 2147483647 * 2147483647 = 4 if midSqr is int. Hence we need to use long.
        */
        long mid = 0;
        long midSqr = 0;
        // using binary search
        while (i <= num) {
            mid = (i + num) / 2;
            midSqr = mid * mid;
            if (midSqr == r) {
                return true;
            } if (midSqr > r) {
                num = (int) mid - 1;
            } else {
                i = (int) mid + 1;
            }
        }
        return false;}
}
