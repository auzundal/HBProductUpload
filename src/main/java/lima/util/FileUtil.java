package lima.util;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileUtil {

    public static String IMAGE_UPLOAD_FOLDER = "C:/Users/eanyig/Desktop/Lima/data/sample/imageUpload";

    public static List<String> getValidImageNames() {
        File folder = new File(IMAGE_UPLOAD_FOLDER);
        return Arrays.stream(folder.listFiles()).map(i -> i.getName()).collect(Collectors.toList());
    }
}
