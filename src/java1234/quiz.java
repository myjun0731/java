package java1234;

public class quiz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Q.1-------");
		String[] bus = { "상암08", "1234" };
		int[] time = { 3, 5 };
		double[] distance = { 0.8, 1.5 };

		for (int i = 0; i < bus.length; i++) {
			System.out.println(bus[i] + "번 버스\n약 " + time[i] + "분 후 도착\n남은 거리 " + distance[i] + "km\n");
		}
		System.out.println("Q.2-------");

		int k = 120;
		String result = (k >= 120) ? "탑승 가능합니다" : "탑승 불가합니다";
		System.out.println("키가 " + k + "cm이상 이므로 " + result);
		System.out.println("Q.3-------");

		String id = "901231-1234567";
		System.out.println(id.substring(0, id.indexOf("-") + 2));
		System.out.println("Q.4-------");

		int hour = 5;
		boolean car = false;
		boolean person = false;

		int fee = hour * 4000;

		if (fee > 30000) {
			fee = 30000;
		}

		if (car || person) {
			fee /= 2;
		}

		System.out.println("주차 요금은 " + fee + "원 입니다");
		System.out.println("Q.5-------");

		int[] size = new int[10];
		for (int i = 0; i < size.length; i++) {
			size[i] = 250 + (5 * i);
		}

		for (int i : size) {
			System.out.println("사이즈 " + i + " (재고있음)");
		}
	}
}