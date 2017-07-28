package hello;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Controller
public class GreetingController {


    @MessageMapping("/hello")
    //@SendTo("/topic/greetings") //by default response will send on topic "/topic/hello"
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + message.getName() + "!");
    }


    @MessageMapping("/hello-with-time")
    @SendToUser("/queue/ownhello")
    public Greeting greeting2(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + message.getName() + " on " + message.getDate().toString() +"! " + (new Date()).toString() );
    }

}
