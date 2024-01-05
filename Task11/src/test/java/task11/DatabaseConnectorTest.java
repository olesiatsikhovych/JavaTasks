package task11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DatabaseConnectorTest {

    @Test
    void testGetDataById() {
        DatabaseConnector databaseConnector = new DatabaseConnector();

        String result = databaseConnector.getDataById();
        String expected = "data";

        assertEquals(expected, result);
    }
//
//    @Test
//    void testGetDataById() {
//        DatabaseConnector databaseConnector = mock(DatabaseConnector.class);
//
//        when(databaseConnector.getDataById())
//                .thenReturn("Some data");
//
//        String result = databaseConnector.getDataById();
//        String expected = "Some data";
//
//        assertEquals(expected, result);
//    }
}
