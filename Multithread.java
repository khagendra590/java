public class MultiThreadExample {

    public static void main(String[] args) {
        Thread collegeThread = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    System.out.println("BMS College of Engineering");
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            }
        });
        Thread cseThread = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    System.out.println("CSE");
                    try {
                        Thread.sleep(2000); 
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            }
        });

        collegeThread.start();
        cseThread.start();
        
    }
}