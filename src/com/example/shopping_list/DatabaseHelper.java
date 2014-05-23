package com.example.shopping_list;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String TABLE_GROUP = "groups";
    public static final String TABLE_ITEMS = "items";

    public static final String COLUMN_ID = "_id";

    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_TRANSLATION = "translation";
    public static final String COLUMN_TRANSCRIPT = "transcript";
    public static final String COLUMN_AUDIO = "audio";

    public static final String COLUMN_GROUP_ID = "group_id";

    private static final String DATABASE_NAME = "education";

    private static final int DATABASE_VERSION = 103;


    private static final String TABLE_CREATE_GROUP = "create table "
            + TABLE_GROUP + "(" + COLUMN_ID
            + " integer primary key autoincrement, "
            + COLUMN_NAME
            + " text not null);";

    private static final String TABLE_CREATE_ITEM = "create table "
            + TABLE_ITEMS + "(" + COLUMN_ID
            + " integer primary key autoincrement, "
            + COLUMN_GROUP_ID +
            " integer not null, "
            + COLUMN_TRANSLATION
            + " text, "
            + COLUMN_TRANSCRIPT
            + " text, "
            + COLUMN_AUDIO
            + " text, "
            + COLUMN_NAME
            + " text not null);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLE_CREATE_GROUP);
        sqLiteDatabase.execSQL(TABLE_CREATE_ITEM);

        String str[] = new String[]{"Greeting","Transport","Eating out","Numbers"};
        ItemsModel itemsModel[][] = new ItemsModel[4][12];

        itemsModel[0][0] = new ItemsModel("Hello", 					"Салам", 					"Salam",						"audio1");
        itemsModel[0][1] = new ItemsModel("How are you?", 			"Кандайсыз?",				"Kandaisyz?",					"kanday");
        itemsModel[0][2] = new ItemsModel("I'm fine", 				"Мен жакшы",				"Men zhakshy",					"jakwy");
        itemsModel[0][3] = new ItemsModel("What's your name?", 		"Сиздин атыңыз ким?",		"Sizdin atynyz kim?",			"atynyz");
        itemsModel[0][4] = new ItemsModel("My name is ...", 		"Менин атым ...",			"Menin atym ...",				"atym");
        itemsModel[0][5] = new ItemsModel("Good morning", 			"Кутман таң",				"Kutman tan",					"morning");
        itemsModel[0][6] = new ItemsModel("Good afteroon", 			"Кутман күн",				"Kutman kun",					"afternoon");
        itemsModel[0][7] = new ItemsModel("Good evening", 			"Кутман кеч",				"Kutman tan",					"evening");
        itemsModel[0][8] = new ItemsModel("Good night", 			"Кутман түн",				"Kutman tun",					"night");
        itemsModel[0][9] = new ItemsModel("Do you speak english?", 	"Англисче сүйл аласызбы?",	"Anglische suiloi alasyzby?",	"english");
        itemsModel[0][10] = new ItemsModel("Yes", 					"Ооба",						"Ooba",							"yes");
        itemsModel[0][11] = new ItemsModel("No", 					"Жок",						"Zhok",							"no");
        
        itemsModel[1][0] = new ItemsModel("Airport",			"Абамайданы",			"Abamaidany",				"airport");
        itemsModel[1][1] = new ItemsModel("Bus station",		"Автобекет",			"Avtobeket",			  	"station");
        itemsModel[1][2] = new ItemsModel("Plane",				"Учак",					"uchak",				  	"plane");
        itemsModel[1][3] = new ItemsModel("Bus",				"Автобус",				"Avtobus",			  	 	"bus");
        itemsModel[1][4] = new ItemsModel("Taxi",				"Такси",				"Taksi",				  	"taxi");
        itemsModel[1][5] = new ItemsModel("I'm lost",			"Мен адашып калдым",	"Men adashyp kaldym",	  	"lost");
        itemsModel[1][6] = new ItemsModel("Airport",			"Абамайданы",			"Abamaidany",				"airport");
        itemsModel[1][7] = new ItemsModel("Bus station",		"Автобекет",			"Avtobeket",			  	"station");
        itemsModel[1][8] = new ItemsModel("Plane",				"Учак",					"uchak",				  	"plane");
        itemsModel[1][9] = new ItemsModel("Bus",				"Автобус",				"Avtobus",			  	 	"bus");
        itemsModel[1][10] = new ItemsModel("Taxi",				"Такси",				"Taksi",				  	"taxi");
        itemsModel[1][11] = new ItemsModel("I'm lost",			"Мен адашып калдым",	"Men adashyp kaldym",	  	"lost");
        
        itemsModel[2][0] = new ItemsModel("Food", 				"Тамак", 				"Tamak",					"food");
        itemsModel[2][1] = new ItemsModel("Meat", 				"Эт", 					"Et",						"meat");
        itemsModel[2][2] = new ItemsModel("Chicken",			"Тоок",					"Took",						"chicken");
        itemsModel[2][3] = new ItemsModel("Fish", 				"Балык", 				"Balyk",					"fish");
        itemsModel[2][4] = new ItemsModel("Rice", 				"Күрүч", 				"Kuruch",					"rice");
        itemsModel[2][5] = new ItemsModel("Spoon", 				"Кашык", 				"Kashyk",					"spoon");
        itemsModel[2][6] = new ItemsModel("Knife", 				"Бычак", 				"Bychak",					"knife");
        itemsModel[2][7] = new ItemsModel("Can I have a menu?",	"Меню алсам болобу?",   "Menu alsam bolobu?",		"menu");
        itemsModel[2][8] = new ItemsModel("I'm hungry", 		"Курсагым ачты", 		"Kursagym achty",			"hungry");
        itemsModel[2][9] = new ItemsModel("I'm full", 			"Жедим",		 		"Zhedim",					"full");
        itemsModel[2][10] = new ItemsModel("I love this dish", 	"Бул тамак мага жакты", "Bul tamak maga zhakty",	"dish");
        itemsModel[2][11] = new ItemsModel("I love this dish", 	"Бул тамак мага жакты", "Bul tamak maga zhakty",	"dish");
        
        itemsModel[3][0] = new ItemsModel("Zero", 				"НӨл", 					"Nol",					"zero");
        itemsModel[3][1] = new ItemsModel("One", 				"Бир", 					"Bir",					"one");
        itemsModel[3][2] = new ItemsModel("Two",				"Эки", 					"Eki",					"two");
        itemsModel[3][3] = new ItemsModel("Three", 				"Үч", 					"Uch",					"three");
        itemsModel[3][4] = new ItemsModel("Four", 				"ТӨрт", 				"Tort",					"four");
        itemsModel[3][5] = new ItemsModel("Five", 				"Беш", 					"Besh",					"five");
        itemsModel[3][6] = new ItemsModel("Six", 				"Алты", 				"Alty",					"six");
        itemsModel[3][7] = new ItemsModel("Seven", 				"Жети", 				"Zheti",				"seven");
        itemsModel[3][8] = new ItemsModel("Eight", 				"Сегиз", 				"Segiz",				"eight");
        itemsModel[3][9] = new ItemsModel("Nine", 				"Тогуз", 				"Toguz",				"nine");
        itemsModel[3][10] = new ItemsModel("Ten", 				"Он", 				    "On",					"ten");
        itemsModel[3][11] = new ItemsModel("Eleven", 			"Он бир", 			    "On bir",				"eleven");
        
        for(int i =0; i<4;i++){

            ContentValues values = new ContentValues();
            values.put(DatabaseHelper.COLUMN_NAME,str[i]);
            long group_id = sqLiteDatabase.insert(DatabaseHelper.TABLE_GROUP,null,values);

            for(int j = 0 ; j<12; j++){
                ContentValues values1 = new ContentValues();

                values1.put(DatabaseHelper.COLUMN_NAME,itemsModel[i][j].getName());
                values1.put(DatabaseHelper.COLUMN_TRANSLATION,itemsModel[i][j].getTranslation());
                values1.put(DatabaseHelper.COLUMN_TRANSCRIPT,itemsModel[i][j].getTranscript());
                values1.put(DatabaseHelper.COLUMN_AUDIO,itemsModel[i][j].getAudio());
                values1.put(DatabaseHelper.COLUMN_GROUP_ID,group_id);

                sqLiteDatabase.insert(DatabaseHelper.TABLE_ITEMS,null,values1);
            }

        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_ITEMS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_GROUP);
        onCreate(sqLiteDatabase);

    }
}
