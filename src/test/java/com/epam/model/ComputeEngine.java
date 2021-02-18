package com.epam.model;

import java.util.Objects;

public class ComputeEngine {

    private String numberOfInstances;
    private String operatingSystemAndSoftware;
    private String virtualMachineClass;
    private String series;
    private String instanceType;
    private String typeGPU;
    private String localSSD;
    private String dataCenterLocation;
    private String commitedUsage;
    private String estimatedCostPerMonth;

    public ComputeEngine(String numberOfInstances, String operatingSystemAndSoftware, String virtualMachineClass, String series, String instanceType, String typeGPU, String localSSD, String dataCenterLocation, String commitedUsage, String estimatedCostPerMonth) {
        this.numberOfInstances = numberOfInstances;
        this.operatingSystemAndSoftware = operatingSystemAndSoftware;
        this.virtualMachineClass = virtualMachineClass;
        this.series = series;
        this.instanceType = instanceType;
        this.typeGPU = typeGPU;
        this.localSSD = localSSD;
        this.dataCenterLocation = dataCenterLocation;
        this.commitedUsage = commitedUsage;
        this.estimatedCostPerMonth = estimatedCostPerMonth;
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public void setNumberOfInstances(String numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public String getOperatingSystemAndSoftware() {
        return operatingSystemAndSoftware;
    }

    public void setOperatingSystemAndSoftware(String operatingSystemAndSoftware) {
        this.operatingSystemAndSoftware = operatingSystemAndSoftware;
    }

    public String getVirtualMachineClass() {
        return virtualMachineClass;
    }

    public void setVirtualMachineClass(String virtualMachineClass) {
        this.virtualMachineClass = virtualMachineClass;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getInstanceType() {
        return instanceType;
    }

    public void setInstanceType(String instanceType) {
        this.instanceType = instanceType;
    }

    public String getTypeGPU() {
        return typeGPU;
    }

    public void setTypeGPU(String typeGPU) {
        this.typeGPU = typeGPU;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public void setLocalSSD(String localSSD) {
        this.localSSD = localSSD;
    }

    public String getDataCenterLocation() {
        return dataCenterLocation;
    }

    public void setDataCenterLocation(String dataCenterLocation) {
        this.dataCenterLocation = dataCenterLocation;
    }

    public String getCommitedUsage() {
        return commitedUsage;
    }

    public void setCommitedUsage(String commitedUsage) {
        this.commitedUsage = commitedUsage;
    }

    public String getEstimatedCostPerMonth() {
        return estimatedCostPerMonth;
    }

    public void setEstimatedCostPerMonth(String estimatedCostPerMonth) {
        this.estimatedCostPerMonth = estimatedCostPerMonth;
    }

    @Override
    public String toString() {
        return "ComputeEngine{" +
                "numberOfInstances='" + numberOfInstances + '\'' +
                ", operatingSystemAndSoftware='" + operatingSystemAndSoftware + '\'' +
                ", virtualMachineClass='" + virtualMachineClass + '\'' +
                ", series='" + series + '\'' +
                ", instanceType='" + instanceType + '\'' +
                ", typeGPU='" + typeGPU + '\'' +
                ", localSSD='" + localSSD + '\'' +
                ", dataCenterLocation='" + dataCenterLocation + '\'' +
                ", commitedUsage='" + commitedUsage + '\'' +
                ", estimatedCostPerMonth='" + estimatedCostPerMonth + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComputeEngine that = (ComputeEngine) o;
        return Objects.equals(numberOfInstances, that.numberOfInstances) &&
                Objects.equals(operatingSystemAndSoftware, that.operatingSystemAndSoftware) &&
                Objects.equals(virtualMachineClass, that.virtualMachineClass) &&
                Objects.equals(series, that.series) &&
                Objects.equals(instanceType, that.instanceType) &&
                Objects.equals(typeGPU, that.typeGPU) &&
                Objects.equals(localSSD, that.localSSD) &&
                Objects.equals(dataCenterLocation, that.dataCenterLocation) &&
                Objects.equals(commitedUsage, that.commitedUsage) &&
                Objects.equals(estimatedCostPerMonth, that.estimatedCostPerMonth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfInstances, operatingSystemAndSoftware, virtualMachineClass, series, instanceType, typeGPU, localSSD, dataCenterLocation, commitedUsage, estimatedCostPerMonth);
    }
}
