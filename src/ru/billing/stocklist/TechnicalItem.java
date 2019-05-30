package ru.billing.stocklist;

public class TechnicalItem extends GenericItem {
    private short warrantyTime; // гарантийный срок (суток)

    public TechnicalItem(int ID, String name, float price) {
        super(ID, name, price);
    }

    public TechnicalItem(int ID, String name, float price, GenericItem analogID) {
        super(ID, name, price, analogID);
    }

    public void printAll() {
        System.out.printf("ID: %d , Name: %-20s , price:%5.2f, analogID: %d, " +
                "category: %s, warrantyTime: %d \n",
                getID(), getName(), getPrice(), getAnalog(), getCategory(),warrantyTime);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TechnicalItem that = (TechnicalItem) o;
        return warrantyTime == that.warrantyTime;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "TechnicalItem{" +
                "warrantyTime=" + warrantyTime +
                ", ID=" + getID() +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", analogID=" + getAnalog() +
                ", category=" + getCategory() +
                '}';
    }
}
