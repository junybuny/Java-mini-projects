package com.kh.view;

import java.util.ArrayList;
import java.util.Scanner;
import com.kh.controller.BookController;
import com.kh.model.vo.Book;

public class BookMenu {
	
	private Scanner sc = new Scanner(System.in);
	private BookController bc = new BookController();
	
	public void loginMenu() {
		
		while(true) {
			System.out.println("============================");
			System.out.println("1. 로그인");
			System.out.println("2. 회원 등록");
			System.out.println("0. 종료");
			System.out.println("============================");
			System.out.print(">> 메뉴 선택 : ");
			
			int loginMenu = sc.nextInt();
			sc.nextLine();
			
			switch(loginMenu) {
			case 1: 
				bc.loginMember(inputmem_id(), inputmem_pwd());
				break;
			case 2:
				inputMember();
				break;
			case 0:
				System.out.println("이용해주셔서 감사합니다. 프로그램을 종료합니다.");
				return;
			default:
				System.out.println("메뉴를 잘못 입력하셨습니다. 다시 입력해주세요.");
				break;
			}
		}
	}
	
	public void mainMenu() {
		
				System.out.println("로그인 성공");
				while(true) {
				System.out.println("============================");
				System.out.println("3. 대여 현황");
				System.out.println("4. 도서 대여");
				System.out.println("5. 도서 반납");
				System.out.println("6. 도서 등록");
				System.out.println("7. 도서 삭제");
				System.out.println("8. 회원 정보 수정");
				System.out.println("9. 회원 탈퇴");
				System.out.println("0. 종료");
				System.out.println("============================");
				System.out.print(">> 메뉴 선택 : ");
				
				int mainMenu = sc.nextInt();
				sc.nextLine();
				
				switch(mainMenu) {
				case 3: 
					bc.rentY_bookList(); // 수정필요, 로그인 한 회원의 도서목록 가져오기..
					break;
				case 4:
					bc.bookList();
					bc.rent_bookList(rentBook());
					break;
				case 5:
					bc.bookList();
					bc.return_bookList(returnBook());
					break;
				case 6:
					inputBook();
					break;
				case 7: 
					bc.deleteBook(inputbookCode());
					break;
				case 8:
					updateMember();
					break;
				case 9:
					// 회원탈퇴 구현
					bc.deleteMember(inputmem_id()); // <- 이건회원삭제, 대여중인 책 있으면 탈퇴 불가
					break;
				case 0:
					System.out.println("이용해주셔서 감사합니다. 프로그램을 종료합니다.");
					return;
				default:
					System.out.println("메뉴를 잘못 입력하셨습니다. 다시 입력해주세요.");
					break;
				}
			}
		}


	public String returnBook() {
		System.out.print("\n반납할 도서 코드 입력 : ");
		return sc.nextLine();
	}

	public String rentBook() {
		System.out.print("\n대여할 도서 코드 입력 : ");
		return sc.nextLine();
	}

	public String inputmem_id() {
		System.out.print("\n회원 아이디 입력 : ");
		return sc.nextLine();
	}
	
	public String inputmem_pwd() {
		System.out.print("\n회원 비밀번호 입력 : ");
		return sc.nextLine();
	}

	public String inputbookCode() {
		System.out.print("\n도서 코드 입력 : ");
		return sc.nextLine();
	}
	
	public void updateMember() {
		System.out.print("\n======== 회원 정보 수정 ========");
		
		String mem_id = inputmem_id();
		
		System.out.print("변경할 비밀번호 : ");
		String mem_pwd = sc.nextLine();
		
		System.out.print("변경할 이메일 : ");
		String mem_email = sc.nextLine();
		
		System.out.print("변경할 전화번호 : ");
		String mem_phone = sc.nextLine();
		
		System.out.print("변경할 주소 : ");
		String mem_address = sc.nextLine();
		
		bc.updateMember(mem_id, mem_pwd, mem_email, mem_phone, mem_address);
	}

	public void inputBook() {
		// 도서 등록
		System.out.print("\n========== 도서 등록 ==========");

		System.out.print("\n도서코드 : ");
		String code = sc.nextLine();
		
		System.out.print("도서명 : ");
		String title = sc.nextLine();
		
		System.out.print("저자 : ");
		String author = sc.nextLine();

		System.out.print("출판사 : ");
		String publisher = sc.nextLine().toUpperCase();	
		
		bc.insertBook(code, title, author, publisher);
	
	}
	
	public void inputMember() {
		// 회원 등록
		System.out.print("\n========== 회원 등록 ==========");

		System.out.print("\n회원 아이디 : ");
		String mem_id = sc.nextLine();
		
		System.out.print("회원 비밀번호 : ");
		String mem_pwd = sc.nextLine();
		
		System.out.print("회원 이름 : ");
		String mem_name = sc.nextLine();
		
		System.out.print("회원 나이 : ");
		String mem_age = sc.nextLine();

		System.out.print("회원 전화번호 : ");
		String mem_phone = sc.nextLine().toUpperCase();	
		
		System.out.print("회원 주소 : ");
		String mem_address = sc.nextLine();
		
		bc.insertMember(mem_id, mem_pwd, mem_name, mem_age, mem_phone, mem_address);
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

	public void displayBookList(ArrayList<Book> list) {
		System.out.println("========== 도서 목록 ==========");
		System.out.println("도서 코드 \t도서명 \t\t저자 \t\t출판사 \t\t대여가능여부");
		
		for (Book b : list) {
			System.out.println(b);
		}
	}
	
	public void displayRentBookList(ArrayList<Book> list) {
		System.out.println("========== 도서 목록 ==========");
		System.out.println("대여 도서코드 \t대여 도서명 \t대여한 회원아이디 \t대여일자");
		
		for (Book b : list) {
			System.out.println(b);
		}
	}
	
//
//	public void displayMember(Book b) {
//		System.out.println("\n조회된 데이터는 다음과 같습니다.");
//		System.out.println(b);
//	}
	
} // BookMenu
