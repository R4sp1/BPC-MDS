package mds.project;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.file.SimplePathVisitor;
import org.jcodec.api.FrameGrab;
import org.jcodec.api.JCodecException;
import org.jcodec.common.model.Picture;
import org.jcodec.scale.AWTUtil;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class VideoLibrary extends ArrayList<String> {

    private String searchDirectory, keepSuffix;

    public VideoLibrary(String searchDirectory, String keepSuffix) throws JCodecException, IOException {
        super();

        this.searchDirectory = searchDirectory;
        this.keepSuffix = keepSuffix;

        //Nalezení souborů a vytvoření obrázků
        //discoverFiles();
    }


    private static List<File> discoverFiles(Path directory, String keepSuffix) throws IOException {
        List<File> files = new ArrayList<>();

        // FileWalker, dokáže projít i více složek. Jednodušší varianta je na objekt File, který je kořenová složka použít
        // file.listFiles((ff) -> {return ff.getName().endsWith(keepSuffix);}); To automaticky získá všechny soubory z dané složky, které splňují filter
        Files.walkFileTree(directory, new SimplePathVisitor() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                String filePath = String.valueOf(file);
                if (filePath.endsWith(keepSuffix)) files.add(new File(filePath)); //Přidat pouze soubory, které mají určitou koncovku
                return super.visitFile(file, attrs);
            }
        });
        return files;
    }

}
