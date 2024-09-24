package com.example.atcmanagement;

public class AuthenticationManager {
    public enum user_role {
        OWNER,
        ADMIN,
        USER
    }

    private static user_role role;

    public static user_role getRole() {
        return role;
    }

    public static void setRole(user_role role) {
        AuthenticationManager.role = role;
    }
}
