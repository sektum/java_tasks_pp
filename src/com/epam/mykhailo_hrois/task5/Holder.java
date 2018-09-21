package com.epam.mykhailo_hrois.task5;

class Holder {
    public static volatile String pathName = "";
    public static LengthWithIndexes value;
    private static boolean FILE_WAS_READ_COMPLETELY = true;
    private static boolean VALUE_WAS_ALREADY_READ = true;

    public static synchronized void put(LengthWithIndexes value) {
        Holder.value = value;
        Holder.VALUE_WAS_ALREADY_READ = false;
    }

    public static synchronized LengthWithIndexes get() {
        Holder.VALUE_WAS_ALREADY_READ = true;
        return value;
    }

    public static boolean isFileWasReadCompletely() {
        return FILE_WAS_READ_COMPLETELY;
    }

    public static void setFileWasReadCompletely(boolean fileWasReadCompletely) {
        FILE_WAS_READ_COMPLETELY = fileWasReadCompletely;
    }

    public static boolean isValueWasAlreadyRead() {
        return VALUE_WAS_ALREADY_READ;
    }

    public static void setValueWasAlreadyRead(boolean valueWasAlreadyRead) {
        VALUE_WAS_ALREADY_READ = valueWasAlreadyRead;
    }
}
