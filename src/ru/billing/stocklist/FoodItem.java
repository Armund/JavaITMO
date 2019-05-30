package ru.billing.stocklist;

import java.util.Date;
import java.util.Objects;

public class FoodItem extends GenericItem {
    private Date dateOfIncome; // дата производства
    private short expires; // срок годности


    public FoodItem(int ID, String name, float price) {
        super(ID, name, price);
        setCategory(Category.FOOD);
    }

    public FoodItem(int ID, String name, float price, GenericItem analogID) {
        super(ID, name, price, analogID);
        setCategory(Category.FOOD);
    }

    public void printAll() {
        System.out.printf(
                "ID: %d , Name: %-20s , price:%5.2f, analogID: %d, category: %s, dateOfIncome: " +
                        "%tT%n, expires: %d\n",
                getID(), getName(), getPrice(), getAnalog(), getCategory(), dateOfIncome, expires);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FoodItem foodItem = (FoodItem) o;
        return expires == foodItem.expires &&
                Objects.equals(dateOfIncome, foodItem.dateOfIncome);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "FoodItem{" +
                "dateOfIncome=" + dateOfIncome +
                ", expires=" + expires +
                ", ID=" + getID() +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", analogID=" + getAnalog() +
                ", category=" + getCategory() +
                '}';
    }

    //----------------------------------------------------------------------------
    public FoodItem(String name, float price, FoodItem analog, Date date, short expires) {
        this.dateOfIncome = date;
        this.setName(name);
        this.setPrice(price);
        this.setAnalog(analog);
        this.expires = expires;
    }

    public FoodItem(String name, float price, short expires) {
        this(name, price, null, null, expires);
    }

    public FoodItem(String name) {
        this(name, 0, null, null, (short) 0);
    }

    public Date getDateOfIncome() {
        return dateOfIncome;
    }

    public void setDateOfIncome(Date dateOfIncome) {
        this.dateOfIncome = dateOfIncome;
    }

    public short getExpires() {
        return expires;
    }

    public void setExpires(short expires) {
        this.expires = expires;
    }
}
