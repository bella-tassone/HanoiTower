import java.util.Arrays;

public class Peg {
    private int pegNum;
    private int numDiscs;
    private int[] discs;
    private int count;    //the number of discs currently on the peg.

    public Peg(int p, int num)
    {
        pegNum = p;
        numDiscs = num;
        discs = new int[num];
        count = 0;
    }

    public int getPegNum()
    {
        return pegNum;
    }
    public int getNumDiscs()
    {
        return numDiscs;
    }

    public String toString()
    {
        String s = "Peg " + pegNum;
        return s;
    }

    public boolean addDisc(int whichOne)
    {
        if(count == 0) {
            discs[count] = whichOne;
            count++;
            return true;
        }
        else if (whichOne < discs[count-1]) {
            discs[count] = whichOne;
            count++;
            return true;
        }
        else {
            System.out.println("Can't do that");
            return false;
        }
    }

    public int popDisc()
    {
        int i = discs[count-1];
        discs[count-1] = 0;
        count--;
        return i;
    }
    public boolean moveTopDisc(Peg newPeg)
    {
        int disc = popDisc();
        if (newPeg.addDisc(disc))
        {
            System.out.println("Moving disc " + disc + " from peg " + pegNum + " to peg " + newPeg.getPegNum());
            return true;
        }
        else{
            System.out.println("Bad Move");
            return false;
        }
    }
    public static void main(String [] arg) {
        Peg p1 = new Peg(1,5);
        p1.addDisc(3);
        System.out.println(Arrays.toString(p1.discs));
        p1.addDisc(2);
        System.out.println(Arrays.toString(p1.discs));
        p1.addDisc(4);
        System.out.println(Arrays.toString(p1.discs));
        p1.popDisc();
        System.out.println(Arrays.toString(p1.discs));

        System.out.println();

        Peg p2 = new Peg(2,5);
        p2.addDisc(5);
        System.out.println(Arrays.toString(p2.discs));
        p2.addDisc(6);
        System.out.println(Arrays.toString(p2.discs));
        p2.addDisc(4);
        System.out.println(Arrays.toString(p2.discs));
        p2.popDisc();
        System.out.println(Arrays.toString(p2.discs));
        p2.addDisc(2);
        System.out.println(Arrays.toString(p2.discs));
        p2.addDisc(3);
        System.out.println(Arrays.toString(p2.discs));
        p2.addDisc(1);
        System.out.println(Arrays.toString(p2.discs));
    }
}

/* OUTPUT:
[3, 0, 0, 0, 0]
[3, 2, 0, 0, 0]
Can't do that
[3, 2, 0, 0, 0]
[3, 0, 0, 0, 0]

[5, 0, 0, 0, 0]
Can't do that
[5, 0, 0, 0, 0]
[5, 4, 0, 0, 0]
[5, 0, 0, 0, 0]
[5, 2, 0, 0, 0]
Can't do that
[5, 2, 0, 0, 0]
[5, 2, 1, 0, 0]
 */