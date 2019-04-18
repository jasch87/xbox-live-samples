// Copyright (c) Microsoft Corporation
// Licensed under the MIT license. See LICENSE file in the project root for full license information.

package xbl.sample.android.views;

import xbl.sample.android.MainActivity;
import xbl.sample.android.R;
import xbl.sample.android.layers.*;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Button;

public class MenuView
{
    private static final String TAG = "Menu View";

    public native void InitializeNativeVars();

    // Add Layers here
    public MainMenuLayer mainMenuLayer;
    public AchievementsLayer achievementsLayer;
    public SocialLayer socialLayer;

    // Add Menu View Layer (MVL), make sure to add to MenuView_JNI as well!
    public static final int MVL_EMPTY = 0;
    public static final int MVL_MAIN_MENU = 1;
    public static final int MVL_ACHIEVEMENTS = 2;
    public static final int MVL_SOCIAL = 3;
    public static final int MVL_SOCIAL_USERS = 4;
    public static final int MVL_SOCIAL_USER_PROFILE = 5;
    public static final int MVL_SOCIAL_GROUPS = 6;
    public static final int MVL_SOCIAL_GROUP_VIEW = 7;

    private MainActivity m_activity;
    private LinearLayout m_layout;
    private Button m_buttonMenuBack;

    public MenuView(MainActivity activity)
    {
        m_activity = activity;
        m_layout = activity.findViewById(R.id.menuLayout);
        m_buttonMenuBack = activity.findViewById(R.id.button_MenuBack);

        // Allocate Layers
        mainMenuLayer = new MainMenuLayer(activity);
        achievementsLayer = new AchievementsLayer(activity);
        socialLayer = new SocialLayer(activity);

        // Reset View, just encase
        resetView();

        InitializeNativeVars();
    }

    private void resetView()
    {
        if (m_layout == null) { return; }

        if (m_layout.getChildCount() > 0) { m_layout.removeAllViews(); }

        m_buttonMenuBack.setVisibility(View.INVISIBLE);
    }

    private class ChangeLayerRunnable implements Runnable
    {
        private int m_layer;

        ChangeLayerRunnable(int layer)
        {
            m_layer = layer;
        }

        @Override
        public void run()
        {
            resetView();

            switch(m_layer)
            {
                case MVL_SOCIAL_GROUP_VIEW:
                {
                    // socialLayer.m_groupsLayer.m_groupViewLayer.setGroup(group); Call this on button click! Before here!
                    socialLayer.m_groupsLayer.m_groupViewLayer.show(m_layout);
                }break;
                case MVL_SOCIAL_GROUPS:
                {
                    socialLayer.m_groupsLayer.show(m_layout);
                }break;
                case MVL_SOCIAL_USER_PROFILE:
                {
                    // socialLayer.m_usersLayer.m_socialProfileLayer.setUser(user); Call this on button click! Before here!
                    socialLayer.m_usersLayer.m_profileViewLayer.show(m_layout);
                }break;
                case MVL_SOCIAL_USERS:
                {
                    socialLayer.m_usersLayer.show(m_layout);
                }break;
                case MVL_SOCIAL:
                {
                    socialLayer.show(m_layout);
                }break;
                case MVL_ACHIEVEMENTS:
                {
                    achievementsLayer.show(m_layout);
                }break;
                case MVL_MAIN_MENU:
                {
                    mainMenuLayer.show(m_layout);
                }break;
                case MVL_EMPTY:
                default:
                    break;
            }
        }
    }

    public void changeLayer(int layer)
    {
        ChangeLayerRunnable runnable = new ChangeLayerRunnable(layer);
        m_activity.runOnUiThread(runnable);
    }
}