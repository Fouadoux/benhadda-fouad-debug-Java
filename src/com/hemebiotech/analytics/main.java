package com.hemebiotech.analytics;

import com.hemebiotech.analytics.AnalyticsCounter.AnalyticsCounter;

import java.util.List;
import java.util.Map;

public class main {

    public static void main(String[] args) {
        /**
         * Instantiate the AnalyticsCounter class and call the method for reading, the method for counting symptoms,
         * sort the symptoms, and finally call the method to write the results to an output file.
         */
        AnalyticsCounter analyticsCounter = new AnalyticsCounter("symptoms.txt", "result.out");
        List<String> symptomsList = analyticsCounter.getSymptoms();
        Map<String, Integer> symptomsCount = analyticsCounter.countSymptoms(symptomsList);
        Map<String, Integer> symptomsSort=  analyticsCounter.sortSymptoms(symptomsCount);
        analyticsCounter.writeSymptoms(symptomsSort);
    }
}