package com.teb.practice.games;

import java.util.Scanner;

public class TicTacToe {

    private static final String[][] GAME_BOARD = new String[3][3];
    private static final String SPACE = " ";

    public static void main(String[] args) {
        runGame();
    }

    private static void runGame() {
        initialiseGameBoard();
        printCurrentBoard();

        int inputCounter = 1;
        String input = "";

        while (inputCounter >= 1 && inputCounter <= 9) {
            if (inputCounter % 2 == 0) {
                input = "O";
            }
            if (inputCounter % 2 != 0) {
                input = "X";
            }
            inputCounter = getUserInput(input, inputCounter);
        }
    }

    private static void initialiseGameBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                GAME_BOARD[i][j] = SPACE;
            }
        }
    }

    private static void printCurrentBoard() {
        for (int i = 0; i < 3; i++) {
            if (i > 0) {
                System.out.printf("- - - - -%n");
            }
            for (int j = 0; j < 3; j++) {
                System.out.print(GAME_BOARD[i][j]);
                if (j < 2) {
                    System.out.print(" | ");
                }
                if (j == 2) {
                    System.out.printf("%n");
                }
            }
        }
    }

    private static int getUserInput(String input, int inputCounter) {
        Scanner scan = new Scanner(System.in);

        System.out.printf("%nIt is %s's turn%n", input);
        System.out.printf("Please enter the row then the column, each from 0, 1, or 2, separated by space%n");
        String rowAndColumn = scan.nextLine();

        if (cellAlreadyOccupied(input, rowAndColumn)) {
            System.out.printf("The cell is already occupied, please select a different cell%n");
            return inputCounter;
        } else {
            printCurrentBoard();
            if (getWinner()) {
                System.out.printf("%nCongratulations! The winner is: %s%n", input);
                inputCounter = -1;
            }
            return ++inputCounter;
        }
    }

    private static boolean cellAlreadyOccupied(String input, String rowAndColumn) {
        String[] rowColumn = rowAndColumn.split(SPACE);
        int row = Integer.parseInt(rowColumn[0]);
        int column = Integer.parseInt(rowColumn[1]);
        if (SPACE.equals(GAME_BOARD[row][column])) {
            GAME_BOARD[row][column] = input;
            return false;
        }
        return true;
    }

    private static boolean getWinner() {
        boolean winner;
        winner = checkRow();
        if (!winner) {
            winner = checkColumn();
        }
        if (!winner) {
            winner = checkDiagonal();
        }
        return winner;
    }

    private static boolean checkRow() {
        for (int i = 0; i < 3; i++) {
            String a = GAME_BOARD[i][0];
            String b = GAME_BOARD[i][1];
            String c = GAME_BOARD[i][2];

            if (!SPACE.equals(a) && a.equals(b) && b.equals(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkColumn() {
        for (int j = 0; j < 3; j++) {
            String a = GAME_BOARD[0][j];
            String b = GAME_BOARD[1][j];
            String c = GAME_BOARD[2][j];

            if (!SPACE.equals(a) && a.equals(b) && b.equals(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkDiagonal() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String a = GAME_BOARD[0][0];
                String b = GAME_BOARD[1][1];
                String c = GAME_BOARD[2][2];
                String d = GAME_BOARD[0][2];
                String e = GAME_BOARD[2][0];

                if ((!SPACE.equals(a) && a.equals(b) && b.equals(c)) || (!SPACE.equals(d) && d.equals(b) && b.equals(e))) {
                    return true;
                }
            }
        }
        return false;
    }
}
