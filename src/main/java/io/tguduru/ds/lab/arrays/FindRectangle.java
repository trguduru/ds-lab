package io.tguduru.ds.lab.arrays;

import java.util.ArrayList;
import java.util.List;
/*
Imagine we have an image. We'll represent this image as a simple 2D array where every pixel is a 1 or a 0. The image you get is known to have a single rectangle of 0s on a background of 1s.

Write a function that takes in the image and returns one of the following representations of the rectangle of 0's: top-left coordinate and bottom-right coordinate OR top-left coordinate, width, and height.

image1 = [
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 0, 0, 0, 1],
  [1, 1, 1, 0, 0, 0, 1],
  [1, 1, 1, 1, 1, 1, 1],
]

Sample output variations (only one is necessary):

findRectangle(image1) =>
  x: 3, y: 2, width: 3, height: 2
  2,3 3,5 -- row,column of the top-left and bottom-right corners

Other test cases:

image2 = [
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 0],
]

findRectangle(image2) =>
  x: 6, y: 4, width: 1, height: 1
  4,6 4,6

image3 = [
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 0, 0],
  [1, 1, 1, 1, 1, 0, 0],
]

findRectangle(image3) =>
  x: 5, y: 3, width: 2, height: 2
  3,5 4,6

image4 = [
  [0, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
]

findRectangle(image4) =>
  x: 0, y: 0, width: 1, height: 1
  0,0 0,0

image5 = [
  [0],
]

findRectangle(image5) =>
  x: 0, y: 0, width: 1, height: 1
  0,0 0,0
*/

public class FindRectangle {
    public static void main(String[] argv) {
        int[][] image1 = {
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 0, 0, 0, 1},
            {1, 1, 1, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1}
        };

        int[][] image2 = {
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 0}
        };

        int[][] image3 = {
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 0, 0},
            {1, 1, 1, 1, 1, 0, 0}
        };

        int[][] image4 = new int[][]{
            {0, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1}
        };

        int[][] image5 = {
            {0}
        };
        Result r = findRectangle(image3);
        List<Cordinates> cords = r.cords;
        cords.forEach(c -> System.out.println("X:" + c.x + ", Y:" + c.y));
        System.out.println(r.hight + ", " + r.width);
    }

    static class Cordinates {
        private int x;
        private int y;

        Cordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Result {
        List<Cordinates> cords;
        int hight;
        int width;

        Result(List<Cordinates> cords, int h, int w) {
            this.cords = cords;
            this.hight = h;
            this.width = w;
        }
    }

    static Result findRectangle(int[][] image) {
        List<Cordinates> cords = new ArrayList<>();
        if (image == null || image.length == 0)
            return null;

        for (int row = 0; row < image.length; row++) {
            int[] rowValues = image[row];
            for (int column = 0; column < rowValues.length; column++) {
                if (rowValues[column] == 0) {
                    Cordinates cordinates = new Cordinates(row, column);
                    cords.add(cordinates);
                }
            }
        }
        Result r = null;
        if (cords.size() == 1) {
            r = new Result(cords, 1, 1);
        } else { // for multiple
            r = new Result(cords, 1, 1);
        }
        return r;
    }

}
