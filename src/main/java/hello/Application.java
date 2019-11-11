package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

/* @SpringBootApplication 은 다음과 같은 어노테이션을 추가할 때 편리하다.
 * 1. @Configuration : class를 context의 bean 정의 소스로 태그한다
 * 2. @EnableAutoConfigration : Springboot이 classpath setting, other beans,
 * various property setting에 기반해 bean를 추가시키도록 한다.
 * 예를들면, spring-webmvc는 classpath에 있고, 어노테이션은 웹애플리케이션임을 알리고,
 * DispathcerServlet을 세팅하면서 key behaviors를 활성화시킨다.
 * 3. @ComponentScan : Spring이 다른 component, configurations, services를 "hello Package"
 * 안에서 찾게하고 controller를 찾게한다.

 * main() 메소드는 스프링부트의 SpringApplication.run() 메소드를 실행시킨다.
 * 여기에는 xml 파일에 한 줄 추가하지 않아도 되고, web.xml 파일도 없다.
 *
 */
