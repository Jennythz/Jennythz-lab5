public class Enigma{
    //Index 0 is the current "top" character.
    private String rotorInit[] = {
            "#GNUAHOVBIPWCJQXDKRYELSZFMT",
            "#EJOTYCHMRWAFKPUZDINSXBGLQV",
            "#BDFHJLNPRTVXZACEGIKMOQSUWY",
            "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
            "#TGOWHLIFMCSZYRVXQABUPEJKND"};

    private Rotor rotors[];

    public Enigma(int id1, int id2, int id3, String start){
        rotors = new Rotor[3];
        rotors[0] = new Rotor(rotorInit[id1-1], start.charAt(0));
        rotors[1] = new Rotor(rotorInit[id2-1], start.charAt(1));
        rotors[2] = new Rotor(rotorInit[id3-1], start.charAt(2));
    }

    public String decrypt(String message){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);

            // Step 1: outer -> middle
            int pos1 = rotors[2].indexOf(c);
            char c1 = rotors[1].charAt(pos1);

            // Step 2: outer -> inner
            int pos2 = rotors[2].indexOf(c1);
            char c2 = rotors[0].charAt(pos2);

            result.append(c2);

            // rotate rotors for next character
            rotate();
        }
        return result.toString();
    }

    public String encrypt(String message){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);

            // Step 1: inner -> outer
            int pos1 = rotors[0].indexOf(c);
            char c1 = rotors[2].charAt(pos1);

            // Step 2: middle -> outer
            int pos2 = rotors[1].indexOf(c1);
            char c2 = rotors[2].charAt(pos2);

            result.append(c2);

            // rotate rotors for next character
            rotate();
        }
        return result.toString();
    }

    private void rotate(){
        if(rotors[0].rotate()){
            if(rotors[1].rotate()){
                rotors[2].rotate();
            }
        }
    }
}
