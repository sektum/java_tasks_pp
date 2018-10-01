package com.epam.mykhailo_hrois.task5;

class Holder {
    public static volatile String pathName = "";
    public static LengthWithIndexes value;
    private static boolean fileWasReadCompletely = true;
    private static boolean valueWasAlreadyRead = true;

    public static synchronized void put(LengthWithIndexes value) {
        Holder.value = value;
        Holder.valueWasAlreadyRead = false;
    }

    public static synchronized LengthWithIndexes get() {
        Holder.valueWasAlreadyRead = true;
        return value;
    }

    public static boolean isFileWasReadCompletely() {
        return fileWasReadCompletely;
    }

    public static void setFileWasReadCompletely(boolean fileWasReadCompletely) {
        Holder.fileWasReadCompletely = fileWasReadCompletely;
    }

    public static boolean isValueWasAlreadyRead() {
        return valueWasAlreadyRead;
    }

    public static void setValueWasAlreadyRead(boolean valueWasAlreadyRead) {
        Holder.valueWasAlreadyRead = valueWasAlreadyRead;
    }
}
