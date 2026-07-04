package com.example;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MyServiceTest {
    @Test
    public void testVoidMethod() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        // Stub a void method with doNothing()
        doNothing().when(mockApi).updateStatus(anyString());

        MyService service = new MyService(mockApi);
        service.notifyStatusChange("Active");

        // Verify that the interaction occurred
        verify(mockApi).updateStatus("Active");
    }
}
