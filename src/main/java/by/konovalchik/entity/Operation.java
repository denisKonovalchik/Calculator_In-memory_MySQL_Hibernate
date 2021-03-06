package by.konovalchik.entity;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.junit.jupiter.api.Disabled;

import javax.persistence.*;

@Entity
@Table(name = "log_operations")
public class Operation {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private double num1;
private double num2;
private String operation;
private double result;
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name="user_id")
@OnDelete(action = OnDeleteAction.CASCADE)
private User user;


    public Operation(int id, double num1, double num2, String operation, double result, User user) {
        this.id = id;
        this.num1 = num1;
        this.num2 = num2;
        this.operation = operation;
        this.result = result;
        this.user = user;
    }


    public Operation(double num1, double num2, String operation, double result, User user) {
        this.num1 = num1;
        this.num2 = num2;
        this.operation = operation;
        this.result = result;
        this.user = user;
    }

    public Operation(double num1, double num2, String operation, double result) {
        this.num1 = num1;
        this.num2 = num2;
        this.operation = operation;
        this.result = result;
    }


    public Operation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }


    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }


    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }


    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", num1=" + num1 +
                ", num2=" + num2 +
                ", operation='" + operation + '\'' +
                ", result=" + result +
                ", user=" + user +
                '}';
    }
}
