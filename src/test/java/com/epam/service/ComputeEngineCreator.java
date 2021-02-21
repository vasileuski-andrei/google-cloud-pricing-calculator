package com.epam.service;

import com.epam.model.ComputeEngine;

public class ComputeEngineCreator {

    public static final String NUMBER_OF_INSTANCES = "testdata.number-of-instances";
    public static final String OPERATING_SYSTEM = "testdata.operating-system";
    public static final String VIRTUAL_MACHINE_CLASS = "testdata.virtual-machine-class";
    public static final String SERIES = "testdata.series";
    public static final String INSTANCE_TYPE = "testdata.instance-type";
    public static final String TYPE_GPU = "testdata.type-gpu";
    public static final String LOCAL_SSD = "testdata.local-ssd";
    public static final String DATA_CENTER_LOCATION= "testdata.data-center-location";
    public static final String COMMITED_USAGE = "testdata.commited-usage";
    public static final String ESTIMATED_COST = "testdata.estimated-cost";

    public static ComputeEngine getComputeEngineWithCredentialsFromProperty() {
        return new ComputeEngine(TestDataReader.getTestData(NUMBER_OF_INSTANCES),
                TestDataReader.getTestData(OPERATING_SYSTEM),
                TestDataReader.getTestData(VIRTUAL_MACHINE_CLASS),
                TestDataReader.getTestData(SERIES),
                TestDataReader.getTestData(INSTANCE_TYPE),
                TestDataReader.getTestData(TYPE_GPU),
                TestDataReader.getTestData(LOCAL_SSD),
                TestDataReader.getTestData(DATA_CENTER_LOCATION),
                TestDataReader.getTestData(COMMITED_USAGE),
                TestDataReader.getTestData(ESTIMATED_COST));
    }

}
