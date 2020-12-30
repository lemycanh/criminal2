package com.uni.officecriminal;

import android.app.Application;

import com.uni.officecriminal.dao.CriminalOpenHelper;
import com.uni.officecriminal.model.DaoMaster;
import com.uni.officecriminal.model.DaoSession;

import org.greenrobot.greendao.database.Database;

public class CriminalApplication extends Application {
    private DaoSession daoSession;
    private static CriminalApplication instance;
    static final int SCHEMA_VERSION = 3;

    @Override
    public void onCreate() {
        super.onCreate();
        CriminalOpenHelper helper = new CriminalOpenHelper(this, "criminal", SCHEMA_VERSION);
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
        instance = this;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    public static CriminalApplication getInstance() {
        return instance;
    }
}
