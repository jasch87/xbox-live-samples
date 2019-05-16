package xbl.sample.android.layers;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import xbl.sample.android.MainActivity;
import xbl.sample.android.R;
import xbl.sample.android.views.MenuView;

import android.widget.TextView;
import android.widget.ImageView;

public class SocialProfileViewLayer
{
    private static final String TAG = "Social Profile View Layer";

    public native void InitializeNativeVars();

    private MainActivity m_activity;

    private ImageView m_imageViewGamerPic;
    private TextView m_textViewGamerTag;
    private TextView m_textViewGamerScore;

    public SocialProfileViewLayer(MainActivity activity)
    {
        m_activity = activity;

        // Setup GamerPic ImageView
        {
            m_imageViewGamerPic = m_activity.findViewById(R.id.pc_gamerPic);
        }

        // Setup GamerScore TextView
        {
            m_textViewGamerScore = m_activity.findViewById(R.id.pc_gamerScore);
        }

        // Setup GamerTag TextView
        {
            m_textViewGamerTag = m_activity.findViewById(R.id.pc_gamerTag);
        }

        InitializeNativeVars();
    }

    public void Update(double dt)
    {

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