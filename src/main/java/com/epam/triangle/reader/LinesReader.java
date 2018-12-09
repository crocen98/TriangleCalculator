package com.epam.triangle.reader;

import com.epam.triangle.exception.NotSupportedPuthException;
import com.sun.org.apache.bcel.internal.classfile.ConstantUtf8;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class LinesReader {
    private static final Logger LOGGER = LogManager.getLogger(LinesReader.class);


    // charset inject
    public  List<String> readAllLines(Path path , Charset charset) throws NotSupportedPuthException  {
        try {
            LOGGER.info("Start reading lines from: " + path);
            List<String> lines = Files.readAllLines(path,charset);
            LOGGER.info("All lines was reading from: " + path);
            return lines;
        } catch (IOException e) {
            LOGGER.error("Exception generated! Path " + path + " not valid.");
            throw new NotSupportedPuthException("Invalid path: " + path , e);
        }
    }

    public static void main (String ... args) throws NotSupportedPuthException {


    }

}
