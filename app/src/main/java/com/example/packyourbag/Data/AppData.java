package com.example.packyourbag.Data;

import android.app.Application;
import android.content.Context;

import com.example.packyourbag.Constants.MyConstants;
import com.example.packyourbag.Database.RoomDB;
import com.example.packyourbag.Models.Items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppData extends Application {
    RoomDB database;

    Context context;

    String category;

    public static final String LAST_VERSION ="LAST_VERSION";
    public static final int NEW_VERSION = 3;

    public AppData(RoomDB database){
        this.database = database;
    }

public AppData(RoomDB database, Context context){
        this.database = database;
        this.context = context;
}
public List<Items> getBasicData(){

        category = "Basic Needs";
        List<Items>basicItem=new ArrayList<>();
        basicItem.clear();
        basicItem.add(new Items("Visa",category,false));
        basicItem.add(new Items("Passport",category,false));
        basicItem.add(new Items("Tickets",category,false));
        basicItem.add(new Items("Wallet",category,false));
        basicItem.add(new Items("Driving License",category,false));
        basicItem.add(new Items("Currency",category,false));
        basicItem.add(new Items("House Key",category,false));
        basicItem.add(new Items("Book",category,false));
        basicItem.add(new Items("Travel Pillow",category,false));
        basicItem.add(new Items("Eye Patch",category,false));
        basicItem.add(new Items("Umbrella",category,false));
        basicItem.add(new Items("Note Book",category,false));
        return basicItem;
}
public List<Items> getPersonalCareData(){
        String[] data = {"Tooth-brush","Tooth-paste","Floss","Mouthwash","Shaving Cream","Razor Blade",
        "Soap","Fiber","Shampoo","Hair Conditional","Brush","Comb","Hair Dryer","Curling Iron","Hair Moulder",
        "Hair Clip","Moisturizer","Lip Cream","Contact Lens","Perfume","Deodorant","Makeup Materials",
        "Makeup Remover","Wet Wipes","Pad","Ear Stick","Cotton","Nail Polish","Nail Polish Remover","Tweezers","Nail Files","Sun Cream"};
        return prepareItemsList(MyConstants.PERSONAL_CARE_CAMEL_CASE,data);


}

public List<Items> getClothingData(){
        String[] data = {"Stockings","Underwear","Pajamas","T-Shirt","Casual Dress","Evening Dress","Shirt",
        "Cardigan","Vest","Jacket","Skirt","Trousers","Jeans","Shorts","Suit","Coat","Rain Coat",
        "Glove","Hat","Scarf","Bikini","Belt","Slipper","Sneakers","Casual Shoes","Heeled Shoes","Sport Wear"};

        return prepareItemsList(MyConstants.CLOTHING_CAMEL_CASE,data);
}

public List<Items> getBabyNeedsData(){
        String[] data = {"Snap suit","Outfit","Jump Suit","Baby Socks","Baby Hat","Baby pyjamas",
        "Baby Bottles","Baby Food Thermos","Baby Bottle Brushes","Brest-feeding Cover","Baby Bath Soap",
        "Baby bath Towel","Muslin","Blanket","Dribble Bibs","Baby Laundry Detergent","Breast Pump","Water Bottles",
        "Storage Container","Baby Food Spoon","Highchairs","Diaper","Wet Wipes","Baby Cotton","Baby Care Cover",
        "Baby Shampoo","Baby nail Scissors","Body Moisturize","Potty","Diaper Rash Cream"};

        return prepareItemsList(MyConstants.BABY_NEEDS_CAMEL_CASE,data);

}

public List<Items> getHealthData(){
        String[] data = {"Aspirin","Drugs Used","Vitamins Used","Lens Solutions","Hot Water Bag","First Aid Kit","Replacement Lens",
        "pain Relieve Spray"};

        return prepareItemsList(MyConstants.HEALTH_CAMEL_CASE,data);
}

public List<Items> getTechnologyData(){
        String[] data = {"Mobile phone","Phone Cover","E-Book Reader","Camera","Camera Charger",
        "Portable Speaker","Ipad(Tab)","HeadPhone"};
        return prepareItemsList(MyConstants.TECHNOLOGY_CAMEL_CASE,data);
}

public List<Items> getFoodData(){
        String[] data = {"Snack","Sandwich","Juice","Tea Bags","Coffee","Water","Thermos","Chips","Baby Foods"};
        return prepareItemsList(MyConstants.FOOD_CAMEL_CASE,data);
}

public List<Items> getBeachSuppliesData(){
        String[] data = {"Sea Glasses","Sea Bed","Suntan","Beach Umbrella","Sin Fins",
        "Beach Bag","Beach Towel"};
        return prepareItemsList(MyConstants.BEACH_SUPPLIES_CAMEL_CASE,data);

}

public List<Items> getCarSuppliesData(){
        String[] data = {"Pump","Car Jack","Spare Car Key","Accident Record Set","Auto Refrigerator","Car Cover",
                "Car Charger"};
        return prepareItemsList(MyConstants.CAR_SUPPLIES_CAMEL_CASE,data);
}

public List<Items> getNeedData(){
        String[] data={"Backpack","Daily Bags","Laundry Bag","Sewing kit","Travel Lock",
        "Luggage tag","Magazine","Sports Equipment","Important Number"};

        return prepareItemsList(MyConstants.NEEDS_CAMEL_CASE,data);

}
public List<Items> prepareItemsList(String category,String[] data){
      List<String> list = Arrays.asList(data);
      List<Items>dataList = new ArrayList<>();
      dataList.clear();

      for(int i = 0;i<list.size();i++)
      {
          dataList.add(new Items(list.get(i),category,false));

      }
      return dataList;
}
public List<List<Items>> getAllData(){
        List<List<Items>> listOfAllItems = new ArrayList<>();
        listOfAllItems.clear();
        listOfAllItems.add(getBasicData());
        listOfAllItems.add(getClothingData());
        listOfAllItems.add(getPersonalCareData());
        listOfAllItems.add(getBabyNeedsData());
        listOfAllItems.add(getHealthData());
        listOfAllItems.add(getTechnologyData());
        listOfAllItems.add(getFoodData());
        listOfAllItems.add(getBeachSuppliesData());
        listOfAllItems.add(getCarSuppliesData());
        listOfAllItems.add(getNeedData());
        return listOfAllItems;
}

public void persistAllData(){
       List<List<Items>> listOfAllItems = getAllData();
       for(List<Items> list:listOfAllItems){
           for(Items items:list)
           {
               database.mainDao().saveItem(items);
           }
       }
       System.out.println("Data added");
}

}
