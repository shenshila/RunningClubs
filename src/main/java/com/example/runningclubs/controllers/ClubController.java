package com.example.runningclubs.controllers;

import com.example.runningclubs.DTO.ClubDTO;
import com.example.runningclubs.models.Club;
import com.example.runningclubs.models.UserEntity;
import com.example.runningclubs.security.SecurityUtil;
import com.example.runningclubs.services.ClubService;
import com.example.runningclubs.services.UserService;
import jakarta.validation.Valid;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClubController {
    private ClubService clubService;
    private UserService userService;

    public ClubController(ClubService clubService, UserService userService) {
        this.clubService = clubService;
        this.userService = userService;
    }

    @GetMapping("/clubs")
    public String listClubs(Model model) {
//        UserEntity user = new UserEntity();
        List<ClubDTO> clubs = clubService.findAllClubs();
//        String username = SecurityUtil.getSessionUser();
//        if (username != null) {
//            user = userService.findByUsername(username);
//            model.addAttribute("user", user);
//        }
//        model.addAttribute("user", user);
        model.addAttribute("clubs", clubs);
        return "clubs-list";
    }

    @GetMapping("/clubs/new")
    public String createClubForm(Model model) {
        Club club = new Club();
        model.addAttribute("club", club);
        return "clubs-create";
    }

    @PostMapping("/clubs/new")
    public String saveClub(@Valid @ModelAttribute("club") ClubDTO clubDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("club", clubDTO);
            return "clubs-create";
        }
        clubService.saveClub(clubDTO);
        return "redirect:/clubs";
    }

    @GetMapping("/clubs/{clubId}/delete")
    public String deleteClub(@PathVariable("clubId") Long clubId) {
        clubService.delete(clubId);
        return "redirect:/clubs";
    }

    @GetMapping("/clubs/search")
    public String searchString(@RequestParam(value = "query") String query, Model model) {
        List<ClubDTO> clubs = clubService.searchClubs(query);
        model.addAttribute("clubs", clubs);
        return "clubs-list";
    }

    @GetMapping("/clubs/{clubId}")
    public String clubDetail(@PathVariable("clubId") long clubId, Model model) {
        ClubDTO clubDTO = clubService.findClubById(clubId);
        model.addAttribute("club", clubDTO);
        return "clubs-detail";
    }

    @GetMapping("/clubs/{clubId}/edit")
    public String editClubForm(@PathVariable("clubId") long clubId, Model model) {
        ClubDTO club = clubService.findClubById(clubId);
        model.addAttribute("club", club);
        return "clubs-edit";
    }

    @PostMapping("/clubs/{clubId}/edit")
    public String updateClub(@PathVariable("clubId") Long clubId,
                             @Valid @ModelAttribute("club") ClubDTO club,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("club", club);
            return "clubs-edit";
        }
        club.setId(clubId);
        clubService.updateClub(club);
        return "redirect:/clubs";
    }

}
