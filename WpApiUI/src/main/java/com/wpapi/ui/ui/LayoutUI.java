package com.wpapi.ui.ui;

import com.wpapi.ui.R;

/**
 * Created by RajanMaurya on 02/02/16.
 */
public enum LayoutUI {

    google_card, cheesesquare;


    public static int UI_Type(LayoutUI ui)
    {
        switch (ui)
        {
            case google_card:
                return R.layout.item_google_big_card;
            case cheesesquare:
                return R.layout.item_cheesesqaure_list;
            default:
                return 0xffffff00;
        }
    }
}