package com.collection.gc.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExceptionController {

    @GetMapping("/exception/c")
    public void exception() {
        throw new IllegalStateException();
    }

}