public class permutation2 {
   static int N = 4;
   static int[] Nums = {1, 2, 3, 4};
   static boolean[] isSelected = new boolean[N];

   static void solve(int cnt, int val, int idx) {
      if (cnt == 2) {
         System.out.println(val);
         return;
      }

      int ret = 0;
      for (int i = 0; i < N; ++i) {
         if (isSelected[i]) continue;
         isSelected[i] = true;
         solve(cnt + 1, val * 10 + Nums[i], idx++);
         isSelected[i] = false;
      }
   }

   public static void main(String[] args) {
      solve(0 ,0 , 0);
   }
}
