import java.util.Locale;

public class Dni {
    private static final char[] LETRAS = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P',
            'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

    private int number;
    private char letra;

    public Dni() {
        number = 0;
        letra = 'T';
    }

    public Dni(int number) {
        this.number = number;
        letra = LETRAS[number % 23];
    }

    public Dni(int number, char letra) {
        this.letra = letra;
        char realLetter = LETRAS[number % 23];
        if (realLetter != letra) {
            this.number = -number;
        } else {
            this.number = number;
        }
    }

    public Dni(String str) {
        String strNumber = str.replaceAll("[^\\d]", "");
        number = Integer.parseInt(strNumber);
        letra = str.toUpperCase().charAt(str.length() - 1);
        char realLeter = LETRAS[number % 23];
        if (realLeter != letra) {
            number = -number;
        }
    }

    @Override
    public String toString() {
        return number + "-" + letra;
    }

    public int getNumber() {
        return number;
    }

    public char getLetra() {
        return letra;
    }

    public void setNumber(int number) {
        this.number = number;
        char realLetter = LETRAS[number % 23];
        if (realLetter != letra) {
            this.number = -this.number;
        }
    }

    public static char letterforDni(int number) {
        return LETRAS[number % 23];
    }

    public static String NifForDni(int number) {
        return number + "_" + letterforDni(number);

    }

    public boolean correctDNi() {
        if (number > 0) {
            return false;
        } else {
            return true;
        }
    }

    public String toFormattedString() {
        String strNumber = "" + number;
        String s = "";
        if (number > 999) {
            s += "." + strNumber.substring(strNumber.length() - 3, strNumber.length());
            if (number > 999999) {
                s = strNumber.substring(0, strNumber.length() - 6) + "." + strNumber.substring(strNumber.length() - 6, strNumber.length() - 3) + s;
            }

        } else{
            s = strNumber;
    }
        s += "_" + letra;
        return s;
}

}

