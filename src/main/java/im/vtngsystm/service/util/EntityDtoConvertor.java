package im.vtngsystm.service.util;

import im.vtngsystm.dto.*;
import im.vtngsystm.entity.*;
import im.vtngsystm.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class EntityDtoConvertor {

    @Autowired
    private PartyRepository partyRepository;
    @Autowired
    private PollingDivisionRepository pollingDivisionRepository;
    @Autowired
    private ContestantRepository contestantRepository;
    @Autowired
    private ElectionRepository electionRepository;
    @Autowired
    private VoteRepository voteRepository;
    @Autowired
    private VoterRepository voterRepository;
    @Autowired
    private ElectionCommissionerRepository electionCommissionerRepository;
    @Autowired
    private GramaNiladariRepository gramaNiladariRepository;
    @Autowired
    private ElectoralDistrictRepository electoralDistrictRepository;
    @Autowired
    private ProvinceRepository provinceRepository;
    @Autowired
    private ElectionContestantRepository electionContestantRepository;

    public SuperEntity convertToEntity(SuperDTO dto) {
        if (dto instanceof ContestantDTO) {
            ContestantDTO o = (ContestantDTO) dto;
            Party partyById = partyRepository.findById(o.getParty()).get();
            return new Contestant(o.getContestId(), o.getName(), pollingDivisionRepository.findPollingDivisionByPollNameIs(o.getPollDiv()), partyById);

        } else if (dto instanceof ElectionContestantDTO) {
            ElectionContestantDTO o = (ElectionContestantDTO) dto;
            ElectionContestant e = new ElectionContestant();
            e.getPrimaryKey().setContestant(contestantRepository.findById(o.getContestID()).get());
            e.getPrimaryKey().setElection(electionRepository.findById(o.getElecID()).get());
            e.setCandidateNo(o.getCandidateNO());
            e.setVotes(voteRepository.findVotesByElectionContestantIs(e));
            return e;

        } else if (dto instanceof ElectionDTO) {
            ElectionDTO e = (ElectionDTO) dto;
            System.out.println(e.getDate());
            System.out.println(e.getStartTime());
            System.out.println(e.getEndTime());
            String[] startSplit = e.getStartTime().split(":");
            String[] endSplit = e.getEndTime().split(":");
            String[] dateSplit = e.getDate().split("-");
            return new Election(e.getId(), LocalDate.of(Integer.parseInt(dateSplit[0]), Integer.parseInt(dateSplit[1]), Integer.parseInt(dateSplit[2])),
                    LocalTime.of(Integer.parseInt(startSplit[0]), Integer.parseInt(startSplit[1])),
                    LocalTime.of(Integer.parseInt(endSplit[0]), Integer.parseInt(endSplit[1])), e.getElectionType());

        } else if (dto instanceof ElectionCommissionerDTO) {
            ElectionCommissionerDTO e = (ElectionCommissionerDTO) dto;
            return new ElectionCommissioner("ele" + e.getUsername(), e.getPassword(), e.getName(), e.getTitle(), e.getEmail(),
                    e.getPost());

        } else if (dto instanceof ElectoralDistrictDTO) {
            ElectoralDistrictDTO e = (ElectoralDistrictDTO) dto;
            return new ElectoralDistrict(e.getName(), provinceRepository.findProvinceByProvName(e.getProvince()));

        } else if (dto instanceof GramaNiladariDTO) {
            GramaNiladariDTO g = (GramaNiladariDTO) dto;
            GramaNiladari gramaNiladari = new GramaNiladari("grn" + g.getUsername(), g.getPassword(), g.getName(), g.getTitle(),
                    g.getEmail(), g.getGnProvision(), g.getMobile());
            return gramaNiladari;

        } else if (dto instanceof PartyDTO) {
            PartyDTO p = (PartyDTO) dto;
            Party party = new Party(p.getPartyInitials(), p.getPartyName());
            return party;

        } else if (dto instanceof PollingDivisionDTO) {
            PollingDivisionDTO p = (PollingDivisionDTO) dto;
            return new PollingDivision(p.getPollId(), p.getPollName(),
                    electoralDistrictRepository.findElectoralDistrictByDistName(p.getElectoralDistrict()));

        } else if (dto instanceof ProvinceDTO) {
            ProvinceDTO p = (ProvinceDTO) dto;
            return new Province(p.getName());

        } else if (dto instanceof VoteDTO) {
            VoteDTO v = (VoteDTO) dto;
            Voter voter = voterRepository.findById(v.getVoterId()).get();
            ElectionContestant ec = electionContestantRepository.findElectionContestantByContestantAndElection
                    (v.getContestant().getContestId(), v.getElection().getId());
            return new Vote(v.getVoteId(), v.getDateTime(), voter, ec);

        } else if (dto instanceof VoterDTO) {
            VoterDTO v = (VoterDTO) dto;
            return new Voter(v.getUsername(), v.getPassword(), v.getName(), v.getTitle(), v.getEmail(), v.getAddress(), v.getMobile());
        }
        return null;
    }

    public SuperDTO convertToDTO(SuperEntity entity) {
        if (entity instanceof Contestant) {
            Contestant c = (Contestant) entity;
            PollingDivision p = c.getPollingDivision();
            ElectoralDistrict e = electoralDistrictRepository.findById(p.getElectoralDistrict().getDistId()).get();
            Province pp = provinceRepository.findById(e.getProvince().getProvId()).get();
            return new ContestantDTO(c.getContestId(), c.getName(), pp.getProvName(), e.getDistName(), p.getPollName(),
                    c.getParty().getPartyInitials());

        } else if (entity instanceof ElectionContestant) {
            ElectionContestant e = (ElectionContestant) entity;
            return new ElectionContestantDTO(e.getContestant().getContestId(), e.getElection().getElecId(), e.getCandidateNo());

        } else if (entity instanceof Election) {
            Election e = (Election) entity;
            return new ElectionDTO(e.getElecId(), e.getDate().toString(), e.getStartTime().toString(), e.getEndTime().toString(), e.getType());

        } else if (entity instanceof ElectionCommissioner) {
            ElectionCommissioner e = (ElectionCommissioner) entity;
            return new ElectionCommissionerDTO(e.getUsername(), e.getPassword(), e.getName(),
                    e.getTitle(), e.getEmail(), e.getPost());

        } else if (entity instanceof ElectoralDistrict) {
            ElectoralDistrict e = (ElectoralDistrict) entity;
            return new ElectoralDistrictDTO(e.getDistId(), e.getDistName(), e.getProvince().getProvName());

        } else if (entity instanceof GramaNiladari) {
            GramaNiladari g = (GramaNiladari) entity;
            GramaNiladariDTO gramaNiladariDTO = new GramaNiladariDTO(g.getUsername(), g.getPassword(), g.getName(),
                    g.getTitle(), g.getEmail(), g.getContact(), g.getGnProvision());
            return gramaNiladariDTO;

        } else if (entity instanceof Party) {
            Party p = (Party) entity;
            return new PartyDTO(p.getPartyInitials(), p.getPartyName());

        } else if (entity instanceof PollingDivision) {
            PollingDivision p = (PollingDivision) entity;
            return new PollingDivisionDTO(p.getPollId(), p.getPollName(),
                    p.getElectoralDistrict().getProvince().getProvName(), p.getElectoralDistrict().getDistName());

        } else if (entity instanceof Province) {
            Province p = (Province) entity;
            List<ElectoralDistrictDTO> list = convertToDtoList(p.getElectoralDistricts());
            return new ProvinceDTO(p.getProvId(), p.getProvName(), list);
        } else if (entity instanceof Vote) {
            Vote v = (Vote) entity;
            return new VoteDTO(v.getVoteID(), (ElectionDTO) convertToDTO(v.getElectionContestant().getElection()),
                    (ContestantDTO) convertToDTO(v.getElectionContestant().getContestant()), v.getVoter().getUsername(),
                    v.getVote(), v.getDateTime());
        } else if (entity instanceof Voter) {
            Voter v = (Voter) entity;
            return new VoterDTO(v.getUsername(), v.getPassword(), v.getName(), v.getTitle(), v.getEmail(),
                    v.getBirthdate(), v.getContactNo(), v.getAddress(),
                    v.getPollingDivision().getPollName()
            );
        }
        return null;
    }

    public List convertToDtoList(List list) {
        if (0 == list.size()) {
            System.out.println("------------------------------------------------------nothing in the list ->" + list);
            return null;
        }
        if (list.get(0) instanceof Contestant) {
            ArrayList<ContestantDTO> contestantDTOS = new ArrayList<>();
            for (Object e : list) {
                ContestantDTO c = (ContestantDTO) convertToDTO((SuperEntity) e);
                contestantDTOS.add(c);
            }
            return contestantDTOS;
        } else if (list.get(0) instanceof ElectionContestant) {
            ArrayList<ElectionContestantDTO> contestants = new ArrayList<>();
            for (Object e : list) {
                ElectionContestantDTO c = (ElectionContestantDTO) convertToDTO((SuperEntity) e);
                contestants.add(c);
            }
            return contestants;
        } else if (list.get(0) instanceof Election) {
            ArrayList<ElectionDTO> elections = new ArrayList<>();
            for (Object e : list) {
                ElectionDTO election = (ElectionDTO) convertToDTO((SuperEntity) e);
                elections.add(election);
            }
            return elections;
        } else if (list.get(0) instanceof ElectoralDistrict) {
            ArrayList<ElectoralDistrictDTO> electoralDistrictDTOS = new ArrayList<>();
            for (Object e : list) {
                ElectoralDistrictDTO electoralDistrictDTO = (ElectoralDistrictDTO) convertToDTO((SuperEntity) e);
                electoralDistrictDTOS.add(electoralDistrictDTO);
            }
            return electoralDistrictDTOS;
        } else if (list.get(0) instanceof GramaNiladari) {
            ArrayList<GramaNiladariDTO> gramaNiladariDTOS = new ArrayList<>();
            for (Object e : list) {
                GramaNiladariDTO gramaNiladariDTO = (GramaNiladariDTO) convertToDTO((SuperEntity) e);
                gramaNiladariDTOS.add(gramaNiladariDTO);
            }
            return gramaNiladariDTOS;
        } else if (list.get(0) instanceof Voter) {
            ArrayList<VoterDTO> voterDTOS = new ArrayList<>();
            for (Object e : list) {
                VoterDTO voterDTO = (VoterDTO) convertToDTO((SuperEntity) e);
                voterDTOS.add(voterDTO);
            }

            return voterDTOS;
        } else if (list.get(0) instanceof Party) {
            ArrayList<PartyDTO> partyDTOS = new ArrayList<>();
            for (Object e : list) {
                PartyDTO partyDTO = (PartyDTO) convertToDTO((SuperEntity) e);
                partyDTOS.add(partyDTO);
            }
            return partyDTOS;
        } else if (list.get(0) instanceof PollingDivision) {
            ArrayList<PollingDivisionDTO> pollingDivisionDTOS = new ArrayList<>();
            for (Object e : list) {
                PollingDivisionDTO pollingDivisionDTO = (PollingDivisionDTO) convertToDTO((SuperEntity) e);
                pollingDivisionDTOS.add(pollingDivisionDTO);
            }
            return pollingDivisionDTOS;
        } else if (list.get(0) instanceof Province) {
            ArrayList<ProvinceDTO> provinceDTOS = new ArrayList<>();
            for (Object e : list) {
                ProvinceDTO provinceDTO = (ProvinceDTO) convertToDTO((SuperEntity) e);
                provinceDTOS.add(provinceDTO);
            }
            return provinceDTOS;
        } else if (list.get(0) instanceof Vote) {
            ArrayList<VoteDTO> voteDTOS = new ArrayList<>();
            for (Object e : list) {
                VoteDTO voteDTO = (VoteDTO) convertToDTO((SuperEntity) e);
                voteDTOS.add(voteDTO);
            }
            return voteDTOS;
        }
        System.out.println("--------------------------------------------------list doesnt match anything ->" + list);
        return null;
    }

    public List convertToEntityList(List list) {
        if (0 == list.size()) {
            System.out.println("------------------------------------------------------nothing in the list ->" + list);
            return null;
        }
        if (list.get(0) instanceof ContestantDTO) {
            ArrayList<Contestant> contestants = new ArrayList<>();
            for (Object e : list) {
                Contestant c = (Contestant) convertToEntity((SuperDTO) e);
                contestants.add(c);
            }
            return contestants;
        } else if (list.get(0) instanceof ElectionContestantDTO) {
            ArrayList<ElectionContestant> contestants = new ArrayList<>();
            for (Object e : list) {
                ElectionContestant c = (ElectionContestant) convertToEntity((SuperDTO) e);
                contestants.add(c);
            }
            return contestants;
        } else if (list.get(0) instanceof ElectionDTO) {
            ArrayList<Election> elections = new ArrayList<>();
            for (Object e : list) {
                Election election = (Election) convertToEntity((SuperDTO) e);
                elections.add(election);
            }
            return elections;
        } else if (list.get(0) instanceof ElectoralDistrictDTO) {
            ArrayList<ElectoralDistrict> electoralDistricts = new ArrayList<>();
            for (Object e : list) {
                ElectoralDistrict electoralDistrict = (ElectoralDistrict) convertToEntity((SuperDTO) e);
                electoralDistricts.add(electoralDistrict);
            }
            return electoralDistricts;
        } else if (list.get(0) instanceof GramaNiladariDTO) {
            ArrayList<GramaNiladari> gramaNiladaris = new ArrayList<>();
            for (Object e : list) {
                GramaNiladari gramaNiladari = (GramaNiladari) convertToEntity((SuperDTO) e);
                gramaNiladaris.add(gramaNiladari);
            }
            return gramaNiladaris;
        } else if (list.get(0) instanceof VoterDTO) {
            ArrayList<Voter> voters = new ArrayList<>();
            for (Object e : list) {
                Voter voter = (Voter) convertToEntity((SuperDTO) e);
                voters.add(voter);
            }
            return voters;
        } else if (list.get(0) instanceof PartyDTO) {
            ArrayList<Party> parties = new ArrayList<>();
            for (Object e : list) {
                Party party = (Party) convertToEntity((SuperDTO) e);
                parties.add(party);
            }
            return parties;
        } else if (list.get(0) instanceof PollingDivisionDTO) {
            ArrayList<PollingDivision> pollingDivisions = new ArrayList<>();
            for (Object e : list) {
                PollingDivision pollingDivision = (PollingDivision) convertToEntity((SuperDTO) e);
                pollingDivisions.add(pollingDivision);
            }
            return pollingDivisions;
        } else if (list.get(0) instanceof ProvinceDTO) {
            ArrayList<Province> provinces = new ArrayList<>();
            for (Object e : list) {
                Province province = (Province) convertToEntity((SuperDTO) e);
                provinces.add(province);
            }
            return provinces;
        } else if (list.get(0) instanceof VoteDTO) {
            ArrayList<Vote> votes = new ArrayList<>();
            for (Object e : list) {
                Vote vote = (Vote) convertToEntity((SuperDTO) e);
                votes.add(vote);
            }
            return votes;
        }
        System.out.println("--------------------------------------------------list doesnt match anything ->" + list);
        return null;
    }
}
