package com.collection.gc.mockito;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Slf4j
@Service
@RequiredArgsConstructor
public class MockitoService {

    private final EqualService equalService;

    private final EmptyService emptyService;

    private final AlwaysService alwaysService;

    private final static String HELLO = "hello";

    private final static String WORLD = "world";

    public String union(String text) {
        StringBuilder result = new StringBuilder();
        if ( HELLO.equals(text) ) {
            result.append( equalService.doubleText(text) );
        }
        if (StringUtils.isEmpty(text)) {
            result.append( emptyService.alwaysEmpty() );
        }
        result.append( alwaysService.andDot() );
        if ( WORLD.equals(text) ) {
            for (int i = 0; i < 10; i++) {
                result.append( alwaysService.andDot() );
            }
        }
        return result.toString();
    }
}
