import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class day1 {
    /*
    1721
    979
    366
    299
    675
    1456
    */
    public static void main(String[] args) {
        List<Integer> lst = new ArrayList<>();
        try {
			Scanner scanner = new Scanner(new File("inputs/day1.txt"));
			while (scanner.hasNextLine()) {
                lst.add(Integer.parseInt(scanner.nextLine()));
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
        }
        System.out.println(DayOneP1(lst));
        System.out.println(DayOneP2(lst));
    }

    public static int DayOneP2(List<Integer> nums) {
        int ans = 0;
        for (int i = 0; i < nums.size() - 2; i++) {
            HashSet<Integer> map = new HashSet<>();
            int curr = 2020 - nums.get(i);
            for (int j = i + 1; j < nums.size(); j++) {
                if (map.contains(curr - nums.get(j))) {
                    ans = nums.get(i) * nums.get(j) * (curr - nums.get(j));
                }
                map.add(nums.get(j));
            }
        }
        return ans;
    }

    public static int DayOneP1(List<Integer> nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(int i = 0; i < nums.size(); i++) {
            int delta = 2020 - nums.get(i);
            if(map.containsKey(delta)) {
                ans = map.getOrDefault(i, delta) * nums.get(i);
            } else {
                map.put(nums.get(i), i);
            }
        }
        return ans;
    }

    // brute force algorithms
    public static int DayOnePartOne(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == 2020) {
                    res = nums[i] * nums[j];
                }
            }
        }
        return res;
    }

    public static int DayOnePartTwo(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 2020) {
                        res = nums[i] * nums[j] * nums[k];
                    }
                }
            }
        }
        return res;
    }
}
