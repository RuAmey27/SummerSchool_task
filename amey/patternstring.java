class patternstring {
    public static void printbase(int level) {

        
        System.out.print("*$");
        System.out.print("+");
        for (int i = 0; i < level; i++) {
            System.out.print(" ");
        }
        System.out.print("+");
        System.out.print("$*");
        
    }

    public static void printpa(int level) {
        int q = 2 * level + 1;
        for (int i = q; i >0; i--) {
            if (i == level) {
                for (int j = 0; j < level; j++) {
                    System.out.print(" ");
                }
                printbase(level);
                for (int j = 0; j < level; j++) {
                    System.out.print(" ");
                }
            } else {
                // for (int j = 0; j < level; j++) {
                //     System.out.print(" ");
                // }
                printnonbase(level, i);
                // for (int j = 0; j < level; j++) {
                //     System.out.print(" ");
                // }
            }
            System.out.println(" ");
        }
    }

    public static void printnonbase(int level, int lineno) {
        // if (lineno % level == 0) {
        //     int q = level * 2 + 2;
        //     for (int i = 0; i < lineno % level; i++) {
        //         System.out.print(" ");
        //     }
        //     for (int i = 0; i <= q; i++) {
        //         System.out.print("*");
        //     }
        //     System.out.print("+");
        //     for (int i = 0; i <= q; i++) {
        //         System.out.print("*");
        //     }
        //     for (int i = 0; i < lineno % level; i++) {
        //         System.out.print(" ");
        //     }
        // } else {

            int q=(lineno % level)*2;
            int r=q+2;
            for (int i = 0; i < lineno % level; i++) {
                System.out.print(" ");
            }
            for (int i = 0; i <=r; i++) {
                System.out.print("*");
            }
            System.out.print("+");
            for (int i = 0; i < level; i++) {
                System.out.print(" ");
            }
            System.out.print("+");
            for (int i = 0; i <= r; i++) {
                System.out.print("*");
            }
            for (int i = 0; i < lineno % level; i++) {
                System.out.print(" ");
            }

        //}

    }

    public static void main(String[] args) {
        printpa(2);
    }

}
