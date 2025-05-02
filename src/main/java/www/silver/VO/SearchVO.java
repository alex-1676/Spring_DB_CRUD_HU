package www.silver.VO;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SearchVO {
    private int id;
    private String searchName;
    private java.sql.Timestamp searchDate;

}
