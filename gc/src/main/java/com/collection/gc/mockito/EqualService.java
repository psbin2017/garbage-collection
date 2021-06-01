package com.collection.gc.mockito;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EqualService {

    public String doubleText(String text) {
        return text + text;
    }
}
