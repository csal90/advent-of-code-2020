import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
    1-3 a: abcde
    1-3 b: cdefg
    2-9 c: ccccccccc
*/

public class day2 {
    public static void main(String[] args) {
        int ans = 0;
        try {
			Scanner scanner = new Scanner(new File("inputs/day2.txt"));
			while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                Pattern p = Pattern.compile("([0-9]+)-([0-9]+) ([a-z]): ([a-z]+)");
                Matcher m = p.matcher(str);
                String lower = "", upper = "", letter = "", password = "";
                while (m.find()) {
                    lower = m.group(1);
                    upper = m.group(2);
                    letter = m.group(3);
                    password = m.group(4);
                }
                ans += isValid(Integer.parseInt(lower), Integer.parseInt(upper), letter, password);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
        }
        System.out.println(ans);
    }

    public static int isValid(int lower, int upper, String letter, String password) {
        int count = 0;
        int totalValid = 0;
        char c = letter.charAt(0);
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) == c) {
                count += 1;
            }
        }
        if (count >= lower && count <= upper) {
            totalValid++;
        }
        return totalValid;
    }

    public static int isValidPartTwo(int lower, int upper, String letter, String password) {
        char c = letter.charAt(0);
        int count = 0;
        Boolean lowerFlag = false, upperFlag = false;
        for (int i = 0; i < password.length(); i++) {
            if (i + 1 == lower) {
                if (password.charAt(i) == c) {
                    lowerFlag = true;
                }
            } else if (i + 1 == upper) {
                if (password.charAt(i) == c) {
                    upperFlag = true;
                }
            }
        }
        if (lowerFlag || upperFlag) {
            count += 1;
        } else if (lowerFlag && upperFlag) {
            count -= 1;
        }
        return count;
    }

}