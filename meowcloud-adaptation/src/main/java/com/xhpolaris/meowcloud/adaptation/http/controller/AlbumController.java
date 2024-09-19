package com.xhpolaris.meowcloud.adaptation.http.controller;

import com.xhpolaris.meowcloud.adaptation.http.api.AlbumApi;
import com.xhpolaris.meowcloud.common.model.cmd.AlbumCmd;
import com.xhpolaris.meowcloud.common.model.vo.album.AlbumBasicVO;
import com.xhpolaris.meowcloud.common.model.vo.album.AlbumDetailVO;
import com.xhpolaris.meowcloud.common.model.vo.album.AlbumInfoVO;
import com.xhpolaris.meowcloud.domain.service.AlbumService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AlbumController implements AlbumApi {

    private final AlbumService albumService;

    @Override
    public List<AlbumBasicVO> getCatAlbum(int pageSize, int pageNum) {
        return albumService.getCatAlbum(pageSize, pageNum);
    }

    @Override
    public List<AlbumBasicVO> getTeamCatAlbum(Integer id, int pageSize, int pageNum) {
        return albumService.getTeamCatAlbum(id, pageSize, pageNum);
    }

    // TODO 新建猫猫相册
    @Override
    public boolean createCatAlbum(AlbumCmd.CreateCatAlbumCmd cmd) {
        return albumService.createCatAlbum(cmd);
    }

    @Override
    public AlbumDetailVO getCatAlbumDetail(String id) {
        return albumService.getCatAlbumDetail(id);
    }

    @Override
    public AlbumInfoVO getCatAlbumInfo(String id) {
        return albumService.getCatAlbumInfo(id);
    }

    @Override
    public boolean updateAlbumInfo(AlbumCmd.UpdateCatAlbumInfoCmd cmd) {
        return albumService.updateAlbumInfo(cmd);
    }
}
