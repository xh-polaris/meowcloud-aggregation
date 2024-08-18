package com.xhpolaris.meowcloud.adaptation.http.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "UserApi",description = "用户相关接口")
@RequestMapping("/api/user")
public interface UserApi {
}
