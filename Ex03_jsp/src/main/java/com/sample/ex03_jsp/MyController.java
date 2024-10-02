package com.sample.ex03_jsp;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import java.util.ArrayList;

@Controller
public class MyController {

    @RequestMapping("/")
    public @ResponseBody String root(){
        return "jsp test";
    }

    @RequestMapping("/test")
    public String test(){
        return "test";
    }

    @RequestMapping("/test1")
    public String test1(){
        return "sub/test1";
    }

    @RequestMapping("/model")
    public String model(Model model){
        model.addAttribute("name","홍길동");
        return "model";
    }

    @RequestMapping("/mv")
    public ModelAndView mv2(){
        ModelAndView mv = new ModelAndView();

        List<String> list = new ArrayList<String>();
        list.add("test1");
        list.add("test2");
        list.add("test3");

        mv.addObject("lists",list);
        mv.addObject("name","홍길동");
        mv.setViewName("view/mv");

        return mv;
    }

    @RequestMapping("/index") //index?name=한성용
    public String index(HttpServletRequest request, Model model){
        // HttpServletRequest 의 경우에는 param 이 없어도 가능하다.
        String name = request.getParameter("name");
        String nickname = request.getParameter("nickname");
        model.addAttribute("name",name);
        model.addAttribute("nickname",nickname);
        return "index";
    }

    @RequestMapping("/view1")
    public String view1(@RequestParam("id") String id, @RequestParam("name") String name, Model model){
        // 하지만 @RequestParam 은 명시한 param 이 없는 경우 400 bad request 가 발생함.
        model.addAttribute("id",id);
        model.addAttribute("name",name);
        return "view1";
    }
    @RequestMapping("/view2")
    public String view2(MemberDto member, Model model){
        model.addAttribute("id",member.getId());
        model.addAttribute("name",member.getName());

        return "view2";
    }

    @RequestMapping("/view3/{studentId}/{name}")
    public String view3(@PathVariable("studentId") String studentId,@PathVariable("name") String name, Model model){
        model.addAttribute("id",studentId);
        model.addAttribute("name",name);
        return "view3";
    }
}
