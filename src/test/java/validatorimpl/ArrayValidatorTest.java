package validatorimpl;
import static org.junit.jupiter.api.Assertions.*;

import by.kotsuba.arrayprocessor.validator.ArrayValidator;
import by.kotsuba.arrayprocessor.validatorimpl.ArrayValidatorImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Test for validation")
public class ArrayValidatorTest {
    private ArrayValidator validator;
    @BeforeEach
    void setUp(){
        validator = new ArrayValidatorImpl();
    }

    @Test
    @DisplayName("isValid")
    void isValid_true(){
        String validInput1 = "1,2,3";
        String validUnput2 = "10,20,30";
        assertTrue(validator.isValid(validInput1));
        assertTrue(validator.isValid(validUnput2));
    }
}
