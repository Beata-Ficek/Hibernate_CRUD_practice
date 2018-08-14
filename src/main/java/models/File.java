package models;


import javax.persistence.*;

@Entity
@Table(name="files")

public class File {

    private int id;
    private String name;
    private Extension extension;
    private int size;
    private Folder folder;

    public File(){

    }

    public File(String name, Extension extension, int size, Folder folder){
        this.name = name;
        this.extension = extension;
        this.size = size;
        this.folder = folder;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Enumerated(value=EnumType.STRING)
    public Extension getExtension() {
        return extension;
    }

    public void setExtension(Extension extension) {
        this.extension = extension;
    }

    @Column(name = "size")
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @ManyToOne
    @JoinColumn(name = "folder_id", nullable = false)

    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }
}
