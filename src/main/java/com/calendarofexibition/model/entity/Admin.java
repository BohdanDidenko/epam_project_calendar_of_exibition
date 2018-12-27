package com.calendarofexibition.model.entity;

public class Admin extends User{
    private Boolean isActive;

    public Admin() {
    }

    public Admin(Integer id, String role, String username, String password, Boolean isActive) {
        super(id, role, username, password);
        this.isActive = isActive;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Admin)) return false;
        if (!super.equals(o)) return false;

        Admin admin = (Admin) o;

        return isActive != null ? isActive.equals(admin.isActive) : admin.isActive == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (isActive != null ? isActive.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return super.toString() +
                "isActive=" + isActive +
                '}';
    }
}
