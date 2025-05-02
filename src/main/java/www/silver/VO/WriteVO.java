package www.silver.VO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WriteVO {
	
	private int no;
	private String title;
	private String name;
	private String body;
	private java.sql.Timestamp wdate;
	private int cnt;
	private String s_flag;
//여기서부터
	
}
