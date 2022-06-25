package project.AI;

public class NeuroneEnd extends project.AI.Neurone {
    public NeuroneEnd() {
        super(0);
    }

    @Override
    public void send(){
        throw new IllegalCallerException();
    }

    @Override
    public void set(double amount){
        throw new IllegalCallerException();
    }
}
