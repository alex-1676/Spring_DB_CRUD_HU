package www.silver.hom;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import www.silver.VO.CommentVO;
import www.silver.VO.WriteVO;
import www.silver.service.IF_CommentService;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class CommentController {


    private final IF_CommentService  commentService;

    @GetMapping("allComments")
    public String saveComment1(@RequestParam("no")int num, Model model) {
        System.out.println("11111111111111111111111111111  "+num);
        List<CommentVO> comments = commentService.getComments(num);
        model.addAttribute("commentList", comments);
        return "write/chboard";
    }

    @PostMapping("saveComment")
    public String saveComment(@ModelAttribute CommentVO commentVO, HttpSession session){
        commentVO.setUser_Id(session.getAttribute("userId").toString());
        commentService.addComment(commentVO);

        return "redirect:/chboard?no="+commentVO.getNum();
    }
}
