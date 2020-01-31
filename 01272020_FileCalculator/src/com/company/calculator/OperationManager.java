package com.company.calculator;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

public class OperationManager {

    Map<Character, Operation> operationBySymbol;

    public OperationManager(List<String> operationPaths) {
        init(operationPaths);
    }

    private void init(List<String> operationPaths) {
        for (String path : operationPaths) {
            try {
                ModernOperations operation = (ModernOperations) Class.forName(path).getDeclaredConstructor().newInstance();
                operationBySymbol.put(operation.getSymbol(), operation);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
                throw new OperationNotFoundException();
            }
        }
    }

    public Operation get(char operation) {

        return operationBySymbol.get(operation);
    }
}
