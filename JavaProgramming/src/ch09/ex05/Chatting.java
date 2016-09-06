package ch09.ex05;

public class Chatting {
	
	void startChat(String chatId) {
//		String nickName = null;
//		nickName = chatId;		// nickName이 final 특성을 갖고있어 값을 변경하지 못한다.
		
		String nickName = chatId;
		
		Chat chat = new Chat() {
			@Override
			void start() {
				while(true) {
					String inputData = "안녕하세요";
					String message = "[" + nickName + "]" + inputData;
					sendMessage(message);
				}				
			}
		};
		chat.start();		
	}
	
	class Chat {
		void start() {}
		void sendMessage(String message) {}
	}
}
