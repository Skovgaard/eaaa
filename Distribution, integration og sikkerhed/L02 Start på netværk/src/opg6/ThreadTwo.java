package opg6;

public class ThreadTwo extends Thread {

    public void run(){
        while (true){
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!Common.getString().isEmpty())
                System.out.println(Common.getString());
        }
    }

}
