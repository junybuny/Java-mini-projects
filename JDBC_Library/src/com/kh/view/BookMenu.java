package com.kh.view;

import java.util.ArrayList;
import java.util.Scanner;
import com.kh.controller.BookController;
import com.kh.model.vo.Book;

public class BookMenu {
	
	private Scanner sc = new Scanner(System.in);
	private BookController bc = new BookController();
	
	public void mainMenu() {
		// 로그인 하지 않아도 보여주는거 -> 대여현황(대여가능/불가능 전체), 회원등록
		// 로그인 후 -> 도서대여(내가 빌린책만 조회), 도서반납, 회원탈퇴?, 회원정보수정
		// 관리자가 있다면 -> 도서등록, 도서삭제, 회원삭제
		while(true) {
			
				while(true) {
				System.out.println("============================");
				System.out.println("1. 로그인");
				System.out.println("2. 회원등록");
				System.out.println("0. 종료");
				System.out.println("============================");
				System.out.print(">> 메뉴 선택 : ");
				
				int num1 = sc.nextInt();
				sc.nextLine();
				
				switch(num1) {
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
				break;
			}
			
			
			while(true) {
				// 일반회원 목록
				System.out.println("============================");
				System.out.println("1. 대여 현황");
				System.out.println("2. 도서 대여");
				System.out.println("3. 도서 반납");
				System.out.println("4. 회원 탈퇴"); // 대여중인 도서가 있으면 불가
				System.out.println("0. 프로그램 종료");
				System.out.println("============================");
				
				System.out.print(">> 메뉴 선택 : ");
				int memberMenu = sc.nextInt();
				sc.nextLine();
				
				switch(memberMenu) {
					case 1:
						bc.rentY_bookList();
						break;
					case 2: 
						bc.rent_bookList(rentBook());
						break;
					case 3: 
						bc.return_bookList(returnBook());
						break;
					case 4:
						
						break;
					case 0:
						System.out.println("이용해주셔서 감사합니다. 프로그램을 종료합니다.");
						return;
					default:
						System.out.println("메뉴를 잘못 입력하셨습니다. 다시 입력해주세요."); // 일반회원 목록으로.. 가야하는디..
						break;
				}
				// 일반회원 메뉴 루프 종료
			    break;
			}
			
			while(true) {
				// 관리자 목록
				System.out.println("============================");
				System.out.println("1. 도서 목록"); // rent_TF = 'Y'인것만할지 고민중
				System.out.println("2. 도서 등록");
				System.out.println("3. 도서 삭제");
				System.out.println("4. 회원 삭제");
				System.out.println("0. 프로그램 종료");
				System.out.println("============================");
				
				System.out.print(">> 메뉴 선택 : ");
				int maseterMenu = sc.nextInt();
				sc.nextLine();
				
				switch(maseterMenu) {
				case 1: 
					bc.rentY_bookList();
					break;
				case 2:
					inputBook();
					break;
				case 3:
					bc.deleteBook(inputbookCode());
					break;
				case 4: 
					bc.deleteMember(inputmem_id());
					break;
				case 0:
					System.out.println("이용해주셔서 감사합니다. 프로그램을 종료합니다.");
					return;
				default:
					System.out.println("메뉴를 잘못 입력하셨습니다. 다시 입력해주세요.");
					break;
				}
				// 관리자 메뉴 루프 종료
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
		
		System.out.print("대여가능여부(Y/N) : ");
		String rent_TF = sc.nextLine().toUpperCase();
		
		bc.insertBook(code, title, author, publisher, rent_TF);
	
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
		System.out.println("도서 코드 \t\t도서명 \t\t저자 \t\t출판사 \t\t대여가능여부");
		
		for (Book b : list) {
			System.out.println(b);
		}
	}
	
	public void displayRentBookList(ArrayList<Book> list) {
		System.out.println("========== 도서 목록 ==========");
		System.out.println("대여 도서코드 \t\t대여 도서명 \t\t대여한 회원아이디 \t\t대여일자");
		
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
