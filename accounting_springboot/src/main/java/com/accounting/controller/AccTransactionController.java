package com.accounting.controller;

import com.accounting.service.AccTransactionService;
import com.accounting.shared.dto.AccTransactionDTO;
import com.accounting.shared.vo.AccTransactionQueryVO;
import com.accounting.shared.vo.AccTransactionUpdateVO;
import com.accounting.shared.vo.AccTransactionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/accTransaction")
public class AccTransactionController {

    @Autowired
    private AccTransactionService accTransactionService;

    @PostMapping
    public String save(@RequestBody AccTransactionVO vO) {
        return accTransactionService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        accTransactionService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long id,
                        @RequestBody AccTransactionUpdateVO vO) {
        accTransactionService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AccTransactionDTO getById( @PathVariable("id") Long id) {
        return accTransactionService.getById(id);
    }

    @GetMapping
    public Page<AccTransactionDTO> query( AccTransactionQueryVO vO) {
        return accTransactionService.query(vO);
    }
}
