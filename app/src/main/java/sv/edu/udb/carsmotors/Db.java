package sv.edu.udb.carsmotors;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Db extends SQLiteOpenHelper {

    public static final String DBNAME="Cars motorDB5.db";

    public Db(Context context) {
        super(context, "Cars motorDB5.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table Usuarios( IdUsuario INTEGER primary key autoincrement ,Nombres TEXT,Apellidos TEXT,Email TEXT," +
                "User TEXT UNIQUE,Password TEXT,Tipo TEXT )");
        MyDB.execSQL("create Table Marcas( IdMarcas INTEGER primary key autoincrement, Nombre TEXT )");
        MyDB.execSQL("create Table Colores( IdColores INTEGER primary key autoincrement, Descripcion TEXT )");
        MyDB.execSQL("create Table TipoAutomovil( IdTipoAutomovil INTEGER primary key autoincrement, Descripcion TEXT )");
        MyDB.execSQL("create Table Automovil( IdAutomovil INTEGER primary key autoincrement, Modelo TEXT,NumeroVin TEXT,NumeroChasis TEXT" +
                ",NumeroMotor TEXT,NumeroAsientos INTEGER, anio TEXT,CapacidadAsientos INTEGER,Precio NUMERIC,UriImg TEXT,Descripcion TEXT ,IdMarcas INTEGER REFERENCES Marcas(IdMarcas)," +
                "IdTipoAutomovil INTEGER REFERENCES TipoAutomovil(IdTipoAutomovil),IdColores INTEGER REFERENCES Colores(IdColores))");
        MyDB.execSQL("create Table FavoritosAutomovil( IdFavoritosAutomovil INTEGER primary key autoincrement, IdUsuario INTEGER REFERENCES Usuarios(IdUsuario)," +
                "IdTipoAutomovil INTEGER REFERENCES TipoAutomovil(IdTipoAutomovil),FechaAgregado TEXT )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists Usuarios");
        MyDB.execSQL("drop Table if exists Marcas");
        MyDB.execSQL("drop Table if exists Colores");
        MyDB.execSQL("drop Table if exists TipoAutomovil");
        MyDB.execSQL("drop Table if exists Automovil");
        MyDB.execSQL("drop Table if exists FavoritosAutomovil");
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

    public long InsertarColor(String Descripcion) {

        long id = 0;

        try {

            SQLiteDatabase MyDB = this.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("Descripcion", Descripcion);


            id = MyDB.insert("Colores", null, values);
        } catch (Exception ex) {
            ex.toString();
        }

        return id;
    }
    public long InsertarMarca(String Nombre) {

        long id = 0;

        try {

            SQLiteDatabase MyDB = this.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("Nombre", Nombre);


            id = MyDB.insert("Marcas", null, values);
        } catch (Exception ex) {
            ex.toString();
        }

        return id;
    }
    public long InsertarTipoAutomovil(String Descripcion) {

        long id = 0;

        try {

            SQLiteDatabase MyDB = this.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("Descripcion", Descripcion);


            id = MyDB.insert("TipoAutomovil", null, values);
        } catch (Exception ex) {
            ex.toString();
        }

        return id;
    }
    public long Insertarautomovil(String Modelo,String NumeroVin,String NumeroChasis,String NumeroMotor,Integer NumeroAsientos, String anio,Integer CapacidadAsientos ,Float Precio,String UriImg,String Descripcion) {

        long id = 0;

        try {

            SQLiteDatabase MyDB = this.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("Modelo", Modelo);
            values.put("NumeroVin", NumeroVin);
            values.put("NumeroChasis", NumeroChasis);
            values.put("NumeroMotor", NumeroMotor);
            values.put("NumeroAsientos", NumeroAsientos);
            values.put("anio", anio);
            values.put("Precio", Precio);
            values.put("CapacidadAsientos", CapacidadAsientos);
            values.put("UriImg", UriImg);
            values.put("Descripcion", Descripcion);


            id = MyDB.insert("Automovil", null, values);
        } catch (Exception ex) {
            ex.toString();
        }

        return id;
    }

    public ArrayList<Automovil_Class> mostrarAutomoviles() {

        SQLiteDatabase db = this.getWritableDatabase();

        ArrayList<Automovil_Class> listaCoches = new ArrayList<>();
        Automovil_Class automovil;
        Cursor cursorAutomoviles;

        cursorAutomoviles = db.rawQuery("SELECT * FROM " + "Automovil" + " ORDER BY Modelo ASC", null);

        if (cursorAutomoviles.moveToFirst()) {
            do {
                automovil = new Automovil_Class();
                automovil.setId(cursorAutomoviles.getInt(0));
                automovil.setModelo(cursorAutomoviles.getString(1));
                automovil.setNumeroVin(cursorAutomoviles.getString(2));
                automovil.setNumeroChasis(cursorAutomoviles.getString(3));
                automovil.setNumeroMotor(cursorAutomoviles.getString(4));
                automovil.setNumeroasientos(cursorAutomoviles.getInt(5));
                automovil.setAnio(cursorAutomoviles.getString(6));
                automovil.setCapacidadAsientos(cursorAutomoviles.getInt(7));
                automovil.setPrecio(cursorAutomoviles.getFloat(8));

                listaCoches.add(automovil);
            } while (cursorAutomoviles.moveToNext());
        }

        cursorAutomoviles.close();

        return listaCoches;
    }

    public ArrayList<Marca_Class> mostrarMarcas() {

        SQLiteDatabase db = this.getWritableDatabase();

        ArrayList<Marca_Class> listaMarcas = new ArrayList<>();
        Marca_Class marca;
        Cursor cursorMarcas;

        cursorMarcas = db.rawQuery("SELECT * FROM " + "Marcas" + " ORDER BY Nombre ASC", null);

        if (cursorMarcas.moveToFirst()) {
            do {
                marca = new Marca_Class();
                marca.setId(cursorMarcas.getInt(0));
                marca.setNombre(cursorMarcas.getString(1));

                listaMarcas.add(marca);
            } while (cursorMarcas.moveToNext());
        }

        cursorMarcas.close();

        return listaMarcas;
    }

    public ArrayList<Color_Class> mostrarColores() {

        SQLiteDatabase db = this.getWritableDatabase();

        ArrayList<Color_Class> listaColores = new ArrayList<>();
        Color_Class color;
        Cursor cursorColores;

        cursorColores = db.rawQuery("SELECT * FROM " + "Colores" + " ORDER BY Descripcion ASC", null);

        if (cursorColores.moveToFirst()) {
            do {
                color = new Color_Class();
                color.setId(cursorColores.getInt(0));
                color.setDescripcion(cursorColores.getString(1));

                listaColores.add(color);
            } while (cursorColores.moveToNext());
        }

        cursorColores.close();

        return listaColores;
    }

    public ArrayList<TipoCoche_Class> mostrarTipoCoches() {

        SQLiteDatabase db = this.getWritableDatabase();

        ArrayList<TipoCoche_Class> listaTipos = new ArrayList<>();
        TipoCoche_Class tipo;
        Cursor cursorTipos;

        cursorTipos = db.rawQuery("SELECT * FROM " + "TipoAutomovil" + " ORDER BY Descripcion ASC", null);

        if (cursorTipos.moveToFirst()) {
            do {
                tipo = new TipoCoche_Class();
                tipo.setId(cursorTipos.getInt(0));
                tipo.setDescripcion(cursorTipos.getString(1));

                listaTipos.add(tipo);
            } while (cursorTipos.moveToNext());
        }

        cursorTipos.close();

        return listaTipos;
    }

    public ArrayList<Usuario_Class> mostrarUsuarios() {

        SQLiteDatabase db = this.getWritableDatabase();

        ArrayList<Usuario_Class> listaUsuarios = new ArrayList<>();
        Usuario_Class usuario;
        Cursor cursorUsuarios;

        cursorUsuarios = db.rawQuery("SELECT * FROM " + "Usuarios" + " ORDER BY Nombres ASC", null);

        if (cursorUsuarios.moveToFirst()) {
            do {
                usuario = new Usuario_Class();
                usuario.setId(cursorUsuarios.getInt(0));
                usuario.setNombre(cursorUsuarios.getString(5));
                usuario.setApellido(cursorUsuarios.getString(2));

                listaUsuarios.add(usuario);
            } while (cursorUsuarios.moveToNext());
        }

        cursorUsuarios.close();

        return listaUsuarios;
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
