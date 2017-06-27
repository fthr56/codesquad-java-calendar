package calendar;

import java.util.Scanner;

public class sum {
	public static void main(String[] args){
		//입력: 키보드로 두 수를 입력 받는다.
		//출력: 화면에 두 수를 출력한다.
		int a,b;
		System.out.println("두 수를 입력해 주세요.");
		Scanner scanner = new Scanner(System.in);
		String s1, s2;
		s1 = scanner.next();
		s2 = scanner.next();
		a = Integer.parseInt(s1);
		b = Integer.parseInt(s2);
//		System.out.println(a + ", " + b);
		
//		int c = a+b;
//		System.out.println("두 수의 합은 " + (a + b) + "입니다.");
		System.out.printf("%d와 %d의 합은 %d입니다.", a,b,a+b);
		scanner.close();
	}
}
