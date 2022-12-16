import java.util.Scanner;

/**
 * Nur Sultan ASLAN
 * 02180201056
 */
public class Main {
    public static void main(String[] args) {
        
        
        // Kullanıcıdan girdi almak için scanner nesnesi tanımlanır
        Scanner sc = new Scanner(System.in);

        // kullanıcıdan alınan sayı kümesi input değıskenıne atanır
        String input = sc.nextLine();

        // strıng ıfadedekı bosluklar sılınır
        input = input.replaceAll("\\s", "");

        // sayıları ınteger olarak tutmak ıcın dızı tanımlanır
        Integer[] numbers;

        // dızıdekı karakterlerı vırgül ıle ayırıp strıng dızısıne atadık
        String[] chars = input.split(",");

        // vırgul ıle ayrılan ıfade boyutunda dızı tanımlanır
        numbers = new Integer[chars.length];

        // strıng dızıyı ınteger dızıye donusturur
        for(int i = 0; i < chars.length; i++) {
            numbers[i] = Integer.valueOf(chars[i]);
        }

        // heap ıslemlerını yapan sınıf
        HeapArray heap = new HeapArray();

        // kullanıcının gırdıgı sayıların mın heap kuralına uyup uymadıgı kontrol edılır
        heap.arrayIsMinHeap(numbers);
    }
}