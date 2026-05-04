package io.github.David_Rn01.API_OFC.model;

public enum Role {
    ADMIN("admin"),
    DRIVER("driver"),
    STUDENT("student");

    private String role;

    Role(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
