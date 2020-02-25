package com.company.handler;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperationProvider {

    private Map<String, Operation> operationByName;
    private List<String> operationPaths;

    public OperationProvider(Map<String, Operation> operationByName) {
        this.operationByName = operationByName;
    }

    public OperationProvider(List<String> operationPaths) {
        this.operationPaths = operationPaths;
        operationByName = new HashMap<>();
    }

    public void load() {
        for (String path : operationPaths) {
            try {
                Operation operation = (Operation) Class.forName(path).getConstructor().newInstance();
                operationByName.put(operation.getName(), operation);
            } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException | ClassNotFoundException | InstantiationException e) {
                throw new WrongOperationPathException(e);
            }
        }
    }

    public Operation getByName(String name) {
        return operationByName.get(name);
    }
}

