package toyAppPackage.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import toyAppPackage.data.Toy;
import toyAppPackage.repositories.ToyRepository;
import toyAppPackage.services.interfaces.ToyService;

import java.util.Scanner;

@Controller
public class ToyController {


    private ToyService toyService;

    @Autowired
    public ToyController(ToyService toyService) {
        this.toyService = toyService;
    }

    @GetMapping("/hello")
    public String hello() {

        return "test";
    }

    @GetMapping("/hello2")
    public String hello2(Model model) {

        String greeting = "Hi!";
        model.addAttribute("message", greeting);

        return "test";
    }


    @GetMapping("/toy/{id}")
    public String oneToy(Model model, @PathVariable int id) { //PathVariable kijkt naar {id}
        Toy toy = toyService.getOneById(id);

        model.addAttribute("toy", toy);

        return "toy";
    }

    @GetMapping("/toys")
    public String allToys(Model model) {

        model.addAttribute("toys", toyService.getAllToys());

        return "toys";
    }

   @GetMapping("addToy")
   //public String createToy(Model model)
    public String makeToy(Model model) {
        model.addAttribute("toy",new Toy());
        return "addtoy";
    }

    @PostMapping("addToy")
    public String addToy(Toy toy) {
       toyService.createToy(toy);
        return "redirect:/toys";
    }

}
