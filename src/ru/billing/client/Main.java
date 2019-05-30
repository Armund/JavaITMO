package ru.billing.client;

import ru.billing.WorkArray;
import ru.billing.exception.*;
import ru.billing.stocklist.*;
import ru.billing.sync.*;

import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception {

        // Код для выполнения различных заданий лабораторных работ.

        GenericItem A = new GenericItem(3, "Shade", 4.5f);
        GenericItem B = new GenericItem(123, "Global", 12.12f);
        GenericItem C = new GenericItem(321, "burger", 123.321f, B);
        B.setCategory(Category.FOOD);

        A.printAll();
        B.printAll();
        C.printAll();

        FoodItem FA = new FoodItem(1, "Shades", 4.55f);
        TechnicalItem TA = new TechnicalItem(2, "Sansara", 77.7f);
        FoodItem FB = new FoodItem(5, "Shades", 4.55f);

        GenericItem[] mass = {FA, TA};
        for (int i = 0; i < 2; i++) {
            mass[i].printAll();
        }

        System.out.println(FB.equals(FA));

        FoodItem FC = (FoodItem) FA.clone();
        System.out.println(FC.equals(FA));

        GenericItem D = (GenericItem) C.clone();
        System.out.println(D.equals(C));


        GenericItem e = new GenericItem();
        GenericItem r = new GenericItem();
        GenericItem g = new GenericItem();
        e.printAll();
        r.printAll();
        g.printAll();
        FoodItem rer = new FoodItem(20, "qwerty", 213);
        rer.printAll();

        Integer[] intArr = {10, 20, 15};
        Float[] floatArr = new Float[2];
        for (int i = 0; i < 2; i++) {
            floatArr[i] = 1.1f + i;
        }

        WorkArray insWorkArrayInt = new WorkArray(intArr);
        WorkArray insWorkArrayFloat = new WorkArray(floatArr);
        System.out.println(insWorkArrayInt.sum());
        System.out.println(insWorkArrayFloat.sum());

        String line = "Конфеты ’Маска’    ;   45   ;   120";
        String[] item_fld = line.split("\\s*[-;:]\\s*");
        FoodItem FI = new FoodItem(item_fld[0],
                Float.parseFloat(item_fld[1]), Short.parseShort(item_fld[2]));
        FI.printAll();
        //----------------------------------------------------------------------------
        ItemCatalog IC = new ItemCatalog();
        IC.addItem(A);
        IC.addItem(B);
        IC.addItem(C);
        IC.addItem(e);
        IC.addItem(r);
        IC.addItem(g);
        IC.addItem(D);
        IC.addItem(FI);
        IC.addItem(FA);
        IC.addItem(FB);

        long begin = new Date().getTime();
        for (int i = 0; i < 10000000; i++) IC.findItemByID(10);
        long end = new Date().getTime();
        System.out.println("In HashMap: " + (end - begin));
        begin = new Date().getTime();
        for (int i = 0; i < 10000000; i++) IC.findItemByIDAL(10);
        end = new Date().getTime();
        System.out.println("In ArrayList: " + (end - begin));

        CatalogLoader loader = new CatalogStubLoader();
        try {
            loader.load(IC);
        } catch (CatalogLoadException ex) {
            ex.printStackTrace();
        }
        IC.printItems();

        // get a number as integer
        Integer x = new Integer(123456);

        // get a number as float
        Float y = new Float(9876f);

        // print their value as double
        System.out.println("x as integer :" + x
                + ", x as double:" + x.doubleValue());
        System.out.println("y as float::" + y
                + ", y as double:" + y.doubleValue());


        long begin1 = new Date().getTime();
        for (int i = 0; i < 10000; i++) IC.summaryHash();
        long end1 = new Date().getTime();
        System.out.println("In HashMap: " + (end1 - begin1));
        begin1 = new Date().getTime();
        for (int i = 0; i < 10000; i++) IC.summaryArray();
        end1 = new Date().getTime();
        System.out.println("In ArrayList: " + (end1 - begin1));



    }
}