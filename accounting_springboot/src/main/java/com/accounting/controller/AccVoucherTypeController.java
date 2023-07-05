package com.accounting.controller;

import com.accounting.service.AccVoucherTypeService;
import com.accounting.shared.dto.AccVoucherTypeDTO;
import com.accounting.shared.vo.AccVoucherTypeQueryVO;
import com.accounting.shared.vo.AccVoucherTypeUpdateVO;
import com.accounting.shared.vo.AccVoucherTypeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/accVoucherType")
public class AccVoucherTypeController {

    @Autowired
    private AccVoucherTypeService accVoucherTypeService;

    @PostMapping
    public String save( @RequestBody AccVoucherTypeVO vO) {
        return accVoucherTypeService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete( @PathVariable("id") Integer id) {
        accVoucherTypeService.delete(id);
    }

    @PutMapping("/{id}")
    public void update( @PathVariable("id") Integer id,
                       @RequestBody AccVoucherTypeUpdateVO vO) {
        accVoucherTypeService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AccVoucherTypeDTO getById( @PathVariable("id") Integer id) {
        return accVoucherTypeService.getById(id);
    }

    @GetMapping
    public Page<AccVoucherTypeDTO> query(AccVoucherTypeQueryVO vO) {
        return accVoucherTypeService.query(vO);
    }
}
