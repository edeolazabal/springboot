package com.upc.alumnoapi.model;

public interface IListado {
    String fullName = null;
    String Month = null;
    Double workedHours = null;
    Double salaryByHour = null;
    Double salaryOfMonth = null;
    Double tax = null;
    Double netSalary = null;
    String reportDateTime = null;

    // Getters
    String getFullName();
    String getMonth();
    Double getWorkedHours ();
    Double getSalaryByHour();
    Double getSalaryOfMonth();
    Double getTax();
    Double getNetSalary();
    String getReportDateTime();
}
