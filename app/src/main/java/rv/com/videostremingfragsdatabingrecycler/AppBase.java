package rv.com.videostremingfragsdatabingrecycler;

import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;

import java.io.File;
import java.util.HashMap;


/**
 * Created by USER3 on 1/17/2017.
 */

public class AppBase extends Application {

    Context context;
    public static HashMap<String, Typeface> fontCache = new HashMap<>();

    public static File cacheDir;

    @Override
    public void onCreate() {
        super.onCreate();



        context = this;

       // addFont(getResources().getString(R.string.font_name_helvertica), getResources().getString(R.string.font_helvertica));
       // addFont(getResources().getString(R.string.font_name_myriadpro_bold), getResources().getString(R.string.font_myriadpro_bold));
       // addFont(getResources().getString(R.string.font_name_myriadpro_regular), getResources().getString(R.string.font_myriadpro_regular));


        try {

            if (android.os.Environment.getExternalStorageState().equals(
                    android.os.Environment.MEDIA_MOUNTED)) {
                cacheDir = new File(android.os.Environment
                        .getExternalStorageDirectory().toString()
                        + "/Android/data/ae.lateston.uaecompanies/", "Temp");
            } else {
                cacheDir = getCacheDir();
            }
            if (!cacheDir.exists()) {
                //noinspection ResultOfMethodCallIgnored
                cacheDir.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void addFont(String alias, String fontName) {
        if (!fontCache.containsKey(alias)) {
            try {
                Typeface typeface = Typeface.createFromAsset(this.getAssets(), "fonts/" + fontName);
                fontCache.put(alias, typeface);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }






}
