package ch05.exam03;	//3팀

import java.util.Scanner;

public class BoardExample_ {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		String[][] boards = null; // boards �迭 ����
		boards = new String[100][]; // boards 100����
		int hitNo = 0; // ��ȸ��

		while (true) { // �ݺ�
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("1.��Ϥ�2.�۾����3.�󼼺����4.�����ϱ��5.�����ϱ��6.����"); 
			System.out.println("---------------------------------------------------------------------------");
			System.out.print("����: ");
			String choice = scanner.nextLine(); // ���õ� �޴�

			if (choice.equals("1")) { // 1����, ���
				System.out.println("---------------------------------------------------------------");
				System.out.println("1.��ȣ\t\t2.����\t\t3.�ۼ���\t\t4.��ȸ��"); 
				System.out.println("---------------------------------------------------------------");
				for (int i = 0; i < boards.length; i++) {
					String[] board = boards[i]; // boards
					if (board != null) {
						System.out.println(board[0] + "\t\t" + board[1] + "\t\t" + board[3] + "\t\t" + board[4]);
					}

				}

			} else if (choice.equals("2")) { // 2����, �۾���
				System.out.print("����: ");
				String title = scanner.nextLine(); //title�� ����
				System.out.print("����: ");
				String content = scanner.nextLine();//content�� ����
				System.out.print("�ۼ���: ");
				String name = scanner.nextLine(); //name�� ����
				for (int i = 0; i < boards.length; i++) {
					if (boards[i] == null) {
						String[] board = { String.valueOf(i), title, content, name, String.valueOf(hitNo) };
						boards[i] = board;
						break;

					}
				}
			} else if (choice.equals("3")) {	//3����, �󼼺���
				System.out.print("��ȣ�Է�: ");
				int selectNo = Integer.parseInt(scanner.nextLine());
				System.out.println("����: " + boards[selectNo][1]);
				System.out.println("����: " + boards[selectNo][2]);
				System.out.println("�ۼ���: " + boards[selectNo][3]);
				hitNo = Integer.parseInt(boards[selectNo][4]);	//���ڿ��� ������ ����
				hitNo++;	//hitNo�� 1�� ����
				boards[selectNo][4] = String.valueOf(hitNo);	//������ �ٽ� ���ڿ��� ����

			} else if (choice.equals("4")) { //4����, �����ϱ�
				System.out.println("��ȣ�Է�: ");
				int selectNo = Integer.parseInt(scanner.nextLine());
				System.out.println("����: ");
				boards[selectNo][1] = scanner.nextLine();
				System.out.println("����: ");
				boards[selectNo][2] = scanner.nextLine();
				System.out.println("�ۼ���: ");
				boards[selectNo][3] = scanner.nextLine();

			} else if (choice.equals("5")) {	//5����, ����
				System.out.print("������ ��ȣ: ");
				int num = Integer.parseInt(scanner.nextLine());
				boards[num] = null;
				
			} else if (choice.equals("6")) {	//6����, ����
				break;
			}
		}
	}
}