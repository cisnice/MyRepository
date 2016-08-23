package ch05.exam03;   //2팀

import java.util.Scanner;

public class BoardExample {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		String[][] boards = new String[100][];
		int counter = 0;//조회수
		while (true) {
			System.out.println("------------------------------------------------------------------------");
			System.out.println("1.목록 | 2.글쓰기 | 3.상세보기 | 4.수정하기 | 5.삭제하기 | 6.종료");
			System.out.println("------------------------------------------------------------------------");
			System.out.print("게시판 선택: ");
			String choice = scanner.nextLine();

			if (choice.equals("1")) {
				System.out.println("**********************************************************************");
				System.out.println("게시판번호\t\t제목\t\t글쓴이\t\t조회수");
				System.out.println("**********************************************************************");
				for (int i = 0; i < boards.length; i++) {
					String[] board = boards[i];
					if (board != null) {
						System.out.println(board[0] + "\t\t" + board[1] + "\t\t" + board[3] + "\t\t" + board[4]);
					}
				}

			} else if (choice.equals("2")) {
				System.out.print("제목: ");
				String title = scanner.nextLine();
				System.out.print("내용: ");
				String contents = scanner.nextLine();
				System.out.print("글쓴이: ");
				String writer = scanner.nextLine();
				for (int i = 0; i < boards.length; i++) {
					if (boards[i] == null) {
						String[] board = { String.valueOf(i), title, contents, writer,String.valueOf(counter) };
						boards[i] = board;
						break; // 가장 가까운 for문에 영향을 준다.
					}else
						System.out.println("게시판이 등록이 되어 있습니다.");
				}

			} else if (choice.equals("3")) {
				System.out.print("상세보기 할 게시판 번호: ");
				String detailedBoardNo = scanner.nextLine();
				System.out.println("******************************************************");
				System.out.println("게시판번호\t\t제목\t\t내용\t\t글쓴이\t\t조회수");
				System.out.println("******************************************************");

				for (String[] board : boards) {
					if (board != null) {
						counter = Integer.parseInt(board[4]);
					if (detailedBoardNo.equals(board[0])) {
							counter++;
							board[4]= String.valueOf(counter);
							System.out.println(board[0] + "\t\t" + board[1] + "\t\t" + board[2] + "\t\t" + board[3]
									+ "\t\t" + board[4]);
						}
					}
				}
			} else if (choice.equals("4")) {
				System.out.print("수정할 게시판 번호: ");
				String modifyNo = scanner.nextLine();
				System.out.print("제목: ");
				String modifyTitle = scanner.nextLine();
				System.out.print("내용: ");
				String modifyContents = scanner.nextLine();

				for (String[] board : boards) {
					if (board != null) {
						if (modifyNo.equals(board[0])) {
							board[1] = modifyTitle;
							board[2] = modifyContents;
						}
					}

				}
			} else if (choice.equals("5")) {
				System.out.print("삭제할 게시판 번호: ");
				int deleteNo = Integer.parseInt(scanner.nextLine());
				boards[deleteNo] = null; // 원래 있던 번지를 지우는 것이 삭제이다.
			} else if (choice.equals("6")) {
				break; // while문을 빠져나간다.
			}
		}
	}
}
