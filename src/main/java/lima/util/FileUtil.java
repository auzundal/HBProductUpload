package lima.util;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileUtil {

    public static String imagePath = System.getProperty("user.dir") + "/data/sample/imageUpload/";
    public static String excelUploadPath = System.getProperty("excelUploadPath");

    public static List<String> getValidImageNames() {
        File folder = new File(imagePath);
        return Arrays.stream(folder.listFiles()).map(i -> i.getName()).collect(Collectors.toList());
    }
}
