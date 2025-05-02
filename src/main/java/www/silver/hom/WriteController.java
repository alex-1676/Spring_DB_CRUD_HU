package www.silver.hom;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import www.silver.VO.WriteVO;
import www.silver.service.IF_WriteService;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class WriteController {

    @Inject
    IF_WriteService writeService;

    @GetMapping("write")
    public String write(){
        return "write/write";
    }

    @PostMapping("saveWrite")
    public String saveWrite(@ModelAttribute WriteVO writeVO){
        writeService.addWrite(writeVO);
        return "redirect:/write";
    }

    @GetMapping("board")
    public  String board(Model model){

        List<WriteVO> writeVOList = writeService.getWriteList();
        model.addAttribute("writeList",writeVOList);
        return "write/board";
    }
    @GetMapping("chboard")
    public String chboard(@RequestParam("no")int no, HttpSession session){
        WriteVO writeVO = writeService.getWrite(no);
        session.setAttribute("nowWrite",writeVO);

        return "redirect:/allComments?no=" + no;
    }
}
