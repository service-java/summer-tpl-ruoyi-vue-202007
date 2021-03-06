package com.example.admin.controller.monitor;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.common.base.BaseController;
import com.example.common.model.vo.ResponseVO;
import com.example.framework.model.ServerVO;

/**
 * 服务器监控
 *
 * @author ruoyi
 */
@RestController
@RequestMapping("/monitor/server")
public class ServerController extends BaseController {
    @PreAuthorize("@ss.hasPermi('monitor:server:list')")
    @GetMapping()
    public ResponseVO getInfo() throws Exception {
        ServerVO server = new ServerVO();
        server.copyTo();
        return ResponseVO.success(server);
    }
}
