public class Dni {
    private static final char[] LETRAS = {'T','R','W','A','G','M','Y','F','P',
            'D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};

    private int number;
    private char letra;

    public Dni(int number) {
        this.number = number;
        letra = LETRAS[number%23];

    }
    @Override
    public String toString(){
        return number + "-" + letra;
    }
}