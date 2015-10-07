package com.mishobu.musicfiles;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_files);

        TextView textview = (TextView) findViewById(R.id.text_view);
        String[] columns = new String[] { MediaStore.Audio.Media.TITLE, MediaStore.Audio.Media.DURATION };
        Uri myTunes = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Cursor c = managedQuery(myTunes, columns, null, null, MediaStore.Audio.Media.DURATION);

        if(c.moveToFirst()) {
            String title;
            String Duration;
            do {
                title = c.getString(c.getColumnIndex(MediaStore.Audio.Media.TITLE));
                Duration = c.getString(c.getColumnIndex(MediaStore.Audio.Media.DURATION));

                textview.append(title + " - " + Duration + "\n");
            } while(c.moveToNext());
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_music_files, menu);
        return true;
    }
}
