package Arrays;

public class ValidSudoku {
    public static void main(String[] args) {

    }

//    1 run through th values and box values
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> valiues = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.') {
                    if (valiues.contains("row" + i + board[i][j]) || valiues.contains("col" + j + board[i][j]))
                        return false;

                    valiues.add("row" + i + board[i][j]);
                    valiues.add("col" + j + board[i][j]);

                    if (valiues.contains("box" + (i / 3) + (j / 3) + board[i][j]))
                        return false;
                    valiues.add("box" + (i / 3) + (j / 3) + board[i][j]);
                }
            }
        }
        return true;
    }

    //    correct - Above 30% of other people
    public boolean isValidSudoku1(char[][] board) {
        HashMap<Integer, HashMap<Character, Boolean>> boxPresence = new HashMap<>();

        for (int rowCounter = 0; rowCounter < board.length; rowCounter++) {
            int full = board[rowCounter].length;
            HashMap<Character, Boolean> rowPresence = new HashMap<>();
            for (int j = 0; j < full; j++) {
                if (board[rowCounter][j] != '.') {
                    if (rowPresence.containsKey(board[rowCounter][j]))
                        return false;
                    else
                        rowPresence.put(board[rowCounter][j], true);

                    int box = resolveBox(rowCounter, j);
                    System.out.println("box " + box + " val " + board[rowCounter][j]);

                    if (!boxPresence.containsKey(box))
                        boxPresence.put(box, new HashMap<>());

                    if (boxPresence.get(box).containsKey(board[rowCounter][j])) {
                        System.out.println("vlue repeated " + board[rowCounter][j]);
                        return false;
                    } else
                        boxPresence.get(box).put(board[rowCounter][j], true);
                }
            }

        }
        for (int columnCounter = 0; columnCounter < board.length; columnCounter++) {
            HashMap<Character, Boolean> columnPresence = new HashMap<>();
            int full = board[columnCounter].length;
            for (int j = 0; j < full; j++) {
                if (board[j][columnCounter] != '.') {
                    if (columnPresence.containsKey(board[j][columnCounter]))
                        return false;
                    else
                        columnPresence.put(board[j][columnCounter], true);
                }
            }
        }
        System.out.println(Arrays.asList(boxPresence));
        return true;
    }

    private int resolveBox(int rowCounter, int j) {
        int col, row = 1;
        if (rowCounter < 2)
            row = 1;
        else if (rowCounter < 5)
            row = 2;
        else
            row = 3;

        if (j < 2)
            col = 1;
        else if (j < 5)
            col = 2;
        else
            col = 3;

        return Integer.parseInt(String.valueOf(row).concat(String.valueOf(col)));

    }
}