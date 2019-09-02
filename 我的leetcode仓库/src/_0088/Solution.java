package _0088;

public class Solution {
    static void merge(int A[], int m, int B[], int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        //×¢Òâ kÓÀÔ¶´óÓÚi+j
        while (i >= 0 && j >= 0) {
            if (A[i] > B[j])
                A[k--] = A[i--];
            else
                A[k--] = B[j--];
        }
        while (j >= 0)
            A[k--] = B[j--];
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 7, 0, 0, 0};
        int[] B = {2, 5, 6};
        merge(A, 3, B, 3);
        for (int i = 0; i < 6; i++) {
            System.out.print(A[i]);
        }
    }
}
