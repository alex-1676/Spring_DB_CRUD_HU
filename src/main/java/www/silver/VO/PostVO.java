package www.silver.VO;

public class PostVO {
	
	private int postNumber;
	private int opencheck;
	private String title;
	private String writer;
	private String inwrite;
	private String writeDay;
	private int views;
	public int getPostNumber() {
		return postNumber;
	}
	public void setPostNumber(int postNumber) {
		this.postNumber = postNumber;
	}
	public void setWriteDay(String writeDay) {
		this.writeDay = writeDay;
	}
	public int getOpencheck() {
		return opencheck;
	}
	public void setOpencheck(int opencheck) {
		this.opencheck = opencheck;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getInwrite() {
		return inwrite;
	}
	public void setInwrite(String inwrite) {
		this.inwrite = inwrite;
	}
	public String getWriteDay() {
		return writeDay;
	}
	
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	
}
