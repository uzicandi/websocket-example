package hello;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

	//Create a message-handling controller
	//STOMP 메세지는 @Controller 클래스로 라우팅 될 수 있다.
	//GreetingController 메세지를 대상 "/hello" 로 처리하도록 매핑된다.

	@MessageMapping("/hello")
	// 메세지가 ("/hello")로 보내질 경우 greeting() 메소드가 불러진다.
	// 메세지의 payload(전송되는 데이터)는 greeting()으로 전달되는 HelloMessage 객체에 바인딩된다.

	@SendTo("/topic/greetings") // Return value는 @SendTo를 통해서 "/topic/greetings"로 보내짐
	// 이 때 클라이언트쪽의 브라우저 DOM에서 불러와져 Re-render되므로 입력메세지의 이름이 삭제된다.
	public Greeting greeting(HelloMessage message) throws Exception {
		Thread.sleep(1000); // simulated delay -- 1초
		return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
	}

}
