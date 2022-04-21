package group6.semester.project.controller;


import group6.semester.project.model.Message;
import group6.semester.project.services.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {
    private MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }
    @GetMapping(value = "/message/{id}")
    @ResponseBody
    public ResponseEntity getMessage(@PathVariable int id){
        try {
//            Message message = new Message();
//            message.setBody("HI");
//            message.setId(1);
//            messageService.addMessage(message);
            Message messageFromServer = messageService.getMessageById(id);
            return ResponseEntity.ok(messageFromServer);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/message")
    @ResponseBody
    public ResponseEntity addMessage(@RequestBody  Message message){
        try {
            Message messageFromServer = messageService.addMessage(message);
            return ResponseEntity.ok(messageFromServer);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }

    }
}
