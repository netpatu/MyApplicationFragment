package test.zlive.grtn.com.myapplicationfragment.datasource;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hp on 2017/12/13.
 */

public class MySqliteHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSON = 1;

    public static final String DATABASE_NAME = "My.db";

    private static final String TEXT_TYPE = " TEXT";

    private static final String BOOLEAN_TYPE = " INTEGER";

    private static final String TIME_TYPE = " LONG";

    private static final String COMMA_SEP = ",";

    public static final String TABLE_NAME = "tasks";

    public static final String COLUMN_NAME_ENTRY_ID = "entryid";
    public static final String COLUMN_NAME_TITLE = "title";
    public static final String COLUMN_NAME_DESCRIPTION = "description";
    public static final String COLUMN_NAME_COMPLETED = "completed";
    public static final String COLUMN_NAME_TIME = "time";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_NAME_ENTRY_ID + TEXT_TYPE + " PRIMARY KEY," +
                    COLUMN_NAME_TITLE + TEXT_TYPE + COMMA_SEP +
                    COLUMN_NAME_DESCRIPTION + TEXT_TYPE + COMMA_SEP +
                    COLUMN_NAME_COMPLETED + BOOLEAN_TYPE +
                    COLUMN_NAME_TIME + TIME_TYPE +
                    " )";

    public MySqliteHelper(Context context) {
        this(context, DATABASE_NAME, null, DATABASE_VERSON);
    }

    /**
     * 创建一个帮助类去创建,打开和管理数据库,在这个方法执行后,数据库并没有真正创建或打开,直达getWritableDatabase(),getReadableDatabase() 两个方法其中一个被执行.
     *
     * @param context
     * @param name 数据库名字,如果是空则为内存数据库
     * @param factory 用来创建cursor对象,null 为默认值
     * @param version
     */
    public MySqliteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public MySqliteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //版本判断
//        sqLiteDatabase.delete("","")
    }
}
