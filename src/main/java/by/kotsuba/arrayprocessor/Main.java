package by.kotsuba.arrayprocessor;

import by.kotsuba.arrayprocessor.entity.IntArray;
import by.kotsuba.arrayprocessor.exception.ArrayException;
import by.kotsuba.arrayprocessor.factory.ArrayFactory;
import by.kotsuba.arrayprocessor.reader.ArrayFileReader;
import by.kotsuba.arrayprocessor.service.ArrayService;
import by.kotsuba.arrayprocessor.serviceimpl.ArrayServiceImpl;
import by.kotsuba.arrayprocessor.validator.ArrayValidator;
import by.kotsuba.arrayprocessor.validatorimpl.ArrayValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;


public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Started");
        try {
            ArrayValidator validator = new ArrayValidatorImpl();
            ArrayFactory factory = new ArrayFactory(validator);
            ArrayService service = new ArrayServiceImpl();
            ArrayFileReader fileReader = new ArrayFileReader();
            URL resourceUrl = Main.class.getClassLoader().getResource("input.txt");
            if (resourceUrl == null) {
                logger.error("input.txt not found in resources");
                return;
            }
            Path path = Paths.get(resourceUrl.toURI());
            List<String> lines = fileReader.readLines(path.toString());
            logger.info("Read {} lines from file", lines.size());
            for (String line : lines) {
                try {
                    IntArray array = factory.createArray(line);
                    int[] originalValues = array.getValues();
                    if (originalValues.length == 0) {
                        logger.info("Empty array (valid) - skipping calculations");
                        continue;
                    }
                    logger.info("Processing: {}", line);
                    logger.info("  Original array: {}", Arrays.toString(originalValues));
                    // Min, Max, Sum, Average
                    service.findMin(array).ifPresent(min -> logger.info("  Min: {}", min));
                    service.findMax(array).ifPresent(max -> logger.info("  Max: {}", max));
                    logger.info("  Sum: {}", service.sum(array));
                    service.average(array).ifPresent(avg -> logger.info("  Average: {}", avg));
                    //bubble sort
                    IntArray arrayForBubbleSort = new IntArray(originalValues.clone());
                    service.bubbleSort(arrayForBubbleSort);
                    logger.info("  Bubble sort result: {}", Arrays.toString(arrayForBubbleSort.getValues()));
                    //insertion sort
                    IntArray arrayForInsertionSort = new IntArray(originalValues.clone());
                    service.insertionSort(arrayForInsertionSort);
                    logger.info("  Insertion sort result: {}", Arrays.toString(arrayForInsertionSort.getValues()));
                    logger.info("---");

                } catch (ArrayException e) {
                    logger.warn("Skipping invalid line: {} - {}", line, e.getMessage());
                }
            }
        } catch (Exception e) {
            logger.error("Application failed", e);
        }
        logger.info("Finished");
    }
}