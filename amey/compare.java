import java.util.ArrayList;

class MyInteger {

    public int bitlen(int a) {
        ArrayList<Integer> binaryDigits = new ArrayList<>();

        while (a > 0) {
            int remainder = a % 2;
            binaryDigits.add(remainder);
            a /= 2;
        }

        return binaryDigits.size() - 1;
    }

    public int bitCount(int a) {
        ArrayList<Integer> binaryDigits = new ArrayList<>();

        while (a > 0) {
            int remainder = a % 2;
            binaryDigits.add(remainder);
            a /= 2;
        }

        return binaryDigits.size();
    }

    public  int[] intToTwosComplement32BitArray(int n) {
        int[] binaryArray = new int[32];

        for (int i = 31; i >= 0; i--) {
            binaryArray[i] = n & 1; // Extract the least significant bit
            n >>= 1; // Shift right by 1 bit
        }

        return binaryArray;
    }

    public  int twosComplement32BitArrayToInt(int[] binaryArray) {
        // Check array length
        if (binaryArray.length != 32) {
            throw new IllegalArgumentException("Array length must be 32 bits.");
        }

        int result = 0;

        for (int i = 0; i < 32; i++) {
            result = (result << 1) | binaryArray[i];
        }

        // If the most significant bit is 1, convert to negative
        if ((binaryArray[0] & 1) == 1) {
            result -= (1 << 32);
        }

        return result;
    }

    public int compare(int a, int b) {
        if (a < b) {
            return -1;
        } else if (a > b) {
            return 1;
        } else {
            return 0;
        }

    }

    public  int compareUnsigned(int a, int b) {
        if (a + b == 0) {
            return 0;
        } else if (a < 0 && a - b < 0) {
            return 1;
        } else if (b < 0 && a - b < 0) {
            return -1;
        } else {
            if (a < b) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    // public static long toUnsignedLong(int a) {

    // }

    // public static int divideUnsigned(int a, int b) {

    // }

    public  int highestOneBit(int a) {
        if ((a & (a - 1)) == 0) {
            return a;
        } else {
            return (int) Math.pow(2, bitlen(a));// 2**bitlen(a);
        }

    }

    public int lowestOneBit(int a) {
        if ((a & (a - 1)) == 0) {
            return a;
        } else {
            return (int) Math.pow(2, 1 / bitlen(a));
        }

    }

    public  int numberOfLeadingZeros(int a) {
        if (a < 0) {
            return 0;
        } else {
            int[] binaryDigits = new int[32];
            int index = 31;
            while (a > 0 && index >= 0) {
                binaryDigits[index] = a % 2;
                a /= 2;
                index--;
            }
            int count = 0;
            for (int i = 0; i <= index; i++) {
                count++;
            }

            return count;
        }
    }

    public  int numberOfTrailingZeros(int a) {
        if (a == 0) {
            return 32; // If the number is zero, all bits are zeros
        }

        int count = 0;
        while ((a & 1) == 0) {
            count++;
            a >>= 1;
        }

        return count;
    }

    public  int rotateLeft(int a, int b) {
        return a << b;
        // remaining to handle negative numbers

    }

    public  int rotateRight(int a, int b) {
        int[] input = intToTwosComplement32BitArray(a);
        int msb = input[0];  // Preserve the MSB

        // Perform right rotation with zero filling, preserving MSB
        int[] output = new int[32];
        output[0] = msb;

        for (int i = 1; i < 32; i++) {
            if (i + b < 32) {
                output[i + b] = input[i];
            }
        }

        return twosComplement32BitArrayToInt(output);
    }

    // public static int signum(int);
    public  int reverse(int a) {
        int[] input = intToTwosComplement32BitArray(a);
        int[] output = new int[32];

        // Reverse the bits
        for (int i = 0; i < 32; i++) {
            output[i] = input[31 - i];
        }

        return twosComplement32BitArrayToInt(output);
    }

    public int sum(int a, int b) {
        return a + b;
    }

    public  int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    public  int min(int a, int b) {
        if (a > b) {
            return b;
        } else {
            return a;
        }
    }

    public static void main(String[] args) {
        // System.out.println(reverseBytes(10));
        // // System.out.println(numberOfLeadingZeros(15));
        // // System.out.println(numberOfLeadingZeros(Integer.MAX_VALUE));
        // System.out.println(sum(10,20));
        // // System.out.println(Integer.MIN_VALUE);
        // System.out.println(sum(Integer.MAX_VALUE,Integer.MIN_VALUE));
        // System.out.println(reverseBytes(Integer.MIN_VALUE));
        //System.out.println(reverseBytes(10));

    }

}

// public static int numberOfLeadingZeros(int a) {
// if (a == 0) {
// return 32; // If the number is zero, all bits are zeros
// }

// int count = 0;
// // Shift left until the most significant bit is 1
// while ((a & 0x80000000) == 0) {
// count++;
// a <<= 1;
// }

// return count;
// }