package com.hemebiotech.analytics.ReadSymptoms;

/**
 *  Exception for empty files
 */
public class EmpyFileException extends Exception{
    public EmpyFileException(String error) {
        super("File Empty");
    }
}
