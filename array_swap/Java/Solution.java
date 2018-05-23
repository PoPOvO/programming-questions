/**
 * <b>题目描述</b>：
 * 	给定两个数组m, n, 求出由m数组变化为n数组过程中，m数组中元素交换的下标的变换过程。<br><br>
 * 	例如: m : [1, 2, 3, 4, 5, 6], n : [1, 3, 4, 2, 5, 6] <br>
 * 	则结果为: [(1,3), (2,1)]
 * 
 * @author xl
 *
 */
public class Solution {
	public List<String> numSwap(int[] original, int[] target) {
		List<String> ls = new ArrayList<String>();
		
		for (int i = 0; i < original.length; i++) {
			if (original[i] == target[i]) continue;
	
			for (int j = 0; j < target.length; j++) {
				if (original[i] != target[j]) continue;
				ls.add("(" + i + "," + j + ")");
				original[i] = original[i] ^ original[j];
				original[j] = original[i] ^ original[j];
				original[i] = original[i] ^ original[j];
				break;
			}
		}
		return ls;
	}
	
	public static void main(String[] args) {
		System.err.println(new Solution().numSwap(new int[] {1, 2, 3, 4, 5, 6},  new int[] {1, 3, 4, 2, 5, 6}));
	}
}