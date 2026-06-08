package by.kotsuba.arrayprocessor.validatorimpl;

import by.kotsuba.arrayprocessor.validator.ArrayValidator;

public class ArrayValidatorImpl implements ArrayValidator {
    public static final String ARRAY_REGEX =
            "^\\s*-?\\d+(\\s*[,;\\-]\\s*-?\\d+)*\\s*$";

   @Override
    public boolean isValid(String line){
       return line != null && line.matches(ARRAY_REGEX);
   }
}
