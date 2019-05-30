package ru.billing.stocklist;

import ru.billing.exception.ItemAlreadyExistsException;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ItemCatalog {
    private HashMap<Integer, GenericItem> catalog = new HashMap<Integer, GenericItem>();
    private ArrayList<GenericItem> ALCatalog = new ArrayList<GenericItem>();

    public void addItem(GenericItem item) throws ItemAlreadyExistsException {
        if (findItemByID(item.ID)!=null){
            throw new ItemAlreadyExistsException();
        }
        catalog.put(item.getID(), item);
        // Добавляем товар в HashMap
        ALCatalog.add(item); // Добавляем тот же товар в ArrayList
    }

    public void printItems() {
        for (GenericItem i : ALCatalog) {
            System.out.println(i);
        }
    }

    public GenericItem findItemByID(int id) { //Если нет такого ID, возвращаем пустое значение
        if (!catalog.containsKey(id)) {
            return null;
        } else {

            return catalog.get(id);
        }
    }

    public GenericItem findItemByIDAL(int id) {
        for (GenericItem i : ALCatalog) {
            if (i.getID() == id) return i;
        }
        return null;
    }

    public double summaryHash () {
        double sum = 0;
        for (GenericItem value : catalog.values())
        {
            sum += value.getPrice();
        }
        return sum;
    }
    public double summaryArray () {
        double sum = 0;
        for (GenericItem value : ALCatalog)
        {
            sum += value.getPrice();
        }
        return sum;
    }
}
