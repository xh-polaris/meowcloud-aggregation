package com.xhpolaris.meowcloud.adaptation.http.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "AlbumApi",description = "相册相关接口")
@RequestMapping("/api/album")
public interface AlbumApi {
}
