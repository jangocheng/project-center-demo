package com.lytongxue.controller;

import com.lytongxue.api.domain.dto.ApplicationDTO;
import com.lytongxue.api.domain.dto.ProjectDTO;
import com.lytongxue.api.domain.query.ApplicationQuery;
import com.lytongxue.api.domain.query.ProjectQuery;
import com.lytongxue.api.domain.vo.ApplicationVO;
import com.lytongxue.api.domain.vo.ProjectVO;
import com.lytongxue.converter.ApplicationConverter;
import com.lytongxue.converter.ProjectConverter;
import com.lytongxue.domain.Pagination;
import com.lytongxue.domain.dto.ApplicationCreateDTO;
import com.lytongxue.domain.dto.ProjectCreateDTO;
import com.lytongxue.extension.web.Payload;
import com.lytongxue.service.ProjectService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/projects")
@Validated
@Payload
public class ProjectController {

    @Autowired
    private ProjectService service;

    @Autowired
    private ProjectConverter projectConverter;

    @Autowired
    private ApplicationConverter applicationConverter;

    @ApiOperation("获取详情")
    @GetMapping("/{id}")
    public ProjectVO detail(@PathVariable("id") String id) {
        ProjectDTO dto = service.detail(id);
        return projectConverter.dto2Vo(dto);
    }

    @ApiOperation("创建工程")
    @PostMapping
    public String create(@RequestBody @Valid ProjectCreateDTO dto) {
        return service.create(dto);
    }

    @ApiOperation("获取工程列表")
    @GetMapping
    public Pagination<ProjectVO> listPage(@Valid ProjectQuery query) {
        Pagination<ProjectDTO> listDto = service.listPage(query);
        return new Pagination<>(listDto.getTotal(),toProjectVO(listDto.getRows()));
    }

    @ApiOperation("获取应用列表")
    @GetMapping("/{projectId}/applications")
    public Pagination<ApplicationVO> listApplicationPage(@PathVariable("projectId") String id, @Valid ApplicationQuery query) {
        Pagination<ApplicationDTO> listDto = service.listApplicationPage(id,query);
        return new Pagination<>(listDto.getTotal(),toApplicationVO(listDto.getRows()));
    }

    @ApiOperation("创建应用")
    @PostMapping("/{projectId}/applications")
    public String createApplication(@PathVariable("projectId") String id,@RequestBody @Valid ApplicationCreateDTO dto) {
        return service.createApplication(id,dto);
    }

    private List<ProjectVO> toProjectVO(List<ProjectDTO> listDto) {
        return listDto
                .stream()
                .map(dto -> projectConverter.dto2Vo(dto))
                .collect(Collectors.toList());
    }

    private List<ApplicationVO> toApplicationVO(List<ApplicationDTO> listDto) {
        return listDto
                .stream()
                .map(dto -> applicationConverter.dto2Vo(dto))
                .collect(Collectors.toList());
    }

}
