package example.gsmessagingstompwebsocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");

    }

    @MessageMapping("/goodbye")
    @SendTo("/topic2/goodbye")
    public Greeting goodbye(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Goodbye, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }
}
