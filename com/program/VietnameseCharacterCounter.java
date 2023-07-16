package com.program;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VietnameseCharacterCounter {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chuỗi chữ cái Latin: ");
        String inputString = scanner.nextLine();
        int result = countVietnameseCharacters(inputString);
        System.out.println("Số lượng chữ cái Tiếng Việt có thể tạo thành: " + result);
        scanner.close();

	}
	public static int countVietnameseCharacters(String inputString) {
        Map<String, String> conversions = new HashMap<>();
        conversions.put("aw", "ă");
        conversions.put("aa", "â");
        conversions.put("dd", "đ");
        conversions.put("ee", "ê");
        conversions.put("oo", "ô");
        conversions.put("ow", "ơ");
        conversions.put("uw", "ư");

        int count = 0;
        int length = inputString.length();

        for (int i = 0; i < length; i++) {
            if (i + 1 < length) {
                String twoChars = inputString.substring(i, i + 2);
                if (conversions.containsKey(twoChars)) {
                    count++;
                    i++;
                    continue;
                }
            }

            String oneChar = inputString.substring(i, i + 1);
            if (conversions.containsValue(oneChar)) {
                count++;
            }
        }

        return count;
    }

}
