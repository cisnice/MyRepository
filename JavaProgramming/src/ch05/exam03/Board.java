package ch05.exam03;	//1팀

import java.util.Scanner;

public class Board {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[][] board = null;	
		int saveCountIndex = 1;		// 게시판 최신 인덱스 값을 기억

		while (true) {
			System.out.println("------------------------------------------------------------------------");
			if (board == null) {	// 입력이 전혀 안되있을 경우만 보여주는 보기 실패
				System.out.println("2. 글쓰기 | 6. 종료");
				board = new String[100][];	// 한번만 실행해야 하므로
			} else {
				System.out.println("1. 목록 | 2. 글쓰기 | 3. 상세보기 | 4. 수정하기 | 5. 삭제하기 | 6. 종료");
			}
			System.out.println("------------------------------------------------------------------------");
			System.out.print("선택 : ");
			String choice = scanner.nextLine();	// 보기 번호

			if (choice.equals("1")) {	// 목록 보여주기
				System.out.println("*********************************************************");
				System.out.println("|게시물 번호\t|제목\t\t|글쓴이\t\t|조회수|");
				System.out.println("*********************************************************");
				for (String[] article : board) {	// article 배열 선언 후 board 길이만큼 반복
					if (article != null) {	// article이 비어있지 않은 경우만 실행
						System.out
								.println(article[0] + "\t\t" + article[1] + "\t\t" + article[2] + "\t\t" + article[4]);
					}
				}
			} else if (choice.equals("2")) {	//게시글 입력
				System.out.print("제목 : ");
				String subject = scanner.nextLine();
				System.out.print("글쓴이 : ");
				String name = scanner.nextLine();
				System.out.print("내용 : ");
				String text = scanner.nextLine();
				// 제목, 글쓴이, 내용을 입력 받는다.
				for (int i = 0; i < board.length; i++) {
					if (board[i] == null) {	// board 배열의 첫번째로 빈 공간에 아래 명령어들을 실행
						String[] article = { String.valueOf(saveCountIndex), subject, name, text, "0" };	// 입력받은 값들과 조회수 초기값 0을 배열에 입력
						board[i] = article;
						saveCountIndex++;
						break;
					}
				}
			} else if (choice.equals("3")) {	// 게시글 상세보기
				System.out.print("게시물 번호 : ");	// 보고 싶은 게시글 번호 입력
				int artNum = Integer.parseInt(scanner.nextLine());	// 번호를 문자열로 입력받아 정수형으로 변환
				for(int i=0; i<board.length; i++){
					if(board[i] != null && Integer.parseInt(board[i][0]) == artNum){
						int count = Integer.parseInt(board[i][4]);	// 조회수의 초기값이 문자열로 저장되있으므로 정수형으로 변형 
						count++;	// 조회수 증가
						board[i][4] = String.valueOf(count);	// 배열에 문자열로 입력해야 하기 때문에 문자열로 변환
						System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
						System.out.println("제목 : " + board[i][1] + "\t\t글쓴이 : " + board[i][2] + "\t\t 조회수 : "
							+ board[i][4]);	//제목, 글쓰이, 조회수 출력
						System.out.println("");
						System.out.println(board[i][3]);	// 게시글 내용 출력
						System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
					}
				}
			} else if (choice.equals("4")) {
				System.out.print("수정할 게시물 번호 : ");
				int artNum = Integer.parseInt(scanner.nextLine());
				
				if (board[artNum] != null) {	// 입력한 게시글이 비어있지 않은 경우
					System.out.print("제목 : ");
					String subject = scanner.nextLine();
					System.out.print("글쓴이 : ");
					String name = scanner.nextLine();
					System.out.print("내용 : ");
					String text = scanner.nextLine();
				
					board[artNum][1] = subject;
					board[artNum][2] = name;
					board[artNum][3] = text;
					// 입력받은 제목, 글쓴이, 내용을 덮어 씌운다
				}else{
					System.out.println("수정할 게시물이 없습니다.");
				}
				
				
			} else if (choice.equals("5")) {
				boolean sw = false;
				System.out.print("삭제할 게시물 번호 : ");
				int deleteNum = Integer.parseInt(scanner.nextLine());
				
				for(int i=0; i<board.length; i++){
					if(board[i] != null){
						if(Integer.parseInt(board[i][0]) == deleteNum){
							board[i] = null;	// 해당 게시물을 null 처리 하여 비운다.
							System.out.println(deleteNum + "번 게시물이 삭제되었습니다.");
							for(int k=0; k<board.length-1; k++){
								if(board[k] == null){
									board[k] = board[k+1];
									board[k+1] = null;
								}
							}
							sw = true;
						}	
					}
				}
				if(sw == false){
					System.out.println("삭제할 게시물이 없습니다.");
				}
				
			} else if (choice.equals("6")) {	// 반복문을 빠져나온다.
				break;
			}
		}
		System.out.println("프로그램을 종료합니다.");

	}

}
