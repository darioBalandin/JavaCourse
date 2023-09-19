package org.dario;

public class Main {
    public static void main(String[] args) {


        var parks = new Park[]
                {new Park("Yellowstone", "44.2323, -110.323"), new Park("Yosemite", "34.9678, -134.768"), new Park("Grand Canyon", "44.2323, -110.323")};


        Layer<Park> parkLayer =new Layer<>(parks);
        parkLayer.renderLayer();

        var rivers= new River[]{new River("missisispi", "44.2323,-110.323", "34.9678,-134.768"), new River("amazon", "44.2323,-110.323", "34.9678,-134.768"), new River("nile", "44.2323,-110.323", "34.9678,-134.768")};
        Layer<River> riverLayer =new Layer<>(rivers);
        riverLayer.renderLayer();

    }
}