package by.kotsuba.arrayprocessor.factory;

import by.kotsuba.arrayprocessor.entity.IntArray;
import by.kotsuba.arrayprocessor.exception.ArrayException;
import by.kotsuba.arrayprocessor.validator.ArrayValidator;

public class ArrayFactory {
    private final ArrayValidator validator;
    public ArrayFactory(ArrayValidator validator){
        this.validator = validator;
    }
    public IntArray createArray(String line) throws ArrayException {
        if(!validator.isValid(line)){
            throw new ArrayException("Invalid array data "+ line);
        }
        String[] parts = line.split("\\s*[,;\\-]\\s*");
        int[] values = new int[parts.length];
        for(int i = 0;i<parts.length;i++){
            values[i] = Integer.parseInt(parts[i]);
        }
        return new IntArray(values);
    }
}
