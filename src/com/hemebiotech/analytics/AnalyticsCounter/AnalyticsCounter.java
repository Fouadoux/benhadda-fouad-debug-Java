package com.hemebiotech.analytics.AnalyticsCounter;

import com.hemebiotech.analytics.ReadSymptoms.ReadSymptoms;
import com.hemebiotech.analytics.WriteSymptoms.WriteSymptoms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * This class provides methods to count the occurrences of symptoms and sort them in alphabetical order.
 */
public class AnalyticsCounter {


    ReadSymptoms readSymptoms;
    WriteSymptoms writeSymptoms;
    public AnalyticsCounter(String fileRead, String fileWrite) {
        this.readSymptoms= new ReadSymptoms(fileRead);
        this.writeSymptoms= new WriteSymptoms(fileWrite);

    }

    public List<String>getSymptoms(){
        return readSymptoms.readSymptoms();
    }
    public void writeSymptoms(Map<String,Integer> symptoms){
        writeSymptoms.writeSymptoms(symptoms);
    }
    /**
     *  Method for counting the occurrence of symptoms
     *  Use computeIfAbsent to create a symptom with a value of 0
     *  @see </https://docs.oracle.com/javase/8/docs/api/java/util/Map.html#computeIfAbsent-K-java.util.function.Function->
     *  Use computeIfPresent to increment the value by 1
     *  @see <https://docs.oracle.com/javase/8/docs/api/java/util/Map.html#computeIfPresent-K-java.util.function.BiFunction->
     *
     * @param readSymptomDataFromFile list with all symptoms in symptoms.txt
     * @return a map with the symptoms sorted and counted. We need this to use the method writeSymptoms in the class WriteSymptomDataToFile
     */

    public Map<String, Integer> countSymptoms(List<String> readSymptomDataFromFile) {
        Map<String,Integer> symptomCount = new HashMap<>();
        for (String listSymptom : readSymptomDataFromFile)
        {
            symptomCount.computeIfAbsent(listSymptom, key->0);
            symptomCount.computeIfPresent(listSymptom, (key,value)->value+1);
        }
        return symptomCount;
    }


    /**
     * Method for sorting in alphabetical order
     * Use a foreach loop to put the key and value in a TreeMap to automatically sort the symptoms in alphabetical order.
     *
     * @param symptomCount a Map<Sting,Interger> with the symptom counted
     * @return a map sorted in alphabetical order key=symptom, value=occurrence
     */
    public Map<String, Integer> sortSymptoms(Map<String ,Integer> symptomCount) {
        Map<String, Integer> symptomSort = new TreeMap<>();
        for (Map.Entry<String, Integer> entry : symptomCount.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            symptomSort.put(key, value);
        }
        return symptomSort;
    }
}
