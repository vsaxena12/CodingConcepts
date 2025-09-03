package matrices;

public class Matrices {
      public static void main(String[] args) {
            int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 } };
            int[][] arrSym = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
            matrixPrint(arr);
            System.out.println(matrixSearch(arr, 51));
            matrixSum(arr);
            System.out.println(matrixSum(arr));
            matrixTranspose(arr);

            matrixDiagonalSum(arr);
            System.out.println(matrixDiagonalSum(arr));

            printBoundary(arr); // Fix this code

            matrixSymmetry(arrSym);
            System.out.println(matrixSymmetry(arrSym));

            count_0_1(arrSym);

            matrixIdentity(arrSym);
            System.out.println(matrixIdentity(arrSym));

            matrixMaxElement(arr);
            System.out.println(matrixMaxElement(arr));

      }

      static void matrixPrint(int[][] arr) {
            for (int i = 0; i < arr.length; i++) {
                  for (int j = 0; j < arr[i].length; j++) {
                        System.out.print(arr[i][j] + " ");
                  }
                  System.out.println("");
            }
      }

      static boolean matrixSearch(int[][] arr, int element) {
            for (int i = 0; i < arr.length; i++) {
                  for (int j = 0; j < arr[i].length; j++) {
                        if (arr[i][j] == element) {
                              return true;
                        }
                  }
            }
            return false;
      }

      static int matrixSum(int[][] arr) {
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                  for (int j = 0; j < arr[i].length; j++) {
                        sum += arr[i][j];
                  }
            }
            return sum;
      }

      static void matrixTranspose(int[][] arr) {
            int[][] transpose = new int[arr[0].length][arr.length];

            for (int i = 0; i < arr.length; i++) {
                  for (int j = 0; j < arr[i].length; j++) {
                        transpose[j][i] = arr[i][j];
                  }
            }
            matrixPrint(transpose);
      }

      static int matrixDiagonalSum(int[][] arr) {
            int diagonalSum = 0;
            for (int i = 0; i < arr.length; i++) {
                  for (int j = 0; j < arr[i].length; j++) {
                        if (i == j) {
                              diagonalSum += arr[i][j];
                        }
                  }
            }
            return diagonalSum;
      }

      static void printBoundary(int[][] matrix) {

            int rows = matrix.length;
            int cols = matrix[0].length;

            // Top row
            for (int i = 0; i < cols; i++) {
                  System.out.print(matrix[0][i] + " ");
            }

            // Right column
            for (int i = 1; i < rows; i++) {
                  System.out.print(matrix[i][cols - 1] + " ");
            }

            // Bottom row (only if more than 1 row)
            if (rows > 1) {
                  for (int i = cols - 2; i >= 0; i--) {
                        System.out.print(matrix[rows - 1][i] + " ");
                  }
            }

            // Left column (only if more than 1 column)
            if (cols > 1) {
                  for (int i = rows - 2; i > 0; i--) {
                        System.out.print(matrix[i][0] + " ");
                  }
            }
            System.out.println();
      }

      static boolean matrixSymmetry(int[][] arr) {
            if (arr.length != arr[0].length)
                  return false;

            for (int i = 0; i < arr.length; i++) {
                  for (int j = 0; j < arr[i].length; j++) {
                        if (arr[i][j] != arr[j][i]) {
                              return false;
                        }
                  }
            }
            return true;
      }

      static void count_0_1(int[][] arr) {
            int zeros = 0;
            int ones = 0;
            for (int i = 0; i < arr.length; i++) {
                  for (int j = 0; j < arr[i].length; j++) {
                        if (arr[i][j] == 0) {
                              zeros++;
                        } else if (arr[i][j] == 1) {
                              ones++;
                        }
                  }
            }
            System.out.println("Zeros are: " + zeros + " and ones are: " + ones);
      }

      static boolean matrixIdentity(int[][] arr) {
            if (arr.length != arr[0].length) {
                  return false;
            }

            for (int i = 0; i < arr.length; i++) {
                  for (int j = 0; j < arr[0].length; j++) {
                        if (i == j && arr[i][j] == 1) {
                              continue;
                        } else if (i != j && arr[i][j] == 0) {
                              continue;
                        } else {
                              return false;
                        }
                  }
            }
            return true;
      }

      static int matrixMaxElement(int[][] arr) {
            int max = 0;
            for (int i = 0; i < arr.length; i++) {
                  for (int j = 0; j < arr[0].length; j++) {
                        if (max < arr[i][j]) {
                              max = arr[i][j];
                        }
                  }
            }
            return max;
      }

}
