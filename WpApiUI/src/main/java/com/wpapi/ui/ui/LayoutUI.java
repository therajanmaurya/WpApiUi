package com.wpapi.ui.ui;

import com.wpapi.ui.R;

/**
 * Created by RajanMaurya on 02/02/16.
 */
public enum LayoutUI {

    google_card, cheesesquare ,  simple_cardui , simple_cardui2;


    public static int UI_Type(LayoutUI ui)
    {
        switch (ui)
        {
            case google_card:
                return R.layout.item_google_big_card;
            case cheesesquare:
                return R.layout.item_cheesesqaure_list;
            case simple_cardui:
                return R.layout.item_simple_card;
            case simple_cardui2:
                return R.layout.item_simple_card2;
            default:
                return 0xffffff00;
        }
    }
}