public class Rotor {

    
    private String rotorValues;
    private char startChar;
        
    public Rotor(String v, char c){
        this.rotorValues = new String(v);
        this.startChar = c;
        
        while(!this.rotate());
            
    }
    
    public boolean rotate(){
        //TODO
        //take last char and put it in front
        rotorValues = rotorValues.charAt(rotorValues.length() - 1) +
                rotorValues.substring(0, rotorValues.length() - 1);
        //check if top char equals startChar
        return rotorValues.charAt(0) == startChar;
    }
    

    public int indexOf(char c){
        //TODO
        return rotorValues.indexOf(c);
    }

    public char charAt(int idx){
        //TODO
        return rotorValues.charAt(idx);
    }
}
    
