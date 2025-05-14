package www.silver.hom;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import www.silver.VO.PageVO;
import www.silver.VO.WriteVO;
import www.silver.VO.WriteVO_File;
import www.silver.service.IF_WriteService;
import www.silver.util.FileDataUtil;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class WriteController {


    private final IF_WriteService writeService;
    private final FileDataUtil fileDataUtil;

    @GetMapping("write")
    public String write(){
        return "write/write";
    }

    @PostMapping("saveWrite")
    public String saveWrite(@ModelAttribute WriteVO writeVO , MultipartFile[]file ) throws IOException {
        String[] filename = fileDataUtil.fileUpload(file);
        List<String> fileNames = filename.length > 0 ? Arrays.asList(filename) : null;

        writeService.addWrite(writeVO,fileNames);


        return "redirect:/write";
    }

    @GetMapping("board")

    public  String board(@RequestParam(defaultValue = "1")int page, Model model){
        PageVO pageVO = new PageVO();
        pageVO.setPage(page);
//        pageVO.setPerPageNum(3);
        int allPage = writeService.allCount();
        pageVO.setTotalCount(allPage);
        pageVO.calcPage();
        List<WriteVO> writeVOList = writeService.getWriteList(pageVO);
        model.addAttribute("writeList",writeVOList);
        model.addAttribute("pageVO",pageVO);
        System.out.println("12121212121221=======  "+writeVOList.size() );
        return "write/board";
    }
    @GetMapping("chboard")
    public String chboard(@RequestParam("no")int no, RedirectAttributes redirectAttributes){
        WriteVO writeVO = writeService.getWrite(no);
        List<String> files = writeService.getFiles(no);

        redirectAttributes.addFlashAttribute("write", writeVO);
        redirectAttributes.addAttribute("no", no);
        redirectAttributes.addFlashAttribute("files", files);
        return "redirect:/allComments";
    }

  
    @GetMapping("/delete")
    public String delete(@RequestParam("no")int no){
        writeService.delete(no);
        return "redirect:/board";
    }
}
