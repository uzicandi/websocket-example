package hello;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker // Websocket message handling 가능하게 함. -- Websocket 서버를 사용한다
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{
	// WebsocketMessageBrokerConfigurer 를 상속받아 메소드를 구현하여 websocket 연결 속성을 설정한다.

	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		config.enableSimpleBroker("/topic");
		// broker가 greeting Message를 client(/topic)으로 가게 도와줌
		config.setApplicationDestinationPrefixes("/app");
		// MessageMapping 메소드가 ('/app') 가 prefix로 붙은 것들한테 메세지 매핑해줌.
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		// registerStompEndpoints = 클라이언트에서 websocket에 접속하는 endpoint 등록
		registry.addEndpoint("/gs-guide-websocket").withSockJS();
		// withSockJS() : websocket이 안되면 SockJS 로 하도록 해서 SockJS가 ('/gs-guide-websocket')으로 연결시도.
	}

}
