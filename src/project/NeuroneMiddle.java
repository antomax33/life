package project.AI;

public class NeuroneMiddle extends Neurone {
    public NeuroneMiddle(int numberOfLinks) {
        super(numberOfLinks);
    }

    @Override
    public void set(double amount){
        throw new IllegalCallerException();
    }

}
