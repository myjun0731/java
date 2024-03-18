package java1234;

import java.util.*;

public class afaf {

	public static void main(String[] args) {
		int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		int year = getUserInput("연도를 입력하세요: ");
		int month = getUserInput("월을 입력하세요: ");

		if (isValidMonth(month)) {
			if (isLeapYear(year) && month == 2) {
				System.out.println(year + "년 " + month + "월은 윤달이며, 29일까지 있습니다.");
			} else {
				System.out.println(year + "년 " + month + "월은 " + daysInMonth[month - 1] + "일까지 있습니다.");
			}
		} else {
			System.out.println("잘못된 월을 입력했습니다.");
		}
	}

	// 사용자 입력
	public static int getUserInput(String message) {
		Scanner scanner = new Scanner(System.in);
		System.out.print(message);
		return scanner.nextInt();
	}

	// 윤년 확인
	public static boolean isLeapYear(int year) {
		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}

	// 유효한 월인지 확인
	public static boolean isValidMonth(int month) {
		return month >= 1 && month <= 12;
	}
}