import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;

/**
 * 获取明天此刻时间
 */
public class TomorrowTime {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,1);
        System.out.println(calendar.getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format = sdf.format(calendar.getTime());
        System.out.println(format);

        LocalDateTime today = LocalDateTime.now();
        LocalDateTime tomorrow = today.plusDays(1);
        System.out.println(tomorrow);

        LocalDateTime today1 = LocalDateTime.now();
        LocalDateTime tomorrow1 = today.minusDays(-1);
        System.out.println(tomorrow1);

        int i = 1000;
        Integer j = new Integer(1000);
        System.out.println(i == j);
        System.out.println(j.equals(i));
    }

}
