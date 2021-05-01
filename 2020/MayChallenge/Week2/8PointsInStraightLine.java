/**
    Check If It Is a Straight Line
    ------------------------------
    You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point.
    Check if these points make a straight line in the XY plane.

    Example 1:
    Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
    Output: true

    Example 2:
    Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
    Output: false
 
    Constraints:
        2 <= coordinates.length <= 1000
        coordinates[i].length == 2
        -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
        coordinates contains no duplicate point.

    Hints:
        If there're only 2 points, return true.
        Check if all other points lie on the line defined by the first 2 points.
        Use cross product to check collinearity.
 */
class CheckPoints {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length == 0)
            return false;
        if (coordinates.length <= 2)
            return true;
        
        boolean flag = true;
        
        for (int i = 2; i < coordinates.length; i++) {
            int[] c1 = coordinates[i - 2];
            int[] c2 = coordinates[1 - 1];
            int[] c3 = coordinates[i];
            
            if ((c3[1] - c2[1]) * (c2[0] - c1[0]) !=  (c2[1] - c1[1]) * (c3[0] - c2[0]))
                flag = false;            
        }
        
        return flag;
    }
}