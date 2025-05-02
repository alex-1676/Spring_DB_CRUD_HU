package www.silver.hom;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import www.silver.VO.MemberVO;
import www.silver.service.IF_MemberService;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Member;

@Controller
public class MemberController {

    @Inject
    IF_MemberService memberService;

    @GetMapping("memberjoinPage")
    public String memberjoinPage(){
        return "/member/memberjoinPage";
    }

    @PostMapping("memberjoinj")
    public String addMember(@ModelAttribute MemberVO memberVO){
        memberService.addMember(memberVO);
        return "/member/memberjoinPage";
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
