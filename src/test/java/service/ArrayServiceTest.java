package service;

import by.kotsuba.arrayprocessor.entity.IntArray;
import by.kotsuba.arrayprocessor.service.ArrayService;
import by.kotsuba.arrayprocessor.serviceimpl.ArrayServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Array Service test for array operations")
class ArrayServiceTest {

    private ArrayService service;

    @BeforeEach
    void setUp(){
        service = new ArrayServiceImpl();
    }

    @Test
    @DisplayName("findMin")
    void findMin_returnTrue(){
       IntArray array = new IntArray(new int[]{2,5,1,8,3});
       int result = service.findMin(array).getAsInt();
       assertEquals(1,result);
    }
    @Test
    @DisplayName("findMax")
    void findMax_returnTrue(){
        IntArray array = new IntArray(new int[]{1,2,3,4,5,});
        int result = service.findMax(array).getAsInt();
        assertEquals(5,result);
    }

    @Test
    @DisplayName("bubble sort")
    void bubbleSort_true(){
        IntArray array = new IntArray(new int[]{9,4,2,1,7,8});
        service.bubbleSort(array);
        assertArrayEquals(new int[]{1,2,4,7,8,9},array.getValues());
    }

    @Test
    @DisplayName("bubble sort should handle array with duplicate values")
    void bubbleSort_handleValues(){
        int[] values = {3,1,3,2,1};
        int[] expectedSorted = {1,1,2,3,3};
        IntArray array = new IntArray(values.clone());
        service.bubbleSort(array);
        assertArrayEquals(expectedSorted,array.getValues());
    }
}
