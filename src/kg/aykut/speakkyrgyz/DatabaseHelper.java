package kg.aykut.speakkyrgyz;

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

    private static final int DATABASE_VERSION = 105;


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

        String str[] = new String[]{"Greeting","General", "Transport","Eating out","Numbers"};
        ItemsModel itemsModel[][] = new ItemsModel[5][12];

        itemsModel[0][0] = new ItemsModel("Hello", 					"Салам", 					"Salam",						"salam");
        itemsModel[0][1] = new ItemsModel("How are you?", 			"Кандайсыз?",				"Kandaisyz?",					"kanday");
        itemsModel[0][2] = new ItemsModel("I'm fine", 				"Мен жакшы",				"Men jakshy",					"jakwy");
        itemsModel[0][3] = new ItemsModel("What's your name?", 		"Сиздин атыңыз ким?",		"Sizdin atyngyz kim?",			"atynyz");
        itemsModel[0][4] = new ItemsModel("My name is ...", 		"Менин атым ...",			"Menin atym ...",				"atym");
        itemsModel[0][5] = new ItemsModel("Good luck",	 			"Ийгилик",					"Igilik",						"luck");
        itemsModel[0][6] = new ItemsModel("Good bye", 				"Жакшы бар",				"jakshy bar",					"bye");
        itemsModel[0][7] = new ItemsModel("See you",	 			"Көрүшкөнчө",				"Gorushkoncho",					"seeyou");
        itemsModel[0][8] = new ItemsModel("Take care",	 			"Өзүңдү жакшы кара",		"Ozungdu jakshy kara",			"care");
        itemsModel[0][9] = new ItemsModel("Do you speak english?", 	"Англисче сүйлөй аласызбы?","Anglische suiloi alasyzby?",	"english");
        itemsModel[0][10] = new ItemsModel("Yes", 					"Ооба",						"Ooa",							"yes");
        itemsModel[0][11] = new ItemsModel("No", 					"Жок",						"Jok",							"no");
        
        itemsModel[1][0] = new ItemsModel("Excuse me",	 					"Кечиресиз",							"Kechiresiz",						"audio10");
        itemsModel[1][1] = new ItemsModel("I need help", 					"Мага жардам керек", 					"Maga jardam kerek",				"audio11");
        itemsModel[1][2] = new ItemsModel("Where is hotel?", 				"Мейманкана каерде?",					"Meimankana kayerde?",				"audio12");
        itemsModel[1][3] = new ItemsModel("How far is it from here?", 		"Ал канча алыстыкта?",					"Al kancha alystykta?",				"audio13");
        itemsModel[1][4] = new ItemsModel("Do you understand?", 			"Түшүндүңүзбү?",						"Tushundunguzbu?",					"audio14");
        itemsModel[1][5] = new ItemsModel("I don't understand?", 			"Мен түшүнбөдүм",						"Men tushunbodum",					"audio15");
        itemsModel[1][6] = new ItemsModel("I understand",	 				"Мен түшүндүм",							"Men tushundum",					"audio16");
        itemsModel[1][7] = new ItemsModel("Thank you", 						"Рахмат",								"Rahmat",							"audio17");
        itemsModel[1][8] = new ItemsModel("May I use your phone?",	 		"Телефонуңузду колдонсом болобу?",		"Telefonunguzdu koldonsom bolobu?",	"audio18");
        itemsModel[1][9] = new ItemsModel("What's this?", 					"Бул эмне?",							"Bul emne?",						"audio19");
        itemsModel[1][10] = new ItemsModel("What does this mean?", 			"Бул эмнени түшүндүрөт?",				"Bul emneni tushundurot?",			"audio110");
        itemsModel[1][11] = new ItemsModel("Where is the toilet?", 			"Ажаткана каерде?",						"Ajatkana kaerde?",					"audio111");
        
        itemsModel[2][0] = new ItemsModel("Airport",					"Абамайданы",				"Abamaidany",					"audio20");
        itemsModel[2][1] = new ItemsModel("Bus station",				"Автобекет",				"Avtobeket",			  		"audio21");
        itemsModel[2][2] = new ItemsModel("Plane",						"Учак",						"Uchak",				  		"audio22");
        itemsModel[2][3] = new ItemsModel("Car",						"Унаа",						"Unaa",			  	 			"audio23");
        itemsModel[2][4] = new ItemsModel("Taxi",						"Такси",					"Taxi",				  			"audio24");
        itemsModel[2][5] = new ItemsModel("Bus stop",					"Аялдама",					"Ayaldama",						"audio25");
        itemsModel[2][6] = new ItemsModel("I'm lost",					"Мен адашып калдым",		"Men adashyp kaldym",	  		"audio26");
        itemsModel[2][7] = new ItemsModel("Please put the meter on",	"Эсепти баштатып коёсузбу",	"Esepti bashtatyp koyosuzbu?",	"audio27");
        itemsModel[2][8] = new ItemsModel("Please stop here",			"Токтотуп коёсузбу",		"Toktotup koyosuzbu",	  		"audio28");
        itemsModel[2][9] = new ItemsModel("How much is it to ...?",		"... канча болот?",			"... kancha bolot?",  	 		"audio29");
        itemsModel[2][10] = new ItemsModel("Rental car",				"Ижара унаа",				"Ijara unaa",		  			"audio210");
        itemsModel[2][11] = new ItemsModel("How do I get to ...?",		"... кантип барам?",		"... kantip baram?",	  		"audio211");
        
        itemsModel[3][0] = new ItemsModel("Food", 				"Тамак", 				"Tamak",					"audio300");
        itemsModel[3][1] = new ItemsModel("Meat", 				"Эт", 					"Et",						"audio301");
        itemsModel[3][2] = new ItemsModel("Chicken",			"Тоок",					"Took",						"audio302");
        itemsModel[3][3] = new ItemsModel("Fish", 				"Балык", 				"Balyk",					"audio303");
        itemsModel[3][4] = new ItemsModel("Rice", 				"Күрүч", 				"Guruch",					"audio304");
        itemsModel[3][5] = new ItemsModel("Spoon", 				"Кашык", 				"Kashyk",					"audio305");
        itemsModel[3][6] = new ItemsModel("Knife", 				"Бычак", 				"Bychak",					"audio306");
        itemsModel[3][7] = new ItemsModel("Can I have a menu?",	"Меню алсам болобу?",   "Menu alsam bolobu?",		"audio307");
        itemsModel[3][8] = new ItemsModel("I'm hungry", 		"Курсагым ачты", 		"Kursagym achty",			"audio308");
        itemsModel[3][9] = new ItemsModel("I'm thirsty", 		"Суусадым",		 		"Suusadym",					"audio309");
        itemsModel[3][10] = new ItemsModel("I love this dish", 	"Бул тамак мага жакты", "Bul tamak maga jakty",		"audio310");
        itemsModel[3][11] = new ItemsModel("I'm full", 			"Жедим",		 		"Jedim",					"audio311");
        
        itemsModel[4][0] = new ItemsModel("Zero", 				"Нөл", 					"Nol",					"audio400");
        itemsModel[4][1] = new ItemsModel("One", 				"Бир", 					"Bir",					"audio401");
        itemsModel[4][2] = new ItemsModel("Two",				"Эки", 					"Eki",					"audio402");
        itemsModel[4][3] = new ItemsModel("Three", 				"Үч", 					"Uch",					"audio403");
        itemsModel[4][4] = new ItemsModel("Four", 				"ТӨрт", 				"Tort",					"audio404");
        itemsModel[4][5] = new ItemsModel("Five", 				"Беш", 					"Besh",					"audio405");
        itemsModel[4][6] = new ItemsModel("Six", 				"Алты", 				"Alty",					"audio406");
        itemsModel[4][7] = new ItemsModel("Seven", 				"Жети", 				"Jeti",					"audio407");
        itemsModel[4][8] = new ItemsModel("Eight", 				"Сегиз", 				"Segiz",				"audio408");
        itemsModel[4][9] = new ItemsModel("Nine", 				"Тогуз", 				"Toguz",				"audio409");
        itemsModel[4][10] = new ItemsModel("Ten", 				"Он", 				    "On",					"audio410");
        itemsModel[4][11] = new ItemsModel("Eleven", 			"Он бир", 			    "On bir",				"audio411");
        
        for(int i =0; i<5;i++){

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
