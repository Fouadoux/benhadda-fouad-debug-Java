package com.hemebiotech.analytics;

import com.hemebiotech.analytics.ReadSymptoms.ReadSymptoms;
import com.hemebiotech.analytics.AnalyticsCounter.AnalyticsCounter;
import com.hemebiotech.analytics.WriteSymptoms.WriteSymptoms;

import java.util.List;
import java.util.Map;

public class main {

    public static void main(String args[]) throws Exception {


        AnalyticsCounter analyticsCounter = new AnalyticsCounter("symptoms.txt", "resolt.out");
        List<String> symptomsList = analyticsCounter.getSymptoms();
        Map<String, Integer> symptomsCount = analyticsCounter.countSymptoms(symptomsList);
        Map<String, Integer> symptomsSort=  analyticsCounter.sortSymptoms(symptomsCount);
        analyticsCounter.writeSymptoms(symptomsSort);

    }
}
