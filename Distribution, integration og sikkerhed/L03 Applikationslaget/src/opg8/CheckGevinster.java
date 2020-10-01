package opg8;

public class CheckGevinster extends Thread {

    private lottoraek[] spillede;
    private int[] antalgev;
    private lottoraek rigtig;

    public CheckGevinster(lottoraek[] spillede, int[] antalgev, lottoraek rigtig) {
        this.spillede = spillede;
        this.antalgev = antalgev;
        this.rigtig = rigtig;
    }

    public void run() {
        for (int j = 0; j < spillede.length; j++) {
            antalgev[rigtig.antalrigtige(spillede[j])]++;
        }
    }
}
