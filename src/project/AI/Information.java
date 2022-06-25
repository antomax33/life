package project.AI;

public final class Information {
    private final boolean[] saw;

    public Information(boolean[] saw){
        if(saw.length!=4) throw new IllegalArgumentException();
        this.saw = saw;
    }

    public boolean[] getSaw() {
        return saw;
    }
}
