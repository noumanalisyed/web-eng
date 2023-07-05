package com.accounting.controller;

import com.accounting.service.AccAccountHeadService;
import com.accounting.shared.dto.AccAccountHeadDTO;
import com.accounting.shared.vo.AccAccountHeadQueryVO;
import com.accounting.shared.vo.AccAccountHeadUpdateVO;
import com.accounting.shared.vo.AccAccountHeadVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Validated
@RestController
@RequestMapping("/accAccountHead")
public class AccAccountHeadController {

    @Autowired
    private AccAccountHeadService accAccountHeadService;

    @PostMapping
    public String save(@RequestBody AccAccountHeadVO vO) {
        return accAccountHeadService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        accAccountHeadService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long id,
                        @RequestBody AccAccountHeadUpdateVO vO) {
        accAccountHeadService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AccAccountHeadDTO getById(@PathVariable("id") Long id) {
        return accAccountHeadService.getById(id);
    }

    @GetMapping
    public Page<AccAccountHeadDTO> query(AccAccountHeadQueryVO vO) {
        return accAccountHeadService.query(vO);
    }
}
