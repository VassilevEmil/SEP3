package via.group6.tier2.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import via.group6.tier2.Model.Message;

@RestController
@RequestMapping("/api/v1")
public class Tier2Controller {


    //Just a return API string message to Tier1
    @GetMapping("/helloworld")
    public ResponseEntity<Message> getMessage()
    {

        Message m = new Message("Hellow World!");
        return ResponseEntity.ok(m);
    }

}
