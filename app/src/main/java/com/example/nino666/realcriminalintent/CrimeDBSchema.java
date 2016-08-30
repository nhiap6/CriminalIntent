package com.example.nino666.realcriminalintent;

/**
 * Created by nino666 on 27.8.2016.
 */
public  class CrimeDBSchema {

    // represents a table
    public static final class CrimeTable{
        public static final String NAME = "crimes";

        // represents columns in table
        public static final class Cols{

            public static final String UUID = "uuid";
            public static final String TITLE = "title";
            public static final String DATE = "date";
            public static final String SOLVED = "solved";

        }

    }
}