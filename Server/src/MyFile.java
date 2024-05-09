//
//public class MyFile {
//	private int id;
//	private String name;
//	private byte[] data;
//	private String fileExtention;
//	
//	public MyFile(int id, String name, byte[] data, String fileExtention) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.data = data;
//		this.fileExtention = fileExtention;
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public byte[] getData() {
//		return data;
//	}
//
//	public void setData(byte[] data) {
//		this.data = data;
//	}
//
//	public String getFileExtention() {
//		return fileExtention;
//	}
//
//	public void setFileExtention(String fileExtention) {
//		this.fileExtention = fileExtention;
//	}
//	
//	
//	
//}

/**
 * id - the id of the object
 * name - the name of the file
 * data - the file data
 * fileExtension - the file extension
 *
 */

public class MyFile {

    private int id;
    private String name;
    private byte[] data;
    private String fileExtension;

    public MyFile(int id, String name, byte[] data, String fileExtension) {
        this.id = id;
        this.name = name;
        this.data = data;
        this.fileExtension = fileExtension;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public byte[] getData() {
        return data;
    }

    public String getFileExtension() {
        return fileExtension;
    }
}
