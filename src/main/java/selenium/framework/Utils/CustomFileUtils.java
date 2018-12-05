package selenium.framework.Utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class CustomFileUtils {

    public String getProjectPath(){
        return System.getProperty("user.dir");
    }

    public void deleteProjectDirectory(String path){
        try {
            FileUtils.deleteDirectory(new File(getProjectPath() + path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}