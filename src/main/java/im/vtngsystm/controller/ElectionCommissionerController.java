package im.vtngsystm.controller;

import im.vtngsystm.dto.*;
import im.vtngsystm.service.custom.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/election-commissioner")
public class ElectionCommissionerController {

    @Autowired
    private GramaNiladariService gramaNiladariService;

    @Autowired
    private ElectionCommissionerService electionCommissionerService;

    @Autowired
    private ElectionService electionService;

    @Autowired
    private ProvinceService provinceService;

    @Autowired
    private ElectoralDistrictService electoralDistrictService;

    @Autowired
    private PollingDivisionService pollingDivisionService;

    @Autowired
    private PartyService partyService;

    @Autowired
    private ContestantService contestantService;

    @Autowired
    private VoterService voterService;

    @GetMapping("/get")
    public Object getElectionCommissioners(@RequestParam(value = "action", required = false) String action) {
        if (null != action) {
            if (action.equals("count")) {
                return electionCommissionerService.getCount();
            }
        }
        List<ElectionCommissionerDTO> all = electionCommissionerService.findAll();
        System.out.println(all.toString());
        return all;
    }

    @PutMapping("/grn/{id}")
    public boolean saveGramaNiladari(@PathVariable("id") String id, GramaNiladariDTO gramaNiladariDTO) {
        gramaNiladariService.save(id, gramaNiladariDTO);
        System.out.println("grama niladari saved successfully");
        return true;
    }

    @PostMapping("/grn/{id}")
    public boolean updateGramaNiladariDetails(@PathVariable("id") String id,
                                              @RequestBody GramaNiladariDTO gramaNiladariDTO) {
        gramaNiladariService.update(id, gramaNiladariDTO);
        System.out.println("voter updated correctly");
        return true;
    }

    @DeleteMapping("/grn/{id}")
    public boolean deleteGramaNiladari(@PathVariable("id") String id) {
        gramaNiladariService.delete(id);
        return true;
    }

    @GetMapping("/grn/{id}")
    public GramaNiladariDTO findGramaNiladariByID(@PathVariable("id") String id) {
        return gramaNiladariService.findByID(id);
    }

    @GetMapping("/grn")
    public Object findAllGramaNiladaris(@RequestParam(value = "action", required = false) String action) {
        if (null != action) {
            if (action.equals("count")) {
                return gramaNiladariService.getCount();
            }
        }
        return gramaNiladariService.findAll();
    }

    @PostMapping("/{id}")
    public boolean updateMyDetails(@PathVariable("id") String id,
                                   @ModelAttribute("user") ElectionCommissionerDTO electionCommissionerDTO) {
        electionCommissionerService.update(id, electionCommissionerDTO);
        return true;
    }

    @PostMapping("/elections/add")
    public boolean declareEletion(@RequestBody ElectionDTO electionDTO) {
        electionService.save(electionDTO);
        System.out.println("election successfully added");
        return true;
    }

    @GetMapping("/elections")
    public Object getAllElections(@RequestParam(value = "action", required = false) String action) {
        if (null != action) {
            if (action.equals("count")) {
                return electionService.getCount();
            }
        }
        List<ElectionDTO> all = electionService.findAll();
        System.out.println(all.toString());
        return all;
    }

    @GetMapping("/provinces")
    public Object getAllProvinces(@RequestParam(value = "action", required = false) String action,
                                  @RequestParam(value = "name", required = false) String name) {
        if (null != action) {
            switch (action) {
                case "count":
                    return provinceService.getCount();
//                case "like":
//                    return service.findCustomersLike(name);
                default:
                    return provinceService.findAll();
            }
        } else {
            return provinceService.findAll();
        }
    }

    @GetMapping("/districts")
    public Object getAllDistricts(@RequestParam(value = "action", required = false) String action,
                                  @RequestParam(value = "name", required = false) String name) {
        if (null != action) {
            switch (action) {
                case "count":
                    return electoralDistrictService.getCount();
                case "like":
                    return provinceService.findDistrictByProvince(name);
                default:
                    return electoralDistrictService.findAll();
            }
        } else {
            return electoralDistrictService.findAll();
        }
    }

    @GetMapping("/pollDivs")
    public Object getAllPollingDivisions(@RequestParam(value = "action", required = false) String action,
                                         @RequestParam(value = "name", required = false) String name) {
        if (null != action) {
            switch (action) {
                case "count":
                    return pollingDivisionService.getCount();
                case "like":
                    return electoralDistrictService.findPollingDivisionsByDistrict(name);
                default:
                    return pollingDivisionService.findAll();
            }
        } else {
            return pollingDivisionService.findAll();
        }
    }

    @GetMapping("/parties")
    public Object getAllParties(@RequestParam(value = "action", required = false) String action) {
        if (null != action) {
            if (action.equals("count")) {
                return partyService.getCount();
            }
        }
        List<PartyDTO> all = partyService.findAll();
        System.out.println(all.toString());
        return all;
    }

    @GetMapping("/parties/{id}")
    public PartyDTO getParty(@PathVariable("id") String id) {
        PartyDTO byID = partyService.findByID(id);
        System.out.println(byID.toString());
        return byID;
    }

    @GetMapping("/provinces/{name}")
    public ProvinceDTO getProvinceByName(@PathVariable("name") String name) {
        ProvinceDTO byName = provinceService.findByName(name);
        System.out.println(byName.toString());
        return byName;
    }

