package sv.edu.udb.carsmotors;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Db extends SQLiteOpenHelper {

    public static final String DBNAME="Cars motorDB1.db";

    public Db(Context context) {
        super(context, "Cars motorDB1.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table Usuarios( IdUsuario INTEGER primary key autoincrement,Nombres TEXT,Apellidos TEXT,Email TEXT," +
                "User TEXT,Password TEXT,Tipo TEXT UNIQUE )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists Usuarios");
    }
    public Boolean insertData( String Nombres,String Apellidos, String Email,String User,String Password, String Tipo ){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("Nombres", Nombres);
        contentValues.put("Apellidos", Apellidos);
        contentValues.put("Email", Email);
        contentValues.put("User", User);
        contentValues.put("Password", Password);
        contentValues.put("Tipo", Tipo);




        long result = MyDB.insert("Usuarios", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }
    public Boolean RevisarUsuario(String User) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from Usuarios where User = ?", new String[]{User});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }
    public Boolean RevisarUsuariosyContra(String User, String Password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from Usuarios where User = ? and Password = ? ", new String[] {User,Password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

}
