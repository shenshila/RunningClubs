package com.example.runningclubs.controllers;

import com.example.runningclubs.DTO.ClubDTO;
import com.example.runningclubs.models.Club;
import com.example.runningclubs.services.ClubService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ClubController {
    private ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping("/clubs")
    public String listClubs(Model model) {
        List<ClubDTO> clubs = clubService.findAllClubs();
        model.addAttribute("clubs", clubs);
        return "clubs-list";
    }

    @GetMapping("/clubs/{clubId}")
    public String clubDetail(@PathVariable("clubId") long clubId, Model model) {
        ClubDTO clubDTO = clubService.findClubById(clubId);
        model.addAttribute("club", clubDTO);
        return "clubs-detail";
    }

    @GetMapping("/clubs/new")
    public String createClubForm(Model model) {
        Club club = new Club();
        model.addAttribute("club", club);
        return "clubs-create";
    }

    @GetMapping("/clubs/{clubId}/edit")
    public String editClubForm(@PathVariable("clubId") long clubId, Model model) {
        ClubDTO club = clubService.findClubById(clubId);
        model.addAttribute("club", club);
        return "clubs-edit";
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

    @PostMapping("/clubs/{clubId}/edit")
    public String updateClub(@PathVariable("clubId") Long clubId,
                             @Valid @ModelAttribute("club") ClubDTO club,
                             BindingResult result) {
        if (result.hasErrors()) {
            return "clubs-edit";
        }
        club.setId(clubId);
        clubService.updateClub(club);
        return "redirect:/clubs";
    }

}
