package calendar;

import java.text.ParseException;
import java.util.Scanner;

public class Prompt {
	/**
	 * 
	 * @param week
	 *            요일명
	 * @return 0~6 (0 = Sunday, 6 = Saturday)
	 */
	public int parseDay(String week) {

		switch (week) {
		case "su":
			return 0;
		case "mo":
			return 1;
		case "tu":
			return 2;
		case "we":
			return 3;
		case "th":
			return 4;
		case "fr":
			return 5;
		case "sa":
			return 6;
		default:
			return 0;
		}
	}

	public void printMenu() {
		System.out.println("+----------------------+");
		System.out.println("| 1. 일정 등록");
		System.out.println("| 2. 일정 검색");
		System.out.println("| 3. 달력 보기");
		System.out.println("| h. 도움말 q. 종료");
		System.out.println("+----------------------+");
		// System.out.println("명령 (1, 2, 3, h, q)");
	}

	public void runPrompt() throws ParseException {

		printMenu();
		Scanner scanner = new Scanner(System.in);
		calendar cal = new calendar();
		boolean isLoop = true;
		while (isLoop) {
			System.out.println("명령 (1, 2, 3, h, q)");
			String cmd = scanner.next();
			switch (cmd) {
			case "1":
				cmdRegister(scanner, cal);
				break;
			case "2":
				cmdSearch(scanner, cal);
				break;
			case "3":
				cmdCal(scanner, cal);
				break;
			case "h":
				printMenu();
				break;
			case "q":
				isLoop = false;
				break;
			}
		}

		System.out.println("Thank you. Bye!!");
		scanner.close();
	}

	private void cmdCal(Scanner s, calendar c) {
		// TODO Auto-generated method stub
		int month = 1;
		int year = 2017;
		System.out.println("년도를 입력하세요[exit: -1]");
		System.out.print("YEAR> ");
		year = s.nextInt();

		System.out.println("달을 입력하세요.");
		System.out.print("MONTH> ");
		month = s.nextInt();

		if (month > 12 || month < 1) {
			System.out.println("잘못된 입력입니다.");
			return;
		}
		c.printCalendar(year, month);

	}

	private void cmdSearch(Scanner s, calendar c) {
		System.out.println("[일정 검색]");
		System.out.println("날짜를 입력해 주세요. (yyyy-MM-dd).");
		String date = s.next();
		PlanItem plan;
		plan = c.searchPlan(date);
		if(plan != null){
			System.out.println(plan.detail);
		} else{
			System.out.println("일정이 없습니다.");
		}
	}

	private void cmdRegister(Scanner s, calendar c) throws ParseException {
		System.out.println("[새 일정 등록]");
		System.out.println("날짜를 입력해 주세요. (yyyy-MM-dd).");
		String date = s.next();
		String text = "";
		System.out.println("일정을 입력해 주세요.(문장의 끝에;을 입력해주세요.)");
//		s.nextLine();
//		text = s.nextLine();
		String word;
		while(!(word = s.next()).endsWith(";")){
			text += word;
		}
		text += word.replace(";","");
		// while (true){
		// String word = s.next();
		// text += word + " ";
		// if(word.endsWith(";")){
		// break;
		// }
		// }
		c.registerPlan(date, text);

	}

	public static void main(String[] args) throws ParseException {

		// 쉘 실행
		Prompt p = new Prompt();
		p.runPrompt();

	}
}
