package com.epam.mykhailo_hrois.task5;

import java.util.concurrent.SynchronousQueue;

class Holder {
    public static volatile String pathName = "";
    public static SynchronousQueue<LengthWithIndexes> queue = new SynchronousQueue<>();
}
