package MyThread.PseudoSharing;

/**
 * @author Deep-Feeling-1999
 * @create 2020/10/16
 *
 * 伪共享
 * CPU访问变量时会先去看cache，没有的话再去主存
 * 然后把该变量所在的内存区域的一个cache行放到cache中
 * 所以当多个线程访问同一个缓存行里的多个变量会出现伪共享
 *
 *
 */
public class TestForContent {
    static final int LINE = 1024;
    static final int COLUMN = 1024;

    public static void main(String[] args) {
        long[][] array = new long[LINE][COLUMN];
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < LINE; ++i) {
            for (int j = 0; j < COLUMN; ++j) {
                array[i][j] = i * 2 + j;
            }
        }
        long endTime = System.currentTimeMillis();
        long cacheTime = endTime - startTime;
        System.out.println("cache time :" + cacheTime);
    }
}
