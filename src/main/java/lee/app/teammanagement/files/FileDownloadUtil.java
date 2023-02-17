package lee.app.teammanagement.files;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileDownloadUtil {
    private File foundFile;

    public Resource getFileAsResource(String fileCode) throws IOException {
        Path uploadDir = Paths.get("src/main/java/lee/app/teammanagement/Files-Upload");

        Files.list(uploadDir).forEach(file -> {
            if (file.getFileName().toString().startsWith(fileCode))  {
                foundFile = file.toFile();
            }
        });

        if (foundFile != null){
            return new UrlResource(foundFile.toURI());
        }
        return null;
    }
}
