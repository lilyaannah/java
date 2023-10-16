import java.util.*;
import java.math.BigInteger;

public class ModulVm2 {
            private BigInteger p, q, n, seed;


    public ModulVm2(BigInteger p, BigInteger q, BigInteger seed) {
                this.p = p;
                this.q = q;
                this.n = p.multiply(q);
                this.seed = seed.mod(n);
            }

            public int getNextBit() {
                BigInteger x = seed.modPow(BigInteger.valueOf(2), n);
                seed = x;
                return x.testBit(0) ? 1 : 0;
            }

            public String encrypt(String message) {
                StringBuilder sb = new StringBuilder();
                for (char c : message.toCharArray()) {
                    int ascii = (int) c;
                    String binary = Integer.toBinaryString(ascii);
                    int len = binary.length();
                    while (len < 8) {
                        binary = "0" + binary;
                        len++;
                    }
                    for (char b : binary.toCharArray()) {
                        int bit = getNextBit();
                        sb.append(bit ^ Character.getNumericValue(b));
                    }
                }
                return sb.toString();
            }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigInteger p = new BigInteger("11");
        BigInteger q = new BigInteger("19");
        BigInteger seed = new BigInteger("3");
        ModulVm2 bbs = new ModulVm2(p, q, seed);
        System.out.print("Введите текст для шифрования: ");
        String message = in.nextLine();
        String encrypted = bbs.encrypt(message);
        System.out.println("Encrypted message: " + encrypted);
        System.out.println(encrypted.length());
    }
    }

