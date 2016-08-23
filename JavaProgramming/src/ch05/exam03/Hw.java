package ch05.exam03; //패키지 선언 4팀

import java.util.Scanner;  //자바가 스캐너를 제공 

public class Hw {    //클래스 Hw선언 

	public static void main(String[] args) {  //메인 메소드 선언
		
		int[] views=new int[100];  //조회수를 저장하기위한 int형 크기 100짜리 배열 선언...String.valueOf()...
		
		Scanner scanner = new Scanner(System.in); //스캐너 타입의 변수 생성, 키보드로 입력받는값을 스캐너가 읽어들이겠다.
				
		String[][] news= new String[100][] ; //100개의 게시글을 저장할수있는 다차원 배열 선언
				
		
		
		while(true){  
			System.out.println("-------------------------------------------------------------------");
			System.out.println("1.목록 | 2.글쓰기 | 3.상세보기 | 4.수정하기 | 5.삭제하기 | 6.종료");
			System.out.println("-------------------------------------------------------------------");
			System.out.println("선택 ");
			String choice=scanner.nextLine();
					
				if(choice.equals("1")){
					
					boolean newsconfig = false;
					for ( String[] newspaper : news ) {
						if ( newspaper != null ) {
							newsconfig = true;
						}
					}
					// 입력된 글이 없을 때 다음을 실행하지 않고, continue를 실행해서 while의 처음으로 돌아간다.
					if( newsconfig == false ) {
						System.out.println("저장되어있는 글이 없습니다. ");
						continue;
					}
					
					System.out.println("******************************************************");
					System.out.println("번호\t\t" + "제목\t\t"+"글쓴이\t\t"+"조회수");
					System.out.println("******************************************************");
					
					for(String[] newspaper: news){
						if(newspaper != null) //값이 저장되어있는 배열의 값을 출력  
							System.out.println(newspaper[0]+"\t\t"+newspaper[1]+"\t\t"+newspaper[2]+"\t\t"+views[Integer.parseInt(newspaper[0])]);				
					}
				}
					
				else if(choice.equals("2")){
					System.out.println("제목을 입력하시오."); 
					String title= scanner.nextLine(); 
					System.out.println("글쓴이를 입력하시오.");
					String name= scanner.nextLine();
					System.out.println("내용을 입력하시오.");
					String context= scanner.nextLine();
						
					for(int i=0; i<news.length; i++){
						if(news[i]==null){
							String[] newspaper={String.valueOf(i), title, name, context}; //매개값숫자를 문자열로바꿔서 index값을 게시글의 번호로 만들고, scanner로 입력받은값을 배열에 저장
							news[i]=newspaper;
							break;
						}		
					}
				}
				
				else if(choice.equals("3")){
					
					boolean newsconfig = false;
					
					for ( String[] newspaper : news ) {
						if ( newspaper != null ) {
							newsconfig = true;
						}
					}
					
					// 입력된 글이 없을 때 다음을 실행하지 않고, continue를 실행해서 while의 처음으로 돌아간다.
					if( newsconfig == false ) {
						System.out.println("저장되어있는 글이 없습니다. ");
						continue;
					}
					System.out.println("상세히 보고싶은 글의 번호를 입력하세요.");
					int num=Integer.parseInt(scanner.nextLine()); 
					System.out.println(num+"번 글의 내용 : "+ news[num][3]); //news배열의 네번째 배열에 상세히 보고자하는 내용이 담겨있으므로 출력 
					views[num]++; //상세보기를 한 게시글의 조횟수를 1 증가 
				}
					
				else if(choice.equals("4")){
					
					boolean newsconfig = false;
					
					for ( String[] newspaper : news ) {
						if ( newspaper != null ) {
							newsconfig = true;
						}
					}
					
					// 입력된 글이 없을 때 다음을 실행하지 않고, continue를 실행해서 while의 처음으로 돌아간다.
					if( newsconfig == false ) {
						System.out.println("저장되어있는 글이 없습니다. ");
						continue;
					}
					
					System.out.println("수정하려는 글의 번호를 입력하세요."); 
					int num=Integer.parseInt(scanner.nextLine());
					
					System.out.println("---------------------------");
					System.out.println("1. 제목 수정 | 2. 내용 수정");
					System.out.println("---------------------------");
					int select=Integer.parseInt(scanner.nextLine());
						
					if(select==1){
						System.out.println("제목을 다시 입력 하세요.");
						news[num][1]=null; //수정할 글의 제목을 null값으로 만들고
						news[num][1]= scanner.nextLine(); //다시입력
					}
					if(select==2){
						System.out.println("내용을 다시 입력 하세요.");  //수정할 글의 내용을 null값으로 만들고
						news[num][3]=null; //수정할 글의 내용을 null값으로 만들고
						news[num][3]= scanner.nextLine(); //다시입력
					}
								
				}
				else if(choice.equals("5")){
					
					boolean newsconfig = false;
					
					for ( String[] newspaper : news ) {
						if ( newspaper != null ) {
							newsconfig = true;
						}
					}
					
					// 입력된 글이 없을 때 다음을 실행하지 않고, continue를 실행해서 while의 처음으로 돌아간다.
					if( newsconfig == false ) {
						System.out.println("저장되어있는 글이 없습니다. ");
						continue;
					}
					System.out.println("삭제 하고 싶은 글의 번호를 입력하세요.");
					int num=Integer.parseInt(scanner.nextLine());
					news[num]=null;
					views[num]=0;
				}
				
				else if(choice.equals("6")){
					break;
				}
		}
		
	}
}
