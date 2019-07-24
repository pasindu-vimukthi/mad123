package com.example.mtrsliit.it17117388;

import android.provider.BaseColumns;

public final class BookInfo implements BaseColumns{

    private BookInfo(){}

        public static final String TABLENAME = "BookInfo";
        public static final String COLUMNNAME_ID = "_ID";
        public static final String COLUMNNAME_BOOKNAME = "bookName";
        public static final String COLUMNNAME_AUTHOR_ID = "authorID";
        public static final String COLUMNNAME_AUTHOR_NAME= "authorName";
        public static final String COLUMNNAME_BOOK_CATEGORY = "bookCategory";

}

