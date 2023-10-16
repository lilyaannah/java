import java.util.*;
public class GammaBBS {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = 11, q = 19, x = 3;
        int M = p * q;//число Блюма

        System.out.print("Text: ");
        String message = in.nextLine();
        StringBuilder encryptedMessage = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            int ascii = (int) message.charAt(i);
            int[] binary = new int[8];
            for (int j = 0; j < 8; j++) {
                x = (int) Math.pow(x, 2) % M;
//                System.out.print(x+" ");
                int bit = x & 1;
                binary[j] = bit;
            }
           // System.out.println(" ");
            int xor = binary[0] ^ binary[1] ^ binary[2] ^ binary[3] ^ binary[4] ^ binary[5] ^ binary[6] ^ binary[7];
           // System.out.println(xor);
            int encryptedAscii = ascii ^ xor;
            encryptedMessage.append( encryptedAscii+" ");
        }
        System.out.println("Encrypted message: " +encryptedMessage.toString());

    }
        }
