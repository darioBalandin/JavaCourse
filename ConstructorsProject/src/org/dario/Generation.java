package org.dario;

public enum Generation {
    GEN_Z(2000,2010),
    MILLENIAL(1990,1999),
    BOOMER(1950,1969),
    SILENT(1970,1989),
    GREATEST(1920,1949);


    private int startYear;
    private int endYear;


    Generation(int startYear, int endYear) {
        this.startYear = startYear;
        this.endYear = endYear;
        System.out.println(this + " " + startYear + " " + endYear);
    }


}
