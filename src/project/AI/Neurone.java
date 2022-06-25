package project.AI;

import java.util.*;

public abstract class Neurone {
    // List whom get the info.
    protected List<Link> links;
    private double value=0;
    private final int numberOfLinks;
    private final static Random rand = new Random(System.currentTimeMillis());

    private final static int PROBABILITY_CHANGE_LINKS_ON_EVOLVE = 5;
    private final static double FACTOR_GAUSSIENNE_CHANGEMENT = 0.02;


    private final static int MIN_VALUE_INFORMATION = -1;
    private final static int MAX_VALUE_INFORMATION = 1;

    public Neurone(int numberOfLinks){
        this.numberOfLinks = numberOfLinks;
        links = new ArrayList<>();
    }

    public double getValue(){
        return value;
    }

    @Override
    public String toString(){
        StringJoiner sj = new StringJoiner(", ", "{", "}");
        for (Link link: links) {
            sj.add(String.valueOf(link.amount));
        }
        return "value " + value + " " + sj;
    }

    /**
     * Clear the previous value.
     * Generally between two actions.
     */
    public void clear(){set(0);}
    public void set(double amount){
        if(!(MIN_VALUE_INFORMATION <=amount && amount <= MAX_VALUE_INFORMATION))
                                throw new IllegalArgumentException();
        value=amount;
    }
    public void add(double x){
        //System.out.println("x " + x);
        double newX = x + value;
        value = Math2.clamp(MIN_VALUE_INFORMATION, newX, MAX_VALUE_INFORMATION);
        //System.out.println("value2 " + value);
    }
    public void send(){
        for (Link link : links) {
            //System.out.println("amount " + link.amount);
            //System.out.println("value " + value);
            link.neurone.add(value*link.amount);
        }
    }

    public void setLinks(List<Neurone> nextRange){
        if(nextRange.size() < numberOfLinks) throw new IllegalArgumentException();
        links.clear();

        addConnection(nextRange, links, numberOfLinks);
    }



    public void evolve(List<Neurone> nextRange){

        Iterator<Link> it = links.listIterator();
        List<Link> newList = new ArrayList<>();

        while (it.hasNext()){
            Link actual = it.next();

            // 95% to change the amount of the link
            if (rand.nextInt(100) >= PROBABILITY_CHANGE_LINKS_ON_EVOLVE) {
                newList.add(new Link(actual.neurone,
                        actual.amount + rand.nextGaussian()*FACTOR_GAUSSIENNE_CHANGEMENT));
            }// Else not added in the new list.

        }
        // 5% change link to another connector.
        addConnection(nextRange, newList, numberOfLinks - links.size());
        links = newList;
    }

    private void addConnection(List<Neurone> neurones, List<Link> linkList, int amount){
        if(neurones.size() + amount <= linkList.size() || amount < 0)
                                                    throw new IllegalArgumentException();
        if(amount==0) return;

        List<Neurone> neuroneOfLinkList = new ArrayList<>();

        for (Link link: linkList) {
            neuroneOfLinkList.add(link.neurone);
        }

        for (int i = 0; i < amount; i++) {
            int random = rand.nextInt(amount);
            Neurone neurone = neurones.get(random);
            if (!neuroneOfLinkList.contains(neurone)) {
                linkList.add(newLink(neurone));
            }
        }
    }

    private Link newLink(Neurone neurone){
        return new Link(neurone, Math2.clamp(-1, rand.nextGaussian(), 1));
    }

    private record Link(Neurone neurone, double amount){}
}
