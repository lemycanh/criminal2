package com.uni.officecriminal.dao;

import android.content.Context;

import com.uni.officecriminal.model.DaoMaster;

import org.apache.commons.io.IOUtils;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseOpenHelper;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class CriminalOpenHelper extends DatabaseOpenHelper {
    private Context context;

    public CriminalOpenHelper(Context context, String name, int version) {
        super(context, name, version);
        this.context = context;
    }

    @Override
    public void onCreate(Database db) {
        super.onCreate(db);
        DaoMaster.createAllTables(db, false);
        RunSql(db, "main.sql");
    }

    private void RunSql(Database db, String filename) {
        try {
            InputStream inputStream = context.getAssets().open(filename);
            List<String> lines = IOUtils.readLines(inputStream, StandardCharsets.UTF_8);
            for (String line : lines) {
                db.execSQL(line);
            }
        } catch (Exception e) {
            //
        }
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
        if (oldVersion == 2 && newVersion == 3) {
            RunSql(db, "upgrade3.sql");
        }
    }
}
