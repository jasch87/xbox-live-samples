// Copyright (c) Microsoft Corporation
// Licensed under the MIT license. See LICENSE file in the project root for full license information.

package xbl.sample.android.layers;

import xbl.sample.android.MainActivity;
import xbl.sample.android.R;
import xbl.sample.android.views.MenuView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Button;
import android.graphics.Color;

public class SocialUsersLayer
{
    private static final String TAG = "Social Users Layer";

    public native void InitializeNativeVars();

    public SocialProfileViewLayer m_profileViewLayer;

    private MainActivity m_activity;

    private Button[] m_buttonUser;

    public SocialUsersLayer(MainActivity activity)
    {
        m_activity = activity;

        m_profileViewLayer = new SocialProfileViewLayer(m_activity);
        m_buttonUser = new Button[10];

        // Create User Buttons
        for (int i = 0; i < 10; ++i)
        {
            m_buttonUser[i] = new Button(m_activity);
            m_buttonUser[i].setText(m_activity.getString(R.string.button_socialUserID, i));
            m_buttonUser[i].setTextColor(Color.BLACK);
            m_buttonUser[i].setBackgroundResource(android.R.drawable.btn_default);
            m_buttonUser[i].setHeight(48);
            m_buttonUser[i].setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View v)
                {

                }
            });
        }

        InitializeNativeVars();
    }

    public void Update(double dt)
    {

    }

    public void show(LinearLayout layout)
    {
        for (int i = 0; i < 10; ++i)
        {
            layout.addView(m_buttonUser[i]);
        }

        // Bind Menu Button
        {
            Button buttonMenuBack = m_activity.findViewById(R.id.button_MenuBack);
            buttonMenuBack.setText(R.string.button_socialMenu);
            buttonMenuBack.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View v)
                {
                    m_activity.menuView.changeLayer(MenuView.MVL_SOCIAL);
                }
            });

            buttonMenuBack.setVisibility(View.VISIBLE);
        }
    }
}