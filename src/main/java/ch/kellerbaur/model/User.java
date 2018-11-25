package ch.kellerbaur.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private List<String> roles = new ArrayList<>();

    public List<String> getRoles() {
        return roles;
    }

    public void addRole(final String role) {
        roles.add(role);
    }

    public void setRoles(final List<String> roles) {
        this.roles = roles;
    }

    public boolean isC3() {
        return roles.contains("C3.C3");
    }

    public boolean isClear() {
        return roles.contains("C3.CLEAR");
    }

    public boolean isInfodienst() {
        return roles.contains("C3.INFODIENST");
    }

    public boolean isTax() {
        return roles.contains("C3.TAX");
    }

    public boolean isSonda() {
        return roles.contains("C3.SONDA");
    }

    public boolean isSondm() {
        return roles.contains("C3.SONDM");
    }

    @Override
    public String toString() {
        return "user (roles = " + roles + ")";
    }

}
