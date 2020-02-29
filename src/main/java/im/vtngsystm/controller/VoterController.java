package im.vtngsystm.controller;

import im.vtngsystm.dto.ElectionDTO;
import im.vtngsystm.dto.VoteDTO;
import im.vtngsystm.dto.VoterDTO;
import im.vtngsystm.service.custom.ElectionService;
import im.vtngsystm.service.custom.VoteService;
import im.vtngsystm.service.custom.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
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

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public int login(@RequestParam String nic) {
//        String status = voterService.login(nic);
        int status = voterService.login(nic);
        System.out.println("status of login - " + status);
        return status;

    }

    @GetMapping("/election/history")
    public List<VoteDTO> getMyVotes() {
//        VoterDTO voter = (VoterDTO) httpServletRequest.getSession().getAttribute("user");
        System.out.println("---------------------------------------------------------------------voter in session - " + voter);
        return voteService.findVotesByVoter(voter);
    }

    @PostMapping("/otp-validate")
    public boolean checkOTP(@RequestParam String otp, @RequestParam String nic) {
        return voterService.checkOTP(nic, otp);
    }

}
