import java.util.Arrays;

public class EnteroEnorme {
    // Arreglo de enteros donde cada posicion representa un digito 
    private int[] digitos;

    // contructor, inicializo el arreglo con 40 ceros 
    public EnteroEnorme() {
        this.digitos = new int[40];
        Arrays.fill(this.digitos, 0);
    }

    // Llamo al constructor por defecto para inicializar el arreglo digitos y luego llamo al método parse para llenar el arreglo con los dígitos del String numero.
    public EnteroEnorme(String numero) {
        this();
        parse(numero);
    }



public void parse(String numero) {
    // Relleno el arreglo 'digitos' con ceros para asegurarme de que no queden residuos de operaciones anteriores
    Arrays.fill(this.digitos, 0);
    
    // Obtengo la longitud del string 'numero'
    int length = numero.length();
    
    // Calculo el punto de inicio en el arreglo 'digitos' donde empezaré a insertar los dígitos del 'numero'
    int start = 40 - length;

    // Recorro cada carácter del string 'numero'
    for (int i = 0; i < length; i++) {
        // Obtengo el carácter en la posición 'i' del string
        char c = numero.charAt(i);
        
        // Verifico si el carácter es un dígito
        if (Character.isDigit(c)) {
            // Convierto el carácter a su valor numérico y lo coloco en la posición correcta del arreglo 'digitos'
            this.digitos[start + i] = Character.getNumericValue(c);
        } else {
            // Si el carácter no es un dígito, lanzo una excepción
            throw new IllegalArgumentException("El carácter " + c + " no es un dígito.");
        }
    }
}


@Override
public String toString() {
    // Utilizo StringBuilder para construir el string resultante de manera eficiente
    StringBuilder sb = new StringBuilder();
    
    // Uso una bandera para manejar los ceros a la izquierda
    boolean leadingZeros = true;

    // Recorro cada dígito en el arreglo 'digitos'
    for (int digito : this.digitos) {
        // Si la bandera 'leadingZeros' está activa y el dígito es 0, continúo al siguiente dígito
        if (leadingZeros && digito == 0) {
            continue;
        }
        // Una vez que encuentro un dígito distinto de 0, desactivo la bandera 'leadingZeros'
        leadingZeros = false;
        // Añado el dígito al StringBuilder
        sb.append(digito);
    }

    // Si el StringBuilder está vacío, significa que todos los dígitos eran ceros, así que retorno "0"
    if (sb.length() == 0) {
        return "0";
    }
    
    // Retorno el string resultante
    return sb.toString();
}


public void sumar(EnteroEnorme otro) {
    // Inicializo la variable 'acarreo' en 0 para manejar los acarreo durante la suma
    int acarreo = 0;

    // Recorro los arreglos de derecha a izquierda, empezando desde el último dígito (posición 39)
    for (int i = 39; i >= 0; i--) {
        // Sumo los dígitos correspondientes de ambos números más el acarreo actual
        int suma = this.digitos[i] + otro.digitos[i] + acarreo;
        
        // Almaceno el último dígito de la suma en la posición correspondiente del arreglo 'digitos'
        this.digitos[i] = suma % 10;
        
        // Calculo el nuevo acarreo dividiendo la suma entre 10
        acarreo = suma / 10;
    }
}


public void restar(EnteroEnorme otro) {
    // Inicializo la variable 'acarreo' en 0 para manejar los préstamos durante la resta
    int acarreo = 0;

    // Recorro los arreglos de derecha a izquierda, empezando desde el último dígito (posición 39)
    for (int i = 39; i >= 0; i--) {
        // Resto los dígitos correspondientes de ambos números menos el acarreo actual
        int diferencia = this.digitos[i] - otro.digitos[i] - acarreo;
        
        // Si la diferencia es menor que 0, necesito hacer un préstamo
        if (diferencia < 0) {
            // Ajusto la diferencia sumándole 10 (base decimal)
            diferencia += 10;
            // Establezco el acarreo a 1, ya que he hecho un préstamo
            acarreo = 1;
        } else {
            // Si no se necesita préstamo, el acarreo se establece a 0
            acarreo = 0;
        }
        
        // Almaceno la diferencia en la posición correspondiente del arreglo 'digitos'
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
        // Recorro los arreglos desde el dígito más significativo (posición 0) hasta el menos significativo (posición 39)
        for (int i = 0; i < 40; i++) {
            // Si encuentro un dígito en 'this.digitos' que es mayor que el correspondiente en 'otro.digitos', retorno true
            if (this.digitos[i] > otro.digitos[i]) {
                return true;
            // Si encuentro un dígito en 'this.digitos' que es menor que el correspondiente en 'otro.digitos', retorno false
            } else if (this.digitos[i] < otro.digitos[i]) {
                return false;
            }
            // Si los dígitos son iguales, continúo al siguiente dígito
        }
        // Si todos los dígitos son iguales, retorno false porque 'this' no es mayor que 'otro'
        return false;
    }
    

    public boolean esMenorQue(EnteroEnorme otro) {
        // Recorro los arreglos desde el dígito más significativo (posición 0) hasta el menos significativo (posición 39)
        for (int i = 0; i < 40; i++) {
            // Si encuentro un dígito en 'this.digitos' que es menor que el correspondiente en 'otro.digitos', retorno true
            if (this.digitos[i] < otro.digitos[i]) {
                return true;
            // Si encuentro un dígito en 'this.digitos' que es mayor que el correspondiente en 'otro.digitos', retorno false
            } else if (this.digitos[i] > otro.digitos[i]) {
                return false;
            }
            // Si los dígitos son iguales, continúo al siguiente dígito
        }
        // Si todos los dígitos son iguales, retorno false porque 'this' no es menor que 'otro'
        return false;
    }
    

    public boolean esMayorOIgualA(EnteroEnorme otro) {
        // Verifico si 'this' es mayor que 'otro' o si 'this' es igual a 'otro'
        // Si cualquiera de las dos condiciones es verdadera, retorno true
        return this.esMayorQue(otro) || this.esIgualA(otro);
    }
    
    public boolean esMenorOIgualA(EnteroEnorme otro) {
        // Verifico si 'this' es menor que 'otro' o si 'this' es igual a 'otro'
        // Si cualquiera de las dos condiciones es verdadera, retorno true
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
        // Creo un nuevo arreglo 'resultado' para almacenar el producto de la multiplicación
        int[] resultado = new int[40];
        
        // Recorro los dígitos de 'this' de derecha a izquierda
        for (int i = 39; i >= 0; i--) {
            // Inicializo la variable 'acarreo' en 0 para manejar los acarreo durante la multiplicación
            int acarreo = 0;
            
            // Recorro los dígitos de 'otro' de derecha a izquierda
            for (int j = 39; j >= 0; j--) {
                // Verifico si la posición actual en 'resultado' está dentro de los límites del arreglo
                if (i + j >= 39) {
                    // Calculo el producto del dígito actual de 'this' y 'otro', sumo el valor almacenado en 'resultado'
                    // y el acarreo
                    int producto = this.digitos[i] * otro.digitos[j] + resultado[i + j - 39] + acarreo;
                    
                    // Almaceno el último dígito del producto en la posición correspondiente del arreglo 'resultado'
                    resultado[i + j - 39] = producto % 10;
                    
                    // Calculo el nuevo acarreo dividiendo el producto entre 10
                    acarreo = producto / 10;
                }
            }
        }
        
        // Asigno el arreglo 'resultado' a 'this.digitos' para que 'this' ahora represente el producto
        this.digitos = resultado;
    }
    

}
