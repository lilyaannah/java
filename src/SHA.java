import java.util.Scanner;

public class SHA {
    public static int messLength = 0;

    public static void main(String[] args) {
        System.out.print("Enter Text to be encypted:");
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();

        String binary = convertToBinary(word);
        messLength = binary.length();
        calculateMod(word, binary);
    }

    public static String convertToBinary(String word) {
        byte[] bytes = word.getBytes();
        StringBuilder binary = new StringBuilder();
        for (byte b : bytes) {
            int value = b;
            for (int i = 0; i < 8; i++) {
                binary.append((value & 128) == 0 ? 0 : 1);
                value <<= 1;
            }
            binary.append(' ');
            System.out.println(binary);
        }
        return binary.toString();
    }

    public static String createMessageLength(String message, String paddedOne, int zeros, String endLength) {
        StringBuilder messageBinary = new StringBuilder(message);
        messageBinary.insert(messageBinary.toString().length(), paddedOne);

        while (zeros > 0) {
            messageBinary.insert(messageBinary.toString().length(), 0);
            zeros--;
        }

        messageBinary.insert(messageBinary.toString().length(), endLength);
        String m = printMessage(messageBinary.toString());
        m = m.replaceAll("\\s+", "");
        int[] mArray = new int[m.toString().length()/32];

        for (int i = 0; i < m.toString().length(); i+=32) {
            mArray[i/32] = Integer.valueOf(m.substring(i+1, i+32),2);
            if(m.charAt(i) == '1'){
                mArray[i/32] |= 0X80000000;
            }
            System.out.printf("10, 2: %d %s \n", i, m.substring(i, i+32),mArray[i/32]);
        }
        hash(mArray);
        return messageBinary.toString();
    }
    public static void calculateMod(String word, String binary) {
        int binaryMessageLength = word.length() * 8 - 8;
        String endBitLength = calculateMessageLength(binaryMessageLength+8);
        int temp = (binaryMessageLength) % 512;

        if (432 - temp < 0) {
            int x = 512 - temp;
            temp = x + 440 + temp + 64;
        } else {
            temp = 432 - temp;
        }

        int binaryZeros = temp;
        String onePadded = "10000000";
        binary = binary.replaceAll("\\s+", "");
        createMessageLength(binary, onePadded, binaryZeros, endBitLength);
    }

    public static String calculateMessageLength(int bitLength) {
        String tempBitsLength = Integer.toBinaryString(bitLength);
        StringBuilder sb = new StringBuilder(tempBitsLength);
        int temp = 64 - tempBitsLength.length();

        while (temp > 0) {
            sb.insert(0, 0);
            temp--;
        }
        return sb.toString();
    }

    public static String printMessage(String message) {
        StringBuilder sb = new StringBuilder(message);
        int num = message.length();
        while (num > 0) {
            if (num % 32 == 0) {
                sb.insert(num, " ");
            }
            num--;
        }
        return sb.toString();
    }

    private static int a = 0x67452301;
    private static int b = 0xEFCDAB89;
    private static int c = 0x98BADCFE;
    private static int d = 0x10325476;
    private static int e = 0xC3D2E1F0;
    private static int k = 0x8F1BBCDC;

    private static String hash(int[] z) {
        int integer_count = z.length;
        System.out.println(integer_count+" count");
        int[] W = new int[80];
        int t = 0;

        for(int i = 0; i < integer_count; i += 16) {
            for(t = 0; t < 16; t++)
                W[t] = z[t+i];
            for ( t = 16; t <= 79; t++ ) {
                W[t] = leftrotate((W[t - 3] ^
                        W[t - 8] ^ W[t - 14] ^ W[t - 16]), 1);
            }

            int A = a;
            int B = b;
            int C = c;
            int D = d;
            int E = e;
            int kt = 0;

            for (int c = 40; c <= 59; c++ ) {
                kt = ((B&C)|(B&D)|(C&D))+E+
                        leftrotate(A,5)+
                        W[c]+k;

                E=D; D=C; C=leftrotate(B,30); B=A; A=kt;
            }
            a+=A; b+=B; c+=C; d+=D; e+=E;
        }

        String aLength =Integer.toHexString(a);
        String bLength = Integer.toHexString(b);
        String cLength = Integer.toHexString(c);
        String dLength = Integer.toHexString(d);
        String eLength = Integer.toHexString(e);

        if(aLength.length() < 8) {
            StringBuilder aL = new StringBuilder(aLength);
            aL.insert(0,0);
            aLength = aL.toString();
        } else if(bLength.length() < 8) {
            StringBuilder bL = new StringBuilder(bLength);
            bL.insert(0,0);
            bLength = bL.toString();
        } else if(cLength.length() < 8) {
            StringBuilder cL = new StringBuilder(cLength);
            cL.insert(0,0);
            cLength = cL.toString();
        } else if(dLength.length() < 8) {
            StringBuilder dL = new StringBuilder(dLength);
            dL.insert(0,0);
            dLength = dL.toString();
        } else if(eLength.length() < 8) {
            StringBuilder eL = new StringBuilder(eLength);
            eL.insert(0,0);
            eLength = eL.toString();
        }

        String hh = aLength + bLength + cLength + dLength + eLength;
        System.out.println("Result: " + hh);
        System.out.println("length "+hh.length());

        return null;
    }
    private static int leftrotate(int x, int shift) {
        return ((x << shift) | (x >>> (32 - shift)));
    }
}