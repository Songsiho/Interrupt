package com.example.songsiho.baccara;

import android.util.Log;

import java.lang.String;
/**
 * Created by Alab on 7/29/2016.
 */
public class Interupt {

    public class SomeBackgroundProcess implements Runnable {

        Thread backgroundThread;

        public void start() {
            if (backgroundThread == null) {
                backgroundThread = new Thread(this);
                backgroundThread.start();
            }
        }

        public void stop() {
            if (backgroundThread != null) {
                backgroundThread.interrupt();
            }
        }

        public void run() {
            try {
                while (!backgroundThread.interrupted()) {
                    System.out.println("Thread: ");
                }
            } catch (InterruptedException ex) {
                // important you respond to the InterruptedException and stop processing
                // when its thrown!  Notice this is outside the while loop.
            } finally {
                backgroundThread = null;
            }
        }
    }
}
