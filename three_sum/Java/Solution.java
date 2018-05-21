import java.util.ArrayList;
import java.util.List;

public class Solution {
	private List<Integer> temp;                 //存储每次的组合
	private int step = 3;                       //组合步长
	
	private void dealNSums(List<List<Integer>> res, List<Integer> item) {
		int sum = item.get(0);
		for (int i = 1; i < item.size(); i++)
			sum += item.get(i);
		
		if (sum == 0) {
			for (List<Integer> list: res) {
				List<Integer> temp = new ArrayList<>(list);
				for (Integer e: item) {
					if (temp.contains(e)) temp.remove(e); 
				}
				if (temp.size() == 0) return;
			}
			res.add(item);
		}
	}
	
	private void combin(int start, int step, int[] nums, List<List<Integer>> res) {
		if (step == 0) {
			List<Integer> item = new ArrayList<>(temp);
			dealNSums(res, item);
			return;
		}
		
		for (int i = start; i < nums.length; i++) {
			if (res.size() == 0) temp.add(this.step-step, nums[i]);                 //注意，第一组组合使用add，其后使用modified
				else temp.set(this.step-step, nums[i]);
			combin(i+1, step-1, nums, res);
		}
	}
	
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>(); 
		temp = new ArrayList<>(step);
		combin(0, step, nums, res);
		return res;
    }
	
	public static void main(String[] args) {
		int[] start = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> res = new Solution().threeSum(start);
		
		System.out.println(res);
	}
}