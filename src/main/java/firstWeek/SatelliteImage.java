package firstWeek;

import java.util.Arrays;

public class SatelliteImage {

    public static void satelliteImage(int[][] image1, int[][] image2) {
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;

        int r = Integer.MAX_VALUE;
        int c = Integer.MIN_VALUE;

        for (int i = 0; i < image1.length; ++i) {
            int l1 = Arrays.stream(image1[i]).sum();
            int r1 = Arrays.stream(image2[i]).sum();

            for(int j = 0; j < image1[i].length && (l1 != r1); ++j) {
                int a = image1[i][j];
                int b = image2[i][j];
                if (a != b) {
                    start = Math.min(start, j);
                    end = Math.max(end, j);
                    r = Math.min(r, i);
                    c = Math.max(c, i);
                }
            }
        }

        System.out.println(image1.length + " " + image1[0].length);
        System.out.println((r+1) +" " + (start+ 1)+ " " + (c + 1) + " " + (end + 1));

    }

    public static void main(String[] args) {
        int[][] image1 = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {2, 2, 2, 2, 2, 3, 3, 3, 3, 3},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 5, 5},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        int[][] image2 = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {2, 2, 2, 2, 2, 3, 3, 3, 3, 3},
                {2, 2, 9, 9, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 5, 5, 5},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 3, 1, 1, 3, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 5, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        satelliteImage(image1, image2);
    }
}
