package xbl.sample.android.layers;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import xbl.sample.android.MainActivity;
import xbl.sample.android.R;
import xbl.sample.android.views.MenuView;

public class SocialProfileViewLayer
{
    private static final String TAG = "Social Profile View Layer";

    public native void InitializeNativeVars();

    private MainActivity m_activity;

    public SocialProfileViewLayer(MainActivity activity)
    {
        m_activity = activity;

        InitializeNativeVars();
    }

    public void show(LinearLayout layout)
    {
        // Bind Menu Button
        {
            Button buttonMenuBack = m_activity.findViewById(R.id.button_MenuBack);
            buttonMenuBack.setText(R.string.button_socialUsersMenu);
            buttonMenuBack.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View v)
                {
                    m_activity.menuView.changeLayer(MenuView.MVL_SOCIAL_USERS);
                }
            });

            buttonMenuBack.setVisibility(View.VISIBLE);
        }
    }
}