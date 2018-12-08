package com.company;

public class ThreadLesson {
    public static void main (String[] args){
        Loader obj = new Loader();
        Loader2 obj2 = new Loader2();
        Loader3 obj3 = new Loader3();
        Loader4 obj4 = new Loader4();
        obj.setPriority(Thread.MAX_PRIORITY);
        obj2.setPriority(Thread.MIN_PRIORITY);
        obj3.setPriority(Thread.MIN_PRIORITY);
        obj4.setPriority(Thread.MIN_PRIORITY);
        obj.start();
        obj2.start();
        obj3.start();
        obj4.start();
    }
}

class Loader extends Thread {
    public void run(){
//        Thread.currentThread().setPriority(MAX_PRIORITY);
        while(true){
            System.out.println("1");
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
//                e.printStackTrace();
            }
        }
    }
}

class Loader2 extends Thread {
    public void run(){
        while(true){
            System.out.println(" 2");
//            Thread.currentThread().setPriority(MIN_PRIORITY);
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
//                e.printStackTrace();
            }
        }
    }
}

class Loader3 extends Thread {
    public void run(){
//        Thread.currentThread().setPriority(MAX_PRIORITY);
        while(true){
            System.out.println("  3");
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
//                e.printStackTrace();
            }
        }
    }
}

class Loader4 extends Thread {
    public void run(){
//        Thread.currentThread().setPriority(MAX_PRIORITY);
        while(true){
            System.out.println("    4");
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
//                e.printStackTrace();
            }
        }
    }
}

//public class Main {
//    public static void main (String[] args){
//        Loader obj = new Loader();
//        obj.start();
//        Loader2 obj2 = new Loader2();
//        obj2.start();
//    }
//}
//
//class Loader extends Thread {
//    public void run(){
//        for(int i = 0; i<9; i++){
//            System.out.println("thread 1: " + i * i);
//            try {
//                Thread.sleep(400);
//            } catch (InterruptedException e) {
////                e.printStackTrace();
//            }
//        }
//    }
//}
//
//class Loader2 extends Thread {
//    public void run(){
//        for(int i = 0; i<9; i++){
//            System.out.println("thread 2: " + i * i);
//            try {
//                Thread.sleep(400);
//            } catch (InterruptedException e) {
////                e.printStackTrace();
//            }
//        }
//    }
//}