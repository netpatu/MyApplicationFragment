package test.zlive.grtn.com.myapplicationfragment.datasource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by hp on 2017/12/18.
 */

public class TaskLocalDataSource {
    private Context context;
    SQLiteDatabase sqLiteDatabase;

    /**
     * getWritableDatabase : Create and/or open a database that will be used for reading and writing
     * （这个方法一旦被执行，数据库即将被打开：SqliteHelper对象的onCreate ，onUpgrade ，或onOpen方法将被调用)
     * <p>
     * getReadableDatabase：一般来说这个方法返回的数据库对象和上面的一样，可以读写。但是在某些情况下，系统要求数据库此时只允许读，例如本地磁盘满了。
     * 这个时候这个方法返回一个只允许读的数据库对象。如果未来磁盘扩容了，那么它又返回一概可读可写的数据库对象。
     * <p>
     * 因此getReadableDatabase比getWritableDatabase更加安全
     */
    public TaskLocalDataSource() {
        sqLiteDatabase = new MySqliteHelper(context).getReadableDatabase();
    }

    /**
     * 如果contentValues 没有设定值时，拿nullColumnHack当作默认值。
     * SQL doesn't allow inserting a completely empty row without naming at least one column name.
     * 不允许插入一个空行而且这行一个字段名称都没有命名(这行数据为空,字段名字为空)
     */
    public void saveTask(Task task) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(MySqliteHelper.COLUMN_NAME_ENTRY_ID, task.getmId());
        contentValues.put(MySqliteHelper.COLUMN_NAME_TITLE, task.getmTitle());
        contentValues.put(MySqliteHelper.COLUMN_NAME_DESCRIPTION, task.getmDesc());
        contentValues.put(MySqliteHelper.COLUMN_NAME_COMPLETED, task.ismComplete());
        contentValues.put(MySqliteHelper.COLUMN_NAME_TIME, task.getTime());
        sqLiteDatabase.insert(MySqliteHelper.TABLE_NAME, "", contentValues);
    }

    /**
     * @param taskId
     */
    public void delete(String taskId) {
        String selection = MySqliteHelper.COLUMN_NAME_ENTRY_ID + " LIKE ?";
        String[] args = {taskId};
        sqLiteDatabase.delete(MySqliteHelper.TABLE_NAME, selection, args);
    }

    /**
     * @param task
     */
    public void completeTask(Task task) {
        ContentValues contentValues = new ContentValues();

        String selection = MySqliteHelper.COLUMN_NAME_ENTRY_ID + "LIKE ?";
        String[] whereArgs = {String.valueOf(task.getmId())};

        sqLiteDatabase.update(MySqliteHelper.TABLE_NAME, contentValues, selection, whereArgs);
    }

    /**
     * columns : A list of which columns to return;
     * groupBy : A filter declaring how to group rows,passing null cause the row to not be grouped
     * having : A filter declare which row groups to include in the cursor.
     * Passing null will cause all row groups to be included, and is required when row grouping is not being used.
     */
    public void getTask(String taskId) {
        String[] columns = {MySqliteHelper.COLUMN_NAME_ENTRY_ID};
        String selection = MySqliteHelper.COLUMN_NAME_ENTRY_ID + "LIKE ?";
        String[] selectionArgs = {taskId};
        String groupBy = null;
        String having = "";
        String orderBy = "";
        String limit = "";

        Cursor cursor = sqLiteDatabase.query(MySqliteHelper.TABLE_NAME, columns, selection, selectionArgs, groupBy, having, orderBy, limit);
    }
}
