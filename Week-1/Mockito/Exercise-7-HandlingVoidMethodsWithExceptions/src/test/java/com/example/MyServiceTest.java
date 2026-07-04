package com.example;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MyServiceTest {
    @Test
    public void testVoidMethodWithException() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        // Stub the void method to throw an exception
        doThrow(new RuntimeException("Database Offline"))
            .when(mockApi).processData("Error Trigger");

        MyService service = new MyService(mockApi);

        // Verify that the exception is thrown
        Exception exception = assertThrows(RuntimeException.class, () -> {
            service.process("Error Trigger");
        });

        assertEquals("Database Offline", exception.getMessage());
        verify(mockApi).processData("Error Trigger");
    }
}
