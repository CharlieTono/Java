package com.company;

import java.util.Map;

public class OperationProvider {

    private Map<String, Operation> operationByName;

    public OperationProvider(Map<String, Operation> operationByName) {
        this.operationByName = operationByName;
    }

    public Operation getByName(String name) {
        return operationByName.get(name);
    }
}
