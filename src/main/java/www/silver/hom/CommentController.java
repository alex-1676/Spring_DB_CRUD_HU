package www.silver.hom;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import www.silver.VO.CommentVO;
import www.silver.VO.WriteVO;
import www.silver.service.IF_CommentService;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class CommentController {

    @Inject
    IF_CommentService  commentService;
    @GetMapping("allComments")
    public String saveComment1(@RequestParam("no")int num, Model model, HttpSession session) {
//        System.out.println("asdasdasd"+commentVO.getNum());
        System.out.println("11111111111111111111111111111    "+num);

        List<CommentVO> comments = commentService.getComments(num);
        WriteVO writeVO = (WriteVO) session.getAttribute("nowWrite");
        model.addAttribute("commentList", comments);
        model.addAttribute("write", writeVO);
        session.removeAttribute("nowWrite");
        return "write/chboard";
    }

    @PostMapping("saveComment")
    public String saveComment(@ModelAttribute CommentVO commentVO){
        commentService.addComment(commentVO);
        return "redirect:/allComments?no="+commentVO.getNum();
    }
}
