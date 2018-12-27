package com.calendarofexibition.model.entity;

public class Consumer extends User{
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private Double spentMoney;
    private Double discount;

    public Consumer() {
    }

    public Consumer(Integer id, String role, String login, String password, String name,
                    String surname, String email, String phoneNumber, Double spentMoney, Double discount) {
        super(id, role, login, password);
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.spentMoney = spentMoney;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Double getSpentMoney() {
        return spentMoney;
    }

    public void setSpentMoney(Double spentMoney) {
        this.spentMoney = spentMoney;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Consumer)) return false;
        if (!super.equals(o)) return false;

        Consumer consumer = (Consumer) o;

        if (getName() != null ? !getName().equals(consumer.getName()) : consumer.getName() != null) return false;
        if (getSurname() != null ? !getSurname().equals(consumer.getSurname()) : consumer.getSurname() != null)
            return false;
        if (getEmail() != null ? !getEmail().equals(consumer.getEmail()) : consumer.getEmail() != null) return false;
        if (getPhoneNumber() != null ? !getPhoneNumber().equals(consumer.getPhoneNumber()) : consumer.getPhoneNumber() != null)
            return false;
        if (getSpentMoney() != null ? !getSpentMoney().equals(consumer.getSpentMoney()) : consumer.getSpentMoney() != null)
            return false;
        return getDiscount() != null ? getDiscount().equals(consumer.getDiscount()) : consumer.getDiscount() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getSurname() != null ? getSurname().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getPhoneNumber() != null ? getPhoneNumber().hashCode() : 0);
        result = 31 * result + (getSpentMoney() != null ? getSpentMoney().hashCode() : 0);
        result = 31 * result + (getDiscount() != null ? getDiscount().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + "{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", spentMoney=" + spentMoney +
                ", discount=" + discount +
                '}';
    }
}
