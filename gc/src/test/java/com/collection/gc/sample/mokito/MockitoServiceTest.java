package com.collection.gc.sample.mokito;

import com.collection.gc.mockito.AlwaysService;
import com.collection.gc.mockito.EmptyService;
import com.collection.gc.mockito.EqualService;
import com.collection.gc.mockito.MockitoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MockitoServiceTest {

    @InjectMocks
    private MockitoService mockitoService;

    @Mock
    private EqualService equalService;

    @Mock
    private EmptyService emptyService;

    @Mock
    private AlwaysService alwaysService;

    @BeforeEach
    void setUp() {

    }

    @DisplayName("hello 로 입력된 경우")
    @Test
    void test_hello_equalService() throws Exception {
        // given
        when(equalService.doubleText("hello"))
                .thenReturn("hellohello");

        // when
        mockitoService.union("hello");

        // then
        verify(equalService, times(1))
                .doubleText("hello");
        verify(emptyService, never())
                .alwaysEmpty();
        verify(alwaysService, times(1))
                .andDot();
    }

    @DisplayName("공백으로 입력된 경우")
    @Test
    void test_empty_emptyService() throws Exception {
        // given
        when(emptyService.alwaysEmpty())
                .thenReturn("empty");

        // when
        mockitoService.union("");

        // then
        verify(equalService, never())
                .doubleText("");
        verify(emptyService, times(1))
                .alwaysEmpty();
        verify(alwaysService, times(1))
                .andDot();
    }

    @DisplayName("world 로 입력된 경우")
    @Test
    void test_world_alwaysService_11() throws Exception {
        // given

        // when
        mockitoService.union("world");

        // then
        verify(equalService, never())
                .doubleText("");
        verify(emptyService, never())
                .alwaysEmpty();
        verify(alwaysService, times(11))
                .andDot();
    }

    @DisplayName("dummy 로 입력된 경우")
    @Test
    void test_dummy_alwaysService_only() throws Exception {
        // given

        // when
        mockitoService.union("dummy");

        // then
        verify(alwaysService, only())
                .andDot();
    }

}
