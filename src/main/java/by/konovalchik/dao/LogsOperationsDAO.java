package by.konovalchik.dao;

import by.konovalchik.entity.Operation;
import by.konovalchik.entity.User;

import java.util.List;

public interface LogsOperationsDAO {

    void saveOperation(double num1, double num2, String operation, double result, User user);
    List<Operation> showLogs();
    List<Operation> showLogsByLogin(String login);

}
