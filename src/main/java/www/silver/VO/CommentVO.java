package www.silver.VO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentVO {
    private int comment_id;
    private String user_Id;//여기서부터 고치셈
    private int num;
    private String content;
    private java.sql.Timestamp cdate;
    private int good;
}
