package com.hemebiotech.analytics.WriteSymptoms;

/**
 *Return a message if the extension is not .out
 */
public class FileExtentionException extends Exception {
   public FileExtentionException(String error) {

        super("Wrong extension file");
    }
}