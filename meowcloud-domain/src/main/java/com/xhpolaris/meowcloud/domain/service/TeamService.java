package com.xhpolaris.meowcloud.domain.service;

import com.xhpolaris.meowcloud.common.model.vo.TeamVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeamService {
    List<TeamVO> getTeams();
}
