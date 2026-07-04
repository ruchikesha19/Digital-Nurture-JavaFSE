package com.example;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

public class MyServiceTest {
    @Test
    public void testInteractionOrder() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        service.performOrderedOperations();

        // Verify order of calls
        InOrder inOrder = inOrder(mockApi);
        inOrder.verify(mockApi).processData("Initial Step");
        inOrder.verify(mockApi).getData();
    }
}