    @GetMapping("/districts/{name}")
    public ElectoralDistrictDTO getDistrictByName(@PathVariable("name") String name) {
        ElectoralDistrictDTO byName = electoralDistrictService.findByName(name);
        System.out.println(byName.toString());
        return byName;
    }

    @GetMapping("/pollDivs/{name}")
    public PollingDivisionDTO getPollingDivisionByName(@PathVariable("name") String name) {
        PollingDivisionDTO byName = pollingDivisionService.findByName(name);
        System.out.println(byName.toString());
        return byName;
    }

    @GetMapping("/provinces/{id}")
    public ProvinceDTO getProvinceById(@PathVariable("id") String id) {
        ProvinceDTO byID = provinceService.findByID(Integer.parseInt(id));
        System.out.println(byID.toString());
        return byID;
    }

    @GetMapping("/districts/{id}")
    public ElectoralDistrictDTO getDistrictById(@PathVariable("id") String id) {
        ElectoralDistrictDTO byID = electoralDistrictService.findByID(Integer.parseInt(id));
        System.out.println(byID.toString());
        return byID;
    }

    @GetMapping("/pollDivs/{id}")
    public PollingDivisionDTO getPollingDivisionById(@PathVariable("id") String id) {
        PollingDivisionDTO byID = pollingDivisionService.findByID(Integer.parseInt(id));
        System.out.println(byID.toString());
        return byID;
    }

    @PutMapping("/provinces/0a")
    public boolean addProvince(@RequestBody ProvinceDTO provinceDTO) {
        provinceService.save(provinceDTO);
        System.out.println("province saved successfully");
        return true;
    }

    @PutMapping("/districts/0a")
    public boolean addDistrict(@RequestBody ElectoralDistrictDTO electoralDistrictDTO) {
        electoralDistrictService.save(electoralDistrictDTO);
        System.out.println("district saved successfully");
        return true;
    }

    @PutMapping("/pollDivs/0a")
    public boolean addPollingDivision(@RequestBody PollingDivisionDTO pollingDivisionDTO) {
        pollingDivisionService.save(pollingDivisionDTO);
        System.out.println("polling division saved successfully");
        return true;
    }

    @PutMapping("/parties/{id}")
    public boolean addParty(@PathVariable("id") String initials, @RequestBody PartyDTO partyDTO) {
        partyService.save(initials, partyDTO);
        System.out.println("party added successfully");
        return true;
    }

    @DeleteMapping("/provinces/{id}")
    public boolean deleteProvince(@PathVariable("id") String id) {
        provinceService.delete(Integer.parseInt(id));
        System.out.println("successfully deleted");
        return true;
    }

    @DeleteMapping("/districts/{id}")
    public boolean deleteDistrict(@PathVariable("id") String id) {
        electoralDistrictService.delete(Integer.parseInt(id));
        System.out.println("successfully deleted");
        return true;
    }

    @DeleteMapping("/pollDivs/{id}")
    public boolean deletePollingDivision(@PathVariable("id") String id) {
        pollingDivisionService.delete(Integer.parseInt(id));
        System.out.println("successfully deleted");
        return true;
    }

    @DeleteMapping("/parties/{id}")
    public boolean deleteParty(@PathVariable("id") String id) {
        partyService.delete(id);
        System.out.println("successfully deleted");
        return true;
    }

    @PutMapping(value = "/contestants/0a", consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean addContestant(@RequestBody ContestantDTO contestantDTO) {
        contestantService.save(contestantDTO);
        System.out.println("successfully added");
        return true;
    }

    @DeleteMapping("/contestants/{id}")
    public boolean deleteContestant(@PathVariable("id") String id) {
        contestantService.delete(Integer.parseInt(id));
        System.out.println("successfully deleted");
        return true;
    }

    @PostMapping(value = "/contestants/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean updateContestant(@PathVariable("id") String id, @RequestBody ContestantDTO contestantDTO) {
        contestantService.update(Integer.parseInt(id), contestantDTO);
        System.out.println("successfully updated");
        return true;
    }

    @GetMapping("/contestants")
    public Object getAllContestants(@RequestParam(value = "action", required = false) String action,
                                    @RequestParam(value = "details", required = false) String details) {
        if (null != action) {
            switch (action) {
                case "count":
                    return contestantService.getCount();
                case "like":
                    return pollingDivisionService.findContestantsByPollingDivisionAndParty(details);
                default:
                    return contestantService.findAll();
            }
        } else {
            return contestantService.findAll();
        }
    }

    @GetMapping("/contestants/{id}")
    public ContestantDTO getContestant(@PathVariable("id") String id) {
        ContestantDTO byID = contestantService.findByID(Integer.parseInt(id));
        System.out.println(byID.toString());
        return byID;
    }

    @GetMapping("/voters")
    public Object getAllVoters(@RequestParam(value = "action", required = false) String action) {
        if (null != action) {
            if (action.equals("count")) {
                return voterService.getCount();
            }
        }
        List<VoterDTO> all = voterService.findAll();
        System.out.println(all.toString());
        return all;
    }

    @GetMapping("/voters/{id}")
    public VoterDTO getVoterByID(@PathVariable("id") String id) {
        return voterService.findByID(id);
    }

    @PutMapping(value = "/voters/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void registerVoter(@PathVariable("id") String nic, @RequestBody VoterDTO voterDTO, HttpRequest httpRequest) {
        voterService.save(nic, voterDTO);
    }
}
