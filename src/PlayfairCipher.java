//import java.util.*;
//    public class PlayfairCipher {
//
//        private char[][] matrix;
//        private String key;
//
//        // PlayfairCipher constructor
//        public PlayfairCipher(String key) {
//            this.key = key.toUpperCase();
//            this.matrix = createMatrix();
//        }
//
//        // Method for creating a 5x5 matrix based on the key
//        private char[][] createMatrix() {
//            // Remove repeated characters from the key
//            String filteredKey = this.key.chars()
//                    .distinct()
//                    .filter(c -> Character.isLetter(c))
//                    .mapToObj(c -> String.valueOf((char) c))
//                    .collect(Collectors.joining());
//            // Fill the matrix with characters from the key
//            char[][] matrix = new char[5][5];
//            int row = 0, col = 0;
//            for (int i = 0; i < filteredKey.length(); i++) {
//                char c = filteredKey.charAt(i);
//                matrix[row][col] = c;
//                col++;
//                if (col == 5) {
//                    col = 0;
//                    row++;
//                }
//            }
//            // Fill the remaining part of the matrix with the remaining letters of the alphabet
//            String alphabet = "ABCDEFGHIKLMNOPQRSTUVWXYZ";
//            for (int i = 0; i < alphabet.length(); i++) {
//                char c = alphabet.charAt(i);
//                if (!filteredKey.contains(String.valueOf(c))) {
//                    matrix[row][col] = c;
//                    col++;
//                    if (col == 5) {
//                        col = 0;
//                        row++;
//                    }
//                }
//            }
//            return matrix;
//        }
//
//        // Method for encrypting a message
//        public String encrypt(String plaintext) {
//            // Remove all punctuation and spaces from the message
//            plaintext = plaintext.toUpperCase().replaceAll("[^A-Z]", "");
//            // Split the message into pairs of letters
//            List<String> pairs = new ArrayList<>();
//            for (int i = 0; i < plaintext.length(); i += 2) {
//                if (i == plaintext.length() - 1) {
//                    pairs.add(plaintext.substring(i) + "X");
//                } else if (plaintext.charAt(i) == plaintext.charAt(i + 1)) {
//                    pairs.add(plaintext.substring(i, i + 1) + "X");
//                    i--;
//                } else {
//                    pairs.add(plaintext.substring(i, i + 2));
//                }
//            }
//            // Encrypt each pair of letters
//            StringBuilder ciphertext = new StringBuilder();
//            for (String pair : pairs) {
//                char c1 = pair.charAt(0);
//                char c2 = pair.charAt(1);
//                int r1 = -1, c1Index = -1, r2 = -1, c2Index = -1;
//                // Find the row and column indices of the two letters in the matrix
//                for (int i = 0; i < 5; i++) {
//                    for (int j = 0; j < 5; j++) {
//                        if (matrix[i][j] == c1) {
//                            r1 = i;
//                            c1Index = j;
//                        } else if (matrix[i][j] == c2) {
//                            r2 = i;
//                            c2Index = j;
//                        }
//                    }
//                }
//                // If the letters are in the same row, shift them to the right
//                if (r1 == r2) {
//                    c1Index = (c1Index + 1) % 5;
//                    c2Index = (c2Index + 1) % 5;
//                }
//                // If the letters are in the same
//            }
//
//        return ;
//    }}