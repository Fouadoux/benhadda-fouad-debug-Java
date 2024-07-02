package com.hemebiotech.analytics.Exception;

/**
 *Return a message if the extension is not .out
 */
public class FileExtentionException extends Exception {
   public FileExtentionException(String error) {

        super(error);
    }
}