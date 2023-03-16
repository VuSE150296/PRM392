package com.example.roomdatabase.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.roomdatabase.dao.PersonDAO;
import com.example.roomdatabase.model.Person;

@Database(entities = {Person.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase sInstance;

    public static synchronized AppDatabase getInstance(Context context) {
        if (sInstance == null) {
            sInstance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "app_database")
                    .addMigrations(MIGRATION_1_2)
                    .build();
        }
        return sInstance;
    }

    private static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            // Xóa bảng cũ
            database.execSQL("DROP TABLE IF EXISTS person");

            // Tạo bảng mới với trường ID được tự động tạo
            database.execSQL("CREATE TABLE IF NOT EXISTS person (uid INTEGER PRIMARY KEY AUTOINCREMENT, first_name String, last_name String)");
        }
    };

    public abstract PersonDAO personDao();
}
