public enum State {

    SELANGOR("Selangor"),
    TERENGGANU("Terengganu"),
    PAHANG("Pahang"),
    KELANTAN("Kelantan"),
    MELAKA("Melaka"),
    PULAU_PINANG("Pulau Pinang"),
    KEDAH("Kedah"),
    JOHOR("Johor"),
    PERLIS("Perlis"),
    SABAH("Sabah"),
    SARAWAK("Sarawak");

    private final String name;

    private State(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static State fromString(String text) {
        if (text == null) {
            return null; 
        }
        for (State state : State.values()) {
            if (state.name.equalsIgnoreCase(text.trim())) {
                return state;
            }
        }
        return null;
    }

}