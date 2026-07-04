package com.example;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MyServiceTest {
    @Test
    public void testMultipleReturns() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        // Stub methods to return different values on consecutive calls
        when(mockApi.getData())
            .thenReturn("First Call")
            .thenReturn("Second Call");

        MyService service = new MyService(mockApi);

        assertEquals("First Call", service.fetchData());
        assertEquals("Second Call", service.fetchData());
    }
}
