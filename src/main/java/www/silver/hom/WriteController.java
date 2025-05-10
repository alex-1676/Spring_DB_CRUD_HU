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
    public String saveWrite(@ModelAttribute WriteVO writeVO , MultipartFile[]file) throws IOException {
        String[] filename = fileDataUtil.fileUpload(file);
        List<String> fileNames = Arrays.asList(filename);

        writeService.addWrite(writeVO,fileNames);


        return "redirect:/write";
    }

    @GetMapping("board")
    public  String board(Model model){

        List<WriteVO> writeVOList = writeService.getWriteList();
        model.addAttribute("writeList",writeVOList);
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
}
