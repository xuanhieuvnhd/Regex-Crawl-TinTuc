import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlNews {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.24h.com.vn/tin-tuc-quoc-te-c415.html");
                // Mở luồng và đưa nó vào bộ đệm
                Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
                scanner.useDelimiter("\\Z");
                String content = scanner.next();
                // Đóng máy quét
                scanner.close();
                // Loại bỏ tất cả các dòng mới
                content = content.replaceAll("\\n+", "");
                // Lập quy tắc
                Pattern p = Pattern.compile("<b>(.*?)</b>");
                Matcher m = p.matcher(content);
                while (m.find()) {
                    System.out.println(m.group(1));
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
        }
    }
}
