import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int[][] matrix = new int[dimensions[0]][dimensions[1]];
        int counter = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = counter++;
            }
        }

        String line = scanner.nextLine();

        while (!line.equals("Nuke it from orbit")) {
            int[] command = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            int row = command[0];
            int col = command[1];
            int radius = command[2];

            boolean[][] markedMatrix = new boolean[matrix.length][];
            for (int i = 0; i < matrix.length; i++) {
                markedMatrix[i] = new boolean[matrix[i].length];
            }

            for (int i = 0; i <= radius; i++) {
                for (Direction direction : Direction.getAllDirections()){
                    int currentRow = row + (i * direction.getRowModifier());
                    int currentCol = col + (i * direction.getColModifier());
                    if (isInBounds(currentRow, currentCol, matrix)) {
                        markedMatrix[currentRow][currentCol] = true;
                    }
                }
            }

            matrix = clearMatrix(matrix, markedMatrix);

            line = scanner.nextLine();
        }

        printMatrix(matrix);
    }

    static boolean isInBounds(int row, int col, int[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] clearMatrix(int[][] originalMatrix, boolean[][] markedMatrix) {
        for (int i = 0; i < originalMatrix.length; i++) {
            int deletionCount = 0;
            for (int j = 0; j < markedMatrix[i].length; j++) {
                if (markedMatrix[i][j]) {
                    deletionCount++;
                }
            }

            int[] newRow = new int[originalMatrix[i].length - deletionCount];
            int newRowCounter = 0;
            for (int j = 0; j < originalMatrix[i].length; j++) {
                if(!markedMatrix[i][j]) {
                    newRow[newRowCounter] = originalMatrix[i][j];
                    newRowCounter++;
                }
            }

            originalMatrix[i] = newRow;
        }

        return originalMatrix;
    }
}

enum Direction {
    TOP(-1, 0),
    DOWN(1, 0),
    LEFT(0, -1),
    RIGHT(0, 1);

    private int rowModifier;
    private int colModifier;

    Direction(int rowModifier, int colModifier) {
        this.rowModifier = rowModifier;
        this.colModifier = colModifier;
    }

    public int getRowModifier() {
        return rowModifier;
    }

    public int getColModifier() {
        return colModifier;
    }

    public static List<Direction> getAllDirections() {
        return List.of(TOP, DOWN, LEFT, RIGHT);
    }
}
