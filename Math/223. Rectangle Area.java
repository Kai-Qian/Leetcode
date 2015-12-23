/*
Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

Rectangle Area
Assume that the total area is never beyond the maximum possible value of int.
*/
public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int total = (C - A) * (D - B) + (G - E) * (H - F);
        int A1 = Math.max(A, E);//小的中找大的，大的中找小的才有可能重叠
        int B1 = Math.min(H, D);
        int C1 = Math.min(C, G);
        int D1 = Math.max(F, B);
        if(A1 >= C1 || B1 <= D1) {
            return total;
        } else {
            return (total - (C1 - A1) * (B1 - D1));
        }
    }
}