package java1234;

import java.util.Scanner;

public class SignUpSystem {
	private static String[] usernames = new String[100]; // 사용자명
	private static String[] passwords = new String[100]; // 비밀번호
	private static boolean[] isLoggedIn = new boolean[100]; // 로그인 여부 추적
	private static int userCount = 0; // 가입한 사용자 수를 추적하는 변수

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); 

		while (true) {
			System.out.println("사용 가능한 명령어: 가입, 로그인, 로그아웃, 목록, 종료");
			System.out.println("명령어를 입력하세요:");
			String command = scanner.nextLine();

			switch (command) {
			case "가입":
				signUp(scanner);
				break;
			case "로그인":
				login(scanner);
				break;
			case "로그아웃":
				if (isLoggedIn()) {
					logout();
				} else {
					System.out.println("로그인 상태가 아닙니다.");
				}
				break;
			case "목록":
				showLoggedInUsers();
				break;
			case "종료":
				System.out.println("프로그램을 종료합니다.");
				scanner.close();
				return;
			default:
				System.out.println("잘못된 명령어입니다. 다시 시도하세요.");
				break;
			}
		}
	}

	// 회원가입
	private static void signUp(Scanner scanner) {
		System.out.println("사용자명을 입력하세요:");
		String username = scanner.nextLine();

		System.out.println("비밀번호를 입력하세요:");
		String password = scanner.nextLine();

		// 중복된 사용자명인지 확인
		for (int i = 0; i < userCount; i++) {
			if (usernames[i].equals(username)) {
				System.out.println("이미 사용중인 사용자명입니다. 다른 사용자명을 선택하세요.");
				return;
			}
		}

		// 사용자명, 비밀번호를 배열에 저장한 후에 유저수 1증가
		usernames[userCount] = username;
		passwords[userCount] = password;
		userCount++;
		System.out.println("회원가입이 완료되었습니다.");
	}

	// 로그인
	private static void login(Scanner scanner) {
		System.out.println("사용자명을 입력하세요:");
		String username = scanner.nextLine();

		System.out.println("비밀번호를 입력하세요:");
		String password = scanner.nextLine();

		// 등록된 사용자인지 확인
		boolean usernameCorrect = false;
		for (int i = 0; i < userCount; i++) {
			if (usernames[i].equals(username)) {
				usernameCorrect = true;
				if (passwords[i].equals(password)) {
					isLoggedIn[i] = true; // 로그인 상태로 설정
					System.out.println("로그인 성공!");
					return;
				}
			}
		}

		if (usernameCorrect) {
			System.out.println("비밀번호가 틀렸습니다.");
		} else {
			System.out.println("사용자명이 틀렸거나 존재하지 않습니다.");
		}
	}

	// 로그아웃
	private static void logout() {
		for (int i = 0; i < userCount; i++) {
			isLoggedIn[i] = false; // 모든 사용자의 로그인 상태를 false로 변경(즉, 로그아웃으로 전환)
		}
		System.out.println("로그아웃 되었습니다.");
	}

	// 목록
	private static void showLoggedInUsers() {
		System.out.println("로그인된 사용자 목록:");
		boolean loggedIn = false;
		for (int i = 0; i < userCount; i++) {
			if (isLoggedIn[i]) {
				System.out.println(usernames[i]);
				loggedIn = true;
			}
		}
		if (!loggedIn) {
			System.out.println("로그인된 사용자가 없습니다.");
		}
	}

	// 로그인 상태 확인
	private static boolean isLoggedIn() {
		for (int i = 0; i < userCount; i++) {
			if (isLoggedIn[i]) {
				return true;
			}
		}
		return false;
	}
}