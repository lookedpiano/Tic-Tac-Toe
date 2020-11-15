import java.util.Scanner;

public class TicTacToe {

    public static void printField(char[] field) {
        System.out.println("---------");
        System.out.println("| " + field[0] + " " + field[1] + " " + field[2] + " |");
        System.out.println("| " + field[3] + " " + field[4] + " " + field[5] + " |");
        System.out.println("| " + field[6] + " " + field[7] + " " + field[8] + " |");
        System.out.println("---------");
    }

    public static int coordinatesToNum(int x, int y, int userInput) {
        // userInput = 0;
        if (x == 1 && y == 1) {
            userInput = 6;
        } else if (x == 1 && y == 2) {
            userInput = 3;
        } else if (x == 2 && y == 1) {
            userInput = 7;
        } else if (x == 2 && y == 2) {
            userInput = 4;
        } else if (x == 2 && y == 3) {
            userInput = 1;
        } else if (x == 3 && y == 1) {
            userInput = 8;
        } else if (x == 3 && y == 2) {
            userInput = 5;
        } else if (x == 3 && y == 3) {
            userInput = 2;
        }
        return userInput;
    }

    public static int convertUserInput(char[] field) {
        Scanner sc = new Scanner(System.in);

        boolean succeed = false;
        int x = 0;
        int y = 0;

        int userInput = 0;
        do {
            System.out.print("Enter the coordinates: ");
            String choice1 = sc.nextLine();
            String[] choices = choice1.split(" ");

            try {
                x = Integer.parseInt(choices[0]);
                y = Integer.parseInt(choices[1]);

                if (x < 1 || x > 3 || y < 1 || y > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }
                userInput = coordinatesToNum(x, y, userInput);
                if (field[userInput] != ' ') {
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                }
                succeed = true;
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
            }
        } while (!succeed);
        return userInput;
    }

    public static void result(char[] field) {

        int userInput = convertUserInput(field);
        boolean res = checkSet(field);
        int count = 0;

        boolean free = false;
        while (!res) {
            if (count % 2 == 0) {
                field[userInput] = 'X';
            } else {
                field[userInput] = 'O';
            }
            count++;
            printField(field);
            res = checkSet(field);
            if (res) {
                continue;
            }
            userInput = convertUserInput(field);
        }
    }

