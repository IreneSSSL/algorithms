package easy.math;

public class CountPrime204 {
    public static void main(String[] args) {
        char s = 'A';
        System.out.println(Character.toLowerCase(s));
//        double a = 5.60;
//        System.out.println(new CountPrime204().countPrimes(10000));
    }

    //    this is what I thought originally, but this method beat only 38% competitors;
    public int countPrimes2(int n) {
        if (n <= 2) {
            return 0;
        }
        int[] array = new int[n];

        int upper = (int) Math.sqrt(Double.valueOf(String.valueOf(n)));

        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
        array[1] = 0;

        for (int i = 2; i <= upper; i++) {
            if (array[i] == 0) {
                continue;
            }
            int j = 2;
            while (j * i < n) {
                if (array[j * i] != 0) {
                    array[j * i] = 0;
                }
                j++;
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (array[i] != 0) {
                count++;
            }
        }

        return count;
    }


    //    this one is slightly better, reaching 16ms, beating 45%.
//
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        boolean[] array = new boolean[n];

        int upper = (int) Math.sqrt(Double.valueOf(String.valueOf(n)));

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (array[i]) {
                continue;
            }
            count++;
            int j = 2;
            while (i <= upper && j * i < n) {
                if (!array[j * i]) {
                    array[j * i] = true;
                }
                j++;
            }
        }
        return count;
    }



//    this one comes from discussion board, which is the best one, using 6ms and beating 99.9%.
//    the idea is the same, but it highlights that we only need to remove the product of odd and odd is OK, since all even is non-prime(except for 2)
//    besides, for a odd, we dont need to multiple it with all odds that smaller than it. because this has been done when the calculating odd is the smaller odd.
//    what a clever man!
    public int countPrimes3(int n) {
        if (n < 3)
            return 0;

        boolean[] f = new boolean[n];
        //Arrays.fill(f, true); boolean[] are initialed as false by default
        int count = n / 2;
        for (int i = 3; i * i < n; i += 2) {
            if (f[i])
                continue;

            for (int j = i * i; j < n; j += 2 * i) {
                if (!f[j]) {
                    --count;
                    f[j] = true;
                }
            }
        }
        return count;
    }

}
