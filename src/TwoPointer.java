
import java.util.HashMap;
import java.util.Map;

public class TwoPointer {
	public static void main(String[] args) {

	}

	// to find exactly one solution : O(n*2)
	public int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				int currentSum = nums[i] + nums[j];
				if (currentSum == target) {
					return new int[] { i, j };
				}
			}
		}
		return new int[] {};
	}

	// O(n)
	public int[] twoSumWithHashMap(int[] nums, int target) {
		HashMap<Integer, Integer> allNums = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (allNums.containsKey(complement)) {
				return new int[] { allNums.get(complement), i };
			}
			allNums.put(nums[i], i);
		}
		return new int[] {};
	}

	// in a sorted array with Two-pointer technique
	public int[] twoSumwithTwoPointers(int[] nums, int target) {
		int start = 0;
		int last = nums.length - 1;
		while (start < last) {
			int sum = nums[start] + nums[last];
			if (sum > target)
				last--;
			else if (sum < target)
				start++;
			else
				return new int[] { start + 1, last + 1 };
		}

		return new int[] {};
	}

	// remove duplicates from an sorted array
	public int removeDuplicates(int[] nums) {
		int j = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1]) {
				nums[j] = nums[i];
				j++;
			}
		}
		return j;
	}

	// palindrome
	public boolean isPalindrome(String s) {
		String inputStr = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		int strLength = inputStr.length();
		for(int i = 0; i < strLength; i++) {
			if(inputStr.charAt(i) != inputStr.charAt(strLength - 1 - i))
				return false;
		}
		return true;
	}
	
	public boolean isPalindrom(String s) {
		if (s.isEmpty()) {
        	return true;
        }
        int start = 0;
        int last = s.length() - 1;
        while(start <= last) {
        	char currFirst = s.charAt(start);
        	char currLast = s.charAt(last);
        	if (!Character.isLetterOrDigit(currFirst )) {
        		start++;
        	} else if(!Character.isLetterOrDigit(currLast)) {
        		last--;
        	} else {
        		if (Character.toLowerCase(currFirst) != Character.toLowerCase(currLast)) {
        			return false;
        		}
        		start++;
        		last--;
        	}
        }
        return true;
	}

	// trapping rain water
	public int trap(int[] height) {
		int result = 0;
		for (int i = 0; i < height.length - 1; i++) {
			int l = height[i];
			for (int j = 0; j < i; j++) {
				l = Math.max(l, height[j]);
			}
			int r = height[i];
			for (int j = i + 1; j < height.length; j++) {
				r = Math.max(r, height[j]);
			}
			result += Math.min(l, r) - height[i];
		}

		return result;
	}

	public int trapWithTwoPointer(int[] height) {
		int left = 0;
		int right = height.length - 1;
		int leftMax = 0;
		int rightMax = 0;
		int result = 0;
		while (left <= right) {
			if (height[left] <= height[right]) {
				if (height[left] >= leftMax)
					leftMax = height[left];
				else
					result += leftMax - height[left];
				left++;
			} else {
				if (height[right] >= rightMax)
					rightMax = height[right];
				else
					result += rightMax - height[right];
				right--;
			}
		}

		return result;
	}

	
	//longest sub-string without repeating character
	public void longestSubString(String s) {
		Map<Character, Integer> charMap = new HashMap<>();
		int left = 0;
		int maxLength = 0;
		int len = s.length();
		int leftIndex = 0;
		int rightIndex = 0;
		for(int right = 0; right < len; right++) {
			if(!charMap.containsKey(s.charAt(right)) || charMap.get(s.charAt(right)) < left){
				charMap.put(s.charAt(right), right);
				leftIndex = left;
				rightIndex = right;
				maxLength = Math.max(maxLength, right - left + 1);
			} else {
				left = charMap.get(s.charAt(right)) + 1;
				charMap.put(s.charAt(right), right);
			}
		}
		
		 s.substring(leftIndex,rightIndex);
	}
}
