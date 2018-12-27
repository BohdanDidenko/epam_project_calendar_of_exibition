package com.calendarofexibition.model.entity;

import java.io.Serializable;

public class SessionKey implements Serializable{
    private Integer id;
    private Long timeLogin;
    private Long timeOut;
    private User role;

    public SessionKey() {
    }

    public SessionKey(Integer id, Long timeLogin, Long timeOut, User role) {
        this.id = id;
        this.timeLogin = timeLogin;
        this.timeOut = timeOut;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getTimeLogin() {
        return timeLogin;
    }

    public void setTimeLogin(Long timeLogin) {
        this.timeLogin = timeLogin;
    }

    public Long getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Long timeOut) {
        this.timeOut = timeOut;
    }

    public User getRole() {
        return role;
    }

    public void setRole(User role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SessionKey)) return false;

        SessionKey that = (SessionKey) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getTimeLogin() != null ? !getTimeLogin().equals(that.getTimeLogin()) : that.getTimeLogin() != null)
            return false;
        if (getTimeOut() != null ? !getTimeOut().equals(that.getTimeOut()) : that.getTimeOut() != null) return false;
        return getRole() != null ? getRole().equals(that.getRole()) : that.getRole() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getTimeLogin() != null ? getTimeLogin().hashCode() : 0);
        result = 31 * result + (getTimeOut() != null ? getTimeOut().hashCode() : 0);
        result = 31 * result + (getRole() != null ? getRole().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
                "id=" + id +
                ", timeLogin=" + timeLogin +
                ", timeOut=" + timeOut +
                ", role=" + role +
                '}';
    }
}