    public static boolean checkSet(char[] field) {

        boolean res = false;
        // 1. row X or O, 2. and 3. row differ
        if (field[0] == 'X' && field[1] == 'X' && field[2] == 'X' &&
                field[3] == 'O' && field[4] == 'O' && field[5] == 'O') {
            System.out.println("Impossible");
        } else if (field[0] == 'X' && field[1] == 'X' && field[2] == 'X' &&
                field[6] == 'O' && field[7] == 'O' && field[8] == 'O') {
            System.out.println("Impossible");
        } else if (field[0] == 'O' && field[1] == 'O' && field[2] == 'O' &&
                field[3] == 'X' && field[4] == 'X' && field[5] == 'X') {
            System.out.println("Impossible");
        } else if (field[0] == 'O' && field[1] == 'O' && field[2] == 'O' &&
                field[6] == 'X' && field[7] == 'X' && field[8] == 'X') {
            System.out.println("Impossible");
        }
        // 2. row X or O, 2. and 3. row differ
        else if (field[3] == 'X' && field[4] == 'X' && field[5] == 'X' &&
                field[0] == 'O' && field[1] == 'O' && field[2] == 'O') {
            System.out.println("Impossible");
        } else if (field[3] == 'X' && field[4] == 'X' && field[5] == 'X' &&
                field[6] == 'O' && field[7] == 'O' && field[8] == 'O') {
            System.out.println("Impossible");
        } else if (field[3] == 'O' && field[4] == 'O' && field[5] == 'O' &&
                field[0] == 'X' && field[1] == 'X' && field[2] == 'X') {
            System.out.println("Impossible");
        } else if (field[3] == 'O' && field[4] == 'O' && field[5] == 'O' &&
                field[6] == 'X' && field[7] == 'X' && field[8] == 'X') {
            System.out.println("Impossible");
        }
        // 3. row X or O, 2. and 3. row differ
        else if (field[6] == 'X' && field[7] == 'X' && field[8] == 'X' &&
                field[0] == 'O' && field[1] == 'O' && field[2] == 'O') {
            System.out.println("Impossible");
        } else if (field[6] == 'X' && field[7] == 'X' && field[8] == 'X' &&
                field[3] == 'O' && field[4] == 'O' && field[5] == 'O') {
            System.out.println("Impossible");
        } else if (field[6] == 'O' && field[7] == 'O' && field[8] == 'O' &&
                field[0] == 'X' && field[1] == 'X' && field[2] == 'X') {
            System.out.println("Impossible");
        } else if (field[6] == 'O' && field[7] == 'O' && field[8] == 'O' &&
                field[3] == 'X' && field[4] == 'X' && field[5] == 'X') {
            System.out.println("Impossible");
        }
        // 1. col X or O, 2. and 3. row differ
        else if (field[0] == 'X' && field[3] == 'X' && field[6] == 'X' &&
                field[1] == 'O' && field[4] == 'O' && field[7] == 'O') {
            System.out.println("Impossible");
        } else if (field[0] == 'X' && field[3] == 'X' && field[6] == 'X' &&
                field[2] == 'O' && field[5] == 'O' && field[8] == 'O') {
            System.out.println("Impossible");
        } else if (field[0] == 'O' && field[3] == 'O' && field[6] == 'O' &&
                field[1] == 'X' && field[4] == 'X' && field[7] == 'X') {
            System.out.println("Impossible");
        } else if (field[0] == 'O' && field[3] == 'O' && field[6] == 'O' &&
                field[2] == 'X' && field[5] == 'X' && field[8] == 'X') {
            System.out.println("Impossible");
        }
        // 2. col X or O, 2. and 3. row differ
        else if (field[1] == 'X' && field[4] == 'X' && field[7] == 'X' &&
                field[0] == 'O' && field[3] == 'O' && field[6] == 'O') {
            System.out.println("Impossible");
        } else if (field[1] == 'X' && field[4] == 'X' && field[7] == 'X' &&
                field[2] == 'O' && field[5] == 'O' && field[8] == 'O') {
            System.out.println("Impossible");
        } else if (field[1] == 'O' && field[4] == 'O' && field[7] == 'O' &&
                field[0] == 'X' && field[3] == 'X' && field[6] == 'X') {
            System.out.println("Impossible");
        } else if (field[1] == 'O' && field[4] == 'O' && field[7] == 'O' &&
                field[2] == 'X' && field[5] == 'X' && field[8] == 'X') {
            System.out.println("Impossible");
        }
        // 3. col X or O, 2. and 3. row differ
        else if (field[2] == 'X' && field[5] == 'X' && field[8] == 'X' &&
                field[0] == 'O' && field[3] == 'O' && field[6] == 'O') {
            System.out.println("Impossible");
        } else if (field[2] == 'X' && field[5] == 'X' && field[8] == 'X' &&
                field[1] == 'O' && field[4] == 'O' && field[7] == 'O') {
            System.out.println("Impossible");
        } else if (field[2] == 'O' && field[5] == 'O' && field[8] == 'O' &&
                field[0] == 'X' && field[3] == 'X' && field[6] == 'X') {
            System.out.println("Impossible");
        } else if (field[2] == 'O' && field[5] == 'O' && field[8] == 'O' &&
                field[1] == 'X' && field[4] == 'X' && field[7] == 'X') {
            System.out.println("Impossible");
        } else if (field[0] == 'X' && field[1] == 'X' && field[2] == 'X' ||
                field[3] == 'X' && field[4] == 'X' && field[5] == 'X' ||
                field[6] == 'X' && field[7] == 'X' && field[8] == 'X' ||
                field[0] == 'X' && field[3] == 'X' && field[6] == 'X' ||
                field[1] == 'X' && field[4] == 'X' && field[7] == 'X' ||
                field[2] == 'X' && field[5] == 'X' && field[8] == 'X' ||
                field[0] == 'X' && field[4] == 'X' && field[8] == 'X' ||
                field[2] == 'X' && field[4] == 'X' && field[6] == 'X') {
            System.out.println("X wins");
            res = true;
        } else if (field[0] == 'O' && field[1] == 'O' && field[2] == 'O' ||
                field[3] == 'O' && field[4] == 'O' && field[5] == 'O' ||
                field[6] == 'O' && field[7] == 'O' && field[8] == 'O' ||
                field[0] == 'O' && field[3] == 'O' && field[6] == 'O' ||
                field[1] == 'O' && field[4] == 'O' && field[7] == 'O' ||
                field[2] == 'O' && field[5] == 'O' && field[8] == 'O' ||
                field[0] == 'O' && field[4] == 'O' && field[8] == 'O' ||
                field[2] == 'O' && field[4] == 'O' && field[6] == 'O') {
            System.out.println("O wins");
            res = true;
        } else if ((field[0] == 'X' || field[0] == 'O') &&
                (field[1] == 'X' || field[1] == 'O') &&
                (field[2] == 'X' || field[2] == 'O') &&
                (field[3] == 'X' || field[3] == 'O') &&
                (field[4] == 'X' || field[4] == 'O') &&
                (field[5] == 'X' || field[5] == 'O') &&
                (field[6] == 'X' || field[6] == 'O') &&
                (field[7] == 'X' || field[7] == 'O') &&
                (field[8] == 'X' || field[8] == 'O')) {
            System.out.println("Draw");
            res = true;
        } else if (field[0] == '_' ||
                field[1] == '_' ||
                field[2] == '_' ||
                field[3] == '_' ||
                field[4] == '_' ||
                field[5] == '_' ||
                field[6] == '_' ||
                field[7] == '_' ||
                field[8] == '_' ||
                field[0] == ' ' ||
                field[1] == ' ' ||
                field[2] == ' ' ||
                field[3] == ' ' ||
                field[4] == ' ' ||
                field[5] == ' ' ||
                field[6] == ' ' ||
                field[7] == ' ' ||
                field[8] == ' ') {
            // System.out.println("Game not finished");
        }
        return res;
    }

    public static char[] buildBoard() {

        char[] field = new char[9];
        for (int i = 0; i < field.length; i++) {
            field[i] = ' ';
        }
        printField(field);
        return field;
    }

    public static void main(String[] args) {

        char[] field = buildBoard();
        result(field);

    }
}