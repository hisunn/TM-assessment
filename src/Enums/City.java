public enum City {

    KUALA_TERENGGANU("Kuala Terengganu"),
    KUALA_LUMPUR("Kuala Lumpur"),
    KAJANG("Kajang"),
    BANGI("Bangi"),
    DAMANSARA("Damansara"),
    PETALING_JAYA("Petaling Jaya"),
    PUCHONG("Puchong"),
    SUBANG_JAYA("Subang Jaya"),
    CYBERJAYA("Cyberjaya"),
    PUTRAJAYA("Putrajaya"),
    MANTIN("Mantin"),
    KUCHING("Kuching"),
    SEREMBAN("Seremban");

    private final String name;

    private City(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public static City fromString(String text) {
    if (text == null) {
        return null; 
    }
    for (City city : City.values()) {
        if (city.name.equalsIgnoreCase(text.trim())) {
            return city;
        }
    }
    return null; // Input doesn't match any valid enum string
}

}