package calendar;

import java.util.Scanner;

public class Prompt {
	
	private final static String PROMPT = "cal> ";
	
	public void runPrompt(){
		
		Scanner scanner = new Scanner(System.in);
		calendar cal = new calendar();
		
		int month = 1;
		
		while(true) {
			System.out.println("달을 입력하세요.(종료: -1)");
			System.out.print(PROMPT);
			month = scanner.nextInt();
			if ( month == -1) {
				break;
			}
			if(month > 12 || month < 1){
				continue;
			}
			cal.printCalendar(2017,month);

		}
		System.out.println("Bye!!");
		scanner.close();
	}
	
	public static void main(String[] args) {

		//쉘 실행
		Prompt p = new Prompt();
		p.runPrompt();


	}
}
