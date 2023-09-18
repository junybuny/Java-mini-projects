package com.kh.view;

import java.util.Scanner;
import com.kh.controller.BookController;

public class BookMenu {
	
	private Scanner sc = new Scanner(System.in);
	private BookController bc = new BookController();
	
	public void mainMenu() {
		
		while(true) {
			
			System.out.println("============================");
			System.out.println("1. 대여 현황");
			System.out.println("2. 도서 등록");
			System.out.println("3. 도서 대여");
			System.out.println("4. 도서 반납");
			System.out.println("5. 도서 삭제");
			System.out.println("6. 회원 등록");
			System.out.println("7. 회원 삭제");
			System.out.println("0. 프로그램 종료");
			System.out.println("============================");
			
			System.out.print(">> 메뉴 선택 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1: 
				// 회원 아이디 입력 후
				// 회원 아이디 RENT_BOOK 테이블 가져오기
				// OR
				// 누가 빌렸는지 알려주는 조회
				break;
			case 2:
				inputBook();
				break;
			case 3:
				// 여기서도 대여 가능 불가능 도서를 보여줘야함
				break;
			case 4: 
				break;
			case 5:
				bc.deleteBook(inputbookCode());
				break;
			case 6: 
				inputMember();
				break;
			case 7: 
				bc.deleteMember(inputmem_id());
				break;
			case 0:
				System.out.println("이용해주셔서 감사합니다. 프로그램을 종료합니다.");
				return;
			default:
				System.out.println("메뉴를 잘못 입력하셨습니다. 다시 입력해주세요.");
			}		
		}
	}

	public String inputmem_id() {
		System.out.print("\n회원 아이디 입력 : ");
		return sc.nextLine();
	}

	public String inputbookCode() {
		System.out.print("\n도서 코드 입력 : ");
		return sc.nextLine();
	}

	public void inputBook() {
		// 도서 등록
		System.out.print("\n=== 도서 등록 ===");

		System.out.print("\n도서코드 : ");
		String code = sc.nextLine();
		
		System.out.print("도서명 : ");
		String title = sc.nextLine();
		
		System.out.print("저자 : ");
		String author = sc.nextLine();

		System.out.print("출판사 : ");
		String publisher = sc.nextLine().toUpperCase();	
		
		System.out.print("장르 : ");
		String genre = sc.nextLine();
		
		bc.insertBook(code, title, author, publisher, genre);
	
	}
	
	public void inputMember() {
		// 회원 등록
		System.out.print("\n=== 회원 등록 ===");

		System.out.print("\n회원 아이디 : ");
		String mem_id = sc.nextLine();
		
		System.out.print("회원 이름 : ");
		String mem_name = sc.nextLine();
		
		System.out.print("회원 나이 : ");
		String mem_age = sc.nextLine();

		System.out.print("회원 전화번호 : ");
		String mem_phone = sc.nextLine().toUpperCase();	
		
		System.out.print("회원 주소 : ");
		String mem_address = sc.nextLine();
		
		bc.insertMember(mem_id, mem_name, mem_age, mem_phone, mem_address);
	}
	
	
	//-------------------- 응답화면 --------------------
	public void displaySuccess(String message) {
		System.out.println(message);
	}

	public void displayFail(String message) {
		System.out.println("\n서비스 요청 실패 : " + message);
	}
	
	public void displayNoData(String message) {
		System.out.println("\n" + message);
	}
	
//	public void displayMemberList(ArrayList<Book> list) {
//		System.out.println("\n조회된 데이터는 다음과 같습니다");
//			
//		for (Book b : list) {
//			System.out.println(b);
//		}
//	}
//
//	public void displayMember(Book b) {
//		System.out.println("\n조회된 데이터는 다음과 같습니다.");
//		System.out.println(b);
//	}
	
} // BookMenu
