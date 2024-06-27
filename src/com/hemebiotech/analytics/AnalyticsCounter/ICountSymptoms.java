package com.hemebiotech.analytics.AnalyticsCounter;

import java.util.List;
import java.util.Map;

/**
 *
 */
public interface ICountSymptoms {
    /**
     *
     * @param symptoms : list of symptoms read in symptoms.txt
     * @return Map with the occurrence of symptoms
     */
    Map<String,Integer> countSymptoms(List<String> symptoms);



}
