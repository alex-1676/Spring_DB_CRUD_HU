package www.silver.VO;

import lombok.Getter;
import lombok.Setter;
@Setter @Getter
public class PageVO {
    private int startNo;

    private int endNo;
    private int perPageNum=5;
    private Integer page; // Integer 웹에서 받은 페이지 정보(String)가 없으면 null인데 int는 null을 저장할 수 없다. 오류방지
    private int totalCount;
    private int endPage;
    private int startPage;
    private boolean prev;
    private boolean next;
    private int pageGroup=5;

    // 검색용 변수 2개 추가
    private String searchType;
    private String searchKeyword;

    private int aaa;
    private int bbb;

    public void calcPage() {
        startNo = (this.page - 1) * perPageNum +1;
        int tempEnd = (int) (Math.ceil(page / (double) pageGroup) * pageGroup);
        // 6/10=0.6  > 1   10
        // 11/10=1.1  > 2   20

        this.startPage = (tempEnd - pageGroup) + 1;
        if (tempEnd * this.perPageNum > this.totalCount) {
            this.endPage = (int) Math.ceil(this.totalCount / (double) this.perPageNum);
            if(endPage!=page) {
                this.endNo = startNo + this.perPageNum - 1;
            }else {
                this.endNo = startNo + this.totalCount % perPageNum  - 1;
            }
        } else {
            this.endPage = tempEnd;
            this.endNo = startNo + this.perPageNum - 1;
        }

        this.prev = this.startPage != 1;
        this.next = this.endPage * this.perPageNum < this.totalCount;

        this.aaa = this.startNo-1+this.perPageNum;
        this.bbb = this.startNo - 1;
    }


}