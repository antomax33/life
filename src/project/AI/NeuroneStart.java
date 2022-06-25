package project.AI;

public class NeuroneStart extends Neurone {

    public NeuroneStart(int numberOfLinks){
        super(numberOfLinks);
    }

    @Override
    public void add(double amount){
        throw new IllegalCallerException();
    }

}
