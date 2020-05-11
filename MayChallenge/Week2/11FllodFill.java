/**
    Flood Fill
    ----------
    An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).
    Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

    To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel,
    plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. 
    Replace the color of all of the aforementioned pixels with the newColor.

    At the end, return the modified image.

    Example 1:
        Input: 
        image = [[1,1,1],[1,1,0],[1,0,1]]
        sr = 1, sc = 1, newColor = 2
        Output: [[2,2,2],[2,2,0],[2,0,1]]

    Explanation: 
        From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected 
        by a path of the same color as the starting pixel are colored with the new color.
        Note the bottom corner is not colored 2, because it is not 4-directionally connected
        to the starting pixel.
    
    Note:
        The length of image and image[0] will be in the range [1, 50].
        The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
        The value of each color in image[i][j] and newColor will be an integer in [0, 65535].
 */

class Solution {
    int[][] image;
    int[][] imageTrace;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // check for base cases
            // check if r and c within 50
            // sr, sc within limits
            // newColor is within 65535
        if (image.length == 0 || image.length > 50 
            || image[0].length == 0 || image[0].length > 50
            || sr < 0 || sr >= image.length 
            || sc < 0 || sc >= image[0].length 
            || newColor < 0 || newColor > 65535)
            return null;
        this.image = image;
        this.imageTrace = new int[image.length][image[0].length];
        
        // save oldColor, assign newColor to cell
        int oldColor = image[sr][sc];
        this.image[sr][sc] = newColor;
        this.imageTrace[sr][sc] = 1;
        
        // make 4 diff function calls for 4 directions
        floodFill(sr, sc - 1, oldColor, newColor);
        floodFill(sr, sc + 1, oldColor, newColor);
        floodFill(sr - 1, sc, oldColor, newColor);
        floodFill(sr + 1, sc, oldColor, newColor);
        return this.image;
    }
    
    public void floodFill(int sr, int sc, int oldColor, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length 
            || oldColor != image[sr][sc] || imageTrace[sr][sc] == 1)
            return;
        // check if sr && sc is within image limits, else return
        // check if oldColor is equal to image[sr][sc], else return
        image[sr][sc] = newColor;
        imageTrace[sr][sc] = 1;
        // recurse for 4 directional coordinates
        floodFill(sr, sc - 1, oldColor, newColor);
        floodFill(sr, sc + 1, oldColor, newColor);
        floodFill(sr - 1, sc, oldColor, newColor);
        floodFill(sr + 1, sc, oldColor, newColor);
    }
    
}