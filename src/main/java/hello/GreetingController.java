package hello;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

	//Create a message-handling controller
	//STOMP �޼����� @Controller Ŭ������ ����� �� �� �ִ�.
	//GreetingController �޼����� ��� "/hello" �� ó���ϵ��� ���εȴ�.

	@MessageMapping("/hello")
	// �޼����� ("/hello")�� ������ ��� greeting() �޼ҵ尡 �ҷ�����.
	// �޼����� payload(���۵Ǵ� ������)�� greeting()���� ���޵Ǵ� HelloMessage ��ü�� ���ε��ȴ�.

	@SendTo("/topic/greetings") // Return value�� @SendTo�� ���ؼ� "/topic/greetings"�� ������
	// �� �� Ŭ���̾�Ʈ���� ������ DOM���� �ҷ����� Re-render�ǹǷ� �Է¸޼����� �̸��� �����ȴ�.
	public Greeting greeting(HelloMessage message) throws Exception {
		Thread.sleep(1000); // simulated delay -- 1��
		return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
	}

}
