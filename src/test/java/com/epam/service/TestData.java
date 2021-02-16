package com.epam.service;

public class TestData {

    public static final String TESTDATA_DATA_CENTER_LOCATION= "testdata.data-center-location";
    public static final String TESTDATA_ESTIMATED_COST = "testdata.estimated-cost";

    public static String getDataCenterLocationFromProperty() {
        return TestDataReader.getTestData(TESTDATA_DATA_CENTER_LOCATION);
    }

    public static String getEstimatedCostFromProperty() {
        return TestDataReader.getTestData(TESTDATA_ESTIMATED_COST);
    }



}
