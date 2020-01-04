package im.vtngsystm.controller;

import im.vtngsystm.dto.ElectionDTO;
import im.vtngsystm.dto.UserDTO;
import im.vtngsystm.dto.VoteDTO;
import im.vtngsystm.dto.VoterDTO;
import im.vtngsystm.service.custom.ElectionService;
import im.vtngsystm.service.custom.VoteService;
import im.vtngsystm.service.custom.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin
@SessionAttributes("user")
@RequestMapping("/api/v1/voter")
@Scope("session")
public class VoterController {

    @Autowired
    private ElectionService electionService;

    @Autowired
    private VoterService voterService;

    @Autowired
    private VoteService voteService;

    @Autowired
    private VoterDTO voter;

    @GetMapping("/election")
    public ElectionDTO getTodaysElection() {
        return electionService.getCurrentElection();
    }

    @PostMapping("/login")
    public boolean login(@RequestBody UserDTO userDTO, HttpServletRequest httpServletRequest) {
        boolean b = voterService.logIn(userDTO);
        if (b) {
            voter = voterService.findByID(userDTO.getUsername());
            httpServletRequest.getSession().setAttribute("user", voter);
            return b;
        }
        return false;

    }

    @GetMapping("/election/history")
    public List<VoteDTO> getMyVotes() {
//        VoterDTO voter = (VoterDTO) httpServletRequest.getSession().getAttribute("user");
        System.out.println("---------------------------------------------------------------------voter in session - " + voter);
        return voteService.findVotesByVoter(voter);
    }

}
