package com.developlee.springbootmessageconverter.controller;

import com.developlee.springbootmessageconverter.domain.MessageEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author liululee
 * @desc
 * @since 2019/5/28 0028
 **/
@RestController
public class MessageController {

    @PostMapping(value = "/msg",
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity receiveMessage(@RequestBody MessageEntity messageEntity) {
        messageEntity.setName("Hello! " + messageEntity.getName());
        messageEntity.setMsg("Hope U " + messageEntity.getMsg());
        return new ResponseEntity(messageEntity, HttpStatus.OK);
    }
}
