package com.collection.gc.exception;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestExceptionController {

    @PostMapping("/exception/r")
    public void exception() {
        throw new RuntimeException();
    }

}
