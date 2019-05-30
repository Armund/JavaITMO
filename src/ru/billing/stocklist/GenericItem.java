package ru.billing.stocklist;

import java.util.Objects;

public class GenericItem implements Cloneable {

    protected int ID; // ID товара
    private String name; // Наименование товара
    private float price; //Цена товара
    private GenericItem analog;
    private Category category = Category.GENERAL;
    private static int currentID=0;

    public void printAll() {
        System.out.printf("ID: %d , Name: %-20s , price:%5.2f, category: %s ", ID,
                name, price, category);
        if (analog != null) {
            System.out.printf("analogID.ID: %d", analog.ID);
        }
        System.out.println();
    }

    public GenericItem(int ID, String name, float price) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.analog = null;
        this.ID = GenericItem.currentID++;
    }

    public GenericItem(int ID, String name, float price, GenericItem analog) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.analog = analog;
        this.ID = GenericItem.currentID++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenericItem that = (GenericItem) o;
        return ID == that.ID &&
                Float.compare(that.price, price) == 0 &&
                name.equals(that.name) &&
                Objects.equals(analog, that.analog) &&
                category == that.category;
    }


    @Override
    public Object clone() throws CloneNotSupportedException {
        if (analog != null) {
            return analog.clone();
        }
        return super.clone();
    }

    @Override
    public String toString() {
        return "GenericItem{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", analogID=" + analog +
                ", category=" + category +
                '}';
    }

    //----------------------------------------------------------------------------
    public GenericItem(String name, float price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.ID = GenericItem.currentID++;
    }

    public GenericItem(String name, float price, GenericItem analog) {
        this.name = name;
        this.price = price;
        this.analog = analog;
        this.ID = GenericItem.currentID++;
    }

    public GenericItem() {
        this.ID = GenericItem.currentID++;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public GenericItem getAnalog() {
        return analog;
    }

    public void setAnalog(GenericItem analog) {
        this.analog = analog;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public static int getCurrentID() {
        return currentID;
    }

    public static void setCurrentID(int currentID) {
        GenericItem.currentID = currentID;
    }
}

