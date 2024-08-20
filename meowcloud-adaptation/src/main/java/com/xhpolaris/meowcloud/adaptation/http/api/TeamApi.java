package com.xhpolaris.meowcloud.adaptation.http.api;

import com.xhpolaris.meowcloud.common.model.vo.TeamVO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Tag(name = "TeamApi", description = "团队接口")
@RequestMapping("/api/team")
public interface TeamApi {
    // 获取团队列表
    @GetMapping
    public List<TeamVO> getTeams();

    // TODO 成员管理
}
