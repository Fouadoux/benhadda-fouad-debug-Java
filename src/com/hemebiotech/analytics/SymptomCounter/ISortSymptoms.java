package com.hemebiotech.analytics.SymptomCounter;

import java.util.Map;

/**
 *
 */
public interface ISortSymptoms {
    /**
     * Sorts a set of symptoms and their occurrences
     *
     * @param symptomsCount A map where the key is the symptom name and the value is the number of occurrences of that symptom.
     * @return a map sorted in alphabetical order key=symptom, value=occurrence
     */
    Map<String,Integer> sortSymptoms(Map<String,Integer> symptomsCount);

}
