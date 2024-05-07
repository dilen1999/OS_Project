
public class MyFile {
	private int id;
	private String name;
	private byte[] data;
	private String fileExtention;
	
	public MyFile(int id, String name, byte[] data, String fileExtention) {
		super();
		this.id = id;
		this.name = name;
		this.data = data;
		this.fileExtention = fileExtention;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public String getFileExtention() {
		return fileExtention;
	}

	public void setFileExtention(String fileExtention) {
		this.fileExtention = fileExtention;
	}
	
	
	
}
