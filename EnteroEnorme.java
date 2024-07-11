import java.util.Arrays;

public class EnteroEnorme {
    private int[] digitos;

    public EnteroEnorme() {
        this.digitos = new int[40];
        Arrays.fill(this.digitos, 0);
    }

    public EnteroEnorme(String numero) {
        this();
        parse(numero);
    }

    public void parse(String numero) {
        Arrays.fill(this.digitos, 0);
        int length = numero.length();
        int start = 40 - length;

        for (int i = 0; i < length; i++) {
            char c = numero.charAt(i);
            if (Character.isDigit(c)) {
                this.digitos[start + i] = Character.getNumericValue(c);
            } else {
                throw new IllegalArgumentException("El carácter " + c + " no es un dígito.");
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        boolean leadingZeros = true;
        for (int digito : this.digitos) {
            if (leadingZeros && digito == 0) {
                continue;
            }
            leadingZeros = false;
            sb.append(digito);
        }
        if (sb.length() == 0) {
            return "0";
        }
        return sb.toString();
    }

    public void sumar(EnteroEnorme otro) {
        int acarreo = 0;
        for (int i = 39; i >= 0; i--) {
            int suma = this.digitos[i] + otro.digitos[i] + acarreo;
            this.digitos[i] = suma % 10;
            acarreo = suma / 10;
        }
    }

    public void restar(EnteroEnorme otro) {
        int acarreo = 0;
        for (int i = 39; i >= 0; i--) {
            int diferencia = this.digitos[i] - otro.digitos[i] - acarreo;
            if (diferencia < 0) {
                diferencia += 10;
                acarreo = 1;
            } else {
                acarreo = 0;
            }
            this.digitos[i] = diferencia;
        }
    }

    public boolean esIgualA(EnteroEnorme otro) {
        return Arrays.equals(this.digitos, otro.digitos);
    }

    public boolean noEsIgualA(EnteroEnorme otro) {
        return !this.esIgualA(otro);
    }

    public boolean esMayorQue(EnteroEnorme otro) {
        for (int i = 0; i < 40; i++) {
            if (this.digitos[i] > otro.digitos[i]) {
                return true;
            } else if (this.digitos[i] < otro.digitos[i]) {
                return false;
            }
        }
        return false;
    }

    public boolean esMenorQue(EnteroEnorme otro) {
        for (int i = 0; i < 40; i++) {
            if (this.digitos[i] < otro.digitos[i]) {
                return true;
            } else if (this.digitos[i] > otro.digitos[i]) {
                return false;
            }
        }
        return false;
    }

    public boolean esMayorOIgualA(EnteroEnorme otro) {
        return this.esMayorQue(otro) || this.esIgualA(otro);
    }

    public boolean esMenorOIgualA(EnteroEnorme otro) {
        return this.esMenorQue(otro) || this.esIgualA(otro);
    }

    public boolean esCero() {
        for (int digito : this.digitos) {
            if (digito != 0) {
                return false;
            }
        }
        return true;
    }

    public void multiplicar(EnteroEnorme otro) {
        int[] resultado = new int[40];
        for (int i = 39; i >= 0; i--) {
            int acarreo = 0;
            for (int j = 39; j >= 0; j--) {
                if (i + j >= 39) {
                    int producto = this.digitos[i] * otro.digitos[j] + resultado[i + j - 39] + acarreo;
                    resultado[i + j - 39] = producto % 10;
                    acarreo = producto / 10;
                }
            }
        }
        this.digitos = resultado;
    }

}
