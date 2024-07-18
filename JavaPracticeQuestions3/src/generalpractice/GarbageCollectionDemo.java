package generalpractice;

public class GarbageCollectionDemo {

     class MyObject {
        private String name;

        MyObject(String name) {
            this.name = name;
            System.out.println(name + " created");
        }

        @Override
        protected void finalize() throws Throwable {
            System.out.println(name + " destroyed");
            super.finalize();
        }
    }

    public static void main(String[] args) {
        GarbageCollectionDemo gcd= new GarbageCollectionDemo();
        MyObject obj1 = gcd.new MyObject("Object 1");
        MyObject obj2 = gcd.new MyObject("Object 2");
        MyObject obj3= gcd.new MyObject("Object 3");
  
        obj1 = null;
        obj2 = null;

        System.gc();

        try {
            Thread.sleep(1000);
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (obj3 == null) {
            System.out.println("Object 3 has been collected");
        } else {
            System.out.println("Object 3 is still alive");
        }
    }
}

