package www.silver.hom;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import www.silver.VO.MemberVO;
import www.silver.service.IF_MemberService;
import www.silver.util.FileDataUtil;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Member;

@Slf4j
@RequiredArgsConstructor
@Controller
public class MemberController {


   private final IF_MemberService memberService;
   private final FileDataUtil filedatautil;


    @GetMapping("memberjoinPage")
    public String memberjoinPage(){
        return "/member/memberjoinPage";
    }

    @PostMapping("memberjoinj")
    public String addmember(@ModelAttribute MemberVO memberVO, MultipartFile[] file) throws IOException {
        System.out.println(file.length + "filefilefilefile");

        String[] filename = filedatautil.fileUpload(file);
        System.out.println(filename[0]+"/"+filename[1]);

        memberService.addMember(memberVO,filename);

        return "/member/memberjoinPage";
    }

//    @PostMapping("/saved")
//    public String saved(@ModelAttribute MemberVO memberVO, MultipartFile[] file){
//        System.out.println(file.length + "개의 첨부파일이 업로드 외었습니다.");
//        for(int  i = 0 ; i < file.length; i++){
//            System.out.println(i);
//        }
//        return "/wrf";
//    }

    @PostMapping("/wrf")
    public String memberjoind(){
        return"/wrf";
    }

    @GetMapping("duplexid")
    @ResponseBody
    public String data(@RequestParam("id")String id){
        System.out.println("<UNK>"+id);
        String data= memberService.checkMember(id);
        return data;
    }

    @GetMapping("loginPage")
    public String login(){
        return "/member/login";
    }

    @PostMapping("login")
    public String login(@RequestParam("id")String id , @RequestParam("pass")String pass, HttpSession session){
        MemberVO memberVO = memberService.checkID(id);
//        System.out.println(memberVO.getId() + "" + memberVO.getPass());
        if(memberVO != null && memberVO.getPass().equals(pass)){
            System.out.println("QWEQQWEQWEQWE");
                session.setAttribute("userId",id);
            
            System.out.println("2222222222222");
                return "redirect:/";
        }else{
            return "redirect:/loginPage?error=2";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
