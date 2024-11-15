class Foo {
    Semaphore s1=new Semaphore(0);   //0 means initially unavailable for acquiring
    Semaphore s2=new Semaphore(0);

    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        s1.release();        //After completing its task, it calls s1.release(), which increments the count of s1 to 1, signaling that first has completed.
    }

    public void second(Runnable printSecond) throws InterruptedException {
        s1.acquire();              //It calls s1.acquire(), which waits until s1 is released.
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        s2.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        s2.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        
    }
}
