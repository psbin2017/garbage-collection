package com.collection.gc.async.web;

import com.collection.gc.async.service.AsyncService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class AsyncController {

    private final AsyncService asyncService;

    @GetMapping("/async")
    public void async() {
        log.info("🟢 async called");
        asyncService.async();
        log.info("🟢 async finished");
    }

    @GetMapping("/sync")
    public void sync() {
        log.info("🟡 sync called");
        asyncService.sync();
        log.info("🟡 sync finished");
    }

}
