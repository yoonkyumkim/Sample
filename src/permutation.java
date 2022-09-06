public class permutation {
    static int N = 4;
    static int[] Nums = {1, 2, 3, 4};

    static int solve(int cnt, int used, int val) {
        if (cnt == 2) return val;

        int ret = 0;
        for (int i = 0; i < N; i++) {
            if ((used & 1 << i) != 0) continue;
            ret = Math.max(ret, solve(cnt + 1, used | 1 << i, val * 10 + Nums[i]));
        }
        return ret;
    }

    static int combination(int pos, int cnt, int val) {
        if (cnt == 2) return val;
        if (pos == N) return -1;

        int ret = 0;
        ret = Math.max(ret, combination(pos + 1, cnt + 1, val + Nums[pos]));
        ret = Math.max(ret, combination(pos + 1, cnt, val));

        return ret;
    }

    public static void main(String[] args) {
        //System.out.println(solve(0 , 0, 0));
        System.out.println(combination(0, 0, 0));
    }
}
