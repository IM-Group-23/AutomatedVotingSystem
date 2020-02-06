package im.vtngsystm.controller;

import im.vtngsystm.dto.ElectionDTO;
import im.vtngsystm.dto.UserDTO;
import im.vtngsystm.service.custom.ElectionCommissionerService;
import im.vtngsystm.service.custom.ElectionService;
import im.vtngsystm.service.custom.GramaNiladariService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin
@SessionAttributes("user")
@RequestMapping("/api/v1/general")
public class GeneralController {

    @Autowired
    ElectionService electionService;

    @Autowired
    ElectionCommissionerService electionCommissionerService;

    @Autowired
    GramaNiladariService gramaNiladariService;

    @GetMapping
    public List<ElectionDTO> getElectionDetails() {
        return electionService.findAll();
    }

    @PostMapping("/{admin}")
    public UserDTO adminLogin(@PathVariable("admin") String admin,
                              @RequestBody UserDTO userDTO, HttpServletRequest httpRequest) {
        UserDTO user = null;
        switch (admin) {
            case "ele": {
                boolean b = electionCommissionerService.logIn(userDTO);
                if (b) {
                    System.out.println("ele correct");
                    user = electionCommissionerService.findByID(userDTO.getUsername());
//                    httpRequest.getSession().setAttribute("user", user);
                }
                break;
            }
            case "grn": {
                boolean b1 = gramaNiladariService.logIn(userDTO);
                if (b1) {
                    System.out.println("grn correct");
                    user = gramaNiladariService.findByID(userDTO.getUsername());
//                    httpRequest.getSession().setAttribute("user", user);

                }
                break;
            }

        }
        return user;
    }
}
