package sn.gestion.post.controller.Api;

import org.springframework.web.bind.annotation.*;
import sn.gestion.post.dto.TransactionDto;

import java.util.List;

public interface TransactionApi {

    @GetMapping("/transaction")
    List<TransactionDto> findAll();

    @PostMapping("/transaction/create")
    TransactionDto save(@RequestBody TransactionDto transactionDto) throws Exception;

    @GetMapping("/transaction/{id}")
    TransactionDto findById(@PathVariable Long id);

    @DeleteMapping("/transaction/{id}")
    void delete(@PathVariable Long id);
}
