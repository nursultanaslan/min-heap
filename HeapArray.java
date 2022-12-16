
/**
 * Nur Sultan ASLAN
 * 02180201056
 */
public class HeapArray {

    /**
     * Parametre gönderilen dizinin min heap kuralına uyup uymadığı kontrol edilir
     * @param arr: kontrol edilen dizi
     * @return: dizi üçlü min-heap ıse true, değilse false doner
     */
    public Boolean arrayIsMinHeap(Integer[] arr) {
        int n = arr.length; // dızı boyutu

        // dızı eleman sayısının yarısı kadar gezme ıslemı yapılır.
        // dızının yarısı ebeveyn, dıger yarısı çocuk dugum oldugu ıcın n/2 kez doner
        for(int i = 0; i < n/2; i++) {

            // düğümün 3 çocuğunu da kontrol etmek ıcın 1 den 3 e dongu tanımlanır
            for(int j = 1; j < 4; j++) {

                // 3n+1, 3n+2 ve 3n+3 konumları i indisindeki dugumun cocuklarıdır.
                // eger 3n+j eleman sayısına ulasmıssa dızıden tasma olmaması ıcın fonksıyondan cıkılır
                if((3*i+j) == n) {
                    System.out.println("Dizi min-heap.");
                    return true;
                }

                // dızıden tasma olmadıysa elemanın degerı cocuklarından buyuk mu kontrol edılır
                // eger herhangı bır cocugun degerı ebeveynden buyukse mın-heap kuralına uymaz
                // fonksıyondan cıkılır ve dızınin mın-heap formuna donusturulmesı ıcın makeMinHeap fonksiyonu
                // çağırılır.

                // i: ebeveyn düğüm, 3*i+j: çocuk düğüm
                else if(arr[i] > arr[3*i+j]) {
                    System.out.println("Dizi min-heap değil.");
                    makeMinHeap(arr); // dizi min-heap formuna dönüştürülür.
                    printArr(arr); // min-heap formuna dönüştürülen dizi ekrana yazdırılır.
                    return false; // dizi min-heap olmadığından false dönderilir
                }
            }
        }

        // eğer dizide herhangi bir ebeveynin değerinin çocuğundanbüyük olma durumuna rastlanmadıysa
        // döngü sonlanır. dizi min-heap formundadır ve true döndürülür.
        return true;
    }

    /**
     * parametre dizisi min-heap formuna dönüştürülür.
     * dizinin çocukları tek tek kontrol edilir.
     * herhangi bir çocuk düğüm, ebeveynden küçük ise, ebeveyn ile çocuk yer değiştir
     * 3'lü min-heap de çocuk düğümün ebeveynine erişmek ve kontrol etmek için (i-1)/3 formülü kullanılır.
     * @param arr: dönüştürülecek dizi
     */
    public void makeMinHeap(Integer[] arr) {
        int n = arr.length; // dizi boyutu

        // dizinin son elemanından yani yaprak düğümden gezmeye başlanır.
        // dizinin ilk elemanına kadar gezilir.
        // her elemanın ebeveyni (i-1)/3 formülü ile kontrol edilir.
        for(int i = n-1; i > 0; i--) {

            // çocuk düğümün değeri, ebeveyn düğümün değerinden küçükse iki düğüm swap fonksiyonu ile yer değiştirir
            // i: çocuk, (i-1)/3: ebeveyn
            if(arr[i] < arr[(i-1)/3]) {
                swap(arr, i, (i-1)/3);
            }
        }
    }

    /**
     * dizideki iki indis konumunda bulunan elemanlar yer değiştirilir
     * @param arr: güncellenecek dizi
     * @param index1: yeri değiştirilecek birinci elemanın indisi
     * @param index2: yeri değiştirilecek ikinci elemanın indisi
     */
    private void swap(Integer[] arr, int index1, int index2) {
        int temp = arr[index1]; // geçiçi değişken
        arr[index1] = arr[index2];
        arr[index2]= temp;
    }

    /**
     * min-heap formuna dönüştürülen dizi ekrana yazdırılır.
     * @param arr: yazdırılacak dizi
     */
    private void printArr(Integer[] arr) {
        System.out.print("Min-heap hali: ");
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }
}
