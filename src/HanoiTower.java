public class HanoiTower {
    private Peg peg1;
    private Peg peg2;
    private Peg peg3;
    private int numDiscs;

    public HanoiTower(int num)
    {
        numDiscs = num;
        peg1 = new Peg(1, num);
        for(int a = num; a>0; a--) {
            peg1.addDisc(a);
        }
        peg2 = new Peg(2, num);
        peg3 = new Peg(3, num);

    }

    public void solveTower()
    {
        moveTower(peg1, peg3, peg2, numDiscs);
    }

    private void moveTower(Peg startPeg, Peg endPeg, Peg extraPeg, int numtoMove)
    {
        if (numtoMove == 1) {
            startPeg.moveTopDisc(endPeg);
        }
        else {
            moveTower(startPeg, extraPeg, endPeg, numtoMove-1);
            startPeg.moveTopDisc(endPeg);
            moveTower(extraPeg, endPeg, startPeg, numtoMove-1);
        }


    }
    public static void main(String[] args) {
        HanoiTower ht = new HanoiTower(5);
        ht.solveTower();
    }

}