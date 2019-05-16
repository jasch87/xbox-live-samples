// Copyright (c) Microsoft Corporation
// Licensed under the MIT license. See LICENSE file in the project root for full license information.

package xbl.sample.android;

import xbl.sample.android.views.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private static final String TAG = "Android Sample";

    // Used to load the 'native-lib' library on application startup.
    static { System.loadLibrary("native-lib"); }

    private native void InitializeGame();
    private native void CleanupGame();

    private static UpdateThread updateThread = null;

    public IdentityView identityView;
    public MenuView menuView;
    public ConsoleView consoleView;
    public TextView showFPS;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        identityView = new IdentityView(this);
        menuView = new MenuView(this);
        consoleView = new ConsoleView(this);
        showFPS = findViewById(R.id.text_FPS);

        if (updateThread == null)
        {
            updateThread = new UpdateThread(this);
        }

        InitializeGame();

        updateThread.setRunning(true);
        updateThread.start();

        identityView.identityLayer.SignInUserSilently();
    }

    @Override
    protected void onDestroy()
    {
        try
        {
            updateThread.setRunning(false);
            updateThread.join();
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        CleanupGame();

        super.onDestroy();
    }

    public void Update(double dt)
    {
        showFPS.setText(getString(R.string.text_FPS, updateThread.getAverageFPS()));
        //identityView.Update(dt); //No need for it at the moment
        menuView.Update(dt);
    }

    public String GetLocalStoragePath()
    {
        return this.getFilesDir().getPath();
    }
}