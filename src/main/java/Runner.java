import db.DBHelper;
import models.Extension;
import models.File;
import models.Folder;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Folder practiceFolder = new Folder("Practice");
        DBHelper.save(practiceFolder);
        Folder images = new Folder("Images");
        DBHelper.save(images);

        File rubyFile = new File ("Ruby practice", Extension.RB, 5, practiceFolder);
        DBHelper.save(rubyFile);
        File javaFile = new File ("Java practice", Extension.JAVA, 4, practiceFolder);
        DBHelper.save(javaFile);
        File txtFile = new File ("READ ME", Extension.TXT, 1, practiceFolder);
        DBHelper.save(txtFile);


        File jpgFile = new File ("Panda", Extension.JPG, 500, images);
        DBHelper.save(jpgFile);
        File gifFile = new File ("Sneezing panda", Extension.GIF, 5000, images);
        DBHelper.save(gifFile);

        txtFile.setName("READ ME NOW!");
        DBHelper.update(txtFile);

        DBHelper.delete(rubyFile);
        File foundFile = DBHelper.find(File.class, javaFile.getId());

        List<File> files = DBHelper.getAll(File.class);
        List<Folder> folders = DBHelper.getAll(File.class);

    }
}
