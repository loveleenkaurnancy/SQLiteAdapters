package com.kitkatstudio.sqliteadapters.customclass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShowContent {

    public static final List<ShowItem> ITEMS = new ArrayList<>();

    public static class ShowItem {
        public final String name;
        public final String email;
        public final String password;

        public ShowItem(String name, String email, String password) {
            this.name = name;
            this.email = email;
            this.password = password;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
