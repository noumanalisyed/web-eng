package com.accounting.controller;

import com.accounting.service.AccTransactionDetailService;
import com.accounting.shared.dto.AccTransactionDetailDTO;
import com.accounting.shared.vo.AccTransactionDetailQueryVO;
import com.accounting.shared.vo.AccTransactionDetailUpdateVO;
import com.accounting.shared.vo.AccTransactionDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/accTransactionDetail")
public class AccTransactionDetailController {

    @Autowired
    private AccTransactionDetailService accTransactionDetailService;

    @PostMapping
    public String save( @RequestBody AccTransactionDetailVO vO) {
        return accTransactionDetailService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete( @PathVariable("id") Long id) {
        accTransactionDetailService.delete(id);
    }

    @PutMapping("/{id}")
    public void update( @PathVariable("id") Long id,
                       @RequestBody AccTransactionDetailUpdateVO vO) {
        accTransactionDetailService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AccTransactionDetailDTO getById(@PathVariable("id") Long id) {
        return accTransactionDetailService.getById(id);
    }

    @GetMapping
    public Page<AccTransactionDetailDTO> query( AccTransactionDetailQueryVO vO) {
        return accTransactionDetailService.query(vO);
    }
}
