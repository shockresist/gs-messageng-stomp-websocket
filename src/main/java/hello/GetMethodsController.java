package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by admin on 27.07.2017.
 */

@Controller
public class GetMethodsController {

    private SimpMessagingTemplate template;

    @Autowired
    public GetMethodsController(SimpMessagingTemplate template) {
        this.template = template;
    }

    @RequestMapping(path="/greetings", method=GET)
    public String greet() {
        String text = "[GET request on /greetengs executed]";
        this.template.convertAndSend("/topic/events", text);
        return "event trigered";
    }
}
