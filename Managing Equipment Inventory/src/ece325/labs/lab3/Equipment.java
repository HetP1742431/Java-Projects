package ece325.labs.lab3;

public abstract class Equipment {
    private String type; // variable to store the type of the equipment

    public Equipment(String type) {
        this.type = type;
    }

    public String toString() {
        return type; // provide a custom String representation 
    }
}