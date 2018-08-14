import db.DBHelper;
import models.Extension;
import models.File;
import models.Folder;
import models.Owner;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Owner lizzie = new Owner("Lizzie", "Liz82");
        DBHelper.save(lizzie);

        Folder practiceFolder = new Folder("Practice", lizzie);
        DBHelper.save(practiceFolder);
        Folder images = new Folder("Images", lizzie);
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
        List<Folder> folders = DBHelper.getAll(Folder.class);
        List<Owner> owners = DBHelper.getAll(Owner.class);

    }
}
